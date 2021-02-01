package org.mrhpolat.repository;

import org.mrhpolat.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CityRepo extends CommonRepo {

    Logger logger = Logger.getLogger(CityRepo.class.getName());

    public List<City> findAllCity() {
        List<City> cityList = getSession().createQuery("SELECT c from City c", City.class).list();
        logger.info("getCityList; " + cityList.toString());
        return cityList;
    }
}
