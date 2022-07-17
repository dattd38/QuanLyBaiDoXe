package BLL;

import Controller.DAL;
import Controller.NhanVienDAL;
import DTO.NhanVienDTO;
import GUI.QLThongTinCaNhanGUI;
import java.util.ArrayList;

import GUI.QuanTriHeThongGUI;
import GUI.QuanTriHeThongGUI;
import GUI.TrangChuGUI;
import MyException.MyNullException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DangNhapBLL {
	static DangNhapBLL instance;
	
	private DangNhapBLL(){
		
	}
	
	public static DangNhapBLL getInstance() {
		if (instance == null) {
			instance = new DangNhapBLL();
		}
		return instance;
	}
	
	private void checkData(String taiKhoan, String matKhau) throws MyNullException{
		try {
			if (taiKhoan.equals(""))
				throw new MyNullException();
			if (matKhau.equals(""))
				throw new MyNullException();
		}catch(NullPointerException e) {
			throw new MyNullException();
		}
	}
	
	public boolean dangNhap(String taiKhoan, String matKhau) {
		try {
			ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
			dsNhanVien = NhanVienDAL.getInstance().getResources();
			checkData(taiKhoan, matKhau);
                        
			SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
                        Calendar   cal = Calendar.getInstance();
                        java.util.Date date = cal.getTime();
                        String ngaylap = fm.format(date);
                        java.sql.Date.valueOf(ngaylap);
                        String query="INSERT INTO dbo.DOANHTHU VALUES ('"+java.sql.Date.valueOf(ngaylap)+"',0,0,0,0)";
                        DAL.getInstance().executeQueryUpdate(query);
			for (NhanVienDTO nv: dsNhanVien) {
				if (nv.getTenTaiKhoan().equals(taiKhoan) && nv.getMatKhau().equals(matKhau)) {
                                    
					if(nv.getLoaiTaiKhoan().equals("1")) {
						ThongTinCaNhanBLL.getInstance().setNhanVien(nv);
						TrangChuGUI trangchu=TrangChuGUI.getInstance();
                                                ThongTinCaNhanBLL.getInstance().LoadResources();
						trangchu.getFrmTrangChu().setVisible(true);
                                                
					}
                                        else if(nv.getLoaiTaiKhoan().equals("2")) {
						QuanTriHeThongGUI.getInstance().getFrmMain().setVisible(true);
                                                ThongTinCaNhanBLL.getInstance().setNhanVien(nv);
                                                ThongTinCaNhanBLL.getInstance().LoadResources();
					}
                                        else if(nv.getLoaiTaiKhoan().equals("3")) {
						QuanTriHeThongGUI.getInstance().getFrmMain().setVisible(true);
                                                ThongTinCaNhanBLL.getInstance().setNhanVien(nv); 
                                                ThongTinCaNhanBLL.getInstance().LoadResources();
                                        }
                                                
					return true;
				}
			}
			return false;
			
			
		
	
			
			
		}catch(MyNullException e) {
			return false;
		}
	}
}
