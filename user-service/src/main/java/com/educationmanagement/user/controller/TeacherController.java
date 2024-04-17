package com.educationmanagement.user.controller;

import com.educationmanagement.common.admin.response.UserCreationResponse;
import com.educationmanagement.common.user.request.TeacherRequest;
import com.educationmanagement.common.user.response.TeacherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {



    @PostMapping("/addTeacher")
    public ResponseEntity<UserCreationResponse> createTeacher(@RequestBody TeacherRequest teacherRequest) {


        return ResponseEntity.created(null).body(new UserCreationResponse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getTeacher(@PathVariable String id) {
        // Implement the logic to get a teacher by id
        return ResponseEntity.ok(new TeacherResponse());
    }

    @GetMapping("/allTeachers")
    public ResponseEntity<List<TeacherResponse>> getAllTeachers() {
        // Implement the logic to get all teachers
        return ResponseEntity.ok(List.of(new TeacherResponse()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> updateTeacher(@PathVariable String id, @RequestBody TeacherRequest teacherRequest) {
        // Implement the logic to update a teacher
        return ResponseEntity.ok(new TeacherResponse());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String id) {
        // Implement the logic to delete a teacher
        return ResponseEntity.noContent().build();
    }
}