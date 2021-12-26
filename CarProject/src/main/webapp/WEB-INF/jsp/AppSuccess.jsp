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
			   		 <h1>Tesla Electric Car <br> Appointment Booked</h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>
 
   
    
    <h2> &nbsp;&nbsp;&nbsp;&nbsp;Your Appointment Details</h2>
    
     <form>
     <div class="row">
     <strong>Car Model : </strong><c:out value="${carName}"/> <br> <br>
     </div>
     <div class="row">
     <strong>Appointment Date :</strong> <c:out value="${apptDate}"/> <br> <br>
      </div>
      
     <div class="row">
      <strong>Appointment Time  :  </strong><c:out value="${apptTime}"/> <br> <br>
      </div>
       <div class="row">
      <strong>Registration Number  :  </strong><c:out value="${regNumber}"/> <br> <br>
      </div>
       <div class="row">
       <strong>Model Year : </strong> <c:out value="${year}"/> <br> <br>
      </div>


     
     </form>
     
     
     
    <form method="get" action="<c:url value="/" />">
     <div class="row">
          	<div class="col-md-12">
          		<input type="submit" name="button" class="btn btn-outline-primary btn-lg"   value="Home" />
          	</div>
          </div>
    
    </form>
     

   
    
        
    </body>
    </html>
    
  