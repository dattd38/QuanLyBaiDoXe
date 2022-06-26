package Controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;

import DTO.*;
import MyException.ContainException;
import MyException.MyException;

public class NhanVienDAL {

	private static NhanVienDAL instance;
	private ArrayList<NhanVienDTO> dsNhanVien;
	private NhanVienDAL() {
		dsNhanVien = new ArrayList<NhanVienDTO>();
		loadResources();
	}
	
	private void loadResources(){
                                         String query=new String("SELECT * FROM dbo.NHANVIEN");
                                         try {
                                                ResultSet rs=DAL.getInstance().executeQueryToGetData(query);
                                                while(rs.next()){
                                                    NhanVienDTO nv=new NhanVienDTO();
                                                   nv.setMaNhanVien(rs.getString(1));
                                                   nv.setTenNhanVien(rs.getString(2));
                                                   nv.setGioiTinh(rs.getString(3));
                                                   nv.setSoDienThoai(rs.getString(4));
                                                   nv.setNgaySinh(rs.getDate(5));
                                                   nv.setDiaChi(rs.getString(6));
                                                   nv.setTenTaiKhoan(rs.getString(7));
                                                   nv.setMatKhau(rs.getString(8));
                                                   nv.setLoaiTaiKhoan(rs.getString(9));
                                                   dsNhanVien.add(nv);
                                                }
            } catch (Exception e) {
            }
	}
	
	public String getTenNhanVien(String maNhanVien) {
		for (NhanVienDTO item: dsNhanVien) {
			if (item.getTenNhanVien().equals(maNhanVien))
				return item.getTenNhanVien();
		}
		return "";
	}
	
	public NhanVienDTO getNhanVien(String maNhanvien) {
		for (NhanVienDTO item : dsNhanVien) {
			if (item.getMaNhanVien().equals(maNhanvien))
				return item;
		}
		return null;
	}
	
	public static NhanVienDAL getInstance() {
		if (instance == null)
			instance = new NhanVienDAL();
		return instance;
	}
	
	public boolean isContain(NhanVienDTO nv) {
		for (NhanVienDTO item: dsNhanVien)
			if (item.getMaNhanVien().equals(nv.getMaNhanVien()))
				return true;
		return false;
	}
	
	
		public int changeProcessing1(NhanVienDTO nv) {
		int result;
		String query = "update NHANVIEN set" 
		+" TENNHANVIEN=N'"  + nv.getTenNhanVien()
		+"', GIOITINH=N'" + nv.getGioiTinh()
		+"', DIENTHOAI='" + nv.getSoDienThoai()
		+"', NGAYSINH='" + nv.getNgaySinh()
                +"', DIACHI=N'" + nv.getDiaChi()
		+"', TENTAIKHOAN=N'" + nv.getTenTaiKhoan()
	        +"', MATKHAU='" + nv.getMatKhau()
		+"', LOAITAIKHOAN='" + nv.getLoaiTaiKhoan()
		+"' where MANHANVIEN='" + nv.getMaNhanVien()+"'";
		//System.out.println("Query = "+ query);
		result = DAL.getInstance().executeQueryUpdate(query);
		
		if (result > 0)
			for (int i = 0; i<dsNhanVien.size(); i++) {
				NhanVienDTO e = dsNhanVien.get(i);
				if (e.getMaNhanVien().equals(nv.getMaNhanVien()))
				{
					dsNhanVien.set(i, nv);
					break;
				}
			}
		return result;
	}

	
	public int changeProcessing(NhanVienDTO nv) {
		String query = "update NHANVIEN set MATKHAU = '"+nv.getMatKhau()+"' where MANHANVIEN='"+nv.getMaNhanVien()+"'";
		int result = DAL.getInstance().executeQueryUpdate(query);
		
			
		for (NhanVienDTO nv1: dsNhanVien) {
			if (nv1.getMaNhanVien().equals(nv.getMaNhanVien())) {
				nv1.setMatKhau(nv.getMatKhau());
				break;
			}
		}
                return result;
	}
        public int  addNhanVien(NhanVienDTO nv) throws ContainException
        {
           if(isContain(nv))
               throw new ContainException("Nhân viên đã tồn tại");
            String query = "insert into NHANVIEN VALUES (N'"+nv.getMaNhanVien()
                    +"',N'"+nv.getTenNhanVien()
                    +"',N'"+nv.getGioiTinh()
                    +"','"+nv.getSoDienThoai()
                    +"','"+nv.getNgaySinh()
                    +"',N'"+nv.getDiaChi()
                    +"',N'"+nv.getTenTaiKhoan()
                    +"','"+nv.getMatKhau()
                    +"','"+nv.getLoaiTaiKhoan()+"')";
            
            int result = DAL.getInstance().executeQueryUpdate(query);
            if(result > 0) {
                
                dsNhanVien.add(nv);
            }
            
                return result;
	}
        
	
	public int deleteProcessing(String manv) {
		int result = DAL.getInstance().executeQueryUpdate("delete from NHANVIEN where MANHANVIEN='"+manv+"'");
		if (result > 0)
			for (int i = 0; i <dsNhanVien.size(); i++) {
				if (dsNhanVien.get(i).getMaNhanVien().equals(manv))
					dsNhanVien.remove(i);
			}
		return result;
	}
	public ArrayList<NhanVienDTO> getResources(){
			
		return dsNhanVien;
	}
	
	public ArrayList<NhanVienDTO> reloadResources(){
		return dsNhanVien;
	}

	public String thongTin(String maNhanVien) {
		for (NhanVienDTO nv:dsNhanVien) {
			if(maNhanVien.equalsIgnoreCase(nv.getMaNhanVien()))
				return nv.getMaNhanVien()+nv.getTenNhanVien();
		}
		return "";
	}
	
	public int getSodocgia() {
		
		return dsNhanVien.size();
	}
        public int countAdminAcount() {
		int count =0;
		for(NhanVienDTO item: dsNhanVien) {
			if (item.getLoaiTaiKhoan().equalsIgnoreCase("2"))
				count++;
		}
		return count;
	}
}
