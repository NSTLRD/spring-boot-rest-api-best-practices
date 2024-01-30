/**
 * @author Starling Diaz on 1/28/2024.
 * @Academy StarAcademy
 * @version api-rest-demo-01 1.0
 * @since 1/28/2024.
 */
package com.example.apirestdemo01.service;

import com.example.apirestdemo01.dto.UserDto;
import com.example.apirestdemo01.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);

}
