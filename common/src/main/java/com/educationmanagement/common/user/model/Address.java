package com.educationmanagement.common.user.model;

import lombok.Data;

@Data
public class Address {
    private String houseNum;
    private String street;
    private String village;
    private String landMark;
    private String state;
    private String pinCode;

}