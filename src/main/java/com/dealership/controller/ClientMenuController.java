package main.java.com.dealership.controller;

import main.java.com.dealership.service.ClientService;

import java.util.Scanner;

public class ClientMenuController {
    private ClientService clientService;
    private Scanner scanner = new Scanner(System.in);

    public ClientMenuController(ClientService clientService) {
        this.clientService = clientService;
    }

    public void start() {
        int option = 0;
        while (option != 4) {
            System.out.println("\n===== MENU CLIENTES =====");
            System.out.println("1 - Listar Clientes");
            System.out.println("2 - Adicionar Cliente");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Escola uma opção!");
                continue;
            }
            switch (option) {
                case 1:
                    clientService.listClients();
                    break;
                case 2:
                    clientService.addClient();
                    break;
                case 3:
                    clientService.removeClient();
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
