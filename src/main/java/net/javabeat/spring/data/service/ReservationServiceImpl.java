package net.javabeat.spring.data.service;


import net.javabeat.spring.data.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationQueries reservationQueries;

    public List<Reservation> getAllReservations(){
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations :: add);
        return reservationRepository.findAll();//reservations;
    }

    public List<Reservation> findByDate(String date) {
        return reservationQueries.findByDate(date);
    }


    public Reservation findReservation(long id){
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation addReservation(Reservation reservation){
        reservationRepository.save(reservation);
        return reservation;
    }

    public void delete(long id) {
        reservationRepository.deleteById(id);
    }
}
