package com.example.task61.controllers;


import com.example.task61.entities.AppRequest;
import com.example.task61.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RequestService requestService;

    @GetMapping(value = "/")
    public String index(Model model){
        List<AppRequest> appRequestList = requestService.getAllItems();
        model.addAttribute("zayavka", appRequestList);
        return "index";
    }
    @GetMapping(value = "/newApps")
    public String newApps(Model model){
        List<AppRequest> newAppsList = requestService.getNewApps(true);
        model.addAttribute("newApps", newAppsList);
        return "newApps";
    }
    @GetMapping(value = "/checkApps")
    public String checkApps(Model model){
        List<AppRequest> newAppsList = requestService.getCheckApps(false);
        model.addAttribute("checkApps", newAppsList);
        return "checkApps";
    }
    @GetMapping(value = "/details/{idshka}")
    public String details(Model model, @PathVariable(name = "idshka") Long id){
        AppRequest item = requestService.getApp(id);
        model.addAttribute("apps", item);
        return "detail";
    }
    @PostMapping(value = "saveApps")
    public String saveApps(AppRequest appRequest){
        requestService.saveApp(appRequest);
        return "redirect:/";
    }
    @GetMapping(value = "addPage")
    public String addPage(){
        return "addApps";
    }
    @PostMapping(value = "addApps")
    public String addApps(AppRequest appRequest){
        requestService.addApp(appRequest);
        return "redirect:/";
    }
}
