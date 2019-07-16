package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.NotEnoughPositionException;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends Parker{

    @Override
    public Ticket parkCar(Car car) {
        if (isFull()) {
            throw new NotEnoughPositionException();
        }
        return parkingLots.stream().max(Comparator.comparingDouble(ParkingLot::getRemainder)).orElse(null).parkCar(car);
    }

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }
}
