package org.whatsappstatus.user.repository.impl;

import org.whatsappstatus.user.entities.PhoneNumber;
import org.whatsappstatus.user.entities.UserContactEntity;
import org.whatsappstatus.user.repository.UserContactRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserContactRepositoryImpl implements UserContactRepository {

    private static final UserContactEntity EMPTY_USER_CONTACT_ENTITY = new UserContactEntity("NULL", new PhoneNumber("NULL"), new ArrayList<>());
    Map<String, UserContactEntity> contactBookDB = new HashMap<>();
    Map<PhoneNumber, UserContactEntity> contactBookDBIndexedOnPhone = new HashMap<>();

    @Override
    public void syncContactBook(String username, PhoneNumber phoneNumber, List<PhoneNumber> contactBook) {
        UserContactEntity contactEntity = new UserContactEntity(username, phoneNumber, contactBook);
        contactBookDB.put(username, contactEntity);
        contactBookDBIndexedOnPhone.put(phoneNumber, contactEntity);
    }

    @Override
    public UserContactEntity getContactBook(String username) {
        return this.contactBookDB.getOrDefault(username, EMPTY_USER_CONTACT_ENTITY);
    }

    @Override
    public UserContactEntity getContactBook(PhoneNumber phoneNumber) {
        return this.contactBookDBIndexedOnPhone.getOrDefault(phoneNumber, EMPTY_USER_CONTACT_ENTITY);
    }

    @Override
    public boolean isContact(PhoneNumber phoneToBeChecked, PhoneNumber phoneNumber) {
        return this.contactBookDBIndexedOnPhone.containsKey(phoneNumber) && this.contactBookDBIndexedOnPhone
                .get(phoneNumber)
                .getPhoneNumbers()
                .stream()
                .anyMatch(presentNumber -> presentNumber == phoneToBeChecked);
    }
}
