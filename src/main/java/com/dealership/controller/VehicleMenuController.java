package main.java.com.dealership.controller;

import main.java.com.dealership.service.VehicleService;

import java.util.Scanner;

public class VehicleMenuController {
    private VehicleService vehicleService;

    private Scanner scanner = new Scanner(System.in);

    public VehicleMenuController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void start() {
        int option = 0;
        while (option != 4) {
            System.out.println("\n===== MENU VEÍCULOS =====");
            System.out.println("1 - Listar Veículos");
            System.out.println("2 - Adicionar Veículo");
            System.out.println("3 - Remover Veículo");
            System.out.println("4 - Voltar");

            System.out.print("Escolha uma opção: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Escolha uma opção!");
                continue;
            }
            switch (option) {
                case 1:
                    vehicleService.listVehicles();
                    break;
                case 2:
                    vehicleService.addVehicle();
                    break;
                case 3:
                    vehicleService.removeVehicle();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }
}
