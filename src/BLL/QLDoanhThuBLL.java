/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import Controller.HoaDonDAL;
import Controller.RaVaoBenDAL;
import DTO.HoaDonDTO;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

import DTO.VeDTO;
import DTO.RaVaoBenDTO;

public class QLDoanhThuBLL {
    	private static QLDoanhThuBLL instance;
	DefaultTableModel dtm;
	private ArrayList<Object[]> dataRow;
	
	private QLDoanhThuBLL(){
		dataRow = new ArrayList<Object[]>();
	}
    
	public static QLDoanhThuBLL getInstance() {
		if (instance == null)
			instance = new QLDoanhThuBLL();
		return instance;
	}
        @SuppressWarnings("deprecation")
       public DefaultTableModel DoanhThu( ) {
			dtm = new DefaultTableModel();			
			dtm.addColumn("Ngày ");
                        dtm.addColumn("Số Xe Vào ");
                        dtm.addColumn("Số Xe Ra ");
                        dtm.addColumn("Tổng Tiền ");
		ArrayList<RaVaoBenDTO> dsRaVaoBen = RaVaoBenDAL.getInstance().getResources();
		ArrayList<HoaDonDTO> dsHoaDon = HoaDonDAL.getInstance().getResources();
		ArrayList<String> dsXe = new ArrayList<String>();
               
		
		return dtm;
	}
}
