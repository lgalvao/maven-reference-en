package org.sonatype.mavenbook.weather.persist;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.sonatype.mavenbook.weather.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.persistence.TypedQuery;

public interface LocationDAO {
    Location findByZip(String zip);

    List<Location> all();
}

