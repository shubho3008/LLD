package org.whatsappstatus.user.repository;

import org.whatsappstatus.user.entities.PhoneNumber;
import org.whatsappstatus.user.entities.UserProfileEntity;
import org.whatsappstatus.user.models.response.UserResponse;

import java.util.List;

public interface UserRepository {
    void signup(UserProfileEntity userProfileEntity);

    List<UserResponse> getNotifiableContacts(String username);

    UserProfileEntity getUser(String username);

    UserProfileEntity getUserByPhone(PhoneNumber phoneNumber);
}
