package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<ParkingBoy> parkingBoys;

    @Override
    public Ticket parkCar(Car car) {
        return super.parkCar(car);
    }

    public Ticket parkCar(ParkingBoy parkingBoy,Car car){
        return parkingBoy.parkCar(car);
    }

    public void manageParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public void manage(ParkingBoy parkingBoy, ParkingLot parkingLot) {
        if (!parkingBoy.getParkingLots().contains(parkingLot))
            parkingBoy.addParkingLot(parkingLot);
        if(!parkingBoys.contains(parkingBoy))
            parkingBoys.add(parkingBoy);

    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public void setManager(){
        for(ParkingLot parkingLot:parkingLots){
            parkingLot.setManager(this);
        }
    }

    public Manager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parkingBoys = new ArrayList<>();
        setManager();
    }

    public Manager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
        setManager();
    }

}
