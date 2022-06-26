package BLL;

import Controller.NhanVienDAL;
import java.util.ArrayList;

import MyException.ContainException;
import MyException.MyNullException;

import javax.swing.table.DefaultTableModel;


import DTO.*;

public class QLNhanVienBLL {
	
	public static QLNhanVienBLL instance;
	private QLNhanVienBLL(){
		
	}
	
	private boolean checkData(NhanVienDTO nv) throws MyNullException {
		if (nv.getTenTaiKhoan().equals(""))
		{
			throw new MyNullException("Mã tài khoản đang bị trống");
		}
		if (nv.getTenTaiKhoan().equals(""))
		{
			throw new MyNullException("Tên tài khoản đang bị trống");
		}
		if (nv.getTenNhanVien().equals(""))
		{
			throw new MyNullException("Tên nhân viên đang bị trống");
		}
		if (nv.getMatKhau().equals(""))
		{
			throw new MyNullException("Mật khẩu đang bị trống");
		}
		if (nv.getLoaiTaiKhoan().equals(""))
		{
			throw new MyNullException("Loại tài khoản đang bị trống");
		}
		return true;
	}
	
	public static QLNhanVienBLL getInstance() {
		if (instance == null)
			instance = new QLNhanVienBLL();
		return instance;
	}
	
	public String addProcessing(NhanVienDTO nv) {
		try{
			checkData(nv);
			ArrayList<NhanVienDTO> dsNhanVien = NhanVienDAL.getInstance().getResources();
			for(NhanVienDTO item: dsNhanVien) {
				if(item.getTenTaiKhoan().equals(nv.getTenTaiKhoan()))
					return "Tên tài khoản đã tồn tại";
			}
			String msg;
			int result = NhanVienDAL.getInstance().addNhanVien(nv);
			switch(result)
			{
			case -1:
				//msg = "Error";
			case 0:
				msg = "Thêm không thành công! Vui lòng thử lại";
				break;
				default:
					msg = "Đã thêm";
			}
			return msg;
		}
                
		catch(MyNullException ex1) {
			return ex1.getMessage();
		}
		catch(ContainException ex2) {
			return ex2.getMessage();
		}
	}
	
	public DefaultTableModel reloadResources() {
		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
		dsNhanVien = NhanVienDAL.getInstance().reloadResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {   
                        dtm.addColumn("Mã Nhân Viên");
                        dtm.addColumn("Tên nhân viên");
                        dtm.addColumn("Giới Tính");
                        dtm.addColumn("Điện Thoại");
                        dtm.addColumn("Ngày Sinh");
                        dtm.addColumn("Địa Chỉ");
                        dtm.addColumn("Tên tài khoản");
			dtm.addColumn("Mật khẩu");
			dtm.addColumn("Loại tài khoản");
                        
			for(NhanVienDTO nv : dsNhanVien) {
				Object[] row = {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getGioiTinh(),nv.getSoDienThoai(),nv.getNgaySinh(),nv.getDiaChi(),nv.getTenTaiKhoan()
                                ,nv.getMatKhau(),nv.getLoaiTaiKhoan()};
				dtm.addRow(row);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	}
	
	public DefaultTableModel getResources() {
		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
		dsNhanVien = NhanVienDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
                    
                        dtm.addColumn("Mã Nhân Viên");
                        dtm.addColumn("Tên nhân viên");
                        dtm.addColumn("Giới Tính");
                        dtm.addColumn("Điện Thoại");
                        dtm.addColumn("Ngày Sinh");
                        dtm.addColumn("Địa Chỉ");
                        dtm.addColumn("Tên tài khoản");
			dtm.addColumn("Mật khẩu");
			dtm.addColumn("Loại tài khoản");
			
			int i = 1;
			for(NhanVienDTO nv : dsNhanVien) {
				Object[] row = {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getGioiTinh(),nv.getSoDienThoai(),nv.getNgaySinh(),nv.getDiaChi(),nv.getTenTaiKhoan()
                                ,nv.getMatKhau(),nv.getLoaiTaiKhoan()};
				dtm.addRow(row);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	}
        
       
        
	public String changeProcessing(NhanVienDTO nv) {
		String msg;
		ArrayList<NhanVienDTO> dsNhanVien = NhanVienDAL.getInstance().getResources();
		boolean check = false;
		for (NhanVienDTO item: dsNhanVien) {
			if (nv.getMaNhanVien().equals(item.getMaNhanVien())) {
				if (item.getLoaiTaiKhoan().equals("2"))
					check = true;
				break;
			}
		}
		if (check && nv.getLoaiTaiKhoan().equalsIgnoreCase("1") && NhanVienDAL.getInstance().countAdminAcount() == 1)
			return "Hệ thống cần có ít nhất 1 Quản trị hệ thống";
		try {
			checkData(nv);
			int result = NhanVienDAL.getInstance().changeProcessing1(nv);
			switch(result)
			{
			case -1:
			case 0:
				msg = "Sửa không thành công! Vui lòng thử lại";
				break;
				default:
					msg = "Đã chỉnh sửa";
			}
			return msg;
		}
		catch(MyNullException e) {
			return e.toString();
		}
	}
	
	public String deleteProcessing(String matk, String loaiTaiKhoan) {
		
		if (matk.equals(""))
			return "Không có tài khoản nào được chọn để xóa";
		if (loaiTaiKhoan.equalsIgnoreCase("Quản trị hệ thống") && NhanVienDAL.getInstance().countAdminAcount() == 1)
			return "Hệ thống cần có ít nhất 1 Quản trị hệ thống";
		int result = NhanVienDAL.getInstance().deleteProcessing(matk);
		if (result > 0)
			return "Xóa thành công";
		else
			return "Xóa không thành công! Vui lòng kiểm tra lại";
	}
        
}
