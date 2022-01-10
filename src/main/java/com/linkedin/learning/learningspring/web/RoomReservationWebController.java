package com.linkedin.learning.learningspring.web;

import com.linkedin.learning.learningspring.business.dto.RoomReservationDto;
import com.linkedin.learning.learningspring.business.service.RoomReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/reservations")
public class RoomReservationWebController {
    
    private final RoomReservationService roomReservationService;

    @Autowired
    public RoomReservationWebController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }
    
    @GetMapping
    public String getReservationForDate(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = DateUtils.getDateFromString(dateString);
        List<RoomReservationDto> reservations = roomReservationService.getRoomReservationByDate(date);
        
        model.addAttribute("reservations", reservations);
        return "reservations";
    }
}
