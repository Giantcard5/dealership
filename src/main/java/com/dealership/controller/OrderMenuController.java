package main.java.com.dealership.controller;

import main.java.com.dealership.service.OrderService;

import java.util.Scanner;

public class OrderMenuController {
    private OrderService orderService;
    private Scanner scanner = new Scanner(System.in);

    public OrderMenuController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void start() {
        int option = 0;
        while (option != 4) {
            System.out.println("\n===== MENU PEDIDOS =====");
            System.out.println("1 - Listar Pedidos");
            System.out.println("2 - Adicionar Pedido");
            System.out.println("3 - Remover Pedido");
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
                    orderService.listOrders();
                    break;
                case 2:
                    orderService.addOrder();
                    break;
                case 3:
                    orderService.removeOrder();
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
