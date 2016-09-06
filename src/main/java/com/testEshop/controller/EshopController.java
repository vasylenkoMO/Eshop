package com.testEshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *  * Controller class for "/" url.
 *
 * @author Maksym Vasylenko
 * @version 1.0.0 27.08.2016
 */
@Controller
@RequestMapping(value = {"/"})
public class EshopController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {

        return "home";
    }


}
