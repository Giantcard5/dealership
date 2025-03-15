package main.java.com.dealership.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private Client client;
    private List<Vehicle> vehicles;
    private LocalDate orderDate;
    private double totalValue;

    public Order(int id, Client client) {
        this.id = id;
        this.client = client;
        this.vehicles = new ArrayList<>();
        this.orderDate = LocalDate.now();
        this.totalValue = 0.00;
    }

    public int getId() {
        return id;
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        totalValue += vehicle.getPrice();
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " Client: " + client + " Vehicles: " + vehicles + " Order Date: " + orderDate + " Total Value: " + totalValue + " ]";
    }
}
