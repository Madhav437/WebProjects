<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			   		 <h1>Tesla Electric Car <br> Check your Order</h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>
     
     <form method="get" action="carPayAdvance.htm">
     <div class="row">
     <strong> Car Model : </strong> <c:out value="${carName}"/> <br> <br>
     </div>
     <div class="row">
     <strong> Color : </strong> <c:out value="${color}"/> <br> <br>
     </div>
     <div class="row">
     <strong>Motor :</strong> <c:out value="${motor}"/> <br> <br>
      </div>
     <div class="row">
     <strong>Model Option : </strong><c:out value="${modOption}"/> <br> <br>
     </div>
     <div class="row">
     <strong>Wheels : </strong><c:out value="${wheels}"/> <br> <br>
      </div>
      <div class="row">
     <strong>Interior : </strong><c:out value="${interior}"/> <br> <br>
     </div>
      <div class="row">
     <strong>Auto pilot : </strong><c:out value="${autopilot}"/> <br> <br>
     </div>
      <div class="row">
     <strong>Payment : </strong><c:out value="${payment}"/> <br> <br> 
       </div>
     <div class="row">
     <strong>Price : </strong><c:out value="${price}"/> <br> <br> 
     </div>
     
  
    
     
      <div class="row">
          	<div class="col-md-12">
          		<input type="submit" name="button" class="btn btn-outline-primary btn-lg"   value="Pay Advance" />
          	</div>
          </div>
     
     </form>  
      
    </body>
    </html>
    
  