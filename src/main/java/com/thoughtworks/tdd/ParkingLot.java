package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.InvalidCarException;
import com.thoughtworks.tdd.exception.InvalidTicketException;
import com.thoughtworks.tdd.exception.NotEnoughPositionException;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {
    private final int capacity;
    private Map<Ticket, Car> storeCars;
    private Manager manager;

    public boolean isFull() {
        return getRemainder() == 0;
    }

    public Ticket parkCar(Car car) {
        if (car == null || containsCar(car)) {
            throw new InvalidCarException();
        }
        if (isFull()) {
            throw new NotEnoughPositionException();
        }
        Ticket ticket = new Ticket();
        storeCars.put(ticket, car);
        return ticket;
    }

    @Override
    public Car fetchCar(Ticket ticket) {
        if (ticket == null || !containsTicket(ticket)) {
            throw new InvalidTicketException();
        }
        return storeCars.remove(ticket);
    }

    public int getRemainder() {
        return capacity - storeCars.size();
    }

    public double getRemainderRate() {
        return getRemainder() / (double) capacity;
    }

    public boolean containsTicket(Ticket ticket) {
        return storeCars.containsKey(ticket);
    }

    public boolean containsCar(Car car) {
        return storeCars.containsValue(car);
    }

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        storeCars = new HashMap<>(capacity);
    }

    public Map<Ticket, Car> getStoreCars() {
        return storeCars;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
