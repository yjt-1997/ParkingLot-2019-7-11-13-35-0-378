package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket,Car> storeCars;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        storeCars = new HashMap<>(capacity);
    }

    public Ticket parkCar(Car car){
        Ticket ticket = new Ticket();
        storeCars.put(ticket,car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket){
        return storeCars.get(ticket);
    }
}
