package ht2;

import java.math.BigDecimal;

public class SpaTreatment extends HotelService implements Bookable, Chargeable {
    private final int durationMinutes;

    public SpaTreatment(String description, BigDecimal baseCost, int durationMinutes) {
        super(description, baseCost);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public BigDecimal calculateFinalCost() {
        return getBaseCost().add(BigDecimal.valueOf(durationMinutes * 0.5));
    }

    @Override
    public String toString() {
        return "SpaTreatment[id=" + getServiceId() + ", desc=" + getDescription() + ", cost=" + calculateFinalCost() + "]";
    }

    @Override
    public BigDecimal getChargeAmount() {
        return calculateFinalCost();
    }

    private boolean booked = false;

    @Override
    public boolean isBooked() {
        return booked;
    }

    @Override
    public void setBooked(boolean booked) {
        this.booked = booked;
    }


}