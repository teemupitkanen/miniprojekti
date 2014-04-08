package com.ohtu.miniprojektiv2.controller;

import com.ohtu.miniprojektiv2.domain.Citation;
import com.ohtu.miniprojektiv2.service.CitationService;
import com.ohtu.miniprojektiv2.service.TagCitationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class for catching http requests
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
    private TagCitationService tagCitationService;

    /**
     * For now, list all citations when accessing root address
     * @return index page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listAllCitations() {
        return "index";
    }

    /**
     * Directs user to a page where all citations are listed
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
     * @param model is a holder for model attributes
     * @param id is the id of a chosen citation
     * @return name of the .jsp page
     */
    @RequestMapping(value = "citations/{id}", method = RequestMethod.GET)
    public String viewCitation(Model model, @PathVariable Integer id) {
        model.addAttribute("citation", citationService.getById(id));
        model.addAttribute("addedtags", tagCitationService.listTagsByCitationId(id));
        model.addAttribute("missingtags", tagCitationService.getTagsNotLinkedToCitation(id));
        return "viewCitation";
    }

    /**
     * Directs user to a citation creation form
     * @return name of the .jsp page
     */
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newCitationForm(@ModelAttribute("citation") Citation citation) {
        return "new";
    }

    /**
     * Directs user to listAll page if the form for creating a new citation
     * was filled correctly
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
     * @param model
     * @param citation
     * @return 
     */
    @RequestMapping(value="bibtex", method = RequestMethod.GET)
    public String showCitesInBibtexForm(Model model, @ModelAttribute("citation") Citation citation){
        model.addAttribute("citations", citationService.listAll());
        return "listBibTeX";
    }
    
    
    
//    /**
//     * Directs user to tag manipulation page
//     * @param model
//     * @return 
//     */
//    @RequestMapping(value = "tag", method = RequestMethod.GET)
//    public String showTagPage(Model model) {
//        model.addAttribute("tags", tagCitationService.getAllTags());
//        return "tag";
//    }
    
    /**
     * Directs back to tag page after removing deleted tag from the tag list
     * @param model has very small tits
     * @param tag rhymes well with fag
     * @return of the killer rabbit. He will nibble your legs off, you just wait.
     */
    @RequestMapping(value = "deletetag/{tag}", method = RequestMethod.GET)
    public String deleteTag(Model model, @PathVariable Integer tag) {
        tagCitationService.removeTag(tag);
        return "redirect:listAll";
    }
    
    /**
     * Directs to a page for managing tag
     * @param model 
     * @param tagId
     * @return
     */
    @RequestMapping(value = "viewTag/{tag}", method = RequestMethod.GET)
    public String viewTag(Model model, @PathVariable Integer tagId) {
        model.addAttribute("tag", tagCitationService.getCitationsByTagId(tagId));
        return "viewTag";
    }
    
//    /**
//     * Creates a new tag and redirects to tag page, unless there are errors.
//     * Needs validation <-------------------
//     * @param model
//     * @param tag
//     * @return 
//     */
//    @RequestMapping(value = "createtag", method = RequestMethod.POST)
//    public String createTag(Model model, @ModelAttribute("tagname") String tag) {
//        tagCitationService.createTag(tag);
//        return "redirect:tag";
//    }
    
    /**
     * Directs to citation list after adding existing tag
     * @param citationId 
     * @param tagId Id of tag to be added
     * @return
     */
    @RequestMapping(value = "tagwithexisting", method = RequestMethod.POST)
    public String tagcitation(Model model, @RequestParam("citationId") Integer citationId,
            @RequestParam("tagId") Integer tagId) {
        tagCitationService.addTagToCitation(citationId, tagId);
        return "redirect:listAll";
    }
    
    /**
     * Directs to citation list after adding new tag
     * @param citationId 
     * @param tagName Name of the new tag
     * @return
     */
    @RequestMapping(value = "tagwithnew", method = RequestMethod.POST)
    public String tagcitation(Model model, @RequestParam("citationId") Integer citationId,
            @RequestParam("tagName") String tagName) {
        tagCitationService.addTagToCitation(citationId, tagName);
        return "redirect:listAll";
    }
}
