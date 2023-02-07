package com.service.user.service;

import com.service.user.dto.UserDTO;
import com.service.user.entity.User;

import java.util.List;

public interface UserService {

    UserDTO addUser(UserDTO userDTO);

    void removeUser(String username);

    List<UserDTO> getAllUser();

    UserDTO getUserByUsername(String userName);

    UserDTO updateUser(UserDTO userDTO);
}
