
package Controllers;


import Services.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author filippos
 */
public class StudentServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String queryString = request.getQueryString();
        StudentService sts = new StudentService();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>This is a great servlet at " + request.getContextPath() + "</h1>");
            out.println("<br>");
            out.println("<p id='par1'>This is a paragraph</p>");
//            for(Student s: list){
//                out.print("<p>"+s.getSid() + ". " + s.getSfname() + " " + s.getSlname() + " (birth : " + s.getSdate() + ") fees-->" + s.getSfees() + "$"+"</p>");
//            }
            out.println(sts.StudentAsList());

            if (queryString != null) {
                out.println(queryString);
                out.print("param delete is : "+request.getParameter("delete"));
            }
            out.println("</body>");
            out.println("</html>");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
