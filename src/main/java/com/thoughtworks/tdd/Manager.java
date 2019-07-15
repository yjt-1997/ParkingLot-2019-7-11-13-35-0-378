package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Manager implements Parkable {

    private List<Parkable> parkables;

    @Override
    public Ticket parkCar(Car car) {
        if (car == null){
            return null;
        }
        if (!isFull()) {
            return parkables.stream().filter(parkable -> !parkable.isFull()).findFirst().get().parkCar(car);
        }
        System.out.print("位置不足\n");
        return null;
    }

    @Override
    public Car fetchCar(Ticket ticket) {
        if (ticket == null || !containsTicket(ticket)) {
            System.out.print("未识别的停车单\n");
            return null;
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
