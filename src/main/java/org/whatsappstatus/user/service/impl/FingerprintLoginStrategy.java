package org.whatsappstatus.user.service.impl;

import org.whatsappstatus.user.models.request.UserLoginRequest;
import org.whatsappstatus.user.service.LoginStrategy;

public class FingerprintLoginStrategy implements LoginStrategy {
    @Override
    public Boolean login(UserLoginRequest loginRequest) {
        return false;
    }

    @Override
    public void saveCred(String username, String password) {
    }
}
