package com.fflay.userservice.repository;

import com.fflay.userservice.model.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,String> {

}
