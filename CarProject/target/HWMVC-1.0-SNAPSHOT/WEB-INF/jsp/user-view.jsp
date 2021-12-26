<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SimpleUrlHandlerMapping</title>
    </head>

    <body>
        <div>
            ${user.firstName} ${user.lastName} has the following vehicles
            <ul>
                <c:forEach var="item" items="${items}">
                    <li>
                        ${item}
                    </li>
                </c:forEach>
            </ul>
        </div>
        
    </body>
</html>
