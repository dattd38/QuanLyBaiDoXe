package Controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import MyException.ContainException;

public class ViTriDAL {
	
	private static ViTriDAL instance;
	private ArrayList<ViTriDTO> dsViTri;
      
	public ViTriDAL() {
		dsViTri=new ArrayList<ViTriDTO>();
                loadResources();
	}
	
	public static ViTriDAL getInstance() {
		if(instance==null)
			instance=new ViTriDAL();
		return instance;
	}
	public boolean isContain(ViTriDTO pt) {
		for(ViTriDTO p:dsViTri)
			if(p.getTenKhuVuc().equals(pt.getTenKhuVuc()) &&p.getTenViTri().equals(pt.getTenKhuVuc()))
				return true;
		return false;
	}
	
	private void  loadResources(){
               String query=new String("SELECT * FROM dbo.VITRI");
		try {
			
			ResultSet rs=DAL.getInstance().executeQueryToGetData(query);
			while(rs.next()) {
                                               ViTriDTO vt=new ViTriDTO();
                                              
                                               vt.setTenViTri(rs.getString(1));
                                               vt.setTrangThaiViTri(rs.getString(2));
                                               vt.setTenKhuVuc(rs.getString(3));
                                              
                                               dsViTri.add(vt);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		//return dsViTri;
	}
	public ArrayList<ViTriDTO> getResources(){
		return  dsViTri;
	}
	public ArrayList<ViTriDTO> reloadResources(){
            dsViTri= new ArrayList<>();
            String query=new String("SELECT * FROM dbo.VITRI");
		try {
			
			ResultSet rs=DAL.getInstance().executeQueryToGetData(query);
			while(rs.next()) {
                                               ViTriDTO vt=new ViTriDTO();
                                               vt.setTenViTri(rs.getString(1));
                                               vt.setTrangThaiViTri(rs.getString(2));
                                               vt.setTenKhuVuc(rs.getString(3));
                                               dsViTri.add(vt);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return dsViTri;
	}
}
