package net.javabeat.spring.data.domain;

import javax.persistence.*;
import java.io.Serializable;

//tablica w bazie danych, hibernate sam sobie podmieni to w bazie jak
//
@Entity
//@Table(name="reservation")
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name="userid")
    long userId;
    @Column(name="date")
    String date;
    @Column(name="time")
    String time;
    @Column(name="pairOfShoes")
    int pairsOfShoes;
    @Column(name="numberOfPlayers")
    int numberOfPlayers;

    public Reservation(long id, long userId, String date, String time, int pairsOfShoes, int numberOfPlayers) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.pairsOfShoes = pairsOfShoes;
        this.numberOfPlayers = numberOfPlayers;
    }

    public Reservation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPairsOfShoes() {
        return pairsOfShoes;
    }

    public void setPairsOfShoes(int pairsOfShoes) {
        this.pairsOfShoes = pairsOfShoes;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
