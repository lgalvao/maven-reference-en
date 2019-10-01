package org.sonatype.mavenbook.weather.yahoo;

import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.YahooParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YahooParserTest {
    @Test
    public void testParser() throws Exception {
        InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
        Weather weather = new YahooParser().parse("10002", nyData);
        assertEquals("New York", weather.getLocation().getCity());
        assertEquals("NY", weather.getLocation().getRegion());
        assertEquals("US", weather.getLocation().getCountry());
        assertEquals("39", weather.getCondition().getTemp());
        assertEquals("Fair", weather.getCondition().getText());
        assertEquals("39", weather.getWind().getChill());
        assertEquals("67", weather.getAtmosphere().getHumidity());
    }
}
