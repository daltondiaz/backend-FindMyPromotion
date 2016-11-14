package br.com.findmypromotion.controllers;

import br.com.findmypromotion.domain.UserAdmin;
import br.com.findmypromotion.security.Role;
import br.com.findmypromotion.service.implementation.UserAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Dalton on 14/11/2016.
 */
@Controller
@RequestMapping("/admin")
public class UserAdminController  {

    @Autowired
    private UserAdminServiceImpl userAdminService;

    @RequestMapping(value= "/user/create",method= RequestMethod.GET)
    public ModelAndView getUserCreatePage(){
        return new ModelAndView("/admin/user_admin/user","user",new UserAdmin());
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm  (@Valid @ModelAttribute("user") UserAdmin user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/user_admin/user";
        }
        try {
            user.setRole(Role.ADMIN);
            userAdminService.saverOrUpdate(user);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "/admin/user_admin/user";
        }
        return "redirect:/admin/login";
    }
}
