package main.java.com.dealership.model;

public class Client {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Client(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Email: " + email + " Phone: " + phone;
    }
}
