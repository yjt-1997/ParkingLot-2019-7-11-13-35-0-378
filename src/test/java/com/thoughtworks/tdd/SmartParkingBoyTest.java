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
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        //when
        Ticket ticket1 = smartParkingBoy.parkCar(new Car());
        Ticket ticket2 = smartParkingBoy.parkCar(new Car());
        //then
        assertNotNull(ticket1);
        assertNotNull(ticket1);
        assertThat(smartParkingBoy.getParkingLots().get(0).getStoreCars().size(),is(1));
        assertThat(smartParkingBoy.getParkingLots().get(1).getStoreCars().size(),is(1));
    }
}
