package com.plantproject.plantapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.plantproject.plantapp.entities.Order;
import com.plantproject.plantapp.entities.UserDtls;
import com.plantproject.plantapp.repositories.OrderRepository;
import com.plantproject.plantapp.repositories.UserDetailsRepository;
import com.plantproject.plantapp.services.OrderService;
import com.plantproject.plantapp.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

  
    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    @RequestMapping("/viewOrder")
public String getAllOrder(Model model){
model.addAttribute("orders",this.orderService.getAll());
   
return "viewOrder";


}

    @RequestMapping("/login")
    public String login(Model model) {
        UserDtls user = new UserDtls();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") UserDtls user) {
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        String email = user.getEmail();
        UserDtls userData = userDetailsRepository.findByEmail(email);
        if (user.getPassword().equals(userData.getPassword())) {

            return "home";
        } else {
            return "error";
        }
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UserDtls user, HttpSession session) {
        // System.out.println(userDetails);

        boolean f = userService.checkEmail(user.getEmail());

        if (f) {
            session.setAttribute("msg", "Email Already Exist ");
        } else {
            UserDtls userDtls = userService.createUser(user);

            if (userDtls != null) {
                session.setAttribute("msg", "Registerd Successfully");
            } else {
                session.setAttribute("msg", "Something wrong on server ");
            }
        }
        return "success";
    }

    @RequestMapping("/order")
    public String order(Model model) {

        Order order = new Order();
        model.addAttribute("order", order);
        return "order";

    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute Order order) {

        this.orderService.addOrder(order);
        return "orderSuccess";

    }



    @RequestMapping("/delete/{id}")
public String deleteOrder(@PathVariable Integer id){
  this.orderService.deleteOrder(id);

  return "redirect:/viewOrder";
}
@RequestMapping("/update/{id}")
public String updateOrder(Model model,@PathVariable Integer id ){
model.addAttribute("order", this.orderService.searchOrder(id));
  return "updateOrder";
}

@RequestMapping("/updateorder")
  public String updateOrderDone(@ModelAttribute Order order){
    this.orderService.updateOrder(order);
     return "redirect:/viewOrder";
  }

    


}
