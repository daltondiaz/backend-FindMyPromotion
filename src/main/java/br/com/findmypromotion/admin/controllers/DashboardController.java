package br.com.findmypromotion.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dalton on 14/11/2016.
 */
@Controller
@RequestMapping("/admin")
public class DashboardController {

    @RequestMapping(value = "/dashboard")
    public String dashboard(){
        return "admin/admin_index";
    }
}
