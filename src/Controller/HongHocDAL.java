/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTO.HongHocDTO;
import DTO.NhanVienDTO;
import MyException.ContainException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duc_Dat
 */
public class HongHocDAL {
    private static HongHocDAL instance;
    private ArrayList<HongHocDTO> dsHongHoc;
    
    public HongHocDAL(){
        dsHongHoc=new ArrayList<>();
    }
    
    public static HongHocDAL getInstance(){
        if(instance==null){
            instance=new HongHocDAL();
        }
        return instance;
    }
    
    public boolean isContain(HongHocDTO hh) {
		for (HongHocDTO item: dsHongHoc)
			if (item.getMaHongHoc().equals(hh.getMaHongHoc()))
				return true;
		return false;
	}
    
    private void loadResources(){
        String query= new String("SELECT * FROM dbo.HONGHOC");
        try {
            ResultSet resultSet=DAL.getInstance().executeQueryToGetData(query);
            while(resultSet.next()){
                HongHocDTO hh=new HongHocDTO();
                hh.setMaHongHoc(resultSet.getString(1));
                hh.setTenKhachHang(resultSet.getString(2));
                hh.setDienThoai(resultSet.getString(3));
                hh.setBienSoXe(resultSet.getString(4));
                hh.setTinhTrangXe(resultSet.getString(5));
                hh.setNgayBaoHong(resultSet.getDate(6));
                dsHongHoc.add(hh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<HongHocDTO> getResources(){
        return dsHongHoc;
    }
    
    public ArrayList<HongHocDTO> reloadResources(){
        dsHongHoc=new ArrayList<>();
        String query= new String("SELECT * FROM dbo.HONGHOC");
        try {
            ResultSet resultSet=DAL.getInstance().executeQueryToGetData(query);
            while(resultSet.next()){
                HongHocDTO hh=new HongHocDTO();
                hh.setMaHongHoc(resultSet.getString(1));
                hh.setTenKhachHang(resultSet.getString(2));
                hh.setDienThoai(resultSet.getString(3));
                hh.setBienSoXe(resultSet.getString(4));
                hh.setTinhTrangXe(resultSet.getString(5));
                hh.setNgayBaoHong(resultSet.getDate(6));
                dsHongHoc.add(hh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsHongHoc;
    }
    
    public int  addHongHoc(HongHocDTO hh) throws ContainException
        {
           if(isContain(hh))
               throw new ContainException("Mã hỏng hóc đã tồn tại");
            String query = "insert into dbo.HONGHOC VALUES ('"+hh.getMaHongHoc()
                    +"',N'"+hh.getTenKhachHang()
                    +"','"+hh.getDienThoai()
                    +"','"+hh.getBienSoXe()
                    +"',N'"+hh.getTinhTrangXe()
                    +"','"+hh.getNgayBaoHong()+"')";
            
            int result = DAL.getInstance().executeQueryUpdate(query);
            if(result > 0) {
                
                dsHongHoc.add(hh);
            }
            
                return result;
	}
    
    public int changeProcessing1(HongHocDTO hh) {
		int result;
		String query = "update HONGHOC set" 
		+" TENKHACHHANG=N'"  + hh.getTenKhachHang()
		+"', DIENTHOAI='" + hh.getDienThoai()
		+"', BIENSOXE='" + hh.getBienSoXe()
                +"', TINHTRANGXE=N'" + hh.getTinhTrangXe()
		+"', NGAYBAOHONG='" + hh.getNgayBaoHong()
		+"' where MAHONGHOC='" + hh.getMaHongHoc()+"'";
		//System.out.println("Query = "+ query);
		result = DAL.getInstance().executeQueryUpdate(query);
		
		if (result > 0)
			for (int i = 0; i<dsHongHoc.size(); i++) {
				HongHocDTO e = dsHongHoc.get(i);
				if (e.getMaHongHoc().equals(hh.getMaHongHoc()))
				{
					dsHongHoc.set(i, hh);
					break;
				}
			}
		return result;
	}
    
    public int deleteProcessing(String mahh) {
		int result = DAL.getInstance().executeQueryUpdate("delete from HONGHOC where MAHONGHOC='"+mahh+"'");
		if (result > 0)
			for (int i = 0; i <dsHongHoc.size(); i++) {
				if (dsHongHoc.get(i).getMaHongHoc().equals(mahh))
					dsHongHoc.remove(i);
			}
		return result;
	}
}
