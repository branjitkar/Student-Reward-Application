package com.service.user.dto;

import com.service.user.entity.User;

public class UserWrapper {

    public static UserDTO mapToUserDto(User user){
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getRole()
        );
    }

    public static User mapToUser(UserDTO userDto){
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getRole()
        );
    }
}
