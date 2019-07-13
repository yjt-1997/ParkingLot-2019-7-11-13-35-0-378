package com.thoughtworks.tdd;

import java.util.Objects;

public class Ticket {

    private boolean isUsed;

    public void useTicket() {
        isUsed = true;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public Ticket(Car car) {
        isUsed = false;
    }
}
