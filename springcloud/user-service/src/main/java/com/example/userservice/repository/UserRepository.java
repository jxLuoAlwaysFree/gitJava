package com.example.userservice.repository;

import com.example.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByName(String name);

    User findByNickNameAndName(String nickName, String name);

    @Query(value = "select u from User u where u.name = :uname")
    User findUser(@Param("uname") String nickName);
}
