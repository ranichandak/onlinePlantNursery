package com.plantproject.plantapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plantproject.plantapp.entities.UserDtls;
import com.plantproject.plantapp.repositories.UserDetailsRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
@Autowired
private UserDetailsRepository userDetailsRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDtls user =userDetailsRepository.findByEmail(email);

        if(user!=null)
        {
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("user not available");
    }
}



   
