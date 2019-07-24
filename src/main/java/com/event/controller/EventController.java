package com.event.controller;

import com.event.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/list")
    public String getUserWithFormForLastHour(Model model) {
        model.addAttribute("events", eventService.findAllForLastHour());
        return "users";
    }

    @GetMapping("/form")
    public String getTopFiveForms(Model model) {
        model.addAttribute("forms", eventService.getTopFiveForms());
        return "forms";
    }

    @GetMapping("/between")
    public String getBetween(HttpServletRequest request) {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        request.setAttribute("events", eventService.getBetween(startDate, endDate, startTime, endTime));
        return "users";
    }

}
