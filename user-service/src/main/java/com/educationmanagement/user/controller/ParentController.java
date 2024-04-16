package com.educationmanagement.user.controller;

import com.educationmanagement.common.user.request.ParentRequest;
import com.educationmanagement.common.user.response.ParentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @PostMapping("/search")
    public Flux<ParentResponse> searchStudent(@RequestBody ParentRequest parentRequest) {
        // Implement the logic to search a student
        return Flux.just(new ParentResponse());
    }

    @PostMapping("/add")
    public Mono<ResponseEntity<ParentResponse>> createParent(@RequestBody Mono<ParentRequest> parentRequest) {
        // Implement the logic to create a parent
        return Mono.just(ResponseEntity.ok(new ParentResponse()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ParentResponse>> getParent(@PathVariable String id) {
        // Implement the logic to get a parent by id
        return Mono.just(ResponseEntity.ok(new ParentResponse()));
    }

    @GetMapping
    public Flux<ParentResponse> getAllParents() {
        // Implement the logic to get all parents
        return Flux.just(new ParentResponse());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ParentResponse>> updateParent(@PathVariable String id, @RequestBody Mono<ParentRequest> parentRequest) {
        // Implement the logic to update a parent
        return Mono.just(ResponseEntity.ok(new ParentResponse()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteParent(@PathVariable String id) {
        // Implement the logic to delete a parent
        return Mono.just(ResponseEntity.noContent().build());
    }
}