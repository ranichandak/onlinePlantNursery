package com.plantproject.plantapp.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantproject.plantapp.entities.Order;
import com.plantproject.plantapp.entities.UserDtls;
import com.plantproject.plantapp.repositories.UserDetailsRepository;
@Service
public class UserServiceImpl implements UserService{

@Autowired
private UserDetailsRepository userDetailsRepository;

private Map<Integer,UserDtls> userMap=new HashMap<>();
 AtomicInteger atomic =new AtomicInteger();

    @Override
    public UserDtls createUser(UserDtls user) {
        return userDetailsRepository.save(user);
    }

 public Iterable<UserDtls>getAll(){
    return userDetailsRepository.findAll();
}

    @Override
    public boolean checkEmail(String email) {
        return userDetailsRepository.existsByEmail(email);
    }
    
}
