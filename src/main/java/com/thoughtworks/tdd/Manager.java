package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.InvalidCarException;
import com.thoughtworks.tdd.exception.InvalidTicketException;
import com.thoughtworks.tdd.exception.NotEnoughPositionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Manager implements Parkable {

    private List<Parkable> parkables;

    @Override
    public Ticket parkCar(Car car) {
        if (car == null){
            throw new InvalidCarException();
        }
        if (isFull()) {
            throw new NotEnoughPositionException();

        }
        return parkables.stream().filter(parkable -> !parkable.isFull()).findFirst().get().parkCar(car);
    }

    @Override
    public Car fetchCar(Ticket ticket) {
        if (ticket == null || !containsTicket(ticket)) {
            throw new InvalidTicketException();
        }
        return parkables.stream().filter(
                parkingLot -> parkingLot.containsTicket(ticket)).findFirst().get().fetchCar(ticket);
    }

    @Override
    public boolean containsTicket(Ticket ticket) {
        return parkables.stream().anyMatch(parkable -> parkable.containsTicket(ticket));
    }

    @Override
    public boolean isFull() {
        for(Parkable parkable:parkables){
            if(!parkable.isFull()){
                return false;
            }
        }
        return true;
    }

    public void manageParkingBoy(Parker parker) {
        parkables.add(parker);
    }

    public void setManager() {
        for (Parkable parkable : parkables) {
            if (parkable instanceof ParkingLot)
                ((ParkingLot) parkable).setManager(this);
        }
    }

    public Manager(Parkable... parkables) {
        this.parkables = new ArrayList<>(Arrays.asList(parkables));
        setManager();
    }
}
