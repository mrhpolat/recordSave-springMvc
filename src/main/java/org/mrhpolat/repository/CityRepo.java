package org.mrhpolat.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mrhpolat.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepo extends CommonRepo {

    public List<City> findAllCity() {
        return getSession().createQuery("SELECT c from City c", City.class).list();
    }
}
