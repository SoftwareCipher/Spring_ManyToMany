package org.boot.spring_many.controller;

import lombok.RequiredArgsConstructor;
import org.boot.spring_many.dto.UserDTO;
import org.boot.spring_many.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user) {
        Logger.info("save user: " + user);
        userService.saveWithRole(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //username and role
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll() {
        Logger.info("get all users");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //get user by role
    @GetMapping("/roles/{role}")
    public ResponseEntity<List<UserDTO>> getRoles(@PathVariable String role) {
        Logger.info("get role: " + role);
        userService.getUsersByRole(role);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
