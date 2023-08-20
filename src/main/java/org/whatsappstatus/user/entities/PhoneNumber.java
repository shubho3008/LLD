package org.whatsappstatus.user.entities;


public class PhoneNumber {

    //TODO: Add validation for India numbers only
    String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}
