package org.whatsappstatus.user.repository;

import org.whatsappstatus.user.entities.UserContactEntity;
import org.whatsappstatus.user.entities.UserProfileEntity;

import java.util.List;

public interface UserContactBroadcastRepository {
    void addUser(UserContactEntity currUser, UserProfileEntity userToBeBroadcasted);

    List<UserProfileEntity> get(String userName);
}
