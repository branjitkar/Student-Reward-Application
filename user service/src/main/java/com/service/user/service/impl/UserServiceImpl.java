package com.service.user.service.impl;

import com.service.user.dto.UserDTO;
import com.service.user.dto.UserWrapper;
import com.service.user.entity.User;
import com.service.user.exceptions.UserAlreadyExistsException;
import com.service.user.repository.UserRepository;
import com.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userDTO.getUserName());
        if (optionalUser.isPresent()){
            throw new UserAlreadyExistsException("User already exists");
        }
        User user =  UserWrapper.mapToUser(userDTO);
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        return UserWrapper.mapToUserDto(userRepository.save(user));
    }

    @Override
    public void removeUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User>list =  userRepository.findAll();
        return list.stream().map(UserWrapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByUsername(String userName) {
        User user = userRepository.findByUserName(userName);
        return UserWrapper.mapToUserDto(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
       Optional<User> optionalUser = userRepository.findById(userDTO.getUserName());

       if (optionalUser.isPresent()){
           User user = UserWrapper.mapToUser(userDTO);
           String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
           user.setPassword(encodedPassword);
           return UserWrapper.mapToUserDto(userRepository.save(user));
       }

       return userDTO;
    }
}
