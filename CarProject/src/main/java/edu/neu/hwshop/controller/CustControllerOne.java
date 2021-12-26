package edu.neu.hwshop.controller;


import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.neu.hwmvc.model.Customer;
import edu.neu.hwmvc.model.Orders;
import edu.neu.hwshop.validator.OrderValidator;


import java.util.ArrayList;
import javax.servlet.http.Cookie;


@Controller

public class CustControllerOne  {
    private static final long serialVersionUID = 1L;

   
    
    
  
    @RequestMapping(value="/customerhome.htm", method=RequestMethod.GET)
    public String showLandingPage() {
   
    return "CustHome";
    
    }
    
 
    
    @RequestMapping(value="/carBuy.htm", method=RequestMethod.GET)
    public String showBuyPage(Model model,Orders order,Customer customer) {
    order = new Orders();
    
    order.setCarName("Tesla-Model-S");
    order.setColor("Pearl White");
    order.setMotor("Dual Motor");
    order.setModOption("Long Range Plus");
    order.setWheels("19-Tempest");
    order.setInterior("All Black");
    order.setAutopilot("Yes");
    order.setPaymentType("Cash");
    model.addAttribute("order", order);
    return "CustBuy";
    
    }
    
    @RequestMapping(value="/carUser.htm", method=RequestMethod.POST)
    public String showUserPage( HttpServletRequest request,
            HttpServletResponse response, Model model,Customer customer,Orders ord) {
    	
    customer = new Customer();	
    // Add Car Information to the Session
		
    HttpSession session  = request.getSession();
    session.setAttribute("carName",ord.getCarName());
    session.setAttribute("color",ord.getColor());
    session.setAttribute("motor",ord.getMotor());
    session.setAttribute("modOption",ord.getModOption());
    session.setAttribute("wheels",ord.getWheels());
    session.setAttribute("interior",ord.getInterior());
    session.setAttribute("autopilot",ord.getAutopilot());
    session.setAttribute("payment",ord.getPaymentType());
    
    int price = 0;
    
    String switchCar = ord.getCarName();
    switch (switchCar) {
      case "Tesla-Model-S":
    	  price = 75000;
      break;
      case "Tesla-Model-X":
    	  price = 95000;
      break;
      case "Tesla-Model-Y":
    	  price = 65000;
      break;
      case "Tesla-Model-3":
    	  price = 55000;
      break;
    }
    
      
      String switchMotor = ord.getMotor();
      switch (switchMotor) {
        case "Dual Motor":
      	
        break;
        case "Tri Motor":
      	 price = price + 10000;
        break;
      }
        
        
        String switchModel = ord.getModOption();
        switch (switchModel) {
          case "Long Range Plus":
        	 
          break;
          case "Performance":
        	  price = price + 8000;
          break;
          case "Plaid":
        	  price = price + 12000;
          break;
        }
          
          
          
          String switchWheels = ord.getWheels();
          switch (switchWheels) {
            case "19-Tempest":
          	 
            break;
            case "21-Tempest":
          	  price = price + 4000;
            break;
            
          }
            
            
            String switchInterior = ord.getInterior();
            switch (switchInterior) {
              case "All Black":
            	  
              break;
              case "Black and White":
            	  price = price + 3500;
              break;
              case "Cream":
            	  price = price + 5500;
              break;
            }
              
              
              String switchAutopilot = ord.getAutopilot();
              switch (switchAutopilot) {
                case "Yes":
              	  price = price + 10000;
                break;
                case "No":
              	 
                break;
              }
            
      
      
    session.setAttribute("price",price);
    ord.setPrice(price);
     
    
    session.setAttribute("ordObj",ord);
    
    //Initialize fields
    
    customer.setFirstName("");
    customer.setLastName("");
    customer.setAddress("");
    customer.setPhone("");
    customer.setZipCode("");
    customer.setUserEmail("");
    customer.setUserPassword("");
    model.addAttribute("customer", customer);
    session.setAttribute("errMsg","");
    session.setAttribute("errMsg1","");
    return "CustUser";
    
    }
    
    }


	

