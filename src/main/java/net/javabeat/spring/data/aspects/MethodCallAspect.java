package net.javabeat.spring.data.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodCallAspect {
    public static int getAllReservationsCounter = 0;
    public static int deleteReservationCounter = 0;
    public static int updateReservationCounter = 0;
    public static int addReservationCounter = 0;

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.getAllReservations(..))")
    public void beforeAllReservations() {
        getAllReservationsCounter ++;
        System.out.println(getAllReservationsCounter);
    }

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.getReservation(..))")
    public void beforeGetReservation() {
        System.out.println("All reservations will be displaied");
    }

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.deleteReservation(..))")
    public void beforeDeleteReservation() {
        deleteReservationCounter ++;
        System.out.println("Reservation will to be deleted");
    }

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.updateNote(..))")
    public void beforeUpdate() {
        updateReservationCounter ++;
        System.out.println("Reservation will be updated");
    }

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.createNote(..))")
    public void beforeCreateReservation() {
        addReservationCounter ++;
        System.out.println("Reservation will be added");
    }
}
