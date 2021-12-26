<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <script>
    function show(shown, hidden,hidden2) {
      document.getElementById(shown).style.display='block';
      document.getElementById(hidden).style.display='none';
      document.getElementById(hidden2).style.display='none';
      return false;
    }
    </script>
    </head>
    <body>
       
       <br>
       <br>
       
        <a href="#" onclick="return show('Page1','Page2','Page3');">Books</a>
        &nbsp;&nbsp;
        <a href="#" onclick="return show('Page2','Page1','Page3');">Music</a>
        &nbsp;&nbsp;
        <a href="#" onclick="return show('Page3','Page1','Page2');">Computers</a>
        
        <br></br>
        <br></br>
        
        <form action="cart.htm" method="post" id = "formelement">
        <input type="submit" name = 'button' value="Cart" >
        </form>
        
      
        <form action="buy.htm" method="post" id = "formelement">
     
      <div id="Page1">
    
    
        <h2> Shop for Books </h2>
        <hr>
        
       
        <br></br>
        <br></br>
        
            <input type="checkbox"  name="cart" value="Java Servlet Programming"> Java Servlet Programming [$29.50]<br></br>
            <input type="checkbox"  name="cart" value="Oracle Database Programming"> Oracle Database Programming [$48.50]<br></br>
            <input type="checkbox"  name="cart" value="System Analysis & Design using UML"> System Analysis & Design using UML [$14.59]<br></br>
            <input type="checkbox"  name="cart" value="Object oriented Software Engineering"> Object oriented Software Engineering [$29.50]<br></br>
            <input type="checkbox"  name="cart" value="Java Web Services"> Java Web Services [$26.90]<br></br>
            <br></br>
            
            
       
      </div>
    
      <div id="Page2" style="display:none">
    
   
        <h2> Shop for Music </h2>
        <hr>
       
        
        <br></br>
        <br></br>
        
            
            <input type="checkbox"  name="cart" value="I am going to tell you a secret by Maddona"> I am going to tell you a secret by Maddona [$29.50]<br></br>
            <input type="checkbox"  name="cart" value="Baby one more time by Britney Spears"> Baby one more time by Britney Spears [$98.50]<br></br>
            <input type="checkbox"  name="cart" value="Justified by Justin Timberlake"> Justified by Justin Timberlake  [$40.59]<br></br>
            <input type="checkbox"  name="cart" value="Loss by Nelli Futado"> Loss by Nelli Futado [$82.50]<br></br>
            <input type="checkbox"  name="cart" value="Gold digger by Kanye West"> Gold digger by Kanye West [$66.90]<br></br>
            <br></br>
            
            
    
      </div>

      <div id="Page3" style="display:none">
    
    
        <h2> Shop for Computers </h2>
        <hr>
       
        
        
        <br></br>
        <br></br>
       
          
            <input type="checkbox"  name="cart" value="Apple MacBook Pro with 13.3 display "> Apple MacBook Pro with 13.3" display [$1229.50]<br></br>
            <input type="checkbox"  name="cart" value="Asus Laptop with Centrio 2 black"> Asus Laptop with Centrio 2 black [$998.50]<br></br>
            <input type="checkbox"  name="cart" value="HP Pavilion Laptop with Centrio 2 black"> HP Pavilion Laptop with Centrio 2 black  [$840.59]<br></br>
            <input type="checkbox"  name="cart" value="Toshiba Satellite Laptop with Centrio 2- Copper"> Toshiba Satellite Laptop with Centrio 2- Copper [$829.50]<br></br>
            <input type="checkbox"  name="cart" value="Sony VAIO Laptop with Core Composition Black"> Sony VAIO Laptop with Core Composition Black [$766.90]<br></br>
            <br></br>
        
            
      </div>
      
      
      
       <input type="submit" name = 'button' value="Add to Cart" >
       
       <form:form modelAttribute="order">
            Car Name: <form:input path="carName" /> <form:errors path="carName" /> <br />
            
            <input type="submit" value="register" />
        </form:form> 
       
       </form>
       
         
    
    </body>
    </html>