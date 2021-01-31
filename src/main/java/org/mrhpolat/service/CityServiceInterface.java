package org.mrhpolat.service;

import org.mrhpolat.model.City;

import java.util.ArrayList;
import java.util.List;

public interface CityServiceInterface {

    public List<City> findAllCites();

    public ArrayList<String> getCityDesc();
}
