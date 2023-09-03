package org.whatsappstatus.user.models.request;


import org.whatsappstatus.user.entities.PhoneNumber;


public class UserSignUpRequest {

    private final PhoneNumber phone;
    private final String password;
    private String username;

    public UserSignUpRequest(String username, PhoneNumber phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
