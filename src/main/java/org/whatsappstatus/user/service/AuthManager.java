package org.whatsappstatus.user.service;

import org.whatsappstatus.user.models.request.UserLoginRequest;

public class AuthManager {

    private final LoginStrategy loginStrategy;

    public AuthManager(LoginStrategy loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    public Boolean login(UserLoginRequest userLoginRequest) {
        return loginStrategy.login(userLoginRequest);
    }

    public void save(String username, String password) {
        loginStrategy.saveCred(username, password);
    }
}
