package com.plantproject.plantapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.plantproject.plantapp.entities.UserDtls;

import java.util.List;

@Repository
public interface UserDetailsRepository  extends JpaRepository<UserDtls,Integer>{
    public boolean existsByEmail(String email);
    
    public UserDtls findByEmail(String email);

}
