/**
 * @author Starling Diaz on 1/29/2024.
 * @Academy StarAcademy
 * @version api-rest-demo-01 1.0
 * @since 1/29/2024.
 */

package com.example.apirestdemo01.mapper;

import com.example.apirestdemo01.dto.UserDto;
import com.example.apirestdemo01.entity.User;

public class UserMapper {

    //Convert User JPA entity to UserDto
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone()
        );
    }

    //Convert UserDto to User JPA entity
    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhone()
        );
    }
}
