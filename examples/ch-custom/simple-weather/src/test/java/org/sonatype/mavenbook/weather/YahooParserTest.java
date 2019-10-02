package org.sonatype.mavenbook.weather;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YahooParserTest {
    public void testParser() throws Exception {
        InputStream nyData =
                getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
        Weather weather = new YahooParser().parse(nyData);
        assertEquals("New York", weather.getCity());
        assertEquals("NY", weather.getRegion());
        assertEquals("US", weather.getCountry());
        assertEquals("39", weather.getTemp());
        assertEquals("Fair", weather.getCondition());
        assertEquals("39", weather.getChill());
        assertEquals("67", weather.getHumidity());
    }
}
