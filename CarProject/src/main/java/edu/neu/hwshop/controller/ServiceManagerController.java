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

public class ServiceManagerController  {
    private static final long serialVersionUID = 1L;

   
    
    
    
    @RequestMapping(value="/servmgr", method=RequestMethod.GET)
    protected String handler(
            HttpServletRequest request,
            HttpServletResponse response) {
  
		HttpSession session  = request.getSession();
		

		
		ServiceApptDao servApt = new ServiceApptDao();
		List<Serviceapt> serList = new ArrayList<Serviceapt>(); 
		serList = servApt.getTodos();
		
		
		request.setAttribute("serList",serList);
		
	
		
		return "ServiceHome";
    
    }
    
}


	

