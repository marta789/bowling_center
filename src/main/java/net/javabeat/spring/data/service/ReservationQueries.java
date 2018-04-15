package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReservationQueries extends Repository<Reservation, Long> {

    @Query(value = "select * from #{#entityName} b where b.date=?1", nativeQuery = true)
    List<Reservation> findByDate(String date);


}


