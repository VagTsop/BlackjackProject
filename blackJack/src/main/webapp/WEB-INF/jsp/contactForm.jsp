<%-- 
    Document   : contactForm
    Created on : Apr 28, 2020, 2:22:12 AM
    Author     : vatso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="/resources/welcome.css">
    </head>
    <body>
        <div class="container">
            <div>
                <br><br><br>
                <c:choose>
                    <c:when test="${empty address}">
                        <div></div>
                    </c:when>
                    <c:otherwise>
                        <div><h2><strong>Message succesfully delivered to ${address}<strong><h2></div>
                                        </c:otherwise>
                                    </c:choose>
                                            <br>
                                    <h3>Contact Form</h3>
                                    ${msg}
                                    <s:form method="post" modelAttribute="contact"
                                            action="${pageContext.request.contextPath}/contact/send">
                                        <table>
                                            <tr>
                                                <td>Name</td>
                                                <td><s:input class="form-control form-control" value="${theBlackjackPlayer.firstname} ${theBlackjackPlayer.lastname}" path="name"/></td>
                                            </tr>
<!--                                            <tr>
                                                <td>Phone</td>-->
                                                <td><s:input type="hidden" path="phone"/></td>
<!--                                            </tr>   -->
                                            <tr>
                                                <td>Email</td>
                                                <td><s:input class="form-control form-control" value="${theBlackjackPlayer.email}" path="email"/></td>
                                            </tr>   
<!--                                            <tr>
                                                <td>Address</td>-->
                                                <td><s:input type="hidden" value="vatsop52@gmail.com" path="address"/></td>
<!--                                            </tr>   -->
                                            <tr>
                                                <td>Subject</td>
                                                <td><s:input class="form-control form-control" path="subject"/></td>
                                            </tr>   
                                            <tr>
                                                <td valign="top">Content</td>
                                                <td><s:textarea class="form-control form-control" path="content" rows="5" cols="20"/></td>
                                            </tr>   
                                            <tr>
                                                <td>&nbsp;</td>
                                                <td><input type="submit" value="Send"/></td>          
                                            </tr>   
                                        </table>
                                    </s:form>
                                    </div>
                                    </div>
                                    </body>
                                    </html>
