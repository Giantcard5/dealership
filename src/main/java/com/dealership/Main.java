package main.java.com.dealership;

import main.java.com.dealership.model.Client;
import main.java.com.dealership.model.Order;
import main.java.com.dealership.model.Vehicle;
import main.java.com.dealership.repository.ClientRepository;
import main.java.com.dealership.repository.OrderRepository;
import main.java.com.dealership.repository.VehicleRepository;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vehicleRepository = new VehicleRepository();
        ClientRepository clientRepository = new ClientRepository();
        OrderRepository orderRepository = new OrderRepository();

        Vehicle vehicle1 = new Vehicle("BMW", "135i M", 2022, 350000);
        Vehicle vehicle2 = new Vehicle("Toyota", "SW4", 2024, 450000);
        vehicleRepository.addVehicle(vehicle1);
        vehicleRepository.addVehicle(vehicle2);

        System.out.println("\nVeículos Cadastrados:");
        for (Vehicle v: vehicleRepository.getVehicles()) {
            System.out.println(v);
        }

        Client client1 = new Client(1, "Renato Soares", "renato@gmail.com", "(11) 12345-6789");
        Client client2 = new Client(2, "Luiza Soares", "luiza@gmail.com", "(11) 12345-6789");
        clientRepository.addClient(client1);
        clientRepository.addClient(client2);

        System.out.println("\nClientes Cadastrados:");
        for (Client c: clientRepository.getClients()) {
            System.out.println(c);
        }

        Order orderClient1 = new Order(1, client1);
        orderClient1.addVehicle(vehicle1);
        orderRepository.addOrder(orderClient1);

        Order orderClient2 = new Order(2, client2);
        orderClient2.addVehicle(vehicle2);
        orderRepository.addOrder(orderClient2);

        System.out.println("\nPedidos Cadastrados:");
        for (Order o: orderRepository.getOrders()) {
            System.out.println(o);
        }

//        System.out.println("\nBuscando Veículo BMW 135i M:");
//        Vehicle foundVehicle = vehicleRepository.findById(vehicle1.getId());
//        System.out.println(foundVehicle != null ? foundVehicle : "Veículo não encontrado.");
//
//        System.out.println("\nRemovendo Veículo BMW 135i M:");
//        Vehicle vehicleRemoved = vehicleRepository.removeVehicle(vehicle1.getId());
//        System.out.println("Veículo de ID " + vehicleRemoved.getId() + " removido.");
//
//        System.out.println("\nNova Lista de Veículos:");
//        for (Vehicle v: vehicleRepository.getVehicles()) {
//            System.out.println(v);
//        }
//
//        System.out.println("\nBuscando Cliente ID 1:");
//        Client foundClient = clientRepository.findById(1);
//        System.out.println(foundClient != null ? foundClient : "Cliente não encontrado.");
//
//        System.out.println("\nRemovendo Cliente ID 1:");
//        Client clientRemoved = clientRepository.removeClient(1);
//        System.out.println("Cliente de ID " + clientRemoved.getId() + " removido.");
//
//        System.out.println("\nNova Lista de Clientes:");
//        for (Client c: clientRepository.getClients()) {
//            System.out.println(c);
//        }
//
//        System.out.println("\nBuscando Pedido ID 1:");
//        Order foundOrder = orderRepository.findById(1);
//        System.out.println(foundOrder != null ? foundOrder : "Pedido não encontrado.");
//
//        System.out.println("\nRemovendo Pedido ID 1:");
//        Order orderRemoved = orderRepository.removeOrder(1);
//        System.out.println("Pedido de ID " + orderRemoved.getId() + " removido.");
//
//        System.out.println("\nNova Lista de Pedidos:");
//        for (Order o: orderRepository.getOrders()) {
//            System.out.println(o);
//        }
    }
}
