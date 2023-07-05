package com.plantproject.plantapp.entities;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)

public class UserDtls {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private int zip;

    private String role;

   @ManyToMany
    @JoinTable(
        name="usersDtls_orders",
        joinColumns = @JoinColumn(name="userDtls_id",referencedColumnName = "id"),
        inverseJoinColumns =@JoinColumn(name= "order_id",referencedColumnName = "id")
    )
    private List<Order> orders;
}
