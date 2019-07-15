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
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot(4);
        Manager manager = new Manager(parkingLot1,parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1);
        manager.manageParkingBoy(parkingBoy);

        Ticket ticket1 = manager.parkCar(new Car());

        assertNotNull(ticket1);
    }

    @Test
    public void should_return_Ticket_when_manager_parkCar_given_Car() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot(4);
        Manager manager = new Manager(parkingLot1,parkingLot2);

        Ticket ticket1 = manager.parkCar(new Car());

        assertNotNull(ticket1);
        assertThat(parkingLot1.getStoreCars().size(), is(1));
        assertThat(parkingLot2.getStoreCars().size(), is(0));
    }

    @Test
    public void should_return_Message_when_parkCar_given_not_action() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot(4);

        Manager manager = new Manager(parkingLot1,parkingLot2);
        //when
        Ticket ticket1 = manager.parkCar(null);
        //then
        assertNull(ticket1);
    }

}
