package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.InvalidTicketException;
import com.thoughtworks.tdd.exception.NotEnoughPositionException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingLotTest {

    @Test
    public void should_return_right_car_when_fetchCar_given_the_right_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.parkCar(car);
        //then
        assertEquals(car, parkingLot.fetchCar(ticket));
    }

    @Test
    public void should_return_null_when_parkCar_given_the_full_storage() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();

        Ticket ticket1 = parkingLot.parkCar(car1);

        assertThrows(NotEnoughPositionException.class, () -> parkingLot.parkCar(new Car()));
    }

    @Test
    public void should_decrease_storage_when_fetchCar() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        //when
        Ticket ticket1 = parkingLot.parkCar(car1);
        parkingLot.fetchCar(ticket1);
        Ticket ticket2 = parkingLot.parkCar(car2);
        //then
        assertNotNull(ticket2);
    }
}
