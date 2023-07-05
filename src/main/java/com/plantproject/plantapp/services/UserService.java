package com.plantproject.plantapp.services;

import com.plantproject.plantapp.entities.UserDtls;

public interface UserService {
    
public UserDtls createUser(UserDtls user);

public boolean checkEmail(String email);
public Iterable<UserDtls>getAll() ;

}
