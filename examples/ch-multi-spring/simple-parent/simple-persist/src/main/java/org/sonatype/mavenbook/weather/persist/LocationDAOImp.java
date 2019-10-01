package org.sonatype.mavenbook.weather.persist;

import org.hibernate.SessionFactory;
import org.sonatype.mavenbook.weather.model.Location;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public class LocationDAOImp implements LocationDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Location findByZip(final String zip) {
        TypedQuery<Location> query = sessionFactory.getCurrentSession().getNamedQuery("Location.uniqueByZip");
        query.setParameter("zip", zip);
        return query.getSingleResult();
    }

    public List<Location> all() {
        TypedQuery<Location> query = sessionFactory.getCurrentSession().createQuery("from Location");
        return query.getResultList();
    }
}
