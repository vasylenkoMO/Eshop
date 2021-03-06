package com.testEshop.controller;

import com.testEshop.dao.ClientDao;
import com.testEshop.editor.SourceEditor;
import com.testEshop.model.entity.Client;
import com.testEshop.model.entity.ClientProfile;
import com.testEshop.model.entity.Source;
import com.testEshop.service.CLientProfileService;
import com.testEshop.service.ClientService;
import com.testEshop.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Controller class for "/registration" url.
 *
 * @author Maksym Vasylenko
 * @version 1.0.0 31.08.2016
 */
@Controller
@RequestMapping(value = "/")
public class EshopRegistrationController {

    @Autowired
    SourceService sourceService;

    @Autowired
    ClientDao clientDao;

    @Autowired
    CLientProfileService cLientProfileService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    private SourceEditor sourceEditor;

    @Autowired
    ClientService clientService;
    @RequestMapping(value = { "/registration"}, method = RequestMethod.GET)
    public String registerPage(ModelMap modelMap) {

        Client client = new Client();
        modelMap.addAttribute("client", client);
        List<Source> sources = sourceService.findAll();
        modelMap.addAttribute("sources", sources);
        modelMap.addAttribute("roles", initializeProfiles());
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

        if(!clientService.isUserSSOUnique(client.getId(), client.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId",
                    new String[]{client.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }
        clientDao.save(client);

        modelMap.addAttribute("success", "Client: " + client.getLastName() + " " + client.getLastName() + " registered"
                + "successfully");

        clientService.sendClientRegisterConfirmation(client);
        return "home";
    }

    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("roles")
    public List<ClientProfile> initializeProfiles() {
        return cLientProfileService.findAll();
    }

}
