package org.mrhpolat.repository;

import org.mrhpolat.model.Visit;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class VisitRepo extends CommonRepo {

    Logger logger = Logger.getLogger(VisitRepo.class.getName());

    public List<Visit> findAllVisit() {

        List<Visit> visitList = getSession().createQuery("select v from Visit v", Visit.class).list();
        logger.info("findAllVisit" + visitList.toString());
        return visitList;
    }

    public Visit getVisitById(Long id) {
        Visit visit = getSession().find(Visit.class, id);
        logger.info("findAllVisit" + visit.toString());

        return visit;
    }

    public void updateOrSaveVisit(Visit visit) {
        getSession().saveOrUpdate(visit);
        logger.info("Visit updated with " + visit.toString());
    }

    public void deleteVisit(Long id) {

        Visit visit = getVisitById(id);
        if (null != visit) {
            getSession().delete(visit);
            logger.info(" visit is deleted for this id " + visit.toString());
        } else {
            logger.warning("we don't find visit for this id " + id.toString());
        }
    }

}
