<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
			   		 <h1>Tesla Electric Car  <br> Customer Portal </h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>
   
   <div class="form-container">
   		 <form:form method="post" action="carUser.htm" modelAttribute="order">
   		 
   		 <h4>Choose your car model: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-s.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tesla Model S</h5>
    						<p class="card-text">Model S is built for speed and endurance, with ludicrous acceleration</p>
    						<span style="left: 50%;"><form:radiobutton path="carName" value="Tesla-Model-S"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-x.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tesla Model X</h5>
    						<p class="card-text">Model X is one of the safest SUVs ever. Built from the ground up as an electric vehicle</p>
    						<span><form:radiobutton path="carName" value="Tesla-Model-X"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-y.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tesla Model Y</h5>
    						<p class="card-text">Model Y is a fully electric, mid-size SUV, with seating for up to seven and dual motor AWD</p>
    						<span><form:radiobutton path="carName" value="Tesla-Model-Y"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-3.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tesla Model 3</h5>
    						<p class="card-text">Model 3 is designed for electric-powered performance, with dual motor AWD</p>
    						<span><form:radiobutton path="carName" value="Tesla-Model-3"/></span>
  						</div>
					</div>
        	</div>
        </div>
            
            <br><br>
            
       
   		 
   		 <h4>Choose your Color: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="pearl-white.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Pearl White</h5>
    						
    						<span style="left: 50%;"><form:radiobutton path="color" value="Pearl White"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="solid-black.jpeg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Solid Black </h5>
    						
    						<span><form:radiobutton path="color" value="Solid Black"/></span>
  						</div>
					</div>
        	</div>
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="midnight-silver.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Midnight Silver </h5>
    						
    						<span><form:radiobutton path="color" value="Midnight Silver"/></span>
  						</div>
					</div>
        	</div>
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="deep-blue.jpeg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Deep Blue </h5>
    						
    						<span><form:radiobutton path="color" value="Deep Blue"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="red-multicoat.jpeg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Red Multi-Coat</h5>
    						
    						<span><form:radiobutton path="color" value="Red Multi-Coat"/></span>
  						</div>
					</div>
        	</div>
        </div>
        
            
           
           
            <h4>Choose Motor Option: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="dual-motor.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Dual Motor <br> All Wheel Drive</h5>
    						
    						<span style="left: 50%;"><form:radiobutton path="motor" value="Dual Motor"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tri-motor.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Tri Motor <br> All Wheel Drive  </h5>
    						
    						<span><form:radiobutton path="motor" value="Tri Motor"/></span>
  						</div>
					</div>
        	</div>
        	</div>
        	
        	
        	
        	 
            <h4>Choose Model Option: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-s.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Long Range Plus </h5>
    						
    						<span style="left: 50%;"><form:radiobutton path="modOption" value="Long Range Plus"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-s.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Performance </h5>
    						
    						<span><form:radiobutton path="modOption" value="Performance"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="tesla-model-s.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Plaid </h5>
    						
    						<span><form:radiobutton path="modOption" value="Plaid"/></span>
  						</div>
					</div>
        	</div>
        	</div>
        	
            
            <br><br>
            
                <h4>Choose Wheels: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="19inch.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title"> 19" Tempest Wheels </h5>
    						
    						<span style="left: 50%;"><form:radiobutton path="wheels" value="19-Tempest"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="20inch.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">21" Sonic Carbon</h5>
    						
    						<span><form:radiobutton path="wheels" value="21 Sonic Carbon"/></span>
  						</div>
					</div>
        	</div>
            
            </div>
            
            
                <h4>Interior: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="all-black.jpeg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title"> All Black  </h5>
    						
    						<span style="left: 50%;"><form:radiobutton path="interior" value="All Black"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="blackandwhite.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">Black and White</h5>
    						
    						<span><form:radiobutton path="interior" value="Black and White"/></span>
  						</div>
					</div>
        	</div>
        	
        		<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						<img class="card-img-top" src="cream.jpeg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title"> Cream</h5>
    						
    						<span><form:radiobutton path="interior" value="Cream"/></span>
  						</div>
					</div>
        	</div>
            
            </div>
           
            
            <br><br>
            
              
                <h4>Autopilot: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						
  						<div class="card-body">
    						<h5 class="card-title"> Yes </h5>
    						
    						<span style="left: 50%;"><form:radiobutton path="autopilot" value="Yes"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						
  						<div class="card-body">
    						<h5 class="card-title">No</h5>
    						
    						<span><form:radiobutton path="autopilot" value="No"/></span>
  						</div>
					</div>
        	</div>
        	</div>
          
             <h4>Payment Type: </h4>
        
        <div class="row">
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						
  						<div class="card-body">
    						<h5 class="card-title"> Cash </h5>
    						
    						<span style="left: 50%;"><form:radiobutton path="paymentType" value="Cash"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						
  						<div class="card-body">
    						<h5 class="card-title">Lease</h5>
    						
    						<span><form:radiobutton path="paymentType" value="Lease"/></span>
  						</div>
					</div>
        	</div>
        	
        	<div class="col-md-3">
        		<div class="card" style="width: 22vw;">
  						
  						<div class="card-body">
    						<h5 class="card-title">Loan</h5>
    						
    						<span><form:radiobutton path="paymentType" value="Loan"/></span>
  						</div>
					</div>
        	</div>
        	</div>
          
            
            
            <br><br>
          
          <br><br>
          <div class="row">
          	<div class="col-md-12">
          		<input type="submit" name="button" class="btn btn-outline-primary btn-lg"   value="User Details" />
          	</div>
          </div>
         
         
        </form:form>
   </div>
    
    
       
    </body>
    </html>
    
  