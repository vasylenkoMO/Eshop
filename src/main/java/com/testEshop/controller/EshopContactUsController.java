package com.testEshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class for "/contactus" url.
 *
 * @author Maksym Vasylenko
 * @version 1.0.0 31.08.2016
 *
 */
@Controller
@RequestMapping(value = "/")
public class EshopContactUsController {
    @RequestMapping(value = {"/contactus"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        return "contactus";
    }
}
