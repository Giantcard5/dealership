package main.java.com.dealership.controller;

import java.util.Scanner;

public class MenuController {
    private Scanner scanner = new Scanner(System.in);

    private VehicleMenuController vehicleMenu;
    private StockMenuController stockMenu;
    private ClientMenuController clientMenu;
    private OrderMenuController orderMenu;

    public MenuController(
            VehicleMenuController vehicleMenu,
            StockMenuController stockMenu,
            ClientMenuController clientMenu,
            OrderMenuController orderMenu)
    {
        this.vehicleMenu = vehicleMenu;
        this.stockMenu = stockMenu;
        this.clientMenu = clientMenu;
        this.orderMenu = orderMenu;
    }

    public void start() {
        int option = 0;
        while (option != 5) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Veículos");
            System.out.println("2 - Estoque");
            System.out.println("3 - Clientes");
            System.out.println("4 - Pedidos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Escolha uma opção!");
                continue;
            }

            switch (option) {
                case 1:
                    vehicleMenu.start();
                    break;
                case 2:
                    stockMenu.start();
                    break;
                case 3:
                    clientMenu.start();
                    break;
                case 4:
                    orderMenu.start();
                    break;
                case 5:
                    System.out.println("Saindo da aplicação.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }
}
