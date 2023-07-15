package com.me;


import com.me.model.User;
import com.me.repos.RepositoryUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RepositoryUserTests {

    @Autowired
    private RepositoryUser repositoryUser;

    @Test
    public void testListAll(){
        List<User> users = repositoryUser.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for(User u : users)
            System.out.println(u);
    }

    @Test
    public void testAddNew(){
        User user = new User();
        user.setFirstName("Mikey");
        user.setLastName("Kun");
        user.setEmail("Mi@gmail.com");
        user.setPassword("mikey12345");
        Assertions.assertThat(repositoryUser.save(user)).isNotNull();
    }




}
