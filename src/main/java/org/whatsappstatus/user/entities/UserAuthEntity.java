package org.whatsappstatus.user.entities;


public class UserAuthEntity {

    private final String username;
    //TODO: Add security hash, etc
    private final String password;

    public UserAuthEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
