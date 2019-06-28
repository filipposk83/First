
package Controllers;

import Models.Student;
import Services.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentInsert extends HttpServlet {


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
            RequestDispatcher rd = request.getRequestDispatcher("newstudent.jsp");
            request.setAttribute("title", "Insert new Student");
            rd.forward(request, response);
     
//            some changes --- > for github
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
        Student s;
        StudentService sts = new StudentService();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentInsert</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentInsert at " + request.getContextPath() + "</h1>");
            out.println(request.getParameter("fname"));
            out.println(request.getParameter("lname"));
            LocalDate date = LocalDate.parse(request.getParameter("birthdate"));
            s = new Student(request.getParameter("fname"), request.getParameter("lname"), date, Double.parseDouble(request.getParameter("fees")));
            if (sts.StudentInsert(s)){
                out.print("<h2>All inserted</h2>");
            }else{
                out.print("<h2>Nothing inserted...Problem</h2>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
