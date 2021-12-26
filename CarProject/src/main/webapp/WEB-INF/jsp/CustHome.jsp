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
			   		 <h1>Tesla Electric Car Customer Portal </h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>

       
         <div class="button-container">
         	<div class="row">
         		<div class="col-md-4">
         			<div class="card" style="width: 28vw;">
  						<img class="card-img-top" src="buy-a-car.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">BUY A CAR</h5>
    						<p class="card-text">Buy your favorite Tesla car and with customizable options</p>
    						<form method="get" action="carBuy.htm">
            					<input type="submit" name = 'button' class="btn btn-outline-primary btn-lg"  value="Buy a Car" >
        					</form>
  						</div>
					</div>
         		</div>
         		
         		<div class="col-md-4">
         			<div class="card" style="width: 28vw;">
  						<img class="card-img-top" src="book-service-appointment.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">BOOK SERVICE APPOINTMENT <br></h5>
    						<p class="card-text">Book your service appointment <br> 7 days a week</p>
    						<form method="get" action="bookAppt.htm">
            					<input type="submit" name = 'button' class="btn btn-outline-primary btn-lg" value="Book a Service Appointment" >
        					</form>
  						</div>
					</div>
         		</div>
         		
         		<div class="col-md-4">
         			<div class="card" style="width: 28vw;">
  						<img class="card-img-top" src="check-service-appointment.jpg" alt="Card image cap">
  						<div class="card-body">
    						<h5 class="card-title">CHECK SERVICE APPOINTMENTS</h5>
    						<p class="card-text"> Check your previous booking history and service appointments</p>
    						<form method="get" action="retQuery.htm">
            					<input type="submit" name = 'button' class="btn btn-outline-primary btn-lg" value="Retrieve Booking / Appointment" >
        					</form>
  						</div>
					</div>
         		</div>
         		
         		
         	</div>
         </div>
         
    </body>
    <footer id="footer">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
    <span> Madhav</span>
  </div>
  <!-- Copyright -->

</footer>
    </html>