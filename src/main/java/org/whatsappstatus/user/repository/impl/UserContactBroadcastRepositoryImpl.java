package org.whatsappstatus.user.repository.impl;

import org.whatsappstatus.user.entities.UserContactEntity;
import org.whatsappstatus.user.entities.UserProfileEntity;
import org.whatsappstatus.user.repository.UserContactBroadcastRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserContactBroadcastRepositoryImpl implements UserContactBroadcastRepository {

    Map<String, List<UserProfileEntity>> contactBroadcastDB = new HashMap<>();


    @Override
    public void addUser(UserContactEntity currUser, UserProfileEntity userToBeBroadcasted) {
        List<UserProfileEntity> userProfileEntities;
        if (contactBroadcastDB.containsKey(currUser.getUsername())) {
            userProfileEntities = contactBroadcastDB.get(currUser.getUsername());
        } else {
            userProfileEntities = new ArrayList<>();
        }
        userProfileEntities.add(userToBeBroadcasted);
        contactBroadcastDB.put(currUser.getUsername(), userProfileEntities);
    }

    @Override
    public List<UserProfileEntity> get(String userName) {
        return contactBroadcastDB.get(userName);

    }
}
