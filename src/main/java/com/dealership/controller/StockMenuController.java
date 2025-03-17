package main.java.com.dealership.controller;

import main.java.com.dealership.service.StockService;

import java.util.Scanner;

public class StockMenuController {
    private StockService stockService;
    private Scanner scanner = new Scanner(System.in);

    public StockMenuController(StockService stockService) {
        this.stockService = stockService;
    }

    public void start() {
        int option = 0;
        while (option != 5) {
            System.out.println("\n===== MENU ESTOQUE =====");
            System.out.println("1 - Listar Estoque");
            System.out.println("2 - Adicionar Veículo ao Estoque");
            System.out.println("3 - Remover Veículo do Estoque");
            System.out.println("4 - Atualizar Quantidade do Estoque");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Escola uma opção!");
                continue;
            }
            switch (option) {
                case 1:
                    stockService.listStock();
                    break;
                case 2:
                    stockService.addStock();
                    break;
                case 3:
                    stockService.removeStock();
                    break;
                case 4:
                    stockService.increaseStock();
                    break;
                case 5:
                    stockService.decreaseStock();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }
}
