package net.javabeat.spring.data.web;

import net.javabeat.spring.data.domain.Reservation;
import net.javabeat.spring.data.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping("/")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @RequestMapping("/{id}")
    public Reservation getReservation(@PathVariable(value="id") long id) {
        return reservationService.findReservation(id);
    }

    @RequestMapping(value = "/date/{date}")
    public List<Reservation> getReservationByDate(@PathVariable String date) {
        List<Reservation> reservations = reservationService.findByDate(date);
        return reservations;
    }

//    @RequestMapping(value = "/add/{id}/{userid}/{date}/{time}/{pairsOfShoes}/{numberOfPlayers}")
//    public Reservation addReservation(
//            @PathVariable int id,
//            @PathVariable int userid,
//            @PathVariable String date,
//            @PathVariable String time,
//            @PathVariable int pairsOfShoes,
//            @PathVariable int numberOfPlayers) {
//        Reservation reservation = new Reservation();
//        reservation.setId(id);
//        reservation.setUserId(userid);
//        reservation.setDate(date);
//        reservation.setTime(time);
//        reservation.setPairsOfShoes(pairsOfShoes);
//        reservation.setNumberOfPlayers(numberOfPlayers);
//        reservationService.addReservation(reservation);
//        return reservation;
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Reservation createNote(@Valid @RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Reservation updateNote(@PathVariable(value = "id") Long reservationId,
                           @Valid @RequestBody Reservation requestReservation) {

        Reservation reservation = reservationService.findReservation(reservationId);

        reservation.setUserId(requestReservation.getUserId());
        reservation.setDate(requestReservation.getDate());
        reservation.setTime(requestReservation.getTime());
        reservation.setPairsOfShoes(requestReservation.getPairsOfShoes());
        reservation.setNumberOfPlayers(requestReservation.getNumberOfPlayers());

        Reservation updatedReservation = reservationService.addReservation(reservation);
        return updatedReservation;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable int id) {
//        Reservation reservation = new Reservation();
//        reservation.setId(id);
        reservationService.delete(id);
    }

}
