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
public class DeliveryBill {

    private double subTotal;
    private double tax;
    private double shipping;
    private double total;
    private DeliveryShipping deliveryShipping;

    public DeliveryBill() {
    }

    public DeliveryBill(double subTotal, double tax, double shipping, double total, DeliveryShipping deliveryShipping) {
        this.subTotal = subTotal;
        this.tax = tax;
        this.shipping = shipping;
        this.total = total;
        this.deliveryShipping = deliveryShipping;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public DeliveryShipping getDeliveryShipping() {
        return deliveryShipping;
    }

    public void setDeliveryShipping(DeliveryShipping deliveryShipping) {
        this.deliveryShipping = deliveryShipping;
    }

}
