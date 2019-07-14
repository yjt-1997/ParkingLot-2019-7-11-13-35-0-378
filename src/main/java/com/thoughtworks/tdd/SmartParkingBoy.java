package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    private int index;

    @Override
    public Ticket parkCar(Car car) {
        if (!parkingLots.get(index).isFull()) {
            index = index == (parkingLots.size() - 1) ? 0 : ++index;
            return parkingLots.get(index).parkCar(car);
        }
        for (int i = 0; i < parkingLots.size(); i++) {
            ParkingLot parkingLot = parkingLots.get(i);
            if (!parkingLot.isFull()) {
                index = i == (parkingLots.size() - 1) ? 0 : ++i;
                return parkingLot.parkCar(car);
            }
        }
        System.out.print("位置不足\n");
        return null;
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        index = 0;
    }

}
