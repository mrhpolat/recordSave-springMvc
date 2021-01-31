package org.mrhpolat.controller;

import com.sun.istack.Nullable;
import org.firebirdsql.logging.LoggerFactory;
import org.mrhpolat.model.Visit;
import org.mrhpolat.service.CityServiceInterface;
import org.mrhpolat.service.VisitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Book;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/visit")
public class VisitController {

    Logger logger = Logger.getLogger(VisitController.class.getName());
    @Autowired
    VisitServiceInterface visitService;

    @Autowired
    CityServiceInterface cityService;

    //Redirect Pages
    @GetMapping(value = "/")
    public String homePage() {
        logger.info("homePage is loading.");
        return "home";
    }

    //Open the Visit Data Page
    @GetMapping(value = "/data")
    public String showData(Model model, @Nullable Visit visit) {
        logger.info("showData is started.");
        if (visit != null)
            model.addAttribute("visit", visit);
        else
            model.addAttribute("visit", new Visit());
        model.addAttribute("cities", cityService.getCityDesc());
        model.addAttribute("bloods", visitService.getBloodList());
        logger.info("showData is ended.");

        return "form";
    }

    //Get All Visit Datas.
    @GetMapping(value = "/list")
    public String getVisits(Model model, final RedirectAttributes redirectAttributes) {
        logger.info("Visit list is started.");
        List<Visit> listOfVisits = visitService.findAllVisit();
        model.addAttribute("visits", listOfVisits);
        logger.info("Visit List is ended.");
        return "list";
    }

    //Add a visit
    @PostMapping(value = "/ins")
    public String addVisit(@ModelAttribute("visit") Visit visit, final RedirectAttributes redirectAttributes) {
        logger.info("Visit Insert is started.");
        redirectAttributes.addFlashAttribute("css", "success");
        if (visit.getId() == null) {
            redirectAttributes.addFlashAttribute("msg", "Visit added successfully!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Visit updated successfully!");
        }

        visitService.updateOrSaveVisit(visit);
        logger.info("Visit Insert is ended.");
        return "redirect:/visit/list";
    }

    //Get a visit and redirect to show page.
    @GetMapping(value = "/{id}")
    public String showVisit(@PathVariable("id") Long id, Model model) {
        logger.info("Show by id is started.");
        Visit visit = visitService.getVisitById(id);
        if (visit == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("visit", visit);
        logger.info("Show by id is ended.");
        return "show";
    }

    @GetMapping(value = "/upd/{id}")
    public String updateVisit(@PathVariable("id") Long id, Model model) {
        logger.info("Show by Id is updating.");
        return showData(model, visitService.getVisitById(id));
    }

    @GetMapping(value = "/del/{id}")
    public String deleteVisit(@PathVariable("id") Long id, Model model, final RedirectAttributes redirectAttributes) {
        logger.info("delete by Id is started.");
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Visit deleted successfully!");
         visitService.deleteVisit(id);
        logger.info("delete by Id is ended.");
         return "redirect:/visit/list";
    }
}
