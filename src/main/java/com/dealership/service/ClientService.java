package main.java.com.dealership.service;

import main.java.com.dealership.model.Client;
import main.java.com.dealership.repository.ClientRepository;

import java.util.Scanner;

public class ClientService {
    ClientRepository clientRepository;
    Scanner scanner = new Scanner(System.in);

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void listClients() {
        if (clientRepository.getClients().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\nClientes Cadastrados:");
            for (Client c : clientRepository.getClients()) {
                System.out.println(c);
            }
        }
    }

    public void addClient() {
        System.out.println("\nDigite o ID do cliente:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o nome do cliente:");
        String name = scanner.nextLine();

        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();

        System.out.println("Digite o telefone do cliente:");
        String phoneNumber = scanner.nextLine();

        Client newClient = new Client(id, name, email, phoneNumber);
        clientRepository.addClient(newClient);

        System.out.println("Cliente adicionado com sucesso. ID: " + newClient.getId());
    }
    public void removeClient() {
        System.out.println("\nDigite o ID do cliente a ser removido:");
        int id = Integer.parseInt(scanner.nextLine());

        Client removedClient = clientRepository.removeClient(id);
        if (removedClient != null) {
            System.out.println("Cliente removido: " + removedClient);
        } else {
            System.out.println("Cliente com o ID fornecido não foi encontrado.");
        }
    }
}