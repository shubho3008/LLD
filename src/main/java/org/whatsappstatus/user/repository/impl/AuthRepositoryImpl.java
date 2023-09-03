package org.whatsappstatus.user.repository.impl;

import org.whatsappstatus.user.entities.UserAuthEntity;
import org.whatsappstatus.user.repository.AuthRepository;

import java.util.HashMap;
import java.util.Map;

public class AuthRepositoryImpl implements AuthRepository {

    Map<String, UserAuthEntity> userAuthDB = new HashMap<>();

    @Override
    public boolean login(String username, String password) {
        if (userAuthDB.containsKey(username)) {
            return userAuthDB.get(username).getPassword().equals(password);
        }
        return false;

    }

    @Override
    public void save(String username, String password) {
        userAuthDB.put(username, new UserAuthEntity(username, password));
    }
}
