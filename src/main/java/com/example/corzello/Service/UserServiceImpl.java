package com.example.corzello.Service;

import com.example.corzello.Entity.Role;
import com.example.corzello.Entity.UserEntity;
import com.example.corzello.Repository.RoleRepo;
import com.example.corzello.Repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepo userRepo;

    private RoleRepo roleRepo;

    @Override
    public void saveUser(UserEntity user) {
        try {
            userRepo.save(user);
        } catch (Exception e) {
            log.info(e.toString());
        }
        log.info("user saved");
    }

    @Override
    public void saveRole(Role role) {
        try {
            roleRepo.save(role);
        } catch (Exception e) {
            e.toString();
        }
        log.info("role saved");
    }

    @Override
    public void addRoletoUser(long idUser, String rolename) {
        UserEntity user = userRepo.findById(idUser);
        Role role = roleRepo.findByName(rolename);
        try {user.getRoles().add(role);}
        catch (Exception e){
            log.info(e.toString());
        }
        log.info("role added to user");
    }

    @Override
    public UserEntity getUser(long idUser) {
        return userRepo.findById(idUser);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }
}
