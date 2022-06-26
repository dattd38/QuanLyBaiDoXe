package BLL;

import Controller.NhanVienDAL;
import Controller.VeDAL;
import DTO.NhanVienDTO;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DTO.VeDTO;

public class QLVeBLL {
	public static QLVeBLL instance;
	private  QLVeBLL() {
		
	}
	public static QLVeBLL getInstance() {
		if (instance == null)
			instance = new QLVeBLL();
		return instance;
	}

	public DefaultTableModel getResources() {
		
		ArrayList<VeDTO> dsVe = new ArrayList<VeDTO>();
                dsVe=VeDAL.getInstance().getResources();
                
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			
			dtm.addColumn("Mã Vé");
			for (VeDTO veDTO : dsVe) {
				if(veDTO.getTinhTrangVe().equals("Đang sử dụng")) {
					continue;
				}
				Object row[] = {veDTO.getMaVe()};
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
		
		ArrayList<VeDTO> dsVe = new ArrayList<VeDTO>();
                dsVe=VeDAL.getInstance().reloadResources();
                
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			
			dtm.addColumn("Mã Vé");
			for (VeDTO veDTO : dsVe) {
				if(veDTO.getTinhTrangVe().equals("ĐANG SỬ DỤNG")) {
					continue;
				}
				Object row[] = {veDTO.getMaVe()};
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
