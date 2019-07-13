package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<Ticket> tickets;

    public Ticket parkCar(Car car){
        if(parkingLot.isFull())
            return null;
        return parkingLot.parkCar(car);
    }

    public Car fetchCar(Ticket ticket){
        return parkingLot.fetchCar(ticket);
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        tickets = new ArrayList<>();
    }
}
