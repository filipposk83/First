<%-- 
    Document   : newtrainer
    Created on : 27 Ιουν 2019, 9:40:18 μμ
    Author     : filippos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert a Trainer</title>
    </head>
    <body>
        <h1>Insert a Trainer</h1><br>
        <p><%= request.getAttribute("listofCourses") %></p><br>
        <form method="POST" action="TrainerInsert">
            FirstName : <input type="text" name="tfname" /><br>
            LastName : <input type="text" name="tlname" /><br>
            CourseId : <input type="number" name="cid" min="1" max="<%= request.getAttribute("lengthlist") %>" /><br>
            Subject : <input type="text" name="tsubject" /><br>
            <input type="submit" value="New Trainer" />
        </form>
    </body>
</html>
