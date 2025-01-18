package com.tradingapp.user_service.repositories;

import com.tradingapp.user_service.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public User addUser(User user){
        users.add(user);
        return user;
    }

    public User findById(Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow();
    }

    public boolean validateUserByCode(String userCode){
        return users.stream().anyMatch(user -> user.getClientCode().equals(userCode));
    }

    public List<User> findAll(){
        return users;
    }
}
