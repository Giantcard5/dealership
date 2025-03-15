package main.java.com.dealership;

import main.java.com.dealership.model.Client;
import main.java.com.dealership.model.Stock;
import main.java.com.dealership.model.Vehicle;
import main.java.com.dealership.repository.ClientRepository;
import main.java.com.dealership.repository.OrderRepository;
import main.java.com.dealership.repository.StockRepository;
import main.java.com.dealership.repository.VehicleRepository;
import main.java.com.dealership.service.ClientService;
import main.java.com.dealership.service.OrderService;
import main.java.com.dealership.service.StockService;
import main.java.com.dealership.service.VehicleService;

import java.util.Scanner;

public class Dealership {
    public static void main(String[] args) {
        VehicleRepository vehicleRepository = new VehicleRepository();
        ClientRepository clientRepository = new ClientRepository();
        StockRepository stockRepository = new StockRepository();
        OrderRepository orderRepository = new OrderRepository();

        ClientService clientService = new ClientService(clientRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        StockService stockService = new StockService(stockRepository, vehicleRepository);
        OrderService orderService = new OrderService(orderRepository, clientRepository, vehicleRepository, stockRepository);

        Vehicle vehicle1 = new Vehicle("BMW", "135i M", 2022, 0, 350000);
        vehicleRepository.addVehicle(vehicle1);

        Stock stock1 = new Stock(vehicle1, 1);
        stockRepository.addStock(stock1);

        Client client1 = new Client(1, "Renato Soares", "renato@gmail.com", "(11) 12345-6789");
        clientRepository.addClient(client1);

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 15) {
            System.out.println("\n===== MENU =====");
            System.out.println("1  - Listar Veículos Cadastrados");
            System.out.println("2  - Adicionar Veículo");
            System.out.println("3  - Remover Veículo");
            System.out.println("4  - Listar Estoque");
            System.out.println("5  - Adicionar Veículo no Estoque");
            System.out.println("6  - Remover Veículo do Estoque");
            System.out.println("7  - Adicionar Quantidade de Veículos no Estoque");
            System.out.println("8  - Remover Quantidade de Veículos no Estoque");
            System.out.println("9  - Listar Clientes");
            System.out.println("10 - Adicionar Cliente");
            System.out.println("11 - Remover Cliente");
            System.out.println("12 - Listar Pedidos");
            System.out.println("13 - Adicionar Pedido");
            System.out.println("14 - Remover Pedido");
            System.out.println("15 - Sair");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, digite um número.");
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
                    stockService.listStock();
                    break;
                case 5:
                    stockService.addStock();
                    break;
                case 6:
                    stockService.removeStock();
                    break;
                case 7:
                    stockService.increaseStock();
                    break;
                case 8:
                    stockService.decreaseStock();
                    break;
                case 9:
                    clientService.listClients();
                    break;
                case 10:
                    clientService.addClient();
                    break;
                case 11:
                    clientService.removeClient();
                    break;
                case 12:
                    orderService.listOrders();
                    break;
                case 13:
                    orderService.addOrder();
                    break;
                case 14:
                    orderService.removeOrder();
                    break;
                case 15:
                    System.out.println("Saindo da aplicação.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
