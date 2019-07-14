package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots;
    protected List<Ticket> tickets;

    public Ticket parkCar(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull())
                return parkingLot.parkCar(car);
        }
        System.out.print("位置不足\n");
        return null;
    }

    public Car fetchCar(Ticket ticket) {
        if (ticket == null || ticket.isUsed()) {
            System.out.print("未识别的停车单\n");
            return null;
        }
        Car fetchCar = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getStoreCars().containsKey(ticket)) {
                fetchCar = parkingLot.fetchCar(ticket);
                break;
            }
        }
        return fetchCar;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        tickets = new ArrayList<>();
    }

    public void addParkingLot(ParkingLot parkingLot){
        parkingLots.add(parkingLot);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
