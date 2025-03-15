package main.java.com.dealership.service;

import main.java.com.dealership.model.Vehicle;
import main.java.com.dealership.repository.VehicleRepository;

import java.util.Scanner;

public class VehicleService {
    VehicleRepository vehicleRepository;
    Scanner scanner = new Scanner(System.in);

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void listVehicles() {
        if (vehicleRepository.getVehicles().isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            System.out.println("\n=== Veículos Cadastrados ===");
            for (Vehicle v : vehicleRepository.getVehicles()) {
                System.out.println(v);
            }
        }
    }

    public void addVehicle() {
        System.out.println("\nDigite a marca do veículo:");
        String brand = scanner.nextLine();

        System.out.println("Digite o modelo do veículo:");
        String model = scanner.nextLine();

        System.out.println("Digite o ano do veículo:");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a quilometragem do veículo:");
        int mileage = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o preço do veículo:");
        int price = Integer.parseInt(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(brand, model, year, mileage, price);
        vehicleRepository.addVehicle(newVehicle);
        System.out.println("Veículo adicionado com sucesso. ID: " + newVehicle.getId());
    }

    public void removeVehicle() {
        System.out.println("\nDigite o ID do veículo a ser removido:");
        String idToRemove = scanner.nextLine();

        Vehicle removedVehicle = vehicleRepository.removeVehicle(idToRemove);
        if (removedVehicle != null) {
            System.out.println("Veículo removido: " + removedVehicle);
        } else {
            System.out.println("Veículo com o ID fornecido não foi encontrado.");
        }
    }
}
