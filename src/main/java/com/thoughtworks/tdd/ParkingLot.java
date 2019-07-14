package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket, Car> storeCars;

    public boolean isFull() {
        return storeCars.size() >= capacity;
    }

    public Ticket parkCar(Car car) {
        if (isFull()) {
            System.out.print("位置不足\n");
            return null;
        }
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
        Ticket ticket = new Ticket(car);
        storeCars.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        Car fetchCar = null;
        if (ticket == null) {
            System.out.print("未识别的停车单\n");
            return null;
        }
        if (!ticket.isUsed()) {
            ticket.useTicket();
            fetchCar = storeCars.get(ticket);
            storeCars.remove(ticket);
        }else{
            System.out.print("未识别的停车单\n");
        }
        return fetchCar;
    }

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        storeCars = new HashMap<>(capacity);
    }
}
