package com.educationmanagement.user.service.impl;

import com.educationmanagement.common.user.request.StudentParentRequest;
import com.educationmanagement.data.user.entity.Parent;
import com.educationmanagement.data.user.entity.Student;
import com.educationmanagement.data.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentParentServiceImpl {

    public void createStudentParent(StudentParentRequest studentParentRequest) {
        //convert  StudentParentRequest to Student and Parent objects and save Student and Parent objects
        Student student = convertStudentParentRequestToStudent(studentParentRequest);
        User user = convertStudentParentRequestToUser(studentParentRequest);
        Parent parent = convertStudentParentRequestToParent(studentParentRequest);
        


    }

    private Parent convertStudentParentRequestToParent(StudentParentRequest studentParentRequest) {
    }

    private User convertStudentParentRequestToUser(StudentParentRequest studentParentRequest) {
    }

    private Student convertStudentParentRequestToStudent(StudentParentRequest studentParentRequest) {
        Student student = new Student();
        student.setFirstName(studentParentRequest.getStudentFirstName());
        student.setLastName(studentParentRequest.getStudentLastName());
        student.setTenantId(studentParentRequest.getTenantId());
        student.setUserId(studentParentRequest.getStudentId());
        return student;
    }


}
