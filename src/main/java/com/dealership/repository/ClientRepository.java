package main.java.com.dealership.repository;

import main.java.com.dealership.model.Client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }
    public Client removeClient(int id) {
        Iterator<Client> iterator = clients.iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.getId() == id) {
                iterator.remove();
                return client;
            }
        }
        return null;
    }
    public void updateClient(Client client) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == client.getId()) {
                clients.set(i, client);
                break;
            }
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client findById(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
