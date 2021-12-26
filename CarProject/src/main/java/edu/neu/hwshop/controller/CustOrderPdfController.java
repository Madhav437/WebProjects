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

public class CustOrderPdfController  {
    private static final long serialVersionUID = 1L;

   
    @Autowired
    PaymentValidator payValidator;
    
    @RequestMapping(value="/carPdf.htm", method=RequestMethod.POST)
    public String showUserPage( HttpServletRequest request,
            HttpServletResponse response, Model model,Payment paym) {
   
    	
    	 HttpSession session = request.getSession();
    	
		
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
		String ordId = (String) session.getAttribute("newOrdId");
		
		Orders ord = (Orders)session.getAttribute("ordObj");
		
		
		
		

		
		// PDF Doc
			
 
	try{
		
		response.setContentType("application/pdf");
		
		Document document = new Document();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        Paragraph Title = new Paragraph("Order Confirmation");
        Paragraph OrderId = new Paragraph("Order Id : " + ordId);
        Paragraph CarMake = new Paragraph("Car Model: " + carModel);
        Paragraph CarColor = new Paragraph("Car Color: " + color);
        Paragraph CarMotor = new Paragraph("Car Motor: " + motor);
        Paragraph CarModOption = new Paragraph("Model Option: " + modOption);
        Paragraph CarWheels = new Paragraph("Car Wheels: " + wheels);
        Paragraph CarInterior = new Paragraph("Car Interior: " + interior);
        Paragraph CarAutopilot = new Paragraph("Car Autopilot: " + autopilot);
        Paragraph CarPayment = new Paragraph("Car Payment: " + payment);
        

       
        document.add(Title);
        document.add(OrderId);
        document.add(CarMake);
        document.add(CarColor);
        document.add(CarMotor);
        document.add(CarModOption);
        document.add(CarWheels);
        document.add(CarInterior);
        document.add(CarAutopilot);
        document.add(CarPayment);
        
        
        
        
        document.close();
        
        response.setHeader("Content-Disposition",
                "attachment; filename=OrderConfirmation.pdf");
        
        ServletOutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
        
        
		}
		
		catch(Exception e)
		{
			System.out.println("Could not add Confirmation object"+e.getMessage());
		}
	
		  return null;
	}
    
 
			
    
    }
		
		
    
    



	

