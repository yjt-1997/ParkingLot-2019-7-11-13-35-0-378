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

public class SmartParkingBoyTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_parkToDifferent_lot_when_parkCar_given_several_Car() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot(4);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1,parkingLot2);

        Ticket ticket1 = smartParkingBoy.parkCar(new Car());
        Ticket ticket2 = smartParkingBoy.parkCar(new Car());

        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertThat(parkingLot1.getStoreCars().size(),is(2));
        assertThat(parkingLot2.getStoreCars().size(),is(0));
    }
}
