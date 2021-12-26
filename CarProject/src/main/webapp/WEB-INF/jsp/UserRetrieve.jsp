<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>   
 
 
  
  <body>
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
     <div class="jumbotron jumbotron-fluid">
			  <div class="container">
			   <div class="row">
			   	<div class="col-md-6 my-auto" >
			   		 <h1>Tesla Electric Car <br>
			   		Retrieve Your User Details </h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>
   
    
    
        <form:form method="post" action="getUser.htm" modelAttribute="customer">
        
         <div class="row">
    		<div class="col-md-12">
    			
        		User Email :    <form:input path="userEmail" type="text" /> <form:errors path="userEmail" /> 
       			User Password : <form:input path="userPassword" type="password" /><form:errors path="userPassword" /><br/>
        		
    		</div>
    	</div>
    	
    	
         <div class="row">
    		<div class="col-md-6">
    			<input type="submit" name="button" class="btn btn-outline-primary" value="Retrieve User" /> <br><br>
        		  
        		 <p style="color:red">
        		 <c:out value="${errMsg}"/> <br>
        		 
        		
        		 <c:out value="${errMsg3}"/>
        		</p>
        		 
    		</div>
    	</div>     
       
           <br/><br/>
           
               <div class="row">
          	<div class="col-md-2">
          		  First Name :
          	</div>
          	<div class="col-md-10">
          		  <form:input path="firstName" readonly="true"/> <form:errors path="firstName" />
          	</div>
          	
          </div>
          
          <div class="row">
          	<div class="col-md-2">
          		  Last Name : 
          	</div>
          	<div class="col-md-10">
          		<form:input path="lastName" readonly="true"/> <form:errors path="lastName" /> 
          	</div>
          </div>
          
          <div class="row">
          	<div class="col-md-2">
          		  Address : 
          	</div>
        
           <div class="col-md-10">
          	<form:input path="address" readonly="true" /> <form:errors path="address" />
          	</div>
          </div>
          
         <div class="row">
          	<div class="col-md-2">
          		  Zip Code:
          	</div>
          
  
          	<div class="col-md-10">
          		 <form:input path="zipCode" readonly="true" /> <form:errors path="zipCode" />
          	</div>
          </div>
          
          
          <div class="row">
          	<div class="col-md-2">
          		 Phone number :
          	</div>
    
          	<div class="col-md-10">
          		  <form:input path="phone" readonly="true"/> <form:errors path="phone" />
          	</div>
          </div>
          
         
          <div class="row">
          	<div class="col-md-2">
          	 <p style="color:red">
          		 <c:out value="${errMsg1}"/>   
          	</p>	
          	</div>
          	 </div>  
            
    
    
            
            
               
            
           
       
        </form:form> 
        
         <form method="post" action="bookAptTwo.htm">
          <div class="row">
    		<div class="col-md-6">
    			<input type="submit" name="button" class="btn btn-outline-primary" value="Book Appointment" /> 
        		 
        		
    		</div>
    	</div>
            
        </form>
        
      
        
    </body>
    </html>
    
  