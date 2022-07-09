/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTO.DoanhThuDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duc_Dat
 */
public class DoanhThuDAL {
    private static DoanhThuDAL instance;
    private ArrayList<DoanhThuDTO> dsDoanhThu;
    
    public DoanhThuDAL(){
        dsDoanhThu=new ArrayList<DoanhThuDTO>();
    }
    
    public static DoanhThuDAL getInstance(){
        if(instance==null){
            instance=new DoanhThuDAL();
        }
        return instance;
    }
    
    private void loadResources(){
        String query= new String("SELECT * FROM dbo.DOANHTHU");
        try {
            ResultSet resultSet=DAL.getInstance().executeQueryToGetData(query);
            while (resultSet.next()) {                
                DoanhThuDTO dt=new DoanhThuDTO();
                dt.setNgay(resultSet.getDate(1));
                dt.setSoXeVao(resultSet.getInt(2));
                dt.setSoXeRa(resultSet.getInt(3));
                dt.setTongTien(resultSet.getDouble(4));
                dsDoanhThu.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<DoanhThuDTO> getResources(){
        return dsDoanhThu;
    }
    
    public ArrayList<DoanhThuDTO> reloadResources(){
        dsDoanhThu=new ArrayList<>();
        String query= new String("SELECT * FROM dbo.DOANHTHU");
        try {
            ResultSet resultSet=DAL.getInstance().executeQueryToGetData(query);
            while (resultSet.next()) {                
                DoanhThuDTO dt=new DoanhThuDTO();
                dt.setNgay(resultSet.getDate(1));
                dt.setSoXeVao(resultSet.getInt(2));
                dt.setSoXeRa(resultSet.getInt(3));
                dt.setTongTien(resultSet.getDouble(4));
                dsDoanhThu.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDoanhThu;
    }
}
