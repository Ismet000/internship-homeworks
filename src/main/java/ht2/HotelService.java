package ht2;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class HotelService {
    private final String serviceId;
    private final String description;
    private final BigDecimal baseCost;

    public HotelService(String description, BigDecimal baseCost) {
        this.serviceId = "S-" + UUID.randomUUID();
        this.description = description;
        this.baseCost = baseCost;
    }

    public String getServiceId() { return serviceId; }
    public String getDescription() { return description; }
    public BigDecimal getBaseCost() { return baseCost; }

    public abstract BigDecimal calculateFinalCost();

    @Override
    public abstract String toString();
}
