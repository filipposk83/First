package Controllers;

import Services.TrainerService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrainerDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrainerService ts = new TrainerService();
        int id;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrainerDelete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrainerDelete at " + request.getContextPath() + "</h1>");
            id = Integer.parseInt(request.getParameter("delete"));
            if (ts.TrainerDelete(id)){
                out.print("<h2>Deleted</h2>");
            }else{
                out.print("<h2>Not Deleted</h2>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrainerDelete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrainerDelete at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
