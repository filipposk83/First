package Dao;

import Models.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDao extends Dao {

    private final String getStudents = "SELECT * FROM student";
    private final String getStudentById = "SELECT * FROM student WHERE sid = ?";
    private final String insertStudent = "INSERT INTO student (sfname, slname, sdate, sfees) VALUES (?,?,?,?)";
    private final String deleteStudent = "DELETE FROM student WHERE sid = ?";
    private final String updateStudent = "UPDATE student SET sfname=?, slname=?, sdate=?, sfees=?  WHERE sid=?";

    public List<Student> getStudents() {
        List<Student> list = new ArrayList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(getStudents);
            while (rs.next()) {
                LocalDate sDate = LocalDate.parse(rs.getString("sdate"));
                list.add(new Student(rs.getInt("sid"), rs.getString("sfname"), rs.getString("slname"), sDate, rs.getDouble("sfees")));
            }
            closeConnection(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Student getStudentById(int sid) {
        Student s = null;
        try {
            PreparedStatement pst = getConnection().prepareStatement(getStudentById);
            pst.setInt(1, sid);
            ResultSet rs = pst.executeQuery();
            rs.next();
            LocalDate sDate = LocalDate.parse(rs.getString("sdate"));
            s = new Student(rs.getInt("sid"), rs.getString("sfname"), rs.getString("slname"), sDate, rs.getDouble("sfees"));
            closeConnection(rs, pst);
        } catch (SQLException ex) {
            System.out.println("The student with given id don't exist. ");
            System.out.println(ex.getMessage());
        }
        return s;
    }

    public boolean insertStudent(Student s) {
        boolean inserted = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertStudent);
            pst.setString(1, s.getSfname());
            pst.setString(2, s.getSlname());
            pst.setString(3, s.getSdate().toString());
            pst.setDouble(4, s.getSfees());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                inserted = true;
                System.out.println("Successfully insert of Student in the DataBase.");
            } else {
                System.out.println("Student not inserted");
            }
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            inserted = false;
            System.out.println(ex.getLocalizedMessage());
        }
        return inserted;
    }

    public boolean deleteStudent(int sid) {
        boolean deleted = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(deleteStudent);
            pst.setInt(1, sid);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                deleted = true;
                System.out.println("Successfully delete of Student in the DataBase.");
            } else {
                System.out.println("Student not deleted");
            }
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            deleted = false;
            System.out.println(ex.getLocalizedMessage());
        }
        return deleted;
    }

    public boolean updateStudent(Student oldS) {
        boolean updated = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(updateStudent);
            pst.setString(1, oldS.getSfname());
            pst.setString(2, oldS.getSlname());
            pst.setString(3, oldS.getSdate().toString());
            pst.setDouble(4, oldS.getSfees());
            pst.setInt(5, oldS.getSid());
            //gia insert, update, delete ---> executeUpdate
            int rs = pst.executeUpdate();
            if (rs > 0) {
                updated = true;
                System.out.println("Student updated succesfully");
            } else {
                System.out.println("Student not updated");
            }
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }

    public void printStudents(List<Student> list) {
        for (Student s : list) {
            System.out.println(s.getSid() + ". " + s.getSfname() + " " + s.getSlname() + " (birth : " + s.getSdate() + ") fees-->" + s.getSfees() + "$");
        }
    }

}
