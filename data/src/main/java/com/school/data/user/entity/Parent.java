package com.school.data.entity.user;

import com.school.data.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "parent")
public class Parent {

    @Id
    private String _id;
    private String tenantId;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address permanentAddress;
    private Address temporaryAddress;
    private List<Student> students;
    private Instant createdAt;
    private Instant updatedAt;

}