package com.ohtu.miniprojektiv2.controller;

import com.ohtu.miniprojektiv2.service.CitationService;
import com.ohtu.miniprojektiv2.domain.Inproceeding;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private CitationService citationService;

    /**
     * For now, list all citations when accessing root address
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listAllCitations() {
        return "index";
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("citation") Inproceeding citation) {
        model.addAttribute("citations", citationService.listAll());
        return "listAll";
    }

    @RequestMapping(value = "citations/{id}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable Integer id) {
        model.addAttribute("citation", citationService.getById(id));
        return "viewCitation";
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
            return "redirect:listAll";
        }
    }

//    @RequestMapping(value = "success", method = RequestMethod.GET)
//    public String showSuccessfulAdditionPage() {
//        return "success";
//    }
}
