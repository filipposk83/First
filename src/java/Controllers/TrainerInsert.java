package Controllers;

import Dao.CourseDao;
import Models.Course;
import Models.Trainer;
import Services.CourseService;
import Services.TrainerService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrainerInsert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseService cs = new CourseService();
        CourseDao cdao = new CourseDao();
        int length = cdao.getCourses().size();
        String s = cs.CourseAsList();
        request.setAttribute("lengthlist", length);
        request.setAttribute("listofCourses", s);
        RequestDispatcher rd = request.getRequestDispatcher("newtrainer.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Trainer t;
        TrainerService ts = new TrainerService();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrainerInsert</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrainerInsert at " + request.getContextPath() + "</h1>");
            int cid = Integer.parseInt(request.getParameter("cid"));
            CourseDao cdao = new CourseDao();
            Course c = cdao.getCourseById(cid);
            t = new Trainer(request.getParameter("tfname"), request.getParameter("tlname"),c,request.getParameter("tsubject"));
            if (ts.TrainerInsert(t)){
                out.print("<h2>All inserted</h2>");
            }else{
                out.print("<h2>Nothing inserted...Problem</h2>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
