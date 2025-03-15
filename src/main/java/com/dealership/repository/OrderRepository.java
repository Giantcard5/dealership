package main.java.com.dealership.repository;

import main.java.com.dealership.model.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }
    public Order removeOrder(int id) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getId() == id) {
                iterator.remove();
                return order;
            }
        }
        return null;
    }
    public void updateOrder(Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == order.getId()) {
                orders.set(i, order);
                break;
            }
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order findById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
}
