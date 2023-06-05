/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model.orders;

import java.sql.Date;
import sample.model.user.User;

/**
 *
 * @author ACER
 */
public class Order {

    private int orderId;
    private User user;
    private double totalMoney;
    private java.sql.Date dateCreate;
    private boolean status;

    public Order() {
    }

    public Order(int orderId, User user, double totalMoney, Date dateCreate, boolean status) {
        this.orderId = orderId;
        this.user = user;
        this.totalMoney = totalMoney;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
