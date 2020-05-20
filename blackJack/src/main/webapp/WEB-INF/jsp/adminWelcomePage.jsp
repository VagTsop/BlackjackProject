

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/resources/welcome.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <div>
                <br><br><br>
                <a id="welcome">Welcome ${theBlackjackPlayer.username}</a>
                <br>
                <button onclick="location.href = '/signIn/jointable'" type="button" class="btn btn-secondary btn-lg disabled">Join Table</button>
                <br><br><br>
                <a id="welcome">Players</a>
                <table class="table table-hover" style="max-width: 300px;">
                    <tr>
                        <td><strong>Firstname</strong></td>
                        <td><strong>Lastname</strong></td>
                        <td><strong>Username</strong></td>
                    </tr>
                    <c:forEach items="${players}" var="p">
                        <tr>
                            <td>${p.firstname}</td>
                            <td>${p.lastname}</td>
                            <td>${p.username}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
