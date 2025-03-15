package main.java.com.dealership.service;

import main.java.com.dealership.model.Order;
import main.java.com.dealership.model.Client;
import main.java.com.dealership.model.Vehicle;
import main.java.com.dealership.model.Stock;
import main.java.com.dealership.repository.OrderRepository;
import main.java.com.dealership.repository.ClientRepository;
import main.java.com.dealership.repository.VehicleRepository;
import main.java.com.dealership.repository.StockRepository;

import java.util.Scanner;

public class OrderService {
    OrderRepository orderRepository;
    ClientRepository clientRepository;
    VehicleRepository vehicleRepository;
    StockRepository stockRepository;
    Scanner scanner = new Scanner(System.in);

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, VehicleRepository vehicleRepository, StockRepository stockRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.vehicleRepository = vehicleRepository;
        this.stockRepository = stockRepository;
    }

    public void listOrders() {
        if (orderRepository.getOrders().isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
        } else {
            System.out.println("\nPedidos Cadastrados:");
            orderRepository.getOrders().forEach(System.out::println);
        }
    }

    public void addOrder() {
        System.out.println("Clientes cadastrados:");
        clientRepository.getClients().forEach(System.out::println);

        System.out.println("\nDigite o ID do cliente para o pedido:");
        int clientId = Integer.parseInt(scanner.nextLine());

        Client client = clientRepository.findById(clientId);
        if (client == null) {
            System.out.println("Cliente não encontrado. Cadastre o cliente primeiro.");
            return;
        }

        int newOrderId = orderRepository.getOrders().size() + 1;
        Order newOrder = new Order(newOrderId, client);

        System.out.println("Digite a quantidade de veículos para adicionar ao pedido:");
        int vehiclesQuantity = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < vehiclesQuantity; i++) {
            System.out.println("Digite o ID do veículo #" + (i + 1) + ":");
            String vehicleId = scanner.nextLine();

            Vehicle vehicle = vehicleRepository.findById(vehicleId);
            if (vehicle != null) {
                Stock stock = stockRepository.findByVehicleId(vehicle.getId());
                if (stock != null) {
                    boolean success = stock.decreaseQuantity(1);
                    if (success) {
                        stockRepository.updateStock(stock);
                        newOrder.addVehicle(vehicle);

                        System.out.println("Veículo " + vehicle.getModel() + " adicionado ao pedido e estoque atualizado.");
                    } else {
                        System.out.println("Estoque insuficiente para o veículo " + vehicle.getModel() + ". Veículo não adicionado ao pedido.");
                    }
                } else {
                    System.out.println("Registro de estoque não encontrado para o veículo " + vehicle.getModel() + ". Veículo não adicionado ao pedido.");
                }
            } else {
                System.out.println("Veículo com ID " + vehicleId + " não encontrado.");
            }
        }

        orderRepository.addOrder(newOrder);

        System.out.println("Pedido adicionado com sucesso:");
        System.out.println(newOrder);
    }

    public void removeOrder() {
        System.out.println("\nDigite o ID do pedido a ser removido:");
        int orderId = Integer.parseInt(scanner.nextLine());

        Order removedOrder = orderRepository.removeOrder(orderId);
        if (removedOrder != null) {
            for (Vehicle v : removedOrder.getVehicles()) {
                Stock stock = stockRepository.findByVehicleId(v.getId());
                if (stock != null) {
                    int oldQuantity = stock.getQuantity();
                    stock.increaseQuantity(1);
                    stockRepository.updateStock(stock);

                    System.out.println("Veículo " + v.getModel() + " retornado ao estoque. Quantidade anterior: "
                            + oldQuantity + ", nova: " + stock.getQuantity());
                } else {
                    System.out.println("Registro de estoque não encontrado para o veículo " + v.getModel() + ".");
                }
            }
            System.out.println("Pedido removido: " + removedOrder);
        } else {
            System.out.println("Pedido com o ID fornecido não foi encontrado.");
        }
    }
}
