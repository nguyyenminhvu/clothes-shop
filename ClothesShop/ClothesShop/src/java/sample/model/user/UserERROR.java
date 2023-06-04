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
public class UserERROR {

    private String usernameError;
    private String passwordError;
    private String rePasswordError;
    private String newPasswordError;
    private String fullNameError;

    public UserERROR() {
        this.usernameError = "";
        this.passwordError = "";
        this.rePasswordError = "";
        this.fullNameError = "";
        this.newPasswordError = "";
    }

    public UserERROR(String usernameError, String passwordError, String rePasswordError, String fullNAmeError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.rePasswordError = rePasswordError;
        this.fullNameError = fullNAmeError;
    }

    public UserERROR(String usernameError, String passwordError, String rePasswordError, String fullNAmeError, String newPassword) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.rePasswordError = rePasswordError;
        this.fullNameError = fullNAmeError;
        this.newPasswordError = newPassword;
    }

    public String getNewPasswordError() {
        return newPasswordError;
    }

    public void setNewPasswordError(String newPasswordError) {
        this.newPasswordError = newPasswordError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRePasswordError() {
        return rePasswordError;
    }

    public void setRePasswordError(String rePasswordError) {
        this.rePasswordError = rePasswordError;
    }

}
