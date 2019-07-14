package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingBoyTest {

    @Test
    public void should_return_Ticket_when_parkCar_given_Car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_Car_when_fetchCar_given_Ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        //then
        assertEquals(car, parkingLot.fetchCar(ticket));
    }

    @Test
    public void should_return_right_Cars_when_fetchCar_given_right_Tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkingBoy.parkCar(car2);
        //then
        assertEquals(car1, parkingLot.fetchCar(ticket1));
        assertEquals(car2, parkingLot.fetchCar(ticket2));
    }

    @Test
    public void should_return_null_when_fetchCar_given_null() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Car car = parkingBoy.fetchCar(null);
        //then
        assertNull(car);
    }

    @Test
    public void should_return_null_when_fetchCar_given_usedTicket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(car1);
        parkingBoy.fetchCar(ticket1);
        Car result = parkingBoy.fetchCar(ticket1);
        //then
        assertNull(result);
    }

    @Test
    public void should_return_null_when_parkCar_given_the_full_parkinglot() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        Ticket result = parkingBoy.parkCar(car3);
        //then
        assertNull(parkingBoy.fetchCar(result));
    }

    @Test
    public void should_return_null_when_parkCar_given_the_parkedCar() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car1 = new Car();;
        parkingBoy.parkCar(car1);
        Ticket result = parkingBoy.parkCar(car1);
        //then
        assertNull(result);
    }

    @Test
    public void should_return_null_when_parkCar_given_the_nullCar() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car1 = new Car();;
        parkingBoy.parkCar(car1);
        Ticket result = parkingBoy.parkCar(null);
        //then
        assertNull(result);
    }
}
