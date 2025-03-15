package main.java.com.dealership.model;

import java.util.Objects;
import java.util.UUID;

public class Stock {
    private final String id;
    private Vehicle vehicle;
    private int quantity;

    public Stock(Vehicle vehicle, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void increaseQuantity(int amount) {
        if (quantity > 0) {
            this.quantity += amount;
        }
    }
    public boolean decreaseQuantity(int amount) {
        if (amount > 0 && amount <= this.quantity) {
            this.quantity -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock stock)) return false;
        return id.equals(stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Vehicle: " + vehicle + ", Quantity: " + quantity;
    }
}
