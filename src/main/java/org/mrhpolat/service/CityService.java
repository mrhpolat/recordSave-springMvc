package org.mrhpolat.service;

import org.mrhpolat.model.City;
import org.mrhpolat.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CityService implements CityServiceInterface {

    @Autowired
    CityRepo cityRepo;

    Logger logger = Logger.getLogger(CityService.class.getName());

    @Transactional
    @Override
    public List<City> findAllCites() {
        logger.info("findAllCites service called");
        return cityRepo.findAllCity();
    }

    @Override
    public ArrayList<String> getCityDesc() {
        logger.info("Get all city description service called");
        ArrayList<String> cities = new ArrayList<>();
        for (City city : findAllCites()) {
            cities.add(city.getDescription());
        }
        return cities;
    }

}
