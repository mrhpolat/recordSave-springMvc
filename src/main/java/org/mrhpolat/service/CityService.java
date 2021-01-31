package org.mrhpolat.service;

import org.mrhpolat.model.City;
import org.mrhpolat.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements CityServiceInterface {

    @Autowired
    CityRepo cityRepo;

    @Transactional
    @Override
    public List<City> findAllCites() {
        return cityRepo.findAllCity();
    }

    @Override
    public ArrayList<String> getCityDesc() {
        ArrayList<String> cities = new ArrayList<>();
        for (City city : findAllCites()) {
            cities.add(city.getDescription());
        }
        return cities;
    }

}
