package kursach;

import java.util.Date;

public class Order {
    private static int orderCnt;
    private int orderID;
    private Date orderDate;
    private Cart cart;
    private Delivery delivery;

    public Order(Cart cart, Delivery delivery) {
        this.orderID += orderCnt;
        this.orderDate = new Date();
        this.cart = cart;
        this.delivery = delivery;
    }

    public Order(Cart cart) {
        this(cart, new LocalPickup());
    }


}
