package com.example.corzello.Controller;

import com.example.corzello.Entity.Role;
import com.example.corzello.Entity.UserEntity;
import com.example.corzello.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userapi")
public class UserController {
    @Autowired
    private UserService userService ;
    @GetMapping("/allusers")
    public ResponseEntity<List<UserEntity>> getUsers(){
        return  ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request ){
    return ResponseEntity.ok(userService.register(request)) ;
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request ){
        return ResponseEntity.ok(userService.authenticate(request)) ;
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/userapi/role/save").toUriString());
        return  ResponseEntity.created(uri).body(userService.saveRole(role));
}
    @PostMapping("/role/addtoUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoletoUser(form.getUsername(), form.getPassword());
        return  ResponseEntity.ok().build();
    }


}
@Data
class RoleToUserForm{
    private String username ;
    private String password ;
}