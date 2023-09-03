package org.whatsappstatus.user.entities;


import java.util.List;


public class UserContactEntity {

    private String username;

    private PhoneNumber phoneNumber;

    private List<PhoneNumber> phoneNumbers;

    public UserContactEntity(String username, PhoneNumber phoneNumber, List<PhoneNumber> phoneNumbers) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.phoneNumbers = phoneNumbers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
