package main.java.com.dealership.repository;

import main.java.com.dealership.model.Stock;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StockRepository {
    private Set<Stock> stocks = new HashSet<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    public Stock removeStock(String stockId) {
        Iterator<Stock> iterator = stocks.iterator();
        while (iterator.hasNext()) {
            Stock s = iterator.next();
            if (s.getId().equals(stockId)) {
                iterator.remove();
                return s;
            }
        }
        return null;
    }
    public void updateStock(Stock updatedStock) {
        if (stocks.contains(updatedStock)) {
            stocks.remove(updatedStock);
            stocks.add(updatedStock);
        }
    }

    public Set<Stock> getAllStocks() {
        return stocks;
    }

    public Stock findById(String stockId) {
        for (Stock s : stocks) {
            if (s.getId().equals(stockId)) {
                return s;
            }
        }
        return null;
    }
    public Stock findByVehicleId(String vehicleId) {
        for (Stock s : stocks) {
            if (s.getVehicle().getId().equals(vehicleId)) {
                return s;
            }
        }
        return null;
    }
}
