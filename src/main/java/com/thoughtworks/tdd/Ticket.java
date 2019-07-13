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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return isUsed == ticket.isUsed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isUsed);
    }
}
