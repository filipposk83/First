
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

public class StudentUpdate extends HttpServlet {



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
        int id = Integer.parseInt(request.getParameter("update"));
        StudentService sts = new StudentService();
        Student s = sts.StudentById(id);
        request.setAttribute("sid", id);
        request.setAttribute("fname", s.getSfname());
        request.setAttribute("lname", s.getSlname());
        request.setAttribute("birthdate", s.getSdate());
        request.setAttribute("fees", s.getSfees());

        request.setAttribute("title", "Update a student");
        RequestDispatcher rd = request.getRequestDispatcher("editstudent.jsp");
        rd.forward(request, response);

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
            out.println("<title>Servlet StudentUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentUpdate at " + request.getContextPath() + "</h1>");
            int id = Integer.parseInt(request.getParameter("sid"));
            s = sts.StudentById(id);
            s.setSid(id);
            s.setSfname(request.getParameter("fname"));
            s.setSlname(request.getParameter("lname"));
            LocalDate date = LocalDate.parse(request.getParameter("birthdate"));
            s.setSdate(date);
            s.setSfees(Double.parseDouble((request.getParameter("fees"))));
            if (sts.StudentUpdate(s)) {
                out.print("<h2>All updated</h2>");
            } else {
                out.print("<h2>Nothing updated...Problem</h2>");
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
