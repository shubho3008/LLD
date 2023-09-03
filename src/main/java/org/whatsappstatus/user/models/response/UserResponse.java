package org.whatsappstatus.user.models.response;

import org.whatsappstatus.user.entities.PhoneNumber;


public class UserResponse {

    private final String username;

    private final PhoneNumber phone;

    public UserResponse(String username, PhoneNumber phone) {
        this.username = username;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "username='" + username + '\'' +
                ", phone=" + phone +
                '}';
    }

    //TODO:Add other fields
}
