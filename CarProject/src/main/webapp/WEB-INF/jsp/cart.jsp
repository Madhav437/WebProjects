<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="myprefix" uri="/WEB-INF/tlds/message.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
 <head>
    <title><myprefix:MyMsg/></title>
    
 </head>
 <body style="background-color:#ffebcc">
 <form>
 <h2>The Following items have been added to your cart</h2>
 
 <c:forEach items="${shop}" var="shop">
 <c:out value="${shop}"/>  
 <br><br>
 </c:forEach>
 
 
<br><br>
</form>  
   
 <form action="cart.htm" method="post" id = "formelement">
        <input type="submit" name = 'button' value="Cart" >
        </form>
<a href="Shop.html"> [Shop] </a>


	
    <a href="<c:url value="/logout" />">Logout</a>
 
 </body>

</html>