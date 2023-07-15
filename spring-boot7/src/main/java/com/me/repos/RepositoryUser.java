package com.me.repos;

import com.me.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<User, Integer> {
    public User findByFirstName(String name);

}
