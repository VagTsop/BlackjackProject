<%-- 
    Document   : LoginForm
    Created on : Mar 9, 2020, 2:21:31 AM
    Author     : vatso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in with your account</title>
    </head>
    <body>
    <form:form action="signedIn" modelAttribute="registeredUser" method="POST">
        <h2>Log In</h2>

        <table>
            <tbody>
                <tr>
                    <td><label>Username:</label></td>
                    <td>
            <form:input path="username"/>
            <form:label path="username"></form:label>
            <form:errors path="username" ></form:errors> 
            </td>

            </tr>

            <tr>
                <td><label>Password:</label></td>
                <td><form:input path="password"/>
            <form:label path="password"></form:label>   
            <form:errors path="password"></form:errors>
            </td>   
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Submit" class="save"/></td>   
            </tr>
            </tbody>
        </table>
    </form:form>


    <div style="clear; both;"></div

    <p>
     <input type="button" value="Back To Registration Page"
                          onclick="window.location.href='/registration/showRegisterForm'; return false;"/>
    </p>

</div>







</body>
</html>



