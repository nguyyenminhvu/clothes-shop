/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.model.google;

/**
 *
 * @author ACER
 */
public class AccountGoogleDTO {

    private String username;
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountGoogleDTO(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public AccountGoogleDTO() {
    }
    
    
}
