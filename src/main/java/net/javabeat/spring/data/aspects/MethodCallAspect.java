package net.javabeat.spring.data.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodCallAspect {
    @Before("execution(* net.javabeat.spring.data.web.ReservationController.getAllReservations(..))")
    public void beforeAllReservations() {
        System.out.println("Before get All reservations()");
    }

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.getReservation(..))")
    public void beforeGetReservation() {
        System.out.println("Before get Reservation()");
    }

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.deleteReservation(..))")
    public void beforeDeleteReservation() {
        System.out.println("Before delete Reservation()");
    }

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.updateNote(..))")
    public void beforeUpdate() {
        System.out.println("Before update Reservation()");
    }

    @Before("execution(* net.javabeat.spring.data.web.ReservationController.createNote(..))")
    public void beforeCreateReservation() {
        System.out.println("Before create Reservation()");
    }
}
