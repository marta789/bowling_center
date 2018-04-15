package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Reservation;
import java.util.List;


public interface ReservationService {
    public List<Reservation> getAllReservations();
    public List<Reservation> findByDate(String date);
    public Reservation findReservation(long id);
    public Reservation addReservation(Reservation reservation);
    public void delete(long id);

}

