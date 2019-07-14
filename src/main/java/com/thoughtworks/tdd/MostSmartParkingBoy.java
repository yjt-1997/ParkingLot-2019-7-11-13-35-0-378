package com.thoughtworks.tdd;

import java.util.List;

public class MostSmartParkingBoy extends ParkingBoy{

    @Override
    public Ticket parkCar(Car car) {
        double biggestRemainderRate = 0;
        int index = 0;
        for (int i = 0; i < parkingLots.size(); i++) {
            ParkingLot parkingLot = parkingLots.get(i);
            double remainderRate = parkingLot.getRemainderRate();
            if (remainderRate > biggestRemainderRate) {
                biggestRemainderRate = remainderRate;
                index = i;
            }
        }
        if(biggestRemainderRate==0){
            System.out.print("位置不足\n");
            return null;
        }
        return parkingLots.get(index).parkCar(car);
    }

    public MostSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
}
