package org.mrhpolat.service;

import org.mrhpolat.model.Visit;
import org.mrhpolat.repository.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class VisitService implements VisitServiceInterface {

    @Autowired
    VisitRepo visitRepo;
    Logger logger = Logger.getLogger(VisitServiceInterface.class.getName());

    @Override
    public List<Visit> findAllVisit() {
        logger.info("findAllVisit service called");
        return visitRepo.findAllVisit();
    }

    @Override
    public Visit getVisitById(Long id) {
        logger.info("getVisitById service called");
        return visitRepo.getVisitById(id);
    }

    @Override
    public void updateOrSaveVisit(Visit visit) {
        logger.info("updateOrSaveVisit service called");
        visitRepo.updateOrSaveVisit(visit);
    }

    @Override
    public void deleteVisit(Long id) {
        logger.info("deleteVisit service called");
        visitRepo.deleteVisit(id);
    }

    //Standart blood group list
    @Override
    public ArrayList<String> getBloodList() {
        logger.info("getBloodList service called");
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
