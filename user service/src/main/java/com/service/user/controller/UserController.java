package com.service.user.controller;

import com.service.user.dto.UserDTO;
import com.service.user.reponsemsg.ResponseMessage;
import com.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
       userService.addUser(userDTO);
        return new ResponseEntity<>(new ResponseMessage("User Created Successfully"), HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    ResponseEntity<?> getAllUser() {
        List<UserDTO> userDTOList = userService.getAllUser();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    ResponseEntity<?> updateUser(@PathVariable(value = "id") String id, @RequestBody UserDTO dto) {
        dto.setId(id);
        UserDTO updateUser = userService.updateUser(dto);

        if (updateUser == null) {
            return new ResponseEntity<>(new ResponseMessage("User Cannot update"), HttpStatus.BAD_GATEWAY);
        } else {
            return new ResponseEntity<>(new ResponseMessage("User Update Successfully"), HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    ResponseEntity<?> deleteUser(@PathVariable(value = "id") String id){
        userService.removeUser(id);
        return new ResponseEntity<>(new ResponseMessage("User Delete Successfully"), HttpStatus.OK);
    }
}
