/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model.product;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class Cart {

    private Map<Integer, Product> mapCart;

    public Cart() {
    }

    public Cart(Map<Integer, Product> mapCart) {
        this.mapCart = mapCart;
    }

    public Map<Integer, Product> getMapCart() {
        return mapCart;
    }

    public void setMapCart(Map<Integer, Product> mapCart) {
        this.mapCart = mapCart;
    }

    public Boolean AddToCart(Product p) {
        Boolean check = false;
        if (this.mapCart == null) {
            this.mapCart = new HashMap<>();
        }
        if (mapCart.containsKey(p.getId())) {
            p.setQuantity(p.getQuantity() + this.mapCart.get(p.getId()).getQuantity());
            check = true;
        }
        if (p.getQuantity() > 0) {
            this.mapCart.put(p.getId(), p);
        }else{
            this.mapCart.remove(p.getId());
        }
        return check;
    }

    public Double GetTotal() {
        double total = 0;
        for (Product p : this.mapCart.values()) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }

    public Boolean RemoveProduct(int id) {
        Boolean check = false;
        if (this.mapCart != null) {
            if (this.mapCart.containsKey(id)) {
                this.mapCart.remove(id);
                check = true;
            }
        }
        return check;
    }
}
