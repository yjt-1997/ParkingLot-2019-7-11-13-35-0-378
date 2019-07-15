package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.List;

public class MostSmartParkingBoy extends Parker {

    @Override
    public Ticket parkCar(Car car) {
        if (isFull()) {
            System.out.print("位置不足\n");
            return null;
        }
        ParkingLot parkingLot = parkingLots.stream().max(Comparator.comparingDouble(ParkingLot::getRemainderRate)).orElse(null);
        return parkingLot.parkCar(car);
    }

    public MostSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }
}
