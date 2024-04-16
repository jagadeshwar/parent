package com.educationmanagement.user.controller;

import com.educationmanagement.common.user.request.StudentRequest;
import com.educationmanagement.common.user.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {



    @PostMapping("/search")
    public Flux<StudentResponse> searchStudent(@RequestBody StudentRequest studentRequest) {
        // Implement the logic to search a student
        return Flux.just(new StudentResponse());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<StudentResponse>> getStudent(@PathVariable String id) {
        // Implement the logic to get a student by id
        return Mono.just(ResponseEntity.ok(new StudentResponse()));
    }

    @GetMapping("/all")
    public Flux<StudentResponse> getAllStudents() {
        // Implement the logic to get all students
        return Flux.just(new StudentResponse());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<StudentResponse>> updateStudent(@PathVariable String id, @RequestBody Mono<StudentRequest> studentRequest) {
        // Implement the logic to update a student
        return Mono.just(ResponseEntity.ok(new StudentResponse()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable String id) {
        // Implement the logic to delete a student
        return Mono.just(ResponseEntity.noContent().build());
    }
}