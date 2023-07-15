package com.me.service;


import com.me.error.ConflictException;
import com.me.error.NotFoundException;
import com.me.model.User;
import com.me.repos.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    RepositoryUser repositoryUser;

    public List<User> findAll(){
        return repositoryUser.findAll();
    }

    public void save(User user){
//        if (repositoryUser.findByFirstName(user.getFirstName()) != null){
//            throw new ConflictException(String.format("This name {%s} is already exists in database !!", user.getFirstName()));
//        }else
            repositoryUser.save(user);
    }



    public User findById(int id){
        Optional<User> result = repositoryUser.findById(id);
        if (result.isPresent())
            return result.get();
        throw new NotFoundException(String.format("no user in id {%s} ", id));
    }

    public void deleteById(int id){
        repositoryUser.deleteById(id);
    }


}
