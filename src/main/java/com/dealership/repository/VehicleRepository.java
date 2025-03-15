package main.java.com.dealership.repository;

import main.java.com.dealership.model.Vehicle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public Vehicle removeVehicle(int id) {
        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getId() == id) {
                iterator.remove();
                return vehicle;
            }
        }
        return null;
    }
    public void updateVehicle(Vehicle vehicle) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == vehicle.getId()) {
                vehicles.set(i, vehicle);
                break;
            }
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle findById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }
}
