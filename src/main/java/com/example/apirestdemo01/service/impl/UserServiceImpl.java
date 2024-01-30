/**
 * @author Starling Diaz on 1/28/2024.
 * @Academy StarAcademy
 * @version api-rest-demo-01 1.0
 * @since 1/28/2024.
 */

package com.example.apirestdemo01.service.impl;

import com.example.apirestdemo01.dto.UserDto;
import com.example.apirestdemo01.entity.User;
import com.example.apirestdemo01.exceptions.UserNotFoundException;
import com.example.apirestdemo01.mapper.UserMapper;
import com.example.apirestdemo01.repository.UserRepository;
import com.example.apirestdemo01.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto Into User JPA Entity
        User user = UserMapper.mapToUser(userDto);
        //Save User to DB
        User savedUser = userRepository.save(user);
        //Convert User JPA Entity Into UserDto
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

/*THIS LOGIC IS A BEGINEER WAY TO HANDLE THE CONVERT TO DTO A ENTITY AND VICEVERSA
* WE CAN USE THE MAPPER CLASS TO HANDLE THIS LOGIC

    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto Into User JPA Entity
        User user = new User(
               userDto.getId(),
               userDto.getFirstName(),
               userDto.getEmail(),
               userDto.getPassword(),
               userDto.getPhone()
       );
        //Save User to DB
     User savedUser = userRepository.save(user);
      //Convert User JPA Entity Into UserDto
      UserDto savedUserDto = new UserDto(
               savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getEmail(),
                savedUser.getPassword(),
                savedUser.getPhone()
        );
        return savedUserDto;
    }
*/
    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return UserMapper.mapToUserDto(user);
        }else{
            throw new UserNotFoundException(userId);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setPhone(user.getPhone());
            User updatedUser = userRepository.save(userToUpdate);
            return UserMapper.mapToUserDto(updatedUser);
        }else{
            throw new UserNotFoundException(user.getId());
        }
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userRepository.deleteById(userId);
        }else{
            throw new UserNotFoundException(userId);
        }
    }
}
