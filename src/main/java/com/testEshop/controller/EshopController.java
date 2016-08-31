package com.testEshop.controller;

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
    public String homePage(ModelMap modelMap) {

        return "home";
    }


}
