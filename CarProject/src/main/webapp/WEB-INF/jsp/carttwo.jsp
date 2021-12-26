<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="myprefix" uri="/WEB-INF/tlds/message.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
 <head>
    <title><myprefix:MyMsg/></title>
    
 </head>
 <body style="background-color:#ffebcc">
 <form method="post" action="delete.htm">
 <h2>Your Items in the Cart</h2>
 
 <c:forEach items="${shop}" var="shop">
 <input type="checkbox"  name="cart" value="${shop}"/> ${shop}
 <br><br>
 </c:forEach>
	
<br><br>
<input type="submit" name = 'button' value="Delete from Cart" >

   </form> 
 
 <a href="Shop.html"> [Shop] </a> 
 <a href="<c:url value="/logout" />">Logout</a>
   
 </body>
</html>