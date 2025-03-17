package main.java.com.dealership;

import main.java.com.dealership.controller.*;
import main.java.com.dealership.model.*;
import main.java.com.dealership.repository.*;
import main.java.com.dealership.service.*;

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

        VehicleMenuController vehicleMenu = new VehicleMenuController(vehicleService);
        StockMenuController stockMenu = new StockMenuController(stockService);
        ClientMenuController clientMenu = new ClientMenuController(clientService);
        OrderMenuController orderMenu = new OrderMenuController(orderService);

        MenuController menu = new MenuController(vehicleMenu, stockMenu, clientMenu, orderMenu);
        menu.start();
    }
}
