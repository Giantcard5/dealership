package main.java.com.dealership.model;

public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private int year;
    private double price;

    public Vehicle(int id, String brand, String model, int year,double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public int getId() {
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
    public String toString() {
        return "ID: " + id + " Brand: " + brand + " Model: " + model + " Year: " + year + " Price: " + price;
    }
}
