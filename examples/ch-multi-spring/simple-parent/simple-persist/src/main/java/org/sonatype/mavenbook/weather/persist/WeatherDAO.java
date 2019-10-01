package org.sonatype.mavenbook.weather.persist;

import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;

import javax.persistence.TypedQuery;
import java.util.List;

public interface WeatherDAO {
    void save(Weather weather);

    List<Weather> recentForLocation(Location location);
}
