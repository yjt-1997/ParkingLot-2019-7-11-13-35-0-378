package com.thoughtworks.tdd;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_return_Ticket_when_parkCar_given_Car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot(4);
        List<ParkingLot> managerParkingLots = new ArrayList<>();
        managerParkingLots.add(parkingLot1);
        managerParkingLots.add(parkingLot2);
        List<ParkingLot> boyParkingLots = new ArrayList<>();
        boyParkingLots.add(parkingLot1);
        Manager manager = new Manager(managerParkingLots);
        ParkingBoy parkingBoy = new ParkingBoy(boyParkingLots);
        manager.manageParkingBoy(parkingBoy);
        //when
        Ticket ticket1 = manager.parkCar(parkingBoy, new Car());
        //then
        assertNotNull(ticket1);
        assertThat(manager.getParkingLots().get(0).getStoreCars().size(), is(1));
        assertThat(manager.getParkingLots().get(1).getStoreCars().size(), is(0));
        assertEquals(manager.getParkingLots().get(0), parkingBoy.getParkingLots().get(0));
    }

    @Test
    public void should_return_Ticket_when_manager_parkCar_given_Car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot(4);
        List<ParkingLot> managerParkingLots = new ArrayList<>();
        managerParkingLots.add(parkingLot1);
        managerParkingLots.add(parkingLot2);
        ;
        Manager manager = new Manager(managerParkingLots);
        //when
        Ticket ticket1 = manager.parkCar(new Car());
        //then
        assertNotNull(ticket1);
        assertThat(manager.getParkingLots().get(0).getStoreCars().size(), is(1));
        assertThat(manager.getParkingLots().get(1).getStoreCars().size(), is(0));
    }

    @Test
    public void should_return_Message_when_parkCar_given_not_action() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot(4);
        List<ParkingLot> managerParkingLots = new ArrayList<>();
        managerParkingLots.add(parkingLot1);
        managerParkingLots.add(parkingLot2);
        ;
        Manager manager = new Manager(managerParkingLots);
        List<ParkingLot> boyParkingLots = new ArrayList<>();
        boyParkingLots.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(boyParkingLots);
        manager.manageParkingBoy(parkingBoy);
        //when
        Ticket ticket1 = manager.parkCar(parkingBoy, null);
        //then
        assertNull(ticket1);
        assertNotEquals(systemOut().length(), 0);
    }

}
