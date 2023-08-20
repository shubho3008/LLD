package org.whatsappstatus.user.service;

import org.whatsappstatus.user.models.request.UserLoginRequest;

public interface LoginStrategy {
    Boolean login(UserLoginRequest loginRequest);

    void saveCred(String username, String password);
}
