package com.thoughtworks.tdd;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

public class MostSmartParkingBoyTest {

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
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot(4);
        MostSmartParkingBoy mostSmartParkingBoy = new MostSmartParkingBoy(parkingLot1,parkingLot2);
        //when
        Ticket ticket1 = mostSmartParkingBoy.parkCar(new Car());
        Ticket ticket2 = mostSmartParkingBoy.parkCar(new Car());
        Ticket ticket3 = mostSmartParkingBoy.parkCar(new Car());
        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
        assertEquals(parkingLot1.getRemainder(),8);
        assertEquals(parkingLot2.getRemainder(),3);
    }
}
