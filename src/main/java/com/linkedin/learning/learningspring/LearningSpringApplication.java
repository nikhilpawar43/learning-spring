package com.linkedin.learning.learningspring;

import com.linkedin.learning.learningspring.data.domain.Room;
import com.linkedin.learning.learningspring.data.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LearningSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringApplication.class, args);
    }

}

@RestController
@RequestMapping("/rooms")
class RoomController {
    
    private RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("")
    public Iterable<Room> getRooms() {
        return this.roomRepository.findAll();
    }
}
