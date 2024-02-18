package com.example.corzello.Repository;

import com.example.corzello.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username) ;
    UserEntity findById(long id) ;
}