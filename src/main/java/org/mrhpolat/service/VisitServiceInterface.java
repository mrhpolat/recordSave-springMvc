package org.mrhpolat.service;

import org.mrhpolat.model.Visit;

import java.util.ArrayList;
import java.util.List;

public interface VisitServiceInterface {

    public List<Visit> findAllVisit();

    public Visit getVisitById(Long id);

    public void updateOrSaveVisit(Visit visit);

    public void deleteVisit(Long id);

    public ArrayList<String> getBloodList();
}
