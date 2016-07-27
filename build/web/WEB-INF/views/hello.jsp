<%-- 
    Document   : hello
    Created on : 5/01/2016, 07:13:09 AM
    Author     : SPPDF
--%>

<%@page contentType="text/html charset=ISO-8859-1" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<%@include file="include.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chapter-7 Spring MVC</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <div class="container">
            <div class="row center-block">
                <h1 class="well text-center">${name}</h1>
                <h3 class="label label-warning">${greetings}</h3><hr />
                <a href="employee/listEmployees" class="btn btn-info btn-block">Click here List of Employees</a>
            </div>
        </div>
    </body>
</html>
