<%-- 
    Document   : editstudent
    Created on : 26 Ιουν 2019, 6:36:16 μμ
    Author     : filippos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    <body>

        <h1><%= request.getAttribute("title")%></h1>
        <form method="POST" action="StudentUpdate">
            FirstName : <input type="text" name="fname" value="<%= request.getAttribute("fname")%>" /><br>
            LastName : <input type="text" name="lname" value="<%= request.getAttribute("lname")%>" /><br>
            BithDate : <input type="date" name="birthdate" value="<%= request.getAttribute("birthdate")%>" /><br>
            Fees : <input type="number" name="fees" value="<%= request.getAttribute("fees")%>" /><br>
            <input type="hidden" name="sid" value="<%= request.getAttribute("sid")%>" />
            <input type="submit" value="Update Student" />
        </form>
    </body>
</html>
