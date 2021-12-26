
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
import edu.neu.hwmvc.model.Orders;
import edu.neu.hwmvc.model.Payment;

import java.util.ArrayList;
import javax.servlet.http.Cookie;



import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;




@Component
public class PaymentValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return Payment.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors err) {
	   
	   Payment pay = (Payment) obj;

	   //Card Number
	   
	   ValidationUtils.rejectIfEmptyOrWhitespace(err, "cardNumber", "error.cardNumber","Card Number is Empty");
	   
	   Pattern pattern1 = Pattern.compile("\\d{4}-?\\d{4}-?\\d{4}-?\\d{4}");
	      
	      if (!(pattern1.matcher(pay.getCardNumber()).matches())) {
	         err.rejectValue("cardNumber", "cardNumber.invalid","Card Number is invalid");
	      }  
	      
	      
	   // Expiry date
	   ValidationUtils.rejectIfEmptyOrWhitespace(err, "expiryDate", "error.expiryDate","Expiry date is Empty");
	   Pattern pattern2 = Pattern.compile("^((0[1-9]|1[0-2])\\/[0-9]{2})$");
	      
	      if (!(pattern2.matcher(pay.getExpiryDate()).matches())) {
	         err.rejectValue("expiryDate", "expiryDate.invalid","Expiry Date is invalid");
	      }  
	      
	      
	   // CVV
	   ValidationUtils.rejectIfEmptyOrWhitespace(err, "cvvNumber", "error.cvvNumber","CVV Number is Empty");
	   
	   Pattern pattern3 = Pattern.compile("^([0-9]{3,4})$");
	      
	      if (!(pattern3.matcher(pay.getCvvNumber()).matches())) {
	         err.rejectValue("cvvNumber", "cvvNumber.invalid","CVV Number is invalid");
	      }  
	      
	      

      ValidationUtils.rejectIfEmptyOrWhitespace(err, "firstName", "error.firstName","First name is Empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "lastName", "error.lastName","Last name is Empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "address", "error.address","Address is Empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "city", "error.city","City is Empty");
      
       // Zip Code Check
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "zipCode", "error.zipCode","Zipcode is Empty");
      
      
      Pattern pattern4 = Pattern.compile("^\\d{5}$");
      
      if (!(pattern4.matcher(pay.getZipCode()).matches())) {
         err.rejectValue("zipCode", "zipCode.invalid","Zip Code is invalid");
      }  
      
      // Phone Check
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "phone", "error.phone","Phone number is Empty");
      
      Pattern pattern5 = Pattern.compile("^[2-9]\\d{2}-\\d{3}-\\d{4}$");
      
      if (!(pattern5.matcher(pay.getPhone()).matches())) {
         err.rejectValue("phone", "phone.invalid","Phone number is invalid");
      }  
      
      // Email 
      
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "userEmail", "error.userEmail","User Email is Empty");
      Pattern pattern6 = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
              Pattern.CASE_INSENSITIVE);
        if (!(pattern6.matcher(pay.getUserEmail()).matches())) {
           err.rejectValue("userEmail", "user.email.invalid","Email is invalid");
        } 
        
       
      
      
      

       

     

   }

}
