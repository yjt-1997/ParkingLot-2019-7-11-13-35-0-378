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

public class ParkingBoyTest {

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
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = parkingBoy.parkCar(car);

        assertNotNull(ticket);
    }

    @Test
    public void should_return_Car_when_fetchCar_given_Ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = parkingBoy.parkCar(car);

        assertEquals(car, parkingLot.fetchCar(ticket));
    }

    @Test
    public void should_return_right_Cars_when_fetchCar_given_right_Tickets() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkingBoy.parkCar(car2);

        assertEquals(car1, parkingLot.fetchCar(ticket1));
        assertEquals(car2, parkingLot.fetchCar(ticket2));
    }

    @Test
    public void should_return_null_when_fetchCar_given_null() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();

        parkingBoy.parkCar(car1);
        Car car = parkingBoy.fetchCar(null);

        assertNull(car);
    }

    @Test
    public void should_return_null_when_fetchCar_given_usedTicket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Ticket ticket1 = parkingBoy.parkCar(new Car());
        parkingBoy.fetchCar(ticket1);
        Car result = parkingBoy.fetchCar(ticket1);

        assertNull(result);
    }

    @Test
    public void should_return_null_when_parkCar_given_the_parkedCar() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car car1 = new Car();
        parkingBoy.parkCar(car1);
        Ticket result = parkingBoy.parkCar(car1);

        assertNull(result);
    }

    @Test
    public void should_return_message_when_parkCar_given_the_usedTicket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();

        Ticket ticket = parkingBoy.parkCar(car1);
        parkingBoy.fetchCar(ticket);
        Car car = parkingBoy.fetchCar(ticket);

        assertNull(car);
        assertThat(systemOut(), is("未识别的停车单\n"));
    }

    @Test
    public void should_return_message_when_parkCar_given_the_nullCar() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();

        parkingBoy.parkCar(car1);
        Ticket result = parkingBoy.parkCar(null);

        assertNull(result);
        assertThat(systemOut(), is("请提供您的停车票\n"));
    }

    @Test
    public void should_return_messgae_when_parkCar_given_the_full_parkinglot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        parkingBoy.parkCar(new Car());
        Ticket result = parkingBoy.parkCar(new Car());

        assertNull(result);
        assertThat(systemOut(), is("位置不足\n"));
    }

    @Test
    public void should_park_to_second_parkinglot_when_parkCar_given_the_firstFull_and_secondAvailable() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1,parkingLot2);

        parkingBoy.parkCar(new Car());
        Ticket result = parkingBoy.parkCar(new Car());

        assertNotNull(result);
    }
}
