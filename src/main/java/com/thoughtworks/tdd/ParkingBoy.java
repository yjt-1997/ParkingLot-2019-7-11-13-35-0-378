package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.NotEnoughPositionException;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy extends Parker {

    @Override
    public Ticket parkCar(Car car) {
        if (!isFull()) {
            return parkingLots.stream().filter(parkingLot -> !parkingLot.isFull()).findFirst().get().parkCar(car);
        }
        throw new NotEnoughPositionException();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public ParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }
}
