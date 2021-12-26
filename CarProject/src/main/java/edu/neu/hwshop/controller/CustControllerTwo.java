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

import edu.neu.hwmvc.dao.CustomerDao;
import edu.neu.hwmvc.model.Customer;
import edu.neu.hwmvc.model.Orders;
import edu.neu.hwshop.validator.CustomerValidator;
import edu.neu.hwshop.validator.OrderValidator;


import java.util.ArrayList;
import javax.servlet.http.Cookie;


@Controller

public class CustControllerTwo  {
    private static final long serialVersionUID = 1L;

   
    @Autowired
    CustomerValidator custValid;
    
    
    @RequestMapping(value="/retCusCheck.htm", method=RequestMethod.POST)
    public String showPage(HttpServletRequest request,
            HttpServletResponse response,Model model,Customer customer) {
    	
    	CustomerDao cusDao = new CustomerDao();
    	
    	HttpSession session  = request.getSession();
    	
    	if(request.getAttribute("unsafe_request") == "true"){
      		 
      		 session.setAttribute("errMsg2","Invalid Characters entered");
      		 return "CustUser";
           }else {
           	
           	
           	session.setAttribute("errMsg2","");
           }
    	 
    	
    	String email = request.getParameter("inEmail");
    	String password = request.getParameter("inPassword");
    	
    	
    	Customer cus = cusDao.getUser(email,password);
    	
    	if(cus == null) 
    	{
    		//HttpSession session  = request.getSession();
    		session.setAttribute("errMsg","User does not exist, Please create one");
    		return "CustUser";
    	}else {
    		session.setAttribute("errMsg","");
    		
    	}
    		
    	model.addAttribute("customer", cus);
  
    	
    	
    return "CustUser";
    }
    
    
    @RequestMapping(value="/carConfirm", method=RequestMethod.POST)
    protected String handler(
            HttpServletRequest request,
         
            
            HttpServletResponse response,@ModelAttribute("order") Orders ord,@ModelAttribute("customer") Customer customer, BindingResult result, SessionStatus status) {
        
    	HttpSession session  = request.getSession();
    	
    	if(request.getAttribute("unsafe_request") == "true"){
   		 
   		 session.setAttribute("errMsg2","Invalid Characters entered");
   		 return "CustUser";
        }else {
        	
        	
        	session.setAttribute("errMsg2","");
        }
    	
    	custValid.validate(customer,result);
		if(result.hasErrors()) {
			return "CustUser";
		
    
    }
		
		CustomerDao cusDao1 = new CustomerDao();
		
		Customer cusCheck1 = null;
		Customer cusCheck2 = null;
		
	//	HttpSession session  = request.getSession();
		
		cusCheck1 = cusDao1.getUserWithName(customer.getUserEmail());
		cusCheck2 = cusDao1.getUser(customer.getUserEmail(), customer.getUserPassword());
		
		
		if (cusCheck1 != null && cusCheck2 == null) {
			session.setAttribute("errMsg1","User exists with a different password");
    		return "CustUser";
			
		}
		

		
		//HttpSession session  = request.getSession();
	
		
		
		// Add User Details to the Session
		
		session.setAttribute("firstName",customer.getFirstName());
		session.setAttribute("lastName",customer.getLastName());
		session.setAttribute("address",customer.getAddress());
		session.setAttribute("zipCode",customer.getZipCode());
		session.setAttribute("phone",customer.getPhone());
		session.setAttribute("userEmail",customer.getUserEmail());
		session.setAttribute("userPassword",customer.getUserPassword());
		session.setAttribute("custObj",customer);
		
		
		
		
		return "CustConfirm";
    
    }
    
}


	

