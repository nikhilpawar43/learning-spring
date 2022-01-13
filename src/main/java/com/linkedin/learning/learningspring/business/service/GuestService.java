package com.linkedin.learning.learningspring.business.service;

import com.linkedin.learning.learningspring.data.domain.Guest;
import com.linkedin.learning.learningspring.data.repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {
    
    private GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAll() {
        Iterable<Guest> allGuest = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        
        allGuest.forEach(guestList::add);
        guestList.sort(Comparator.comparing(Guest::getFirstName).thenComparing(Guest::getLastName));
        return guestList;        
    }
}
