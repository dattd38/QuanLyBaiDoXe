/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

// Lam Theo Mo hinh Singleton
public class HoaDonDAL {
    //khai bao doi tuong HOADONDAL
    private static HoaDonDAL instance;
    //KHAI BAO DS HOADON
    private ArrayList<HoaDonDTO> dsHoaDon;
    public HoaDonDAL() {
        //CAP NHAT LAI DS HOADON
        dsHoaDon=new ArrayList<HoaDonDTO>();
        loadResources();
    }

    public static HoaDonDAL getInstance() {
        if(instance==null){
            instance = new HoaDonDAL();               
        }
        return instance;
    }

    private void  loadResources() {
        String query = new String("SELECT * FROM dbo.HOADON");
        try {
            ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);	
            while(resultSet.next()) {	
                HoaDonDTO hd =new HoaDonDTO();
                hd.setMaHoaDon(resultSet.getString(1));
                hd.setMaVe(resultSet.getString(2));
                hd.setTenViTri(resultSet.getString(3));
                hd.setTenKhuVuc(resultSet.getString(4));
                hd.setTenNhanVien(resultSet.getString(5));
                hd.setSoNgayGui(resultSet.getString(6));
                hd.setBienSoXe(resultSet.getString(7));
                hd.setThanhTien(resultSet.getString(8));
                hd.setNgayLap(resultSet.getDate(9));
                dsHoaDon.add(hd);
            }      		
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private boolean isContain(HoaDonDTO kv) {
        for (HoaDonDTO item: dsHoaDon){
            if (item.getMaHoaDon().equals(kv.getMaHoaDon())){
                return true;     
            }
        }
        return false;
    }


    public int  addHoaDon(HoaDonDTO hd) throws ContainException{
        if(isContain(hd)){
            throw new ContainException("Hóa đơn đã có ");
        }
        
        String strTT=hd.getThanhTien().replace("VNĐ", "").trim();
        int ThanhTien=Integer.parseInt(strTT);
        
        String query = "insert into HOADON VALUES ('"
        +hd.getMaHoaDon()
        +"','"+hd.getMaVe()
        +"','"+hd.getTenViTri()
        +"','"+hd.getTenKhuVuc()
        +"',N'"+hd.getTenNhanVien()
        +"','"+hd.getSoNgayGui()
        +"','"+hd.getBienSoXe()
        +"','"+String.valueOf(ThanhTien)
        +"','"+hd.getNgayLap()+ "')"
        + "update RAVAOBEN set THOIGIANRA='"+hd.getNgayLap()+"',TRANGTHAI=N'ĐÃ LẤY' WHERE BIENSOXE ='"+hd.getBienSoXe()+"'"
        + "update VITRI set TRANGTHAI =N'TRỐNG' WHERE TENVITRI= '"+hd.getTenViTri()+"'"
        + "update VE set TINHTRANGVE=N'CHƯA SỬ DỤNG' WHERE MAVE='"+hd.getMaVe()+"'"
        +"UPDATE dbo.DOANHTHU SET SOXERA=SOXERA+1,TONGTIEN=TONGTIEN+'"+String.valueOf(ThanhTien)+"' WHERE NGAY='"+hd.getNgayLap()+"'";
        
        int result = DAL.getInstance().executeQueryUpdate(query);
        if(result > 0) {
            dsHoaDon.add(hd);
        }
        return result;
    }
    public ArrayList<HoaDonDTO> reloadResources(){
        dsHoaDon=new ArrayList<>();
        String query = new String("SELECT * FROM dbo.HOADON");
        try {
            ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);	
            while(resultSet.next()) {			
                HoaDonDTO hd =new HoaDonDTO();
                hd.setMaHoaDon(resultSet.getString(1));
                hd.setMaVe(resultSet.getString(2));
                hd.setTenViTri(resultSet.getString(3));
                hd.setTenKhuVuc(resultSet.getString(4));
                hd.setTenNhanVien(resultSet.getString(5));
                hd.setSoNgayGui(resultSet.getString(6));
                hd.setBienSoXe(resultSet.getString(7));
                hd.setThanhTien(resultSet.getString(8));
                hd.setNgayLap(resultSet.getDate(9));
                dsHoaDon.add(hd);
            }      		
        }

        catch(Exception ex){
                ex.printStackTrace();
        }
        return  dsHoaDon;	
    }

    public ArrayList<HoaDonDTO> getResources(){
        return  dsHoaDon;
    }
}
