package com.linkedin.learning.learningspring.data.repository;

import com.linkedin.learning.learningspring.data.domain.Reservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
