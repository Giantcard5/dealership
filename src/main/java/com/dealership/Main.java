package main.java.com.dealership;

import main.java.com.dealership.controller.*;
import main.java.com.dealership.repository.*;
import main.java.com.dealership.service.*;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vehicleRepository = new VehicleRepository();
        ClientRepository clientRepository = new ClientRepository();
        StockRepository stockRepository = new StockRepository();
        OrderRepository orderRepository = new OrderRepository();

        ClientService clientService = new ClientService(clientRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        StockService stockService = new StockService(stockRepository, vehicleRepository);
        OrderService orderService = new OrderService(orderRepository, clientRepository, vehicleRepository, stockRepository);

        VehicleMenuController vehicleMenu = new VehicleMenuController(vehicleService);
        StockMenuController stockMenu = new StockMenuController(stockService);
        ClientMenuController clientMenu = new ClientMenuController(clientService);
        OrderMenuController orderMenu = new OrderMenuController(orderService);

        MenuController menu = new MenuController(vehicleMenu, stockMenu, clientMenu, orderMenu);
        menu.start();
    }
}
