package com.thoughtworks.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        assertEquals(car,parkingLot.fetchCar(ticket));
    }

    @Test
    public void should_return_right_Car_when_fetchCar_given_right_Ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkingBoy.parkCar(car2);
        //then
        assertEquals(car1,parkingLot.fetchCar(ticket1));
        assertEquals(car2,parkingLot.fetchCar(ticket2));
    }

    @Test
    public void should_return_null_when_fetchCar_given_null(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(car1);
        //then
        assertNull(parkingBoy.fetchCar(null));
    }

    @Test
    public void should_return_null_when_fetchCar_given_usedTicket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(car1);
        parkingBoy.fetchCar(ticket1);
        //then
        assertNull(parkingBoy.fetchCar(ticket1));
    }
}
