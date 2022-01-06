package com.linkedin.learning.learningspring.data.repository;

import com.linkedin.learning.learningspring.data.domain.Room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    
}
