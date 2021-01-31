package org.mrhpolat.repository;

import org.mrhpolat.model.Visit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitRepo extends CommonRepo {

    public List<Visit> findAllVisit() {
        return getSession().createQuery("select v from Visit v", Visit.class).list();
    }

    public Visit getVisitById(Long id) {
        return getSession().find(Visit.class, id);
    }

    public void updateOrSaveVisit(Visit visit) {
        getSession().saveOrUpdate(visit);
    }

    public void deleteVisit(Long id) {
        Visit p = getVisitById(id);
        if (null != p) {
            getSession().delete(p);
        }
    }

}
