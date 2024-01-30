/**
 * @author Starling Diaz on 1/28/2024.
 * @Academy StarAcademy
 * @version api-rest-demo-01 1.0
 * @since 1/28/2024.
 */

package com.example.apirestdemo01.controller;

import com.example.apirestdemo01.dto.UserDto;
import com.example.apirestdemo01.entity.User;
import com.example.apirestdemo01.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    //build the create user Rest API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
       UserDto savedUser = userService.createUser(user);
       log.info("Created a new user successfully: {}", savedUser);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build the get user by id Rest API
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        log.info("Get user by id successfully: {}", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //build the get all users Rest API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        log.info("Get all users successfully");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //build the update user Rest API
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        UserDto updatedUser = userService.updateUser(user);
        log.info("Updated user successfully: {}", updatedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //build the delete user Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        log.info("Deleted user successfully");
        return new ResponseEntity<>("Deleted user successfully", HttpStatus.OK);
    }
}
