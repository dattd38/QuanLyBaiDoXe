package BLL;

import Controller.NhanVienDAL;
import Controller.VeDAL;
import DTO.NhanVienDTO;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DTO.VeDTO;
import MyException.ContainException;
import MyException.MyNullException;
import javax.swing.table.TableModel;

public class QLVeBLL {
	public static QLVeBLL instance;
	private  QLVeBLL() {
		
	}
	public static QLVeBLL getInstance() {
		if (instance == null)
			instance = new QLVeBLL();
		return instance;
	}
        
        private boolean checkData(VeDTO ve) throws MyNullException {
		if (ve.getMaVe().equals(""))
		{
			throw new MyNullException("Mã vé đang bị trống");
		}
		if (ve.getBienSoXe().equals(""))
		{
			throw new MyNullException("Biển số xe đang bị trống");
		}
		return true;
	}
        
        public String changeProcessing(VeDTO ve) {
		String msg;
		ArrayList<VeDTO> dsVe = VeDAL.getInstance().getResources();
		boolean check = false;
		for (VeDTO item: dsVe) {
			if (ve.getMaVe().equals(item.getMaVe())) {
                            return "Mã vé đã tồn tại";

			}
		}
		try {
			checkData(ve);
			int result = VeDAL.getInstance().changeProcessing1(ve);
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


	public DefaultTableModel getResources() {
		
		ArrayList<VeDTO> dsVe = new ArrayList<VeDTO>();
                dsVe=VeDAL.getInstance().getResources();
                
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			
			dtm.addColumn("Mã Vé");
                        dtm.addColumn("Biển Số Xe");
                        dtm.addColumn("Ngày Bắt Đầu");
                        dtm.addColumn("Ngày Kết Thúc");
                        dtm.addColumn("Tình Trạng Vé");
			for (VeDTO veDTO : dsVe) {
				if(veDTO.getTinhTrangVe().equals("Đang sử dụng")) {
					continue;
				}
				Object row[] = {veDTO.getMaVe(),
                                    veDTO.getBienSoXe(),
                                    veDTO.getNgayBatDau(),
                                    veDTO.getNgayKetThuc(),
                                    veDTO.getTinhTrangVe()
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
        public TableModel reloadResources() {
		
		ArrayList<VeDTO> dsVe = new ArrayList<VeDTO>();
                dsVe=VeDAL.getInstance().reloadResources();
                
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			
			dtm.addColumn("Mã Vé");
                        dtm.addColumn("Biển Số Xe");
                        dtm.addColumn("Ngày Bắt Đầu");
                        dtm.addColumn("Ngày Kết Thúc");
                        dtm.addColumn("Tình Trạng Vé");
			for (VeDTO veDTO : dsVe) {
				if(veDTO.getTinhTrangVe().equals("ĐANG SỬ DỤNG")) {
					continue;
				}
				Object row[] = {veDTO.getMaVe(),
                                    veDTO.getBienSoXe(),
                                    veDTO.getNgayBatDau(),
                                    veDTO.getNgayKetThuc(),
                                    veDTO.getTinhTrangVe()
                                };
				dtm.addRow(row);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return dtm;
	}
}
