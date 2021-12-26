
package edu.neu.hwshop.validator;
import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.neu.hwmvc.dao.OrdersDao;
import edu.neu.hwmvc.model.Customer;


import java.util.ArrayList;
import javax.servlet.http.Cookie;



import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;




@Component
public class CustomerValidator implements Validator {

   @Override
   public boolean supports(Class<?> type) {
       return Customer.class.isAssignableFrom(type);	
   }

   @Override
   public void validate(Object obj, Errors err) {
	   
	  

      ValidationUtils.rejectIfEmptyOrWhitespace(err, "firstName", "error.firstName","First name is Empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "lastName", "error.lastName","Last name is Empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "address", "error.address","Address is Empty");
      
       // Zip Code Check
      
      Customer cust = (Customer) obj;
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "zipCode", "error.zipCode","Zipcode is Empty");
      
      
      Pattern pattern1 = Pattern.compile("^\\d{5}$");
      
      if (!(pattern1.matcher(cust.getZipCode()).matches())) {
         err.rejectValue("zipCode", "zipCode.invalid","Zip Code is invalid");
      }  
      
      // Phone Check
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "phone", "error.phone","Phone number is Empty");
      
      Pattern pattern2 = Pattern.compile("^[2-9]\\d{2}-\\d{3}-\\d{4}$");
      
      if (!(pattern2.matcher(cust.getPhone()).matches())) {
         err.rejectValue("phone", "phone.invalid","Phone number is invalid");
      }  
      
      // Email 
      
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "userEmail", "error.userEmail","User Email is Empty");
      Pattern pattern3 = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
              Pattern.CASE_INSENSITIVE);
        if (!(pattern3.matcher(cust.getUserEmail()).matches())) {
           err.rejectValue("userEmail", "user.email.invalid","Email is invalid");
        } 
        
       
        // Password
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "userPassword", "error.userPassword","Password is Empty");
      Pattern pattern4 = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$");
      if (!(pattern4.matcher(cust.getUserPassword()).matches())) {
          err.rejectValue("userPassword", "user.password.invalid"," Password must contain min 6 char, at least 1 letter and 1 num");
       } 
      
      
      

       

     

   }

}
