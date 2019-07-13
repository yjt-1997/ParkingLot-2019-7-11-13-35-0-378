package com.thoughtworks.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(car,parkingLot.fetchCar(ticket));
    }
}
