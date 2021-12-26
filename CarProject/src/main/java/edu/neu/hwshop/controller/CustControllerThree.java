package edu.neu.hwshop.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


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

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import edu.neu.hwmvc.dao.CustomerDao;
import edu.neu.hwmvc.dao.OrdersDao;
import edu.neu.hwmvc.model.Customer;
import edu.neu.hwmvc.model.Orders;
import edu.neu.hwmvc.model.Payment;
import edu.neu.hwshop.validator.CustomerValidator;
import edu.neu.hwshop.validator.OrderValidator;
import edu.neu.hwshop.validator.PaymentValidator;


import java.util.ArrayList;
import javax.servlet.http.Cookie;


@Controller

public class CustControllerThree  {
    private static final long serialVersionUID = 1L;

   
    @Autowired
    PaymentValidator payValidator;
    
    @RequestMapping(value="/carPayAdvance.htm", method=RequestMethod.GET)
    public String showUserPage( HttpServletRequest request,
            HttpServletResponse response, Model model,Payment paym) {
    	    paym = new Payment();
    	    paym.setFirstName("");
    	    paym.setLastName("");
    	    paym.setAddress("");
    	    paym.setCity("");
    	    paym.setPhone("");
    	    paym.setZipCode("");
    	    paym.setUserEmail("");
    	    HttpSession session  = request.getSession();
    		session.setAttribute("errMsg","");
    	   
    	    
    	    return "CustPay";
    	
    }
    
    
    @RequestMapping(value="/carSuccess.htm", method=RequestMethod.POST)
    protected String handler(
            HttpServletRequest request,
            HttpServletResponse response,@ModelAttribute("payment") Payment pay, BindingResult result, SessionStatus status) {
  
    	
    	 HttpSession session = request.getSession();
    	if(request.getAttribute("unsafe_request") == "true"){
      		 
      		 session.setAttribute("errMsg","Invalid Characters entered");
      		 return "CustPay";
           }else {
           	
           	
           	session.setAttribute("errMsg","");
           }
    	payValidator.validate(pay,result);
		if(result.hasErrors()) {
			return "CustPay";
		}
		
		
        //HttpSession session = request.getSession();
        
        // Order Details
		
		String carModel = (String) session.getAttribute("carName");
		String color = (String) session.getAttribute("color");
		String motor = (String) session.getAttribute("motor");
		String modOption = (String) session.getAttribute("modOption");
		String wheels = (String) session.getAttribute("wheels");
		String interior = (String) session.getAttribute("interior");
		
		String autopilot = (String) session.getAttribute("autopilot");
		String payment = (String) session.getAttribute("payment");
		
		Orders ord = (Orders)session.getAttribute("ordObj");
		
		OrdersDao ordDao = new OrdersDao();
		
		
		// Customer Details
		
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		String address = (String) session.getAttribute("address");
		String zipCode = (String) session.getAttribute("zipCode");
		String phone = (String) session.getAttribute("phone");
		String userEmail = (String) session.getAttribute("userEmail");
		String userPassword = (String) session.getAttribute("userPassword");
		
		Customer cus = (Customer)session.getAttribute("custObj");
		
		CustomerDao cusDao = new CustomerDao();
		
		
		//Check if existing customer or new
		
		Customer cus1 = cusDao.getUserWithName(userEmail);
		
		if (cus1 == null) {
		
		
		
		int result1 = cusDao.addTodo(cus);
		
		 if(result1 != 1) {
	           // return "errorCust";
	               
	        }
		}else {
			
			cusDao.updateUser(cus1.getCustId(),cus);
			
			
		}
		 
		 // Get Created Customer - Id
		 
		
		 Customer cusSave = cus;
		 if (cus1 != null) {
			 cusSave = cus1;
		 }
			
		
		// Save Order Details in Database
		 
		 ord.setCustomer(cusSave);
		 
		 int result2 = ordDao.addTodo(ord);
			
		 if(result2 != 1) {
	           // return "errorOrd";
	               
	        }
		 
		 String ordId =Integer.toString(ord.getOrderId());
		 
		 session.setAttribute("newOrdId",ordId);
		 session.setAttribute("confPayment",payment);
		 
		 
		 
		 
		 //Send email 
		 
		 try {
		 
		 String from = "p_madhavarau@outlook.com";
	        String host = "smtp.outlook.com";
	        String to = userEmail;
	        Properties properties = System.getProperties();
	        properties.setProperty("mail.smtp.host", host);
	        properties.setProperty("mail.smtp.port", "587");
	        properties.put("mail.transport.protocol", "smtp");
	        properties.put("mail.smtp.starttls.enable","true");//starts TLS connection
	        properties.put("mail.smtp.auth", "true");
	        Authenticator auth = new SMTPAuthenticator();
	        Session sess = Session.getDefaultInstance(properties,auth);
	        
	        // Create a default MimeMessage object - MIME supports email format
	        MimeMessage message = new MimeMessage(sess);

	        // Set From: header field of the header.
	        message.setFrom(new InternetAddress(from));

	        // Set To: header field of the header.
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        
	        // Setting Subject
	        message.setSubject("Your Order Confirmation");
	        
	        //The actual Message
	        message.setText( "Hello " +firstName+" "+lastName+"\n"
	        			+"Thank you for booking you favorite Tesla.  Please find your details below "+"\n"
	        			+"Order Id :" + ordId+ "\n"
	        			+ "Car Model: " + carModel+ "\n"
	        			+"Car Color: " + color+ "\n"
	        			+"Car Motor: " + motor+ "\n"
	        			+"Model Option: " + modOption+ "\n"
	        			+ "Car Wheels: " + wheels+ "\n"
	        			+ "Car Interior: " + interior+ "\n"
	        			+ "Car Autopilot: " + autopilot+ "\n"
	        			+ "Car Payment: " + payment+ "\n");
	        					
	        			
	        
	        Transport.send(message);
	        System.out.println("Sent message successfully");
	        
	        
	        
			}
			catch(Exception e)
			{
				System.out.println("Could not send email "+e.getMessage());
			}
			
			
		
		  return "CustSuccess";
	}
    
 
			
    
    }
		
		
    
    



	

