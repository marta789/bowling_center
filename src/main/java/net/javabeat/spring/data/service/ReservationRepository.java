package net.javabeat.spring.data.service;


import net.javabeat.spring.data.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
