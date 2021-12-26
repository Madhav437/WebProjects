
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
import edu.neu.hwmvc.model.Orders;

import java.util.ArrayList;
import javax.servlet.http.Cookie;



import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;




@Component
public class OrderValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return Orders.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors err) {
	   
	   Orders ord = (Orders) obj;

      ValidationUtils.rejectIfEmpty(err, "carName", "error.carName","Car name is Empty");
     /* ValidationUtils.rejectIfEmpty(err, "email", "user.email.empty");
      ValidationUtils.rejectIfEmpty(err, "gender", "user.gender.empty");
      ValidationUtils.rejectIfEmpty(err, "languages", "user.languages.empty");*/

       

   /*   Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
      if (!(pattern.matcher(user.getEmail()).matches())) {
         err.rejectValue("email", "user.email.invalid");
      } */

   }

}
