<%-- 
    Document   : date
    Created on : 25 Ιουν 2019, 10:49:25 πμ
    Author     : filippos
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        3 + 2 = <%=3 + 2%> <br>
        3 = = 3 = <%=3 == 3%> <br>
        3 + 2 = <% out.print(3 + 2);%> <br>
        <%= new Date()%>
        <% if (Math.random() < 0.5) {
                out.print("heads");
            } else {
                out.println("tails");
            }
        %>
        <%-- this is a comment --%>
        <%
            Date d = new Date();
            System.out.println("Current date = " + d);
        %>

        <%!
            public static int count = 250;
//           out.print(count);
        %>
        <%
            // tin count mporo na ti kano kai declare/initialize meta to print kai 
            // na to ektyposei kanonika
            out.print(count);
        %>

    </body>
</html>
