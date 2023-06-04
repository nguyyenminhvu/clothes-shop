/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model.user;

/**
 *
 * @author ACER
 */
public class UserUpdatepERROR {

    private String fullNameERROR;
    private String phoneERROR;
    private String addressERROR;

    public UserUpdatepERROR() {
        this.fullNameERROR = "";
        this.phoneERROR = "";
        this.addressERROR = "";
    }

    public UserUpdatepERROR(String fullNameERROR, String phoneERROR, String addressERROR) {
        this.fullNameERROR = fullNameERROR;
        this.phoneERROR = phoneERROR;
        this.addressERROR = addressERROR;
    }

    public String getFullNameERROR() {
        return fullNameERROR;
    }

    public void setFullNameERROR(String fullNameERROR) {
        this.fullNameERROR = fullNameERROR;
    }

    public String getPhoneERROR() {
        return phoneERROR;
    }

    public void setPhoneERROR(String phoneERROR) {
        this.phoneERROR = phoneERROR;
    }

    public String getAddressERROR() {
        return addressERROR;
    }

    public void setAddressERROR(String addressERROR) {
        this.addressERROR = addressERROR;
    }

}
