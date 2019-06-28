package Services;

import Dao.TrainerDao;
import Models.Trainer;
import java.util.List;

public class TrainerService {
    
    public String TrainerAsList(){
        TrainerDao tdao = new TrainerDao();
        List<Trainer> list = tdao.getTrainers();
        StringBuilder st = new StringBuilder();
        for (Trainer t : list) {
            //gia na mporoume na valoume parametrous sto URL ----> (? kati=value&......)
            String delete = " <a href='TrainerDelete?delete=" + t.getTid() + "'>Delete</a> ";
            String update = " <a href='TrainerUpdate?update=" + t.getTid() + "'>Update</a> ";
            st.append("<p>" +t.getTid() + ". " + t.getTfname() + " " + t.getTlname() + " (" + t.getTsubject() + ") " + delete + update +"</p>");
        }
        
        return st.toString();
    }
    
    public boolean TrainerInsert(Trainer t){
        TrainerDao tdao = new TrainerDao();
        if (tdao.insertTrainer(t)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean TrainerDelete(int tid){
        TrainerDao tdao = new TrainerDao();
        if (tdao.deleteTrainer(tid)){
            return true;
        }else{
            return false;
        }
    }
    
}
