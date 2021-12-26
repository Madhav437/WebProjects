package edu.neu.hwshop.controller;


import java.io.IOException;


import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import edu.neu.hwshop.validator.OrderValidator;


import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;


@Controller

public class AppointmentController  {
    private static final long serialVersionUID = 1L;

   
    
    
  
    @RequestMapping(value="/bookAppt.htm", method=RequestMethod.GET)
    public String showLandingPage(HttpServletRequest request,
            HttpServletResponse response,Model model,Customer customer) {
    
    HttpSession session  = request.getSession();
    session.setAttribute("errMsg","");
    session.setAttribute("errMsg1","");
    session.setAttribute("errMsg3","");
    session.setAttribute("custCheck",null);
    model.addAttribute("customer", customer);
   
    return "UserRetrieve";
    
    }
    
    @RequestMapping(value="/bookAptTwo.htm", method=RequestMethod.POST)
    public String showBookingPage(HttpServletRequest request,
            HttpServletResponse response,Model model,Customer customer) {
    
    HttpSession session  = request.getSession();
    
    Customer cusCheck = (Customer)session.getAttribute("custCheck");
    
    
    
   if (cusCheck == null) {
   
	session.setAttribute("errMsg1","Please provide user details");
    return "UserRetrieve";
    
    }
   
   
   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   Date date = new Date();
   String todayDate = "\"" + dateFormat.format(date) + "\"";
   
   session.setAttribute("userApptFname",cusCheck.getFirstName());
   session.setAttribute("userApptLname",cusCheck.getLastName());
   session.setAttribute("todayDate", todayDate);
   session.setAttribute("errMsg","");
   
   ;
   
   
   
   return "BookAppt";
    }
    
 
    
    @RequestMapping(value="/getUser.htm", method=RequestMethod.POST)
    public String showBuyPage(HttpServletRequest request,
            HttpServletResponse response,Model model,Customer customer) {
    	
    	CustomerDao cusDao = new CustomerDao();
    	
    	 HttpSession session = request.getSession();
    	 
      	if(request.getAttribute("unsafe_request") == "true"){
        		 
        		 session.setAttribute("errMsg3","Invalid Characters entered");
        		 return "UserRetrieve";
             }else {
             	
             	
             	session.setAttribute("errMsg3","");
             }
    	 
    	
    	String email = customer.getUserEmail();
    	String password = customer.getUserPassword();
    	
    	Customer cus = cusDao.getUser(email,password);
    	
    	if(cus == null) 
    	{
    		//HttpSession session  = request.getSession();
    		session.setAttribute("errMsg","Invalid Credentials");
    		return "UserRetrieve";
    	}else {
    		session.setAttribute("errMsg","");
    	}
    		
    	model.addAttribute("customer", cus);
    	//HttpSession session  = request.getSession();
    	session.setAttribute("custCheck",cus);
    	
    	
    	
    return "UserRetrieve";
    	
    	
    
    
    
    
    }
    
    
    
    
    
   
    }
    
    


	

