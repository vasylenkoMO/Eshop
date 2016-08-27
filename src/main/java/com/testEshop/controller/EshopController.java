package com.testEshop.controller;

import com.testEshop.model.entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Controller
@RequestMapping(value = {"/"})
public class EshopController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
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

    @RequestMapping(value = { "/register"}, method = RequestMethod.GET)
    public String registerPage(ModelMap model) {

        Client client = new Client();
        model.addAttribute("client", client);
        return "register";
    }

}
