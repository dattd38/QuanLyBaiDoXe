/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Controller.HoaDonDAL;
import Controller.NhanVienDAL;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY LAPTOP
 */
public class QLLuong {
    public static QLLuong instance;
	private  QLLuong() {
		
	}
	public static QLLuong getInstance() {
		if (instance == null)
			instance = new QLLuong();
		return instance;
	}
        
       public DefaultTableModel getResources() {
		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
		dsNhanVien = NhanVienDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
                    
                        dtm.addColumn("Tên nhân viên");
                        dtm.addColumn("Chức Vụ");
                        dtm.addColumn("Số Ngày làm");
                        dtm.addColumn("Lương");
                      
			
			String i = "";
                        
			for(NhanVienDTO nv : dsNhanVien) {
                             if(nv.getLoaiTaiKhoan().equals("1"))
                            {
                                i="6000000 VND";
                            }
                            else
                            {
                               i="10000000 VND";
                            }
				Object[] row = {nv.getTenNhanVien(),
                                                 nv.getLoaiTaiKhoan(),
                                                 30,
                                                 i
                                                 
                                    };
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
       
        public DefaultTableModel reloadResources() {
		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
		dsNhanVien = NhanVienDAL.getInstance().reloadResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
                    
                        dtm.addColumn("Tên nhân viên");
                        dtm.addColumn("Chức Vụ");
                        dtm.addColumn("Số Ngày làm");
                        dtm.addColumn("Lương");
                      
			
			String i = "";
                        
			for(NhanVienDTO nv : dsNhanVien) {
                             if(nv.getLoaiTaiKhoan().equals("1"))
                            {
                                i="6000000 VND";
                            }
                            else
                            {
                               i="10000000 VND";
                            }
				Object[] row = {nv.getTenNhanVien(),
                                                 nv.getLoaiTaiKhoan(),
                                                 30,
                                                 i
                                                 
                                    };
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
}