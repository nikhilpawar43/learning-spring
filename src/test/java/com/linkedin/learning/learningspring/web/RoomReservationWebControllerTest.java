package com.linkedin.learning.learningspring.web;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.linkedin.learning.learningspring.business.dto.RoomReservationDto;
import com.linkedin.learning.learningspring.business.service.RoomReservationService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebMvcTest(RoomReservationWebController.class)
public class RoomReservationWebControllerTest {
    
    @MockBean
    private RoomReservationService roomReservationService;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void getReservationForDateTest() throws Exception {
        Date date = DateUtils.getDateFromString("2022-12-01");

        RoomReservationDto roomReservationDto = new RoomReservationDto();
        roomReservationDto.setRoomId(1L);
        roomReservationDto.setRoomName("Junit");
        roomReservationDto.setRoomNumber("Junit_test");
        roomReservationDto.setReservationDate(date);
        roomReservationDto.setGuestId(100L);
        roomReservationDto.setFirstName("Junit");
        roomReservationDto.setLastName("Unit");

        List<RoomReservationDto> roomReservationDtoList = new ArrayList<>();
        roomReservationDtoList.add(roomReservationDto);
        
        when(roomReservationService.getRoomReservationByDate(date)).thenReturn(roomReservationDtoList);
        
        this.mockMvc.perform(get("/reservations?date=2022-12-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Unit, Junit")));
    }
}
