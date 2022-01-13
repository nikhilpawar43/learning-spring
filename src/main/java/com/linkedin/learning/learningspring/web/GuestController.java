package com.linkedin.learning.learningspring.web;

import com.linkedin.learning.learningspring.business.service.GuestService;
import com.linkedin.learning.learningspring.data.domain.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    
    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }
    
    @GetMapping
    public String findAll(Model model) {
        List<Guest> guests = this.guestService.findAll();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
