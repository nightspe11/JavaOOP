package kursach3.user;

import kursach3.storage.cars.*;
import kursach3.storage.offices.*;
import kursach3.storage.suppliers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Client {
    private final String clientId;
    private ClientType clientType;
    private String name;
    private String surname;
    private String phoneNumber;
    private Office office;
    private Cart cart;
    private List<Order> orders;

    public Client(ClientType clientType, String name, String surname, String phoneNumber, Office office) {
        this.clientId = UUID.randomUUID().toString();
        this.clientType = clientType;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.office = office;
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public Client() {
        this(ClientType.UNREGISTRED, "", "", "", null);
    }

    public void addToCart(StockItem item, int count) {
        cart.addStockItem(item, count);
    }

    public void addToCart(StockItem item) {
        addToCart(item, 1);
    }

    public Office getOffice() {
        return office;
    }

    public Cart getCart() {
        return cart;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public List<Order> getOrders() { //TODO filters??
        return orders;
    }

    public Client registation(String name, String surname, String phoneNumber, String officeID, Offices offices) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.clientType = ClientType.REGISTRED;
        this.office = offices.select(officeID);
        return this;
    }

    public Map searchByPartNumber(String partNumber, Stocks stocks) { //TODO check
        return stocks.select(partNumber);
    }

    public CarItem searchByCar(String partNumber, String car, Cars cars) { //TODO check
        if (cars != null) return cars.select(car).select(partNumber);
        else return null;
    }

    public List<Order> searchOrders(OrderStatus orderStatus) {
        return orders.stream().filter(os -> os.getOrderStatus().equals(orderStatus)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientId + '\'' +
                ", clientType=" + clientType +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", office=" + office +
                ", cart=" + cart +
                ", orders=" + orders +
                '}';
    }
}
