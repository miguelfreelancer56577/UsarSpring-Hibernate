<%-- 
    Document   : hello
    Created on : 5/01/2016, 07:13:09 AM
    Author     : SPPDF
--%>

<%@page contentType="text/html charset=ISO-8859-1" pageEncoding="UTF-8" language="java"%>
<%@include file="include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.jsp" %>
        <title>Employee List</title>
    </head>
    <body>
        <div class="container">
            <h1 class="well text-center">Employee List</h1>
            <table class="table table-bordered table-condensed table-hover table-striped">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>id</th>
                        <th>name</th>
                        <th>jobTitle</th>
                        <th>department</th>
                        <th>salary</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${employees}" varStatus="status">
                    <tr >
                        <td><b>${status.index + 1}</b></td>
                        <td>${employee.id}</td>
                        <td>${employee.firstName} ${employee.lastName}</td>
                        <td>${employee.jobTitle}</td>
                        <td>${employee.department}</td>
                        <td>${employee.salary}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
