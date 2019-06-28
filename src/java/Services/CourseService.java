package Services;

import Dao.CourseDao;
import Models.Course;
import java.util.List;

public class CourseService {

    public String CourseAsList() {
        CourseDao cdao = new CourseDao();
        List<Course> list = cdao.getCourses();
        StringBuilder st = new StringBuilder();
        for (Course c : list) {
            st.append("<p>" + c.getCid() + ". " + c.getCtitle() + " (" + c.getCstream() + " / " + c.getCtype() + ")  from " + c.getCstart() + " until " + c.getCend() + "</p>");
        }

        return st.toString();
    }
}
