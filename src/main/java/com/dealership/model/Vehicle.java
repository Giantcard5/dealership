package main.java.com.dealership.model;

import java.util.Objects;
import java.util.UUID;

public class Vehicle {
    private String id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private int mileage;

    public Vehicle(String brand, String model, int year, int mileage, double price) {
        this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return id.equals(vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " Brand: " + brand + " Model: " + model + " Year: " + year + " Mileage: " + mileage + " Price: " + price + " ]";
    }
}
