<%-- 
    Document   : uploadPhotoSuccess
    Created on : Apr 29, 2020, 6:45:50 AM
    Author     : vatso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <table cellpadding="2" cellspacing="2" border="1">
            <tr> 
                <td>Name</td>
                <td>${theBlackjackPlayer.profilePhotoName }</td>
            </tr>
            <tr>
                <td>Photo</td>
                <td>
                    <img src="${pageContext.request.contextPath}/resources/img/${theBlackjackPlayer.profilePhotoData }" />
                </td>
            </tr>


        </table>
    </body>
</html>
