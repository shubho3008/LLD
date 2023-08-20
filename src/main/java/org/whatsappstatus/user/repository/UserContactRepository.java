package org.whatsappstatus.user.repository;

import org.whatsappstatus.user.entities.PhoneNumber;
import org.whatsappstatus.user.entities.UserContactEntity;

import java.util.List;

public interface UserContactRepository {

    void syncContactBook(String username, PhoneNumber phoneNumber, List<PhoneNumber> contactBook);

    UserContactEntity getContactBook(String username);

    UserContactEntity getContactBook(PhoneNumber phoneNumber);

    boolean isContact(PhoneNumber phoneToBeChecked, PhoneNumber phoneNumber);
}
