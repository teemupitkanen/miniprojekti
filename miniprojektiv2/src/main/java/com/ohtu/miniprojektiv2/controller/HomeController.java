package com.ohtu.miniprojektiv2.controller;

import com.ohtu.miniprojektiv2.domain.Inproceeding;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private CitationService citationService;

    /**
     * For now, list all citations when accessing root address
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listAllCitations(Model model, @ModelAttribute("citation") Inproceeding citation) {
        model.addAttribute("citations", citationService.listAll());
        return "listAll";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newCitationForm(@ModelAttribute("citation") Inproceeding citation) {
        return "new";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createNewCitation(@Valid @ModelAttribute("citation") Inproceeding citation,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            citationService.insert(citation);
            return "listAll";
        }
    }
    
//    @RequestMapping(value = "success", method = RequestMethod.GET)
//    public String showSuccessfulAdditionPage() {
//        return "success";
//    }
}