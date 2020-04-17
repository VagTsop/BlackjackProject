<%-- 
    Document   : SpringForm
    Created on : Feb 28, 2020, 7:31:57 PM
    Author     : vatso
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Create an account</title>

    </head>

    <body>

        <form:form action="registerUser" modelAttribute="newuser" method="POST">
            <h2>Create your account</h2>

            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td>
                            <form:input path="firstname"/>
                            <form:label path="firstname"></form:label>
                            <form:errors path="firstname" ></form:errors> 
                            </td>

                        </tr>

                        <tr>
                            <td><label>Last name:</label></td>
                            <td><form:input path="lastname"/>
                            <form:label path="lastname"></form:label>   
                            <form:errors path="lastname"></form:errors>
                            </td>   
                        </tr>

                        <tr>
                            <td><label>Username:</label></td>
                            <td><form:input path="username"/>
                            <form:label path="username"></form:label> 
                            <form:errors path="username"></form:errors>
                            </td>   
                        </tr>
                        <tr>
                            <td><label>Password:</label></td>
                            <td><form:input path="password"/>
                            <form:label path="password"></form:label> 
                            <form:errors path="password" ></form:errors>
                            </td>   
                        </tr>
                        <tr>
                            <td><label>Confirm Password:</label></td>
                            <td><form:input path="matchingpassword"/>
                            <form:label path="matchingpassword"></form:label> 
                            <form:errors path="matchingpassword" ></form:errors>
                            </td>   
                        </tr>
                        <tr>
                            <td><label>Email</label></td>
                            <td><form:input path="email"/>
                            <form:label path="email" />
                            <form:errors path="email"></form:errors>
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
     <input type="button" value="Back To Login Page"
                          onclick="window.location.href='/signIn/showLoginForm'; return false;"/>
</p>

</div>

</body>
</html>
