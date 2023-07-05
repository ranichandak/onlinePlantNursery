package com.plantproject.plantapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantproject.plantapp.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository <Order,Integer>{


    
}
