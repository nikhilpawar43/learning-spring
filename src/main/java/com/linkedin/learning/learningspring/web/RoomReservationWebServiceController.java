package com.linkedin.learning.learningspring.web;

import com.linkedin.learning.learningspring.business.dto.RoomReservationDto;
import com.linkedin.learning.learningspring.business.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class RoomReservationWebServiceController {

    private RoomReservationService roomReservationService;

    @Autowired
    public RoomReservationWebServiceController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public List<RoomReservationDto> getReservationsByDate(@RequestParam(value = "date", required = false) String date) {
        Date reservationDate = DateUtils.getDateFromString(date);
        return roomReservationService.getRoomReservationByDate(reservationDate);
    }
}
