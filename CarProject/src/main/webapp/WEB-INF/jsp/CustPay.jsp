<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>  
   
    <body>
    
     <body>
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
     <div class="jumbotron jumbotron-fluid">
			  <div class="container">
			   <div class="row">
			   	<div class="col-md-6 my-auto" >
			   		 <h1>Tesla Electric Car <br>
			   		Pay Advance Non Refundable Amount - 100 $</h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>
  
    
    
   
    
          <form:form method="post" action="carSuccess.htm" modelAttribute="payment">
          
            <h3> &nbsp;&nbsp;&nbsp;&nbsp;  Please fill in your Payment Details </h3>  <br><br>
            
            <div class="row">
    		<div class="col-md-12">
            Card Number : <form:input path="cardNumber" /> <form:errors path="cardNumber" /> 
            Expiry Date: <form:input path="expiryDate" /> <form:errors path="expiryDate" /> 
            CVV : <form:password path="cvvNumber" /> <form:errors path="cvvNumber" /> <br> <br>
            	
    		</div>
    	</div>
            
            
            <h3>  &nbsp;&nbsp;&nbsp;&nbsp;  Billing Details</h3>
            
            <div class="row">
    		<div class="col-md-2">
            
            
            First Name :  
            		
    		</div>
    
    		    <div class="col-md-8">
    		
    		<form:input path="firstName" /> <form:errors path="firstName" />
    		
    		</div>
    	</div> 
    
    	   
    	 <div class="row">
    		<div class="col-md-2">
    	
            Last Name : 
            
          </div>
          
           <div class="col-md-8">
          
          <form:input path="lastName" /> <form:errors path="lastName" /> <br />
          
          </div>
    	</div>
    	   
    	  <div class="row">
    		<div class="col-md-2">
    	
            Address : 
            
          </div>
          
           <div class="col-md-8">
          
          <form:input path="address" /> <form:errors path="address" /> <br />
          
            </div>
    	</div>
    	
    	
    	    <div class="row">
    		<div class="col-md-2">
    	
          
            City : 
            
            </div>
                <div class="col-md-8">
                
            <form:input path="city" /> <form:errors path="city" /> <br />
            
             
            </div>
    	</div>
    	
    	
    	    <div class="row">
    		<div class="col-md-2">
            Zip Code: 
            
              
            </div>
            
             <div class="col-md-8">
            
            <form:input path="zipCode" /> <form:errors path="zipCode" /> <br />
            
               
            </div>
    	</div>
    	
    	      <div class="row">
    		<div class="col-md-2">
    	
            Phone number : 
            
             </div>
             
              <div class="col-md-8">
            
            <form:input path="phone" /> <form:errors path="phone" /> <br />
                 
            </div>
    	</div>
    	
    	
              <div class="row">
    		<div class="col-md-2">
    		
            User Email :
            
             </div>
             
              <div class="col-md-8">
             
              <form:input path="userEmail" /> <form:errors path="userEmail" /> <br />
             </div>
    	</div>
    	
    	
    	
    	 <div class="row">
    		<div class="col-md-6">
    			<input type="submit" name="button" class="btn btn-outline-primary" value="Pay" /> 
        		 
        		
    		</div>
    			</div>
     
            
             
             
             <c:out value="${errMsg}"/> 
           
        </form:form> 
        
 
       
    </body>
    </html>
    
  