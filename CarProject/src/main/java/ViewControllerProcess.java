/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class ViewControllerProcess extends AbstractController {
    
    public ViewControllerProcess() {
    }
    
    protected ModelAndView handleRequestInternal(
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
       
    	 if (request.getParameter("option") == "Browse")
    		 return new ModelAndView("user-view","",null);
    	 else
    		 return new ModelAndView("user-view","",null);
    		 
        
    }
}
