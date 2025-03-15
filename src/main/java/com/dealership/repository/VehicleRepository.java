package main.java.com.dealership.repository;

import main.java.com.dealership.model.Vehicle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class VehicleRepository {
    private Set<Vehicle> vehicles = new HashSet<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public Vehicle removeVehicle(String id) {
        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getId().equals(id)) {
                iterator.remove();
                return vehicle;
            }
        }
        return null;
    }
    public void updateVehicle(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
            vehicles.add(vehicle);
        }
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle findById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }
}
