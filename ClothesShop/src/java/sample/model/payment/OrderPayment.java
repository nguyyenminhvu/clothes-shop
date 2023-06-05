/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model.payment;

/**
 *
 * @author ACER
 */
public class OrderPayment {

    private String nameProduct;
    private double price;
    private int quantity;
    private double tax;
    private double shipping;

    public OrderPayment() {
    }

    public OrderPayment(String nameProduct, String price, int quantity, String tax, String shipping) {
        this.nameProduct = nameProduct;
        this.price = Double.parseDouble(price);
        this.quantity =quantity;
        this.tax = Double.parseDouble(tax);
        this.shipping = Double.parseDouble(shipping);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return String.format("%.2f", price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuantity() {
        return Integer.toString(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSubTotal() {
        return String.format("%.2f", this.price*this.quantity);
    }

    public String getTax() {
        return String.format("%.2f", tax);
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getShipping() {
        return String.format("%.2f", shipping);
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

}
