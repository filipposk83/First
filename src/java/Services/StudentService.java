package Services;

import Dao.StudentDao;
import Models.Student;
import java.util.List;

public class StudentService {

    public String StudentAsList() {
        StudentDao sdao = new StudentDao();
        List<Student> list = sdao.getStudents();
        StringBuilder st = new StringBuilder();
        for (Student s : list) {
            //gia na mporoume na valoume parametrous sto URL ----> (? kati=value&......)
            String delete = " <a href='StudentDelete?delete=" + s.getSid() + "'>Delete</a> ";
            String update = " <a href='StudentUpdate?update=" + s.getSid() + "'>Update</a> ";
            st.append("<p>" + s.getSid() + ". " + s.getSfname() + " " + s.getSlname() + " (birth : " + s.getSdate() + ") fees-->" + s.getSfees() + "$ " + delete + update +"</p>");
        }
        
        return st.toString();
    }
    
    public boolean StudentInsert(Student s){
        StudentDao sdao = new StudentDao();
        if (sdao.insertStudent(s)){
            return true;
        }else{
            return false;
        }
    }
    
    
    
    public boolean StudentDelete(int sid){
        StudentDao sdao = new StudentDao();
        if (sdao.deleteStudent(sid)){
            return true;
        }else{
            return false;
        }
    }
    
    public Student StudentById(int sid){
        StudentDao sdao = new StudentDao();
        return sdao.getStudentById(sid);
    }
    
    public boolean StudentUpdate(Student s){
        StudentDao sdao = new StudentDao();
        if (sdao.updateStudent(s)){
            return true;
        }else{
            return false;
        }
    }
    

}
