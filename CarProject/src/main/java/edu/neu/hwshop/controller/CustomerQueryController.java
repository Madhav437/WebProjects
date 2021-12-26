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
import edu.neu.hwmvc.dao.OrdersDao;
import edu.neu.hwmvc.dao.ServiceApptDao;
import edu.neu.hwmvc.model.Customer;
import edu.neu.hwmvc.model.Orders;
import edu.neu.hwmvc.model.Serviceapt;
import edu.neu.hwshop.validator.CustomerValidator;
import edu.neu.hwshop.validator.OrderValidator;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;


@Controller

public class CustomerQueryController  {
    private static final long serialVersionUID = 1L;

   
    
    
    
    @RequestMapping(value="/retQuery.htm", method=RequestMethod.GET)
    protected String handler(
            HttpServletRequest request,
            HttpServletResponse response,Customer customer,Model model) {
  
		HttpSession session  = request.getSession();
		
	    session.setAttribute("errMsg","");
	    session.setAttribute("errMsg1","");
	    session.setAttribute("errMsg2","");
	    session.setAttribute("custCheck",null);
	    model.addAttribute("customer", customer);
	   
	    return "UserRetrieveTwo";
	    
	    }
    
    
    
    @RequestMapping(value="/getUserTwo.htm", method=RequestMethod.POST)
    public String showBuyPage(HttpServletRequest request,
            HttpServletResponse response,Model model,Customer customer) {
    	
    	CustomerDao cusDao = new CustomerDao();
    	
    	
    	 
    	 HttpSession session = request.getSession();
    	 
     	if(request.getAttribute("unsafe_request") == "true"){
       		 
       		 session.setAttribute("errMsg2","Invalid Characters entered");
       		 return "UserRetrieveTwo";
            }else {
            	
            	
            	session.setAttribute("errMsg2","");
            }
    	 
    	
    	String email = customer.getUserEmail();
    	String password = customer.getUserPassword();
    	
    	Customer cus = cusDao.getUser(email,password);
    	
    	if(cus == null) 
    	{
    		//HttpSession session  = request.getSession();
    		session.setAttribute("errMsg","Invalid Credentials");
    		return "UserRetrieveTwo";
    	}
    	else {session.setAttribute("errMsg","");}
    		
    	model.addAttribute("customer", cus);
    //	HttpSession session  = request.getSession();
    	session.setAttribute("custCheck",cus);
    	
    	
    	
    return "UserRetrieveTwo";
    	
    	
    
    
    
    
    }
    
    
    
    @RequestMapping(value="/retQueryTwo.htm", method=RequestMethod.POST)
    public String showBookingPage(HttpServletRequest request,
            HttpServletResponse response,Model model,Customer customer) {
    
    HttpSession session  = request.getSession();
    
    if(request.getAttribute("unsafe_request") == "true"){
  		 
  		 session.setAttribute("errMsg2","Invalid Characters entered");
  		 return "UserRetrieveTwo";
       }else {
       	
       	
       	session.setAttribute("errMsg2","");
       }
	 
    
    Customer cusCheck = (Customer)session.getAttribute("custCheck");
    
    
    
   if (cusCheck == null) {
   
	session.setAttribute("errMsg1","Please provide user details");
    return "UserRetrieveTwo";
    
    }
   
	OrdersDao ordDao = new OrdersDao();
	ServiceApptDao servApt = new ServiceApptDao();
	

	
	List<Serviceapt> cusSerList = new ArrayList<Serviceapt>(); 
	List<Orders> cusOrdList = new ArrayList<Orders>();
	
	cusOrdList = ordDao.getCustOrd(cusCheck.getCustId());
	cusSerList = servApt.getServApt(cusCheck.getCustId());
	

	
	request.setAttribute("cusSerList",cusSerList);
	request.setAttribute("cusOrdList",cusOrdList);
	
	return "CustomerQuery";

}
   
  	

	
    }
    



	

