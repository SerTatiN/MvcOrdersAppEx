package org.top.mvcordersappex.model.dao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.mvcordersappex.model.entity.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbDaoUserTest {

    @Autowired
    private IDaoUser daoUser;

    @Test
    void addUser() {
        User user = new User("test_user_01", "qwerty");
        daoUser.addUser(user);
    }
}