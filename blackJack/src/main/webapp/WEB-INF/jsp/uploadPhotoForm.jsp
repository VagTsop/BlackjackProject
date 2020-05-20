<%-- 
    Document   : uploadPhotoForm
    Created on : Apr 29, 2020, 6:29:41 AM
    Author     : vatso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Upload your profile photo</h3>
        <form:form  method="post" modelAttribute="userPhoto" enctype="multipart/form-data"
                    action="save">

            <table>
                <tr>
                    <td>Name</td>
                    <td>
                        <input path="profilePhotoName"/>
                    </td>
                </tr>  


                <tr>
                    <td>Photo</td>
                    <td>
                        <input type="file" name="profilePhotoData"/>
                    </td>
                </tr>

                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" value="Save">
                    </td>
                </tr>


            </table>


        </form:form>




    </body>
</html>
