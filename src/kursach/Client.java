package kursach;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private String clientID;
    private ClientType clientType;
    private String name;
    private String surname;
    private String phoneNumber;
    private Offices office;
    private Cart cart;
    private List<Order> orders;

    public Client(ClientType clientType, String name, String surname, String phoneNumber, Offices office) {
        this.clientID = UUID.randomUUID().toString();
        this.clientType = clientType;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.office = office;
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public Client() {
        this(ClientType.UNREGISTRED, "", "", "", Offices.DEFAULT_MAIN);
    }

    public void addToCart(StockItem item, int count) {
        cart.addStockItem(item, count);
    }

    public Cart getCart() {
        return cart;
    }

    public List<Order> getOrders() { //TODO add + filters
        return null;
    }

    public Client registation(String name, String surname, String phoneNumber, int input) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        switch (input) {
            case 1:
                this.office = Offices.OFFICE1;
                break;
            case 2:
                this.office = Offices.OFFICE2;
                break;
            default:
                this.office = Offices.DEFAULT_MAIN;
        }
        this.clientType = ClientType.REGISTRED;
        return this;
    }

    public List<StockItem> searchByPartNumber(String partNumber, Stocks stocks) { //TODO filters
        return stocks.checkAllStocks(partNumber);
    }

    public List<CarItem> searchByCar(String partNumber, Car car) { //TODO filters
        return car.getParts();
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
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
