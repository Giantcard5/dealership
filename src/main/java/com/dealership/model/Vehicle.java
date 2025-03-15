package main.java.com.dealership.model;

import java.util.Objects;
import java.util.UUID;

public class Vehicle {
    private final String id;
    private String brand;
    private String model;
    private int year;
    private double price;

    public Vehicle(String brand, String model, int year,double price) {
        this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public double getPrice() {
        return price;
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
        return "Brand: " + brand + " Model: " + model + " Year: " + year + " Price: " + price;
    }
}
