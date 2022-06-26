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
	
	public int addProcessing(ViTriDTO pt) throws ContainException{
		/*if(isContain(pt))
			throw new ContainException("Mã lần phạt đã tồn tại");
		String query="insert into quanlytienphat values(\"" +pt.getMaLanPhat()+"\",\""+pt.getSoTien()+"\",\""+pt.getMaDocGia()
		+"\",\""+pt.getNgayPhat()+"\",\""+pt.getLyDo()+"\")";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if(result>0)
			dsPhatTien.add(pt);
		return result;*/
                return  1;
	}
	
	public int deleteProcessing(String malp) {
		/*int result = DAL.getInstance().executeQueryUpdate("delete from quanlytienphat where MaLanPhat=\""+malp+"\"");
		if(result>0)
			for(int i=0;i<dsPhatTien.size();i++)
			{
				if(dsPhatTien.get(i).getMaLanPhat().equals(malp))
					dsPhatTien.remove(i);
			}
		return result;*/
                return 1;
	}
	
	public int changeProcessing(ViTriDTO pt) {
		/*int result;
		String query="update quanlytienphat set SoTien=\""+pt.getSoTien()+"\", MaDocGia=\""+pt.getMaDocGia()+"\", NgayPhat=\""
		+pt.getNgayPhat()+"\", LyDo=\""+pt.getLyDo()+"\" where MaLanPhat=\"" +pt.getMaLanPhat()+"\"";
		System.out.println(query);
		result=DAL.getInstance().executeQueryUpdate(query);
		if(result>0)
			for(int i=0;i<dsPhatTien.size();i++) {
				PhatTienDTO p=dsPhatTien.get(i);
				if(p.getMaLanPhat().equals(pt.getMaLanPhat()))
				{
					dsPhatTien.set(i, pt);
					break;
				}
			}
		return result;*/
                return 1;
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
