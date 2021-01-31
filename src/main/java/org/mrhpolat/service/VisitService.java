package org.mrhpolat.service;

import org.mrhpolat.model.Visit;
import org.mrhpolat.repository.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VisitService implements VisitServiceInterface {

    @Autowired
    VisitRepo visitRepo;

    @Override
    public List<Visit> findAllVisit() {
        return visitRepo.findAllVisit();
    }

    @Override
    public Visit getVisitById(Long id) {
        return visitRepo.getVisitById(id);
    }

    @Override
    public void updateOrSaveVisit(Visit visit) {
        visitRepo.updateOrSaveVisit(visit);
    }

    @Override
    public void deleteVisit(Long id) {
        visitRepo.deleteVisit(id);
    }

    //Standart blood group list
    @Override
    public ArrayList<String> getBloodList() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("0 RH+");
        stringArrayList.add("0 RH-");
        stringArrayList.add("A RH+");
        stringArrayList.add("A RH-");
        stringArrayList.add("B RH+");
        stringArrayList.add("B RH-");
        stringArrayList.add("AB RH+");
        stringArrayList.add("AB RH-");

        return stringArrayList;
    }
}
