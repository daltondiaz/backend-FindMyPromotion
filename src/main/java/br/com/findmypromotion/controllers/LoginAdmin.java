package br.com.findmypromotion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dalton on 14/11/2016.
 */
@Controller
public class LoginAdmin {

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String getLoginPage(){
        return "admin/admin_login";
    }
}
