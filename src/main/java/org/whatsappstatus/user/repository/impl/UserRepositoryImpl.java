package org.whatsappstatus.user.repository.impl;

import org.whatsappstatus.user.entities.PhoneNumber;
import org.whatsappstatus.user.entities.UserProfileEntity;
import org.whatsappstatus.user.models.response.UserResponse;
import org.whatsappstatus.user.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private static final UserProfileEntity EMPTY_USER = new UserProfileEntity("NULL", new PhoneNumber("NULL"));
    //indexed on username (pk);
    Map<String, UserProfileEntity> userDB = new HashMap<>();

    Map<PhoneNumber, UserProfileEntity> userDBIndexedOnPhone = new HashMap<>();

    @Override
    public void signup(UserProfileEntity userProfileEntity) {
        userDB.put(userProfileEntity.getUsername(), userProfileEntity);
        userDBIndexedOnPhone.put(userProfileEntity.getPhone(), userProfileEntity);
    }

    @Override
    public List<UserResponse> getNotifiableContacts(String username) {
        return null;
    }

    @Override
    public UserProfileEntity getUser(String username) {
        return userDB.getOrDefault(username, EMPTY_USER);
    }

    @Override
    public UserProfileEntity getUserByPhone(PhoneNumber phoneNumber) {
        return userDBIndexedOnPhone.getOrDefault(phoneNumber, EMPTY_USER);
    }
}
