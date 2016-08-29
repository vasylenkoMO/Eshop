package com.testEshop.controller;

import com.testEshop.dao.ClientDao;
import com.testEshop.editor.SourceEditor;
import com.testEshop.model.entity.Client;
import com.testEshop.model.entity.Source;
import com.testEshop.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Controller
@RequestMapping(value = {"/"})
public class EshopController {

    @Autowired
    SourceService sourceService;

    @Autowired
    ClientDao clientDao;

    @Autowired
    private SourceEditor sourceEditor;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {

        return "home";
    }

    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        return "products";
    }

    @RequestMapping(value = {"/contactus"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        return "contactus";
    }

    @RequestMapping(value = { "/registration"}, method = RequestMethod.GET)
    public String registerPage(ModelMap modelMap) {

        Client client = new Client();
        modelMap.addAttribute("client", client);
        List<Source> sources = sourceService.findAll();
        modelMap.addAttribute("sources", sources);
        return "registration";
    }

    @InitBinder
    public void initBuilder(WebDataBinder binder) {
        binder.registerCustomEditor(Source.class, this.sourceEditor);
    }
    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String saveClient(@Valid Client client, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) {
            return "registration";
        }

        clientDao.save(client);

        modelMap.addAttribute("success", "Client: " + client.getLastName() + " " + client.getLastName() + " registered"
                + "successfully");
        return "home";
    }







}
