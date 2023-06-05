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
public class UpdateInformationERROR {

    private String nameError;
    private String phoneError;
    private String addressError;
    private String passwordError;

    public UpdateInformationERROR() {
        this.nameError = "";
        this.phoneError = "";
        this.addressError = "";
        this.passwordError = "";
    }

    public UpdateInformationERROR(String nameError, String phoneError, String addressError, String passwordError) {
        this.nameError = nameError;
        this.phoneError = phoneError;
        this.addressError = addressError;
        this.passwordError = passwordError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

}
