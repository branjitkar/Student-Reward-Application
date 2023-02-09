package com.service.user.controller;

import com.service.user.dto.UserDTO;
import com.service.user.exceptions.UserAlreadyExistsException;
import com.service.user.reponsemsg.ResponseMessage;
import com.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        try {
            userService.addUser(userDTO);
            return new ResponseEntity<>(new ResponseMessage("User Created Successfully"), HttpStatus.OK);
        } catch (UserAlreadyExistsException ex){
            return new ResponseEntity<>(new ResponseMessage("User NOT created. User Already Exists."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    ResponseEntity<?> getAllUser() {
        List<UserDTO> userDTOList = userService.getAllUser();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }
    @GetMapping("/{userName}")
    ResponseEntity<?> getUser(@PathVariable String userName) {
        UserDTO userDTO = userService.getUserByUsername(userName);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/{userName}")
    ResponseEntity<?> updateUser(@PathVariable String userName, @RequestBody UserDTO dto) {
        dto.setUserName(userName);
        UserDTO updateUser = userService.updateUser(dto);

        if (updateUser == null) {
            return new ResponseEntity<>(new ResponseMessage("User Cannot update"), HttpStatus.BAD_GATEWAY);
        } else {
            return new ResponseEntity<>(new ResponseMessage("User Update Successfully"), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{userName}")
    ResponseEntity<?> deleteUser(@PathVariable String userName){
        userService.removeUser(userName);
        return new ResponseEntity<>(new ResponseMessage("User Delete Successfully"), HttpStatus.OK);
    }
}
