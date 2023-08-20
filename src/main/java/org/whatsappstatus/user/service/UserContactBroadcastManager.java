package org.whatsappstatus.user.service;

import org.whatsappstatus.user.entities.PhoneNumber;
import org.whatsappstatus.user.entities.UserContactEntity;
import org.whatsappstatus.user.entities.UserProfileEntity;
import org.whatsappstatus.user.repository.UserContactBroadcastRepository;
import org.whatsappstatus.user.repository.UserContactRepository;
import org.whatsappstatus.user.repository.UserRepository;

public class UserContactBroadcastManager {

    private final UserContactRepository userContactRepository;
    private final UserRepository userRepository;

    private final UserContactBroadcastRepository userContactBroadcastRepository;

    public UserContactBroadcastManager(UserContactRepository userContactRepository, UserRepository userRepository, UserContactBroadcastRepository userContactBroadcastRepository) {
        this.userContactRepository = userContactRepository;
        this.userRepository = userRepository;
        this.userContactBroadcastRepository = userContactBroadcastRepository;
    }


    public void updateBroadcastList(String username) {
        UserContactEntity currUsersContactBook = userContactRepository.getContactBook(username);
        for (PhoneNumber phoneNumber : currUsersContactBook.getPhoneNumbers()) {
            UserProfileEntity contactUserByPhone = userRepository.getUserByPhone(phoneNumber);
            if (userContactRepository.isContact(currUsersContactBook.getPhoneNumber(), contactUserByPhone.getPhone())) {
                userContactBroadcastRepository.addUser(currUsersContactBook, contactUserByPhone);
            }
        }
    }
}
