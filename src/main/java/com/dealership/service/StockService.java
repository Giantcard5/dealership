package main.java.com.dealership.service;

import main.java.com.dealership.model.Stock;
import main.java.com.dealership.model.Vehicle;
import main.java.com.dealership.repository.StockRepository;
import main.java.com.dealership.repository.VehicleRepository;

import java.util.Scanner;

public class StockService {
    VehicleRepository vehicleRepository;
    StockRepository stockRepository;
    Scanner scanner = new Scanner(System.in);

    public StockService(StockRepository stockRepository, VehicleRepository vehicleRepository) {
        this.stockRepository = stockRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public void listStock() {
        if (stockRepository.getAllStocks().isEmpty()) {
            System.out.println("Nenhum veículo cadastrado no estoque.");
        } else {
            System.out.println("\nEstoque:");
            for (Stock s : stockRepository.getAllStocks()) {
                System.out.println(s);
            }
        }
    }

    public void addStock() {
        System.out.println("\nDigite o ID do veículo que deseja adicionar ao estoque:");
        String vehicleId = scanner.nextLine();

        Vehicle vehicleFound = vehicleRepository.findById(vehicleId);
        if (vehicleFound == null) {
            System.out.println("Veículo não encontrado. Cadastre o veículo primeiro.");
        } else {
            System.out.println("Digite a quantidade inicial em estoque:");
            int initialQuantity = Integer.parseInt(scanner.nextLine());

            Stock newStock = new Stock(vehicleFound, initialQuantity);
            stockRepository.addStock(newStock);
            System.out.println("Estoque criado para o veículo: " + vehicleFound.getModel() +
                    " | Stock ID: " + newStock.getId());
        }
    }

    public void removeStock() {
        System.out.println("\nDigite o ID do Stock que deseja remover:");
        String stockIdToRemove = scanner.nextLine();

        Stock removedStock = stockRepository.removeStock(stockIdToRemove);
        if (removedStock != null) {
            System.out.println("Registro de estoque removido: " + removedStock);
        } else {
            System.out.println("Nenhum registro de estoque encontrado com esse ID.");
        }
    }

    public void increaseStock() {
        System.out.println("\nDigite o ID do Stock que deseja atualizar:");
        String stockIdToUpdate = scanner.nextLine();

        Stock stockFound = stockRepository.findById(stockIdToUpdate);
        if (stockFound == null) {
            System.out.println("Registro de estoque não encontrado.");
        } else {
            System.out.println("Digite a quantidade que deseja adicionar:");
            int qtyToAdd = Integer.parseInt(scanner.nextLine());

            stockFound.increaseQuantity(qtyToAdd);
            stockRepository.updateStock(stockFound);
            System.out.println("Quantidade adicionada com sucesso. Estoque atual: " + stockFound.getQuantity());
        }
    }

    public void decreaseStock() {
        System.out.println("\nDigite o ID do Stock que deseja atualizar:");
        String stockIdDecrease = scanner.nextLine();

        Stock stockToDecrease = stockRepository.findById(stockIdDecrease);
        if (stockToDecrease == null) {
            System.out.println("Registro de estoque não encontrado.");
        } else {
            System.out.println("Digite a quantidade que deseja remover:");

            int qtyToRemove = Integer.parseInt(scanner.nextLine());
            boolean success = stockToDecrease.decreaseQuantity(qtyToRemove);
            if (success) {
                if (stockToDecrease.getQuantity() == 0) {
                    stockRepository.removeStock(stockToDecrease.getId());

                    System.out.println("Estoque zerado, registro removido.");
                } else {
                    stockRepository.updateStock(stockToDecrease);

                    System.out.println("Quantidade removida com sucesso. Estoque atual: " + stockToDecrease.getQuantity());
                }
            } else {
                System.out.println("Não foi possível remover essa quantidade (valor inválido ou insuficiente).");
            }
        }
    }
}
