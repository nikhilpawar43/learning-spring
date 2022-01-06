package com.linkedin.learning.learningspring.data.repository;

import com.linkedin.learning.learningspring.data.domain.Guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    
}
