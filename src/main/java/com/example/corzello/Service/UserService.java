package com.example.corzello.Service;

import com.example.corzello.Entity.Role;
import com.example.corzello.Entity.UserEntity;

import java.util.List;

public interface UserService {

    void saveUser(UserEntity user) ;
    void saveRole(Role role) ;
    void addRoletoUser(long idUser ,String rolename);
    UserEntity getUser (long idUser) ;
    List<UserEntity> getUsers() ;
}
