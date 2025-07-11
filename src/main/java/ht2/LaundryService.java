package ht2;

import java.math.BigDecimal;

public class LaundryService extends HotelService implements Chargeable {
    private final int itemCount;

    public LaundryService(String description, BigDecimal baseCost, int itemCount) {
        super(description, baseCost);
        this.itemCount = itemCount;
    }

    @Override
    public BigDecimal calculateFinalCost() {
        return getBaseCost().add(BigDecimal.valueOf(itemCount * 1.5));
    }

    @Override
    public String toString() {
        return "LaundryService[id=" + getServiceId() + ", desc=" + getDescription() + ", cost=" + calculateFinalCost() + "]";
    }

    @Override
    public BigDecimal getChargeAmount() {
        return calculateFinalCost();
    }
}