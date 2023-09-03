package org.whatsappstatus.user.service.impl;

import org.whatsappstatus.user.models.request.UserLoginRequest;
import org.whatsappstatus.user.repository.AuthRepository;
import org.whatsappstatus.user.service.LoginStrategy;

public class PasswordLoginStrategy implements LoginStrategy {
    private final AuthRepository authRepository;

    public PasswordLoginStrategy(AuthRepository authRepository) {
        this.authRepository = authRepository;

    }

    @Override
    public Boolean login(UserLoginRequest loginRequest) {
        return authRepository.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @Override
    public void saveCred(String username, String password) {
        authRepository.save(username, password);
    }
}
