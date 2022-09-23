package BLL;

import Controller.VeDAL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DTO.VeDTO;
import MyException.MyNullException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
                if(ve.getNgayBatDau().equals("")){
                    throw new MyNullException("Ngày đăng ký trống ");
                }
		return true;
	}
        
        public String changeProcessing(VeDTO ve) {
		String msg;
		ArrayList<VeDTO> dsVe = VeDAL.getInstance().getResources();
                

		try {
			checkData(ve);
                        for(VeDTO item:dsVe){
                            if(item.getMaVe().equals(ve.getMaVe())){
                                continue;
                            }
                            if(item.getNgayBatDau()!=null){
                                if(item.getBienSoXe().equals(ve.getBienSoXe())){
                                    return "Biển số xe đã được đăng ký vé tháng";
                                }
                            }
                        }
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

                public String changeProcessingDK(VeDTO ve) {
		String msg;
		ArrayList<VeDTO> dsVe = VeDAL.getInstance().getResources();


			
		try {
                        checkData(ve);
                        for(VeDTO item:dsVe){
                            if(item.getNgayBatDau()!=null){
                                if(item.getBienSoXe().equals(ve.getBienSoXe())){
                                    return "Biển số xe đã được đăng ký vé tháng";
                                }
                            }
                        }
			int result = VeDAL.getInstance().changeProcessing1DK(ve);
			switch(result)
			{
			case -1:
			case 0:
				msg = "Đăng ký không thành công! Vui lòng thử lại";
				break;
				default:
					msg = "Đăng ký thành công";
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
        
    public void checkVe(){
        SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
        Calendar   cal = Calendar.getInstance();
        java.util.Date date = cal.getTime();
        String ngayvao = fm.format(date);
        ArrayList<VeDTO> dsVe= new ArrayList<>();
        dsVe=VeDAL.getInstance().reloadResources();
        
        for(VeDTO ve:dsVe){
            if(ve.getNgayKetThuc()==null){
//                continue;
            }
            else if(ve.getNgayKetThuc().compareTo(date)<0){
                VeDAL.getInstance().removeVeHetHan(ve.getMaVe());
            }
        }
    }
}
