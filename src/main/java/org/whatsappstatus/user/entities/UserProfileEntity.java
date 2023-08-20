package org.whatsappstatus.user.entities;


public class UserProfileEntity {

    //PK
    private final String username;
    private final PhoneNumber phone;

    public UserProfileEntity(String username, PhoneNumber phone) {
        this.username = username;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserProfileEntity{" +
                "username='" + username + '\'' +
                ", phone=" + phone +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    //TODO:Add other fields

}
