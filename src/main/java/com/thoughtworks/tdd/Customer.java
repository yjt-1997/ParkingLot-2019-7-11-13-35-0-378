package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //客户所拥有的车
    private Car car;
    //客户停车所获得的小票
    private Ticket ticket;

    public void parkCar(ParkingBoy parkingBoy) {
        Ticket ticket = parkingBoy.parkCar(car);
        if (ticket != null) {
            setCar(null);
            setTicket(ticket);
        }
    }

    public void fetchCar(ParkingBoy parkingBoy) {
        Car car = parkingBoy.fetchCar(ticket);
        if (car != null) {
            setCar(car);
            setTicket(null);
        }
    }

    public void buyCar(Car car) {
        setCar(car);
    }

    public Customer() {
    }

    public Customer(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
