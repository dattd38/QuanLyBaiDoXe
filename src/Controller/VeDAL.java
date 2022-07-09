package Controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.*;
import DTO.VeDTO;
import MyException.ContainException;
import MyException.MyException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
                ve.setBienSoXe(rs.getString(2));
                ve.setNgayBatDau(rs.getDate(3));
                ve.setNgayKetThuc(rs.getDate(4));
                ve.setTinhTrangVe(rs.getString(5));                                                          
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
                            ve.setBienSoXe(rs.getString(2));
                            ve.setNgayBatDau(rs.getDate(3));
                            ve.setNgayKetThuc(rs.getDate(4));
                            ve.setTinhTrangVe(rs.getString(5));                                                          
                            dsve.add(ve);
                  }
            }
            catch(Exception ex){
                    ex.printStackTrace();
            }
            return dsve;
    }
    public String getMV(String maVe) {
        ArrayList<VeDTO> dsVe = new ArrayList<VeDTO>();
        dsVe=VeDAL.getInstance().getResources();
        for (VeDTO ve: dsVe) {
            if (ve.getMaVe().equals(maVe)){               
                return ve.getMaVe();
            }
        }
        return "";
    }

    public String getBsx(String maVe) {
        ArrayList<VeDTO> dsVe = new ArrayList<VeDTO>();
        dsVe=VeDAL.getInstance().getResources();
        for (VeDTO ve: dsVe) {
            if (ve.getMaVe().equals(maVe)){
                return ve.getBienSoXe();
            }
        }
        return "";
    }

    public String DtoS(Date date){
        DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        String dateToS=df.format(date);
        return dateToS;
    }
    public java.util.Date getNHH(String maVe) {
        ArrayList<VeDTO> dsVe = new ArrayList<VeDTO>();
        dsVe=VeDAL.getInstance().getResources();
        for (VeDTO ve: dsVe) {
            if (ve.getMaVe().equals(maVe)){              
            return ve.getNgayKetThuc();
            }
        }
        return null;
    }
            
    public void removeVeHetHan(String maVe){
        String query = "UPDATE dbo.VE SET BIENSOXE=NULL,NGAYBATDAU=NULL,NGAYKETTHUC=NULL WHERE MAVE='"+maVe+"'";
        DAL.getInstance().executeQueryUpdate(query);
    }
    
    public int changeProcessing1(VeDTO ve) {
		int result;
		String query = "UPDATE dbo.VE SET" 
		+" MAVE=N'"  + ve.getMaVe()
		+"', BIENSOXE='" + ve.getBienSoXe()
		+"', NGAYBATDAU='" + ve.getNgayBatDau()+"'";
		//System.out.println("Query = "+ query);
		result = DAL.getInstance().executeQueryUpdate(query);
		
//		if (result > 0)
//			for (int i = 0; i<dsve.size(); i++) {
//				VeDTO e = dsve.get(i);
//				if (e.getMaVe().equals(ve.getMaVe()))
//				{
//					dsve.set(i, ve);
//					break;
//				}
//			}
		return result;
	}
}
