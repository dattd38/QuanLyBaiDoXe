package Controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import MyException.ContainException;
import MyException.MyException;
import java.sql.PreparedStatement;
import Controller.DAL.*;
import java.sql.Connection;
import java.sql.Statement;

public class KhuVucDAL {
	
	private static KhuVucDAL instance;
	private ArrayList<KhuVucDTO> dsKhuVuc;
	public KhuVucDAL() {
		dsKhuVuc=new ArrayList<KhuVucDTO>();
		loadResources();
	}
	
	public static KhuVucDAL getInstance() {
		if(instance==null)
			instance = new KhuVucDAL();
		return instance;
	}
	
	
	private void  loadResources() {
                String query = new String("SELECT * FROM dbo.KHUVUC");
		try {
			
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);	
			while(resultSet.next()) {			
                                                                KhuVucDTO kv=new KhuVucDTO();
                                                               
                                                                kv.setTenKhuVuc(resultSet.getString(1));
                                                                kv.setTrangThaiKhuVuc(resultSet.getString(2));
                                                              
                                                                dsKhuVuc.add(kv);
			}      		
                                            }
                                                     
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private boolean isContain(KhuVucDTO kv) {
		for (KhuVucDTO item: dsKhuVuc)
			if (item.getTenKhuVuc().equals(kv.getTenKhuVuc()))
				return true;
		return false;
	}
	

	
	/*public void changeTrangThai(String maSach, String trangThai) throws MyException{
		String query = "update sach set TrangThai = \""+trangThai+"\" where MaSach=\""+maSach+"\"";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if (result == 0)
			throw new MyException("Cập nhật trạng thái sách không thành công!");
		for (SachDTO s: dsSach) {
			if (maSach.equals(maSach)) {
				s.setTrangThai(trangThai);
				return;
			}
		}
	}*/
	
	public KhuVucDTO getSach(String khuVuc) {
		for (KhuVucDTO item:dsKhuVuc) {
			if (item.getTenKhuVuc().equals(khuVuc))
				return item;
		}
		return null;
	}
	
	
	public ArrayList<KhuVucDTO> getResources(){
		return  dsKhuVuc;
	}

	public int deleteProcessing(String s) {
                                           
		int result = DAL.getInstance().executeQueryUpdate("delete from sach1 where MASACH=\""+ s +"\"");
		if (result > 0)
			for (int i = 0; i <dsKhuVuc.size(); i++) {
				if (dsKhuVuc.get(i).getTenKhuVuc().equals(s))
					dsKhuVuc.remove(i);
			}
		return result;
	}

	public String getThongTin(String maSach) {
		for (KhuVucDTO s: dsKhuVuc) {
			if (s.getTenKhuVuc().equals(maSach))
				return s.getTenKhuVuc()+s.getTenKhuVuc()+ s.getTrangThaiKhuVuc();
		}
		return "";
	}
	
	/*public int changeProcessing(KhuVucDTO s) {
		int result;
		String query = "update sach1 set TenSach=\"" + s.getTenSach() 
		+"\", SoLuong=\""  + s.getSoLuong()
		+"\", SoTrang=\"" + s.getSoTrang()
		+"\",  GiaSach=\"" + s.getGiaSach()
		+"\", NamXuatBan=\"" + s.getNamXuatBan()
		+"\",  NhaXuatBan=\"" + s.getNhaXuatBan()
		+ "\", TheLoai=\"" + s.getTheLoai()
		+ "\", TacGia=\"" + s.getTacGia()
		+ "\" where MaSach=\"" + s.getMaSach()+"\"";
		//System.out.println("Query = "+ query);
		result = DAL.getInstance().executeQueryUpdate(query);
		if (result > 0)
			for (int i = 0; i<dsSach.size(); i++) {
				SachDTO e = dsSach.get(i);
				if (e.getMaSach().equals(s.getMaSach()))
				{
					dsSach.set(i, s);
					break;
				}
			}
		return result;
	}*/
}
