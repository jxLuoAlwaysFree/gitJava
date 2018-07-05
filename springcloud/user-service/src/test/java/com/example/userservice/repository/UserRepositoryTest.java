package com.example.userservice.repository;

import com.example.userservice.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRepositoryTest {


    @Autowired
    private UserRepository repository;

    @Test
    public void findByName() {
        List<User> list = repository.findByName("ljx");
    }

    @Test
    public void findByNickNameAndName() {
        Assert.assertEquals(1, repository.findByNickNameAndName("cat", "ljx").getId().intValue());
    }

    @Test
    public void findUser() {
        Assert.assertEquals("ljx", repository.findUser("dog").getName());
    }
}