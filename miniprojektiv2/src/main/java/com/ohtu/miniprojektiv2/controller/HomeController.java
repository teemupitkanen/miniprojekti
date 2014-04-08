package com.ohtu.miniprojektiv2.controller;

import com.ohtu.miniprojektiv2.domain.Citation;
import com.ohtu.miniprojektiv2.domain.CitationType;
import com.ohtu.miniprojektiv2.service.CitationService;
import com.ohtu.miniprojektiv2.service.TagService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class for catching http requests
 *
 * @author jee
 */
@Controller
public class HomeController {

    /**
     * Service class for storing information
     */
    @Autowired
    private CitationService citationService;

    @Autowired
    private TagService tagService;

    /**
     * For now, list all citations when accessing root address
     *
     * @return index page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listAllCitations() {
        return "index";
    }

    /**
     * Directs user to a page where all citations are listed
     *
     * @param model is a holder for model attributes
     * @return name of the .jsp page
     *
     * HOX -> deleted "@ModelAttribute("citation") Citation citation"
     * from method parameters as probably unnecessary -Santeri
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("citations", citationService.listAll());
        return "listAll";
    }

    /**
     * Directs user to a page which shows the details of chosen citation
     *
     * @param model is a holder for model attributes
     * @param id is the id of a chosen citation
     * @return name of the .jsp page
     */
    @RequestMapping(value = "citations/{id}", method = RequestMethod.GET)
    public String viewCitation(Model model, @PathVariable Integer id) {
        model.addAttribute("citation", citationService.getById(id));
        return "viewCitation";
    }

    /**
     * Directs user to a citation creation form
     *
     * @return name of the .jsp page
     */
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newCitationForm(Model model) {
        model.addAttribute("citationTypes", CitationType.BOOK);
        return "addCitationSetType";
    }

    /**
     * Directs user to a citation creation form
     *
     * @return name of the .jsp page
     */
    @RequestMapping(value = "setFields", method = RequestMethod.POST)
    public String newCitationForm(Model model, @RequestBody String citationType, @ModelAttribute("citation") Citation citation) {
        if (citationType.contains("oo")) {
            citation.setCiteType(CitationType.BOOK);
        } else if (citationType.contains("icl")) {
            citation.setCiteType(CitationType.ARTICLE);
        } else {
            citation.setCiteType(CitationType.INPROCEEDINGS);
        }
        model.addAttribute("citationType", citation.getCiteType().getName());
        model.addAttribute("citation", citation);
        return "addCitationSetFields";
    }

    /**
     * Directs user to listAll page if the form for creating a new citation
     * was filled correctly
     *
     * @param citation is a citation object
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createNewCitation(@Valid @ModelAttribute("citation") Citation citation,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            citationService.insert(citation);
            return "redirect:listAll";
        }
    }

    /**
     * Directs user to a page that shows wanted citation as BibTeX
     *
     * @param model
     * @param citation
     * @return
     */
    @RequestMapping(value = "bibtex", method = RequestMethod.GET)
    public String showCitesInBibtexForm(Model model, @ModelAttribute("citation") Citation citation) {
        model.addAttribute("citations", citationService.listAll());
        return "listBibTeX";
    }

    /**
     * Directs user to tag manipulation page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "tag", method = RequestMethod.GET)
    public String showTagPage(Model model) {
        model.addAttribute("tags", tagService.getAll());
        return "tag";
    }

    /**
     * Directs back to tag page after removing deleted tag from the tag list
     *
     * @param model has very small tits
     * @param tag rhymes well with fag
     * @return of the killer rabbit. He will nibble your legs off, you just
     * wait.
     */
    @RequestMapping(value = "deletetag/${tag}", method = RequestMethod.GET)
    public String deleteTag(Model model, @PathVariable Integer tag) {
        tagService.removeTag(tag);
        model.addAttribute("tags", tagService.getAll());
        return "redirect:listAll";
    }

//    /**
//     * Creates a new tag and redirects to listAll page, unless there are errors.
//     * Needs validation <-------------------
//     * @param model
//     * @param tag
//     * @return 
//     */
    @RequestMapping(value = "createtag", method = RequestMethod.POST)
    public String createTag(Model model, @ModelAttribute("tagname") String tag) {
        //tagService.insert(tag);
        return "redirect:listAll";
    }
}
