package org.whatsappstatus.user.service;

import org.whatsappstatus.user.entities.PhoneNumber;
import org.whatsappstatus.user.models.request.UserLoginRequest;
import org.whatsappstatus.user.models.request.UserSignUpRequest;
import org.whatsappstatus.user.models.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse signup(UserSignUpRequest userSignUpRequest);

    Boolean login(UserLoginRequest userLoginRequest);

    void syncContactBook(String username, PhoneNumber phoneNumber, List<PhoneNumber> contactBook) throws InterruptedException;


}
