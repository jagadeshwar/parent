package com.educationmanagement.admin.controller;

import com.educationmanagement.common.admin.request.ClassRoomRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping
    public Mono<ResponseEntity<ClassRoomResponse>> createClassRoom(@RequestBody Mono<ClassRoomRequest> classRoomRequest) {
        // Implement the logic to create a classroom
        return Mono.just(ResponseEntity.ok(new ClassRoomResponse()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ClassRoomResponse>> getClassRoom(@PathVariable String id) {
        // Implement the logic to get a classroom by id
        return Mono.just(ResponseEntity.ok(new ClassRoomResponse()));
    }

    @GetMapping
    public Flux<ClassRoomResponse> getAllClassRooms() {
        // Implement the logic to get all classrooms
        return Flux.just(new ClassRoomResponse());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ClassRoomResponse>> updateClassRoom(@PathVariable String id, @RequestBody Mono<ClassRoomRequest> classRoomRequest) {
        // Implement the logic to update a classroom
        return Mono.just(ResponseEntity.ok(new ClassRoomResponse()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteClassRoom(@PathVariable String id) {
        // Implement the logic to delete a classroom
        return Mono.just(ResponseEntity.noContent().build());
    }
}