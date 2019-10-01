package org.sonatype.mavenbook.weather;

import java.util.List;

import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.persist.LocationDAO;
import org.sonatype.mavenbook.weather.persist.WeatherDAO;

public class Main {

    private WeatherService weatherService;
    private WeatherDAO weatherDAO;
    private LocationDAO locationDAO;

    public static void main(String[] args) throws Exception {
        // Read the Zip Code from the Command-line (if none supplied, use 60202)
        String zipcode = "60202";
        try {
            zipcode = args[0];
        } catch (Exception e) {
            // OK!
        }

        // Read the Operation from the Command-line (if none supplied, use weather)
        String operation = "weather";
        try {
            operation = args[1];
        } catch (Exception e) {
            // OK!
        }

        // Start the program
        Main main = new Main(zipcode);

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:applicationContext-weather.xml",
                        "classpath:applicationContext-persist.xml"});
        main.weatherService = (WeatherService) context.getBean("weatherService");
        main.locationDAO = (LocationDAO) context.getBean("locationDAO");
        main.weatherDAO = (WeatherDAO) context.getBean("weatherDAO");
        if (operation.equals("weather")) {
            main.getWeather();
        } else {
            main.getHistory();
        }
    }

    private String zip;

    public Main(String zip) {
        this.zip = zip;
    }

    public void getWeather() throws Exception {
        Weather weather = weatherService.retrieveForecast(zip);
        weatherDAO.save(weather);
        System.out.print(new WeatherFormatter().formatWeather(weather));
    }

    public void getHistory() throws Exception {
        Location location = locationDAO.findByZip(zip);
        List<Weather> weathers = weatherDAO.recentForLocation(location);
        System.out.print(new WeatherFormatter().formatHistory(location, weathers));
    }
}
