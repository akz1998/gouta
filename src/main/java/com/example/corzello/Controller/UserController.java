package com.example.corzello.Controller;

import com.example.corzello.Entity.UserEntity;
import com.example.corzello.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userapi")
public class UserController {

    private UserService userService ;
    @GetMapping("/allusers")
    public ResponseEntity<List<UserEntity>> getUsers(){
        return  ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        return  ResponseEntity.ok().body(userService.saveUser(user));
    }
}
