package org.sonatype.mavenbook.weather;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import org.junit.jupiter.api.Test;
import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.WeatherFormatter;
import org.sonatype.mavenbook.weather.YahooParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherFormatterTest {
    @Test
    public void testFormat() throws Exception {
        InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
        Weather weather = new YahooParser().parse(nyData);
        String formattedResult = new WeatherFormatter().format(weather);
        InputStream expected = getClass().getClassLoader().getResourceAsStream("format-expected.dat");
        assertEquals(IOUtils.toString(expected), formattedResult);
    }
}