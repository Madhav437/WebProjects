 package edu.neu.interceptor;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;


public class XssInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       
       try {
    	   
    	   Enumeration<String> paramNames = request.getParameterNames();
    	   
    	   while(paramNames.hasMoreElements()) {
    		   
    		   String key = (String)paramNames.nextElement();
    		   String val = request.getParameter(key);
    		   
    		   if(xssCheck(val)) {
    			   
    			   request.setAttribute("unsafe_request","true");
    			   break;
    		   }
    		   
    	   }
       }catch(Exception e) {
    	   System.out.println(e);
       }
        
        return true;
    }
    
    private boolean xssCheck(String value) {
        if (value != null) {
            return (value.matches("<script>(.*?)</script>") || value.matches("\"<script(.*?)>\""));
        }
        return false;
    }
}
