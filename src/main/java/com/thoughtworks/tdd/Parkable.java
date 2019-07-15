package com.thoughtworks.tdd;

public interface Parkable {
    Ticket parkCar(Car car);
    Car fetchCar(Ticket ticket);
    boolean isFull();
    boolean containsTicket(Ticket ticket);
}
