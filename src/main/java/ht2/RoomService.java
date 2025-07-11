package ht2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RoomService extends HotelService{

    public enum RoomServiceType {FOOD, DRINK, MAINTENANCE, OTHER}

    private final int numberOfItems;
    private final int deliveryTimeMinutes;
    private final RoomServiceType type;
    private final double tipPercentage;
    private final LocalDateTime timeOfOrder;


    public RoomService(String description, BigDecimal baseCost, int numberOfItems,
                       int deliveryTimeMinutes, RoomServiceType type,
                       double tipPercentage, LocalDateTime timeOfOrder) {
        super(description, baseCost);
        this.numberOfItems = numberOfItems;
        this.deliveryTimeMinutes = deliveryTimeMinutes;
        this.type = type;
        this.tipPercentage = tipPercentage;
        this.timeOfOrder = timeOfOrder;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    @Override
    public BigDecimal calculateFinalCost() {
        // For example: base cost + 5 per item ordered
        return getBaseCost().add(BigDecimal.valueOf(5).multiply(BigDecimal.valueOf(numberOfItems)));
    }

    @Override
    public String toString() {
        return "RoomService {" +
                "serviceId='" + getServiceId() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", baseCost=" + getBaseCost() +
                ", numberOfItems=" + numberOfItems +
                ", finalCost=" + calculateFinalCost() +
                '}';
    }
}
