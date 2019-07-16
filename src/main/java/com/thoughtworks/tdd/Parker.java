package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.InvalidTicketException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Parker implements Parkable {
    protected List<ParkingLot> parkingLots;

    public abstract Ticket parkCar(Car car);

    @Override
    public Car fetchCar(Ticket ticket) {
        if (ticket == null || !containsTicket(ticket)) {
            throw new InvalidTicketException();
        }
        return parkingLots.stream().filter(
                parkingLot -> parkingLot.containsTicket(ticket)).findFirst().get().fetchCar(ticket);
    }

    @Override
    public boolean isFull() {
        return parkingLots.stream().allMatch(parkingLot -> parkingLot.isFull());
    }

    @Override
    public boolean containsTicket(Ticket ticket) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.containsTicket(ticket));
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Parker(ParkingLot... parkingLots) {
        this.parkingLots = new ArrayList<>(Arrays.asList(parkingLots));
    }
}
