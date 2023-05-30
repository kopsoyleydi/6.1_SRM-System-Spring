package com.example.task61.controllers;


import com.example.task61.entities.AppRequest;
import com.example.task61.entities.CourseEntity;
import com.example.task61.repository.CourseRepository;
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

    @Autowired
    private CourseRepository courseRepository;

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
        model.addAttribute("item", item);
        List<CourseEntity> courseEntities = courseRepository.findAll();
        model.addAttribute("courses", courseEntities);
        return "detail";
    }

    @PostMapping(value = "saveApps")
    public String saveItem(@RequestParam(name = "id", defaultValue = "0") Long id,
                           @RequestParam(name = "userName", defaultValue = "No Item") String userName,
                           @RequestParam(name = "course_id") Long course_id,
                           @RequestParam(name = "phone", defaultValue = "0") String phone,
                           @RequestParam(name = "commentary", defaultValue = "0") String commentary,
                           @RequestParam(name = "handled", defaultValue = "0") boolean handled) {
       AppRequest appRequest = requestService.getApp(id);
        CourseEntity courses = courseRepository.findAllById(id);
        if(appRequest!=null) {
            appRequest.setUserName(userName);
            appRequest.setCommentary(commentary);
            appRequest.setPhone(phone);
            appRequest.setHandled(handled);
            appRequest.setCourses(courses);
            requestService.saveApp(appRequest);
        }
        return "redirect:/";
    }
    @GetMapping(value = "addPage")
    public String addPage(Model model){
        List<AppRequest> appRequestList = requestService.getAllItems();
        List<CourseEntity> courseEntities = courseRepository.findAll();
        model.addAttribute("zayavka", appRequestList);
        model.addAttribute("courses", courseEntities);
        return "addApps";
    }
    @PostMapping(value = "addApps")
    public String addApps(AppRequest appRequest){
        requestService.addApp(appRequest);
        return "redirect:/";
    }
    @PostMapping(value = "/deleteApp")
    public String deleteMap(@RequestParam(name = "id") Long id){
        requestService.deleteApp(id);
        return "redirect:/";
    }
    @PostMapping(value = "/progessApp")
    public String progessApp(AppRequest appRequest){
        appRequest.setHandled(false);
        requestService.saveApp(appRequest);
        return "redirect:/";
    }
}
