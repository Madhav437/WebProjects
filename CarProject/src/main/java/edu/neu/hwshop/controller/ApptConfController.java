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
import edu.neu.hwmvc.dao.ServiceApptDao;
import edu.neu.hwmvc.model.Customer;
import edu.neu.hwmvc.model.Orders;
import edu.neu.hwmvc.model.Serviceapt;
import edu.neu.hwshop.validator.OrderValidator;


import java.util.ArrayList;
import javax.servlet.http.Cookie;


@Controller

public class ApptConfController  {
    private static final long serialVersionUID = 1L;

   
    
    
  
    @RequestMapping(value="/bookApptConf.htm", method=RequestMethod.POST)
    public String showPage(HttpServletRequest request,
            HttpServletResponse response,Model model) {
    
    HttpSession session  = request.getSession();
   // session.setAttribute("errMsg","");
    
    if(request.getAttribute("unsafe_request") == "true"){
  		 
  		 session.setAttribute("errMsg","Invalid Characters entered");
  		return "BookAppt";
       }else {
       	
       	
       	session.setAttribute("errMsg","");
       }
    
    
    
   //session.setAttribute("errMsg","Please provide a valid Registration number");
   // return "BookAppt";
   
    
    
    Serviceapt serv = new Serviceapt();
    serv.setCarName(request.getParameter("carName"));
    serv.setAppDate(request.getParameter("apptDate"));
    serv.setAppTime(request.getParameter("apptTime"));
    serv.setRegNumber(request.getParameter("regNumber"));
    serv.setMakeYear(request.getParameter("year"));
    
    
    request.setAttribute("carName",request.getParameter("carName"));
    request.setAttribute("apptDate",request.getParameter("apptDate"));
    request.setAttribute("apptTime",request.getParameter("apptTime"));
    request.setAttribute("regNumber",request.getParameter("regNumber"));
    request.setAttribute("year",request.getParameter("year"));
    
    
    Customer cusCheck = (Customer)session.getAttribute("custCheck");
    serv.setCustomer(cusCheck);
    
    
    
    
	ServiceApptDao appDao = new ServiceApptDao();
	appDao.addTodo(serv);
    
  
    	
    	
    return "AppSuccess";
    	
}
    
    
    
    
}
    
    
    
    
    
   
    
    
    


	

