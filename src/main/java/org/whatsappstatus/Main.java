package org.whatsappstatus;

import org.whatsappstatus.content.enums.ContentType;
import org.whatsappstatus.content.exceptions.UploadResponseException;
import org.whatsappstatus.content.models.request.ImageContent;
import org.whatsappstatus.content.models.request.ImageContentRequest;
import org.whatsappstatus.content.models.request.TextContent;
import org.whatsappstatus.content.models.request.TextContentRequest;
import org.whatsappstatus.content.service.ContentService;
import org.whatsappstatus.content.service.ContentServiceFactory;
import org.whatsappstatus.content.service.impl.ContentServiceFactoryImpl;
import org.whatsappstatus.content.service.impl.UserContentBroadcastConsumer;
import org.whatsappstatus.content.service.impl.UserContentBroadcastManager;
import org.whatsappstatus.notification.service.NotificationQueue;
import org.whatsappstatus.notification.service.impl.NotificationQueueImpl;
import org.whatsappstatus.user.models.request.UserLoginRequest;
import org.whatsappstatus.user.models.request.UserSignUpRequest;
import org.whatsappstatus.user.models.response.UserResponse;
import org.whatsappstatus.user.repository.UserContactBroadcastRepository;
import org.whatsappstatus.user.repository.impl.AuthRepositoryImpl;
import org.whatsappstatus.user.repository.impl.UserContactBroadcastRepositoryImpl;
import org.whatsappstatus.user.repository.impl.UserContactRepositoryImpl;
import org.whatsappstatus.user.repository.impl.UserRepositoryImpl;
import org.whatsappstatus.user.service.AuthManager;
import org.whatsappstatus.user.service.UserContactBroadcastManager;
import org.whatsappstatus.user.service.UserService;
import org.whatsappstatus.user.service.impl.PasswordLoginStrategy;
import org.whatsappstatus.user.service.impl.UserContactBroadcastConsumer;
import org.whatsappstatus.user.service.impl.UserContactNotificationPublisher;
import org.whatsappstatus.user.service.impl.UserServiceImpl;

import java.util.Arrays;

public class Main {

    public static final String USER_CONTACT_SYNC_TOPIC = "user_contact";
    public static final String CONTENT_BROADCAST = "CONTENT_BROADCAST";
    public static UserContactRepositoryImpl userContactRepository = new UserContactRepositoryImpl();
    public static UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public static UserContactBroadcastRepository userContactBroadcastRepository = new UserContactBroadcastRepositoryImpl();
    static NotificationQueue contentNotificationQueue = new NotificationQueueImpl(CONTENT_BROADCAST, 10000000);
    static ContentServiceFactory contentServiceFactory = new ContentServiceFactoryImpl(contentNotificationQueue);
    public static UserContentBroadcastConsumer userContentBroadcastConsumer = new UserContentBroadcastConsumer(contentNotificationQueue,
            new UserContentBroadcastManager(userContactBroadcastRepository));
    static NotificationQueue notificationQueue = new NotificationQueueImpl(USER_CONTACT_SYNC_TOPIC, 10000000);
    public static UserService userService = new UserServiceImpl(
            userRepository,
            new AuthManager(new PasswordLoginStrategy(new AuthRepositoryImpl())),
            userContactRepository,
            new UserContactNotificationPublisher(notificationQueue));
    public static UserContactBroadcastConsumer userContactBroadcastConsumer = new UserContactBroadcastConsumer(notificationQueue,
            new UserContactBroadcastManager(userContactRepository, userRepository, userContactBroadcastRepository));

    public static void main(String[] args) throws InterruptedException {

        Thread contactConsumerThread = new Thread(userContactBroadcastConsumer);
        contactConsumerThread.start();
        Thread contentconsumerThread = new Thread(userContentBroadcastConsumer);
        contentconsumerThread.start();


        UserSignUpRequest userSignUpRequest0 = new UserSignUpRequest(DriverDataHelper.USERNAME0, DriverDataHelper.PHONE_NUMBER_0, "p0");
        UserSignUpRequest userSignUpRequest1 = new UserSignUpRequest(DriverDataHelper.USERNAME1, DriverDataHelper.PHONE_NUMBER_1, "p1");
        UserSignUpRequest userSignUpRequest2 = new UserSignUpRequest(DriverDataHelper.USERNAME2, DriverDataHelper.PHONE_NUMBER_2, "p2");
        UserSignUpRequest userSignUpRequest3 = new UserSignUpRequest(DriverDataHelper.USERNAME3, DriverDataHelper.PHONE_NUMBER_3, "p3");


        UserResponse userSignUpResponse0 = userService.signup(userSignUpRequest0);
        UserResponse userSignUpResponse1 = userService.signup(userSignUpRequest1);
        UserResponse userSignUpResponse2 = userService.signup(userSignUpRequest2);
        UserResponse userSignUpResponse3 = userService.signup(userSignUpRequest3);
        System.out.println(userSignUpResponse0);
        System.out.println(userSignUpResponse1);
        System.out.println(userSignUpResponse2);
        System.out.println(userSignUpResponse3);

        Boolean login0 = userService.login(new UserLoginRequest(DriverDataHelper.USERNAME0, "p0"));
        Boolean login1 = userService.login(new UserLoginRequest(DriverDataHelper.USERNAME1, "p1"));

        Boolean login2 = userService.login(new UserLoginRequest(DriverDataHelper.USERNAME2, "p2"));
        Boolean login3 = userService.login(new UserLoginRequest(DriverDataHelper.USERNAME3, "p0"));

        System.out.println(userSignUpResponse0 + " ->" + login0);
        System.out.println(userSignUpResponse1 + " ->" + login1);
        System.out.println(userSignUpResponse2 + " ->" + login2);
        System.out.println(userSignUpResponse3 + " ->" + login3);

        userService.syncContactBook(DriverDataHelper.USERNAME0, DriverDataHelper.PHONE_NUMBER_0, Arrays.asList(DriverDataHelper.PHONE_NUMBER_1, DriverDataHelper.PHONE_NUMBER_3));
        userService.syncContactBook(DriverDataHelper.USERNAME1, DriverDataHelper.PHONE_NUMBER_1, Arrays.asList(DriverDataHelper.PHONE_NUMBER_2, DriverDataHelper.PHONE_NUMBER_0));
        userService.syncContactBook(DriverDataHelper.USERNAME2, DriverDataHelper.PHONE_NUMBER_2, Arrays.asList(DriverDataHelper.PHONE_NUMBER_3, DriverDataHelper.PHONE_NUMBER_0));
        userService.syncContactBook(DriverDataHelper.USERNAME3, DriverDataHelper.PHONE_NUMBER_3, Arrays.asList(DriverDataHelper.PHONE_NUMBER_1, DriverDataHelper.PHONE_NUMBER_0));

        ContentService textContentService = contentServiceFactory.createContentService(ContentType.TEXT);
        ContentService imageContentService = contentServiceFactory.createContentService(ContentType.IMAGE);
//        ContentService videoContentService = contentServiceFactory.createContentService(ContentType.VIDEO);

        try {
            //To allow contacts to be synced before we start using the context upload/view system
            Thread.sleep(1000);
            textContentService.uploadContent(new TextContentRequest(DriverDataHelper.USERNAME0, new TextContent(DriverDataHelper.DUMMY_TEXT)));
        } catch (UploadResponseException e) {
            throw new RuntimeException(e);
        }

        try {
            imageContentService.uploadContent(new ImageContentRequest(DriverDataHelper.USERNAME0, new ImageContent(DriverDataHelper.DUMMY_TEXT, DriverDataHelper.IMAGE_FILE_NAME)));
        } catch (UploadResponseException e) {
            throw new RuntimeException(e);
        }


    }

}