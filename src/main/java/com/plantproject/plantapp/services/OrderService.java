package com.plantproject.plantapp.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.plantproject.plantapp.entities.Order;
import com.plantproject.plantapp.entities.UserDtls;
import com.plantproject.plantapp.repositories.OrderRepository;

@Service
public class OrderService {



    private Map<Integer,Order> orderMap=new HashMap<>();
 AtomicInteger atomic =new AtomicInteger();
    @Autowired
    private OrderRepository orderRepository;





 public Iterable<Order>getAll(){
    return this.orderRepository.findAll();
}

    public void addOrder(Order newOrder) {

     this.orderRepository.save(newOrder);
    }


public void deleteOrder(int id){
this.orderRepository.deleteById(id);
}




public Order searchOrder(int id){
   return this.orderRepository.findById(id).get();
}

public void updateOrder(Order order){
    this.orderRepository.save(order);
}

}
