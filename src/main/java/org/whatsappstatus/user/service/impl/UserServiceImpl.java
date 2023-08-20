package org.whatsappstatus.user.service.impl;

import org.whatsappstatus.user.entities.PhoneNumber;
import org.whatsappstatus.user.entities.UserProfileEntity;
import org.whatsappstatus.user.models.request.UserContactNotificationRequest;
import org.whatsappstatus.user.models.request.UserLoginRequest;
import org.whatsappstatus.user.models.request.UserSignUpRequest;
import org.whatsappstatus.user.models.response.UserResponse;
import org.whatsappstatus.user.repository.UserContactRepository;
import org.whatsappstatus.user.repository.UserRepository;
import org.whatsappstatus.user.service.AuthManager;
import org.whatsappstatus.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final AuthManager authManager;


    private final UserContactRepository userContactRepository;

    private final UserContactNotificationPublisher notificationManager;

    public UserServiceImpl(UserRepository userRepository,
                           AuthManager authManager, UserContactRepository userContactRepository, UserContactNotificationPublisher notificationManager) {
        this.userRepository = userRepository;
        this.authManager = authManager;
        this.userContactRepository = userContactRepository;
        this.notificationManager = notificationManager;
    }

    @Override
    public UserResponse signup(UserSignUpRequest userSignUpRequest) {
        userRepository.signup(new UserProfileEntity(userSignUpRequest.getUsername(), userSignUpRequest.getPhone()));
        authManager.save(userSignUpRequest.getUsername(), userSignUpRequest.getPassword());
        return convert(userRepository.getUser(userSignUpRequest.getUsername()));
    }

    @Override
    public Boolean login(UserLoginRequest userLoginRequest) {
        return authManager.login(userLoginRequest);
    }


    @Override
    public void syncContactBook(String username, PhoneNumber phoneNumber, List<PhoneNumber> contactBook) throws InterruptedException {
        //TODO: Async called seperately (outside of signup)
        userContactRepository.syncContactBook(username, phoneNumber, contactBook);
        notificationManager.publishContactUpdateNotification(new UserContactNotificationRequest(username));
    }

    private UserResponse convert(UserProfileEntity userProfileEntity) {
        return new UserResponse(userProfileEntity.getUsername(), userProfileEntity.getPhone());
    }
}
