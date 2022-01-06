package com.linkedin.learning.learningspring.business.service;

import com.linkedin.learning.learningspring.business.dto.RoomReservationDto;
import com.linkedin.learning.learningspring.data.domain.Guest;
import com.linkedin.learning.learningspring.data.domain.Reservation;
import com.linkedin.learning.learningspring.data.domain.Room;
import com.linkedin.learning.learningspring.data.repository.GuestRepository;
import com.linkedin.learning.learningspring.data.repository.ReservationRepository;
import com.linkedin.learning.learningspring.data.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Service
public class RoomReservationService {
    
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public RoomReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }
    
    public List<RoomReservationDto> getRoomReservationByDate(Date date) {
        Iterable<Room> allRooms = this.roomRepository.findAll();
        Map<Long, RoomReservationDto> roomReservationDtoMap = new HashMap<>();
        
        allRooms.forEach(room -> {
            RoomReservationDto roomReservationDto = new RoomReservationDto();
            roomReservationDto.setRoomId(room.getRoomId());
            roomReservationDto.setRoomName(room.getName());
            roomReservationDto.setRoomNumber(room.getRoomNumber());

            roomReservationDtoMap.put(room.getRoomId(), roomReservationDto);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            RoomReservationDto roomReservationDto = roomReservationDtoMap.get(reservation.getRoomId());
            
            roomReservationDto.setReservationDate(date);
            roomReservationDto.setGuestId(guest.getGuestId());
            roomReservationDto.setFirstName(guest.getFirstName());
            roomReservationDto.setLastName(guest.getLastName());

        });
        
        return roomReservationDtoMap.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
    }
}
