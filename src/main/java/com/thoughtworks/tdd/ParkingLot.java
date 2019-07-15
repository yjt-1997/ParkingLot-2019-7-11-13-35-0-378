package com.thoughtworks.tdd;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {
    private final int capacity;
    private Map<Ticket, Car> storeCars;
    private Manager manager;

    public boolean isFull() {
        return getRemainder() == 0;
    }

    public Ticket parkCar(Car car) {
        if (car == null) {
            System.out.print("请提供您的停车票\n");
            return null;
        }
        for (Ticket ticket : storeCars.keySet()) {
            if (storeCars.get(ticket).equals(car)) {
                System.out.print("这辆车已经停过了\n");
                return null;
            }
        }
        if(isFull()){
            System.out.print("位置不足\n");
            return null;
        }
        Ticket ticket = new Ticket();
        storeCars.put(ticket, car);
        return ticket;
    }

    @Override
    public Car fetchCar(Ticket ticket) {
        if (ticket == null || !containsTicket(ticket)) {
            System.out.print("未识别的停车单\n");
            return null;
        }
        return storeCars.remove(ticket);
    }

    public int getRemainder() {
        return capacity - storeCars.size();
    }

    public double getRemainderRate() {
        return getRemainder() / (double) capacity;
    }

    public boolean containsTicket(Ticket ticket) {
        return storeCars.containsKey(ticket);
    }

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        storeCars = new HashMap<>(capacity);
    }

    public Map<Ticket, Car> getStoreCars() {
        return storeCars;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
