/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model.orders;

import sample.model.payment.DeliveryShipping;
import sample.model.product.Product;

/**
 *
 * @author ACER
 */
public class OrderDetail {

    private int orderId;
    private Product product;
    private int quantity;
    private double price;
    private double tax;
    private double shipping;
    private DeliveryShipping deliveryShipping;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, Product product, int quantity, double price, double tax, double shipping, DeliveryShipping deliveryShipping) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.shipping = shipping;
        this.deliveryShipping = deliveryShipping;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public DeliveryShipping getDeliveryShipping() {
        return deliveryShipping;
    }

    public void setDeliveryShipping(DeliveryShipping deliveryShipping) {
        this.deliveryShipping = deliveryShipping;
    }

}
