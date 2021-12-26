<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			   		  Service Manager Portal </h1>
			   	</div>
			   	<div class="col-md-6" style="text-align:right;">
			   		<img src="tesla-logo.png" class="logo-image" alt="Tesla Logo">
			   	</div>
			   </div>
			   
			  </div>
</div>
     
    
    
    <table border="2" width = 100% id="sales-manager-table">
   
      <thead>
      <tr>
        <th>Car Name</th>
        <th>Appointment date</th>
        <th>Appointment Time</th>
        <th>Registration Number</th>
        <th>Model Year</th>
        <th>Customer Id</th>
       
        
      </tr>
      </thead>
      
      <tbody>
     
        
           <c:forEach items="${serList}" var="serviceapt">
              <tr>
          
          <td><c:out value="${serviceapt.carName}"/></td>
          <td><c:out value="${serviceapt.appDate}"/></td>
          <td><c:out value="${serviceapt.appTime}"/></td>
          <td><c:out value="${serviceapt.regNumber}"/></td>
          <td><c:out value="${serviceapt.makeYear}"/></td>
          <td><c:out value="${serviceapt.customer.custId}"/></td>
        
            </tr>
          
       
          </c:forEach>
     
      </tbody>
    </table>
    
    
    <form method="get" action="<c:url value="/serviceExcel.htm" />">
    <div class="row">
          	<div class="col-md-12">
          		<input type="submit" name="button" class="btn btn-outline-primary btn-lg"   value="Excel Download" />
          	</div>
          </div>
    
    </form>
     
     
  
    <form method="post" action="<c:url value="/logout" />">
    <div class="row">
          	<div class="col-md-12">
          		<input type="submit" name="button" class="btn btn-outline-primary btn-lg"   value="Logout" />
          	</div>
          </div>
   
    </form>
   
   
     
    
         
    
    </body>
    </html>