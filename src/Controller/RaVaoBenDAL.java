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

public class RaVaoBenDAL {
	
	private static RaVaoBenDAL instance;
	private ArrayList<RaVaoBenDTO> dsRaVaoBen;
	public RaVaoBenDAL() {
		dsRaVaoBen=new ArrayList<RaVaoBenDTO>();
		loadResources();
	}
	
	public static RaVaoBenDAL getInstance() {
		if(instance==null)
			instance = new RaVaoBenDAL();
		return instance;
	}
	
	
	private void  loadResources() {
                String query = new String("SELECT * FROM dbo.RAVAOBEN");
		try {
			
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);	
			while(resultSet.next()) {			
                                                                RaVaoBenDTO rvb =new RaVaoBenDTO();
                                                                rvb.setMaVe(resultSet.getString(1));
                                                                rvb.setTenViTri(resultSet.getString(2));
                                                                rvb.setTenKhuVuc(resultSet.getString(3));
                                                                rvb.setBienSoXe(resultSet.getString(4));
                                                                rvb.setNgayVao(resultSet.getDate(5));
                                                                rvb.setNgayRa(resultSet.getDate(6));
                                                                rvb.setTrangThaiRvb(resultSet.getString(7));
                                                                dsRaVaoBen.add(rvb);
                                                              
			}      		
                                            }
                                                     
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	

	
	
	
	public ArrayList<RaVaoBenDTO> getResources(){
		return  dsRaVaoBen;
	}
        public ArrayList<RaVaoBenDTO> reloadResources(){
             dsRaVaoBen=new ArrayList<>();
             String query = new String("SELECT * FROM dbo.RAVAOBEN");
		try {
			
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);	
			while(resultSet.next()) {			
                                                                RaVaoBenDTO rvb =new RaVaoBenDTO();
                                                                rvb.setMaVe(resultSet.getString(1));
                                                                rvb.setTenViTri(resultSet.getString(2));
                                                                rvb.setTenKhuVuc(resultSet.getString(3));
                                                                rvb.setBienSoXe(resultSet.getString(4));
                                                                rvb.setNgayVao(resultSet.getDate(5));
                                                                rvb.setNgayRa(resultSet.getDate(6));
                                                                rvb.setTrangThaiRvb(resultSet.getString(7));
                                                                dsRaVaoBen.add(rvb);
                                                               
			}      		                        
                                            }
                                                     
		catch(Exception ex){
			ex.printStackTrace();
		}
		return  dsRaVaoBen;
	}
       public int  addRaVaoBen(RaVaoBenDTO rvb) 
        {
                
            String query = "insert into RAVAOBEN VALUES ('"+rvb.getMaVe()+"','"+rvb.getTenViTri()+"','"+rvb.getTenKhuVuc()+"','"+rvb.getBienSoXe()
                    +"','"+rvb.getNgayVao()+"',NULL,N'ĐANG GỬI')"
                    + "update VITRI set TRANGTHAI =N'ĐẦY' WHERE TENVITRI= '"+rvb.getTenViTri()+"'"
                    + "update VE set TINHTRANGVE=N'ĐANG SỬ DỤNG' WHERE MAVE='"+rvb.getMaVe()+"'";
            int result = DAL.getInstance().executeQueryUpdate(query);
            if(result > 0) {
                rvb.setTrangThaiRvb("ĐANG GỬI");
                dsRaVaoBen.add(rvb);
            }
                return result;
	}
       

	public String getThongTin(String maVe) {
		for (RaVaoBenDTO rvb: dsRaVaoBen) {
			if (rvb.getMaVe().equals(maVe))
				return rvb.getMaVe()+rvb.getBienSoXe();
		}
		return "";
	}
	}
	



 