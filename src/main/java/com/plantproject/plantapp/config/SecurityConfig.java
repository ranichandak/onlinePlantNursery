package com.plantproject.plantapp.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {

@Autowired
private UserDetailsService userDetailsService;


 @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

 



    @Bean
    public SecurityFilterChain configure(HttpSecurity http)
            throws Exception {

        http
                .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")

                .requestMatchers("/user/**").hasRole("USER")
.requestMatchers("/**").permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/login")
 .defaultSuccessUrl("/user/").and().csrf().disable();             

        return http.build();

    }



   
}

