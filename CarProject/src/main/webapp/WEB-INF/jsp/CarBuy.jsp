<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
    <h1>Tesla Electric Car - Book your Favorite Car and Customize </h1>
    <body>
   
    
    
        <form:form modelAttribute="order">
            
            Car Model: <br><br>
            Tesla Model S <form:radiobutton path="carName" value="Tesla-Model-S"/>
            Tesla Model X <form:radiobutton path="carName" value="Tesla-Model-X"/>
            Tesla Model Y <form:radiobutton path="carName" value="Tesla-Model-Y"/>
            Tesla Model 3 <form:radiobutton path="carName" value="Tesla-Model-3"/>
            
            <br><br>
            Color : <br><br>
            Pearl White <form:radiobutton path="color" value="Pearl White"/>
            Solid Black<form:radiobutton path="color" value="Solid Black"/>
            Midnight Silver  <form:radiobutton path="color" value="Midnight Silver"/>
            Deep Blue <form:radiobutton path="color" value="Deep Blue"/>
            Red Multi-Coat<form:radiobutton path="color" value="Red Multi-Coat"/>
            
            <br><br>
            Motor : <br><br>
            Dual Motor - All Wheel Drive <form:radiobutton path="motor" value="Dual Motor"/>
            Tri Motor - All Wheel Drive  <form:radiobutton path="motor" value="Tri Motor"/>
            
            
            <br><br>
            Model Option : <br><br>
            
            Long Range Plus  <form:radiobutton path="modOption" value="Long Range Plus"/>
            Performance <form:radiobutton path="modOption" value="Performance"/>
            Plaid <form:radiobutton path="modOption" value="Plaid"/>
            
            <br><br>
            Wheels: <br><br>
            
            19" Tempest Wheels <form:radiobutton path="wheels" value="19-Tempest"/>
            21" Sonic Carbon <form:radiobutton path="wheels" value="21-Tempest"/>
            
            <br><br>
            Interior : <br><br>
            
            All Black  <form:radiobutton path="interior" value="All Black"/>
            Black and White<form:radiobutton path="interior" value="Black and White"/>
            Cream <form:radiobutton path="interior" value="Cream"/>
            
            <br><br>
            Autopilot : <br><br>
            <form:checkbox path="autopilot"/>
         
            
            
            <br><br>
            Payment type : <br><br>
           
             
            Cash <form:radiobutton path="paymentType" value="Cash"/>
            Lease<form:radiobutton path="paymentType" value="Lease"/>
            Loan <form:radiobutton path="paymentType" value="Loan"/>
            
     
            
         
        </form:form> 
    
          <form:form modelAttribute="customer">
          
            <h2>Please fill in your Details </h2>  <br><br>
            
            First Name : <form:input path="firstName" /> <form:errors path="firstName" /> <br />
            Last Name : <form:input path="lastName" /> <form:errors path="lastName" /> <br />
            Address : <form:input path="address" /> <form:errors path="address" /> <br />
            Zip Code: <form:input path="zipCode" /> <form:errors path="zipCode" /> <br />
            Phone number : <form:input path="phone" /> <form:errors path="phone" /> <br />
            User Email : <form:input path="userEmail" /> <form:errors path="userEmail" /> <br />
            User Password : <form:password path="userPassword" /> <form:errors path="userPassword" /> <br />
                
            
           
        </form:form> 
        
         <form method="post" action="carConfirm.htm">
        
         <input type="submit" value="Book" />
         
         </form>
    </body>
    </html>
    
  