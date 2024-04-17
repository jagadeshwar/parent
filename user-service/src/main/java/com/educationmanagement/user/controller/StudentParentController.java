package com.educationmanagement.user.controller;

import com.educationmanagement.common.admin.response.UserCreationResponse;
import com.educationmanagement.common.user.request.StudentParentRequest;
import com.educationmanagement.common.user.response.StudentParentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class StudentParentController {

    @PostMapping("/student-parent")
    public Mono<ResponseEntity<UserCreationResponse>> createStudentParent(@RequestBody StudentParentRequest studentParentRequest) {


        return Mono.just(ResponseEntity.ok(new UserCreationResponse()));
    }







}
