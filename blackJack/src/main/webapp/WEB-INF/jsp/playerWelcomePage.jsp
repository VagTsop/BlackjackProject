<%-- 
    Document   : PlayerWelcomePage
    Created on : Apr 28, 2020, 8:58:35 PM
    Author     : gsami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="/resources/welcome.css">



    </head>
    <body>
        <div class="container">
            <div>
                <br><br><br>



                <a id="welcome">Welcome ${theBlackjackPlayer.username}</a>
                <br>
                <button onclick="location.href = '/signIn/jointable'" type="button" class="btn btn-secondary btn-lg disabled">Join Table</button>
                <p id="contactButton">For any further infomation please <a href="/contact/showContactForm" style="color: grey">Contact us</a></p>
            </div>
        </div>

    </body>
</html>
