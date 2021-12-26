<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
			   		 <h1>Tesla Electric Car <br> Book your Service Appointment</h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>
   
         
    
       
        
        <div class="row">
            
         <h4> <strong>First Name : </strong>  <c:out value="${userApptFname}"/> </h4> <br />
         <h4> <strong>Last Name : </strong> <c:out value="${userApptLname}"/></h4> <br/>
        
        </div>
       
       <form method="post" action="bookApptConf.htm">
        <div class="form-container">
   	
   		 
   		 <h4>&nbsp;&nbsp;Choose your car model: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-s.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tesla Model S</h5>
    						<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    						<span style="left: 50%;"><input name="carName" type="radio"value="Tesla-Model-S" checked></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-x.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tesla Model X</h5>
    						<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    						<span> <input name="carName" type="radio"value="Tesla-Model-X"></span>
  						</div>
					</div>
        	</div>
        	
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-y.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tesla Model Y</h5>
    						<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    						<span><input name="carName" type="radio"value="Tesla-Model-Y"></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-3.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tesla Model 3</h5>
    						<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    						<span><input name="carName" type="radio"value="Tesla-Model-3"></span>
  						</div>
					</div>
        	</div>
        </div>
        </div>
        
      
            
        
               <div class="row">
          	     <div class="col-md-2">    
       Appointment Date : 
                 </div>  
                 
                 
              	<div class="col-md-10"> 
       <input type="date" id="date" name="apptDate"  min=${todayDate} max="2021-03-30" required>
       </div>
       </div>
     
   
       
               <div class="row">
          	     <div class="col-md-2">
       Appointment Time :
                 </div>
                 <div class="col-md-10"> 
       <input type="time" id="time" name="apptTime"
       min="08:30" max="18:00" required>  
           </div>
       </div> 
       
       
         <div class="row">
          	     <div class="col-md-2">
       Select Car year:
       </div>
        <div class="col-md-10"> 
       <select id="year" name="year">
       <option value="2020">2020</option>
       <option value="2019">2019</option>
       <option value="2018">2018</option>
       </select> 
        </div>
       </div>
       
        
        <div class="row">
          	     <div class="col-md-2">
        Registration Number : 
        </div>
        <div class="col-md-10"> 
         <input name="regNumber" type="text"  required/>  
          </div>
           </div>
           
           
             
          <div class="row">
    		<div class="col-md-6">
    			<input type="submit" name="button" class="btn btn-outline-primary" value="Book Appointment" /> 
        		 
        		
    		</div>
    	</div>
    	
    	  <div class="row">
          	<div class="col-md-2">
          	 <p style="color:red">
          		 <c:out value="${errMsg}"/>   
          	</p>	
          	</div>
          	 </div> 
        
        
  
        
        </form>
 
        
        
    </body>
    </html>
    
  