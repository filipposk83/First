package Dao;

import Models.Course;
import Models.Trainer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainerDao extends Dao {

    private final String getTrainers = "SELECT * FROM trainer";
    private final String getTrainerById = "SELECT * FROM trainer WHERE tid = ?";
    private final String insertTrainer = "INSERT INTO trainer (tfname, tlname, cid, tsubject) VALUES (?,?,?,?)";
    private final String deleteTrainer = "DELETE FROM trainer WHERE tid = ?";
    private final String updateTrainer = "UPDATE trainer SET tfname=?, tlname=?, cid=?, tsubject=?  WHERE tid=?";

    public List<Trainer> getTrainers() {
        List<Trainer> list = new ArrayList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(getTrainers);
            while (rs.next()) {
                int cid = rs.getInt("cid");
                CourseDao cdao = new CourseDao();
                list.add(new Trainer(rs.getInt(1), rs.getString("tfname"), rs.getString("tlname"), cdao.getCourseById(cid), rs.getString("tsubject")));
            }
            closeConnection(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Trainer getTrainerById(int tid) {
        Trainer t = null;
        try {
            PreparedStatement pst = getConnection().prepareStatement(getTrainerById);
            pst.setInt(1, tid);
            ResultSet rs = pst.executeQuery();
            rs.next();
            int cid = rs.getInt("cid");
            CourseDao cdao = new CourseDao();
            Course c = cdao.getCourseById(cid);
            t = new Trainer(rs.getInt("tid"), rs.getString("tfname"), rs.getString("tlname"), c, rs.getString("tsubject"));
            closeConnection(rs, pst);
        } catch (SQLException ex) {
            System.out.println("The trainer with given id don't exist. ");
            System.out.println(ex.getMessage());
        }
        return t;
    }

    public boolean insertTrainer(Trainer t) {
        boolean inserted = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertTrainer);
            pst.setString(1, t.getTfname());
            pst.setString(2, t.getTlname());
            pst.setInt(3, t.getCourse().getCid());
            pst.setString(4, t.getTsubject());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                inserted = true;
                System.out.println("Successfully insert of Trainer in the DataBase.");
            } else {
                System.out.println("Trainer not inserted");
            }
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            inserted = false;
            System.out.println(ex.getLocalizedMessage());
        }
        return inserted;
    }
    
    public boolean deleteTrainer(int tid) {
        boolean deleted = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(deleteTrainer);
            pst.setInt(1, tid);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                deleted = true;
                System.out.println("Successfully delete of Trainer in the DataBase.");
            } else {
                System.out.println("Trainer not deleted");
            }
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            deleted = false;
            System.out.println(ex.getLocalizedMessage());
        }
        return deleted;
    }
    
    public boolean updateTrainer(Trainer oldT) {
        boolean updated = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(updateTrainer);
            pst.setString(1, oldT.getTfname());
            pst.setString(2, oldT.getTlname());
            pst.setInt(3, oldT.getCourse().getCid());
            pst.setString(4, oldT.getTsubject());
            pst.setInt(5, oldT.getTid());
            //gia insert, update, delete ---> executeUpdate
            int rs = pst.executeUpdate();
            if (rs > 0) {
                updated = true;
                System.out.println("Trainer updated succesfully");
            } else {
                System.out.println("Trainer not updated");
            }
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }
    
    

    public void printTrainers(List<Trainer> list) {
        for (Trainer t : list) {
            System.out.println(t.getTid() + ". " + t.getTfname() + " " + t.getTlname() + " (" + t.getTsubject() + ")");
        }
    }

    public void printTrainersPerCourse(List<Course> listC, List<Trainer> listT) {
        for (Course c : listC) {
            System.out.println(c.getCtitle() + ":");
            for (Trainer t : listT) {
                if (c.equals(t.getCourse())) {
                    System.out.println("   " + t.getTfname() + " " + t.getTlname() + " (" + t.getTsubject() + ")");
                }
            }
        }
    }

}
