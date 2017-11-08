package kursach3.user;

import kursach3.delivery.Delivery;
import kursach3.delivery.LocalPickup;
import java.util.Date;

public class Order {
    private static int orderCnt = 1;
    private final Date createDate;
    private final Cart cart;
    private final int totalAmount;
    private Delivery delivery;
    private int orderId;
    private Date completeDate;
    private OrderStatus orderStatus;

    public Order(Cart cart, Delivery delivery) {
        this.orderId += orderCnt++;
        this.createDate = new Date();
        this.cart = cart;
        this.totalAmount = cart.getTotalAmount();
        this.delivery = delivery;
        this.orderStatus = OrderStatus.NEW;
    }

    public Order(Cart cart) {
        this(cart, new LocalPickup());
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus.equals(OrderStatus.COMPLETE)) {
            this.completeDate = new Date();
        }
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "createDate=" + createDate +
                ", cart=" + cart +
                ", totalAmount=" + totalAmount +
                ", delivery=" + delivery +
                ", orderID=" + orderId +
                ", completeDate=" + completeDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
