<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
 <!-- Bootstrap CSS -->
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
			   		 Enter Your User Details </h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>

    <form method="post" action="retCusCheck.htm">
    <div class="form-container">
    	
    	<h4> Please Login to retrieve your information: </h4>
    	
    
    	<div class="row">
    		<div class="col-md-12">
    			
        		User Email :    <input name="inEmail" type="text" /> &nbsp;&nbsp;&nbsp;&nbsp;
       			User Password : <input name="inPassword" type="password" /><br/>
        		
    		</div>
    	</div>
    	
    	<div class="row">
    		<div class="col-md-6">
    			<input type="submit" name="button" class="btn btn-outline-primary" value="Retrieve User" /> 
        		<c:out value="${errMsg}"/> 
        		
    		</div>
    	</div>
    	
    </div>
    </form>
    
    
    
        
        
   
    
    
        <form:form method="post" action="carConfirm.htm" modelAttribute="customer">
            
        
          
          <h4>Please fill in your Details </h4>

          <div class="row">
          	<div class="col-md-2">
          		  First Name :
          	</div>
          	<div class="col-md-10">
          		  <form:input path="firstName" /> <form:errors path="firstName" />
          	</div>
          	
          </div>
          
          <div class="row">
          	<div class="col-md-2">
          		  Last Name : 
          	</div>
          	<div class="col-md-10">
          		<form:input path="lastName" /> <form:errors path="lastName" /> 
          	</div>
          </div>
          
          <div class="row">
          	<div class="col-md-2">
          		  Address : 
          	</div>
        
           <div class="col-md-10">
          	<form:input path="address" /> <form:errors path="address" />
          	</div>
          </div>
          
         <div class="row">
          	<div class="col-md-2">
          		  Zip Code:
          	</div>
          
  
          	<div class="col-md-10">
          		 <form:input path="zipCode" /> <form:errors path="zipCode" />
          	</div>
          </div>
          
          
          <div class="row">
          	<div class="col-md-2">
          		 Phone number :
          	</div>
    
          	<div class="col-md-10">
          		  <form:input path="phone" /> <form:errors path="phone" />
          	</div>
          </div>
          
           
          <div class="row">
          	<div class="col-md-2">
          		  User Email :
          	</div>
       
          	<div class="col-md-10">
          		  <form:input path="userEmail" /> <form:errors path="userEmail" />
          	</div>
          </div>
          
          <div class="row">
          	<div class="col-md-2">
          		  User Password :
          	</div>
          
          	<div class="col-md-10">
          		  <form:password path="userPassword" /> <form:errors path="userPassword" />
          	</div>
          </div>
          	
            
            
           <div class="row">
           		<div class="col-md-10">
           			 <input type="submit" name="button" class="btn btn-outline-primary" value="Book" />
           		</div>
           </div>
            
           
            
           
       
        </form:form> 
        
         <c:out value="${errMsg1}"/> 
         <c:out value="${errMsg2}"/> 
        
    </body>
    </html>
    
  