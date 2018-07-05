package com.example.userservice;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void jpaTest() throws Exception{
        repository.save(new User("john","me"));

        //查询所有记录
        Assert.assertEquals(4, repository.findAll().size());

        //通过hql查询
        Assert.assertEquals("ljx", repository.findUser("cat").getName());

        //通过两个field
        Assert.assertEquals(1, repository.findByNickNameAndName("cat", "ljx"));

        repository.delete(repository.findByNickNameAndName("cat", "ljx"));

        //测试删除
        Assert.assertEquals(3, repository.findAll().size());
    }

}
