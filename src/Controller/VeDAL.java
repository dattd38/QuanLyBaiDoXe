package Controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.*;
import DTO.VeDTO;
import MyException.ContainException;
import MyException.MyException;

public class VeDAL { 
    private static VeDAL instance;
    private ArrayList<VeDTO> dsve;

    private VeDAL() {
            dsve = new ArrayList<VeDTO>();
            loadResources();
    }

    public static VeDAL getInstance() {
        if (instance == null){
            instance = new VeDAL();
        }
        return instance;
    }

    private void loadResources(){
        String query = new String("SELECT * FROM dbo.VE");
        try {
            ResultSet rs = DAL.getInstance().executeQueryToGetData(query);
            while(rs.next()) {
                VeDTO ve=new VeDTO();
                ve.setMaVe(rs.getString(1));
                ve.setTinhTrangVe(rs.getString(2));                                                          
                dsve.add(ve);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<VeDTO> getResources() {
        return dsve;
    }

    public int addProcessing(VeDTO mt) throws ContainException{
        return  0;
    }

    public int changeProcessing(VeDTO mt) {
        return 1;
    }

    public ArrayList<VeDTO> reloadResources() {
        dsve= new ArrayList<>();
        String query = new String("SELECT * FROM dbo.VE");
            try {
            ResultSet rs = DAL.getInstance().executeQueryToGetData(query);
            while(rs.next()) {
                            VeDTO ve=new VeDTO();
                            ve.setMaVe(rs.getString(1));
                            ve.setTinhTrangVe(rs.getString(2));                                                          
                            dsve.add(ve);
                  }
            }
            catch(Exception ex){
                    ex.printStackTrace();
            }
            return dsve;
    }
}
