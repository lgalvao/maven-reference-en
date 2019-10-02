package org.sonatype.mavenbook.weather.persist;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;

import javax.persistence.TypedQuery;

public class WeatherDAOImp implements WeatherDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Weather weather) {
        sessionFactory.getCurrentSession().save(weather);
    }

    public List<Weather> recentForLocation(final Location location) {
        TypedQuery<Weather> query = sessionFactory.getCurrentSession().createQuery("from Weather");
        return query.getResultList();
    }
}