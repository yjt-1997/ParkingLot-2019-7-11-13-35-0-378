package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket, Car> storeCars;

    public boolean isFull() {
        return storeCars.size() >= capacity;
    }

    public Ticket parkCar(Car car) {
        if(isFull())
            return  null;
        Ticket ticket = new Ticket();
        storeCars.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        Car fetchCar = storeCars.get(ticket);
        storeCars.remove(ticket);
        return fetchCar;
    }

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        storeCars = new HashMap<>(capacity);
    }
}
