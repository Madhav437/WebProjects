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

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import java.util.ArrayList;
import javax.servlet.http.Cookie;

class SMTPAuthenticator extends Authenticator
{

public PasswordAuthentication getPasswordAuthentication()
{
	
	    String username = "***@outlook.com";
	    String password = "****";
	    return new PasswordAuthentication(username, password);
	
}

}
    
    


	

