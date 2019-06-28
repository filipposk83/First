<%-- 
    Document   : newstudent
    Created on : 26 Ιουν 2019, 11:58:07 πμ
    Author     : filippos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
        
        <jsp:useBean id="student" class="Models.Student" scope="page" />
        <jsp:setProperty name="student" property="sfname" value="Tasos" />
        Student First Name : <%= student.getSfname() %>
        
        <!-- mia variable pou tin setaro sto servlet-->
        <h1><%= request.getAttribute("title") %></h1>
        <form method="POST" action="StudentInsert">
            FirstName : <input type="text" name="fname" /><br>
            LastName : <input type="text" name="lname" /><br>
            BirthDate : <input type="date" name="birthdate" /><br>
            Fees : <input type="number" name="fees" /><br>
            <input type="submit" value="New Student" />
        </form>
    </body>
</html>
