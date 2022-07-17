/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import Controller.HongHocDAL;
import Controller.NhanVienDAL;
import DTO.HongHocDTO;
import DTO.NhanVienDTO;
import MyException.ContainException;
import MyException.MyNullException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duc_Dat
 */
public class HongHocBLL {
    public static HongHocBLL instance;
    private HongHocBLL(){
        
    }
    public static HongHocBLL getInstance(){
        if(instance==null){
            instance=new HongHocBLL();
        }
        return instance;
    }
    
    public DefaultTableModel getResources(){
        ArrayList<HongHocDTO> dsHH=new ArrayList<>();
        dsHH=HongHocDAL.getInstance().getResources();
        DefaultTableModel dtm=new DefaultTableModel();
        try {
            dtm.addColumn("Mã hỏng hóc");
            dtm.addColumn("Tên khách hàng");
            dtm.addColumn("Số điện thoại");
            dtm.addColumn("Biển số xe");
            dtm.addColumn("Tình trạng xe");
            dtm.addColumn("Ngày báo hỏng");
            for(HongHocDTO hh:dsHH){
                Object[] row={
                    hh.getMaHongHoc(),
                    hh.getTenKhachHang(),
                    hh.getDienThoai(),
                    hh.getBienSoXe(),
                    hh.getTinhTrangXe(),
                    hh.getNgayBaoHong()
                };
                dtm.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtm;
    }
    public DefaultTableModel reloadResources(){
        ArrayList<HongHocDTO> dsHH=new ArrayList<>();
        dsHH=HongHocDAL.getInstance().reloadResources();
        DefaultTableModel dtm=new DefaultTableModel();
        try {
            dtm.addColumn("Mã hỏng hóc");
            dtm.addColumn("Tên khách hàng");
            dtm.addColumn("Số điện thoại");
            dtm.addColumn("Biển số xe");
            dtm.addColumn("Tình trạng xe");
            dtm.addColumn("Ngày báo hỏng");
            for(HongHocDTO hh:dsHH){
                Object[] row={
                    hh.getMaHongHoc(),
                    hh.getTenKhachHang(),
                    hh.getDienThoai(),
                    hh.getBienSoXe(),
                    hh.getTinhTrangXe(),
                    hh.getNgayBaoHong()
                };
                dtm.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtm;
    }
    
    private boolean checkData(HongHocDTO hh) throws MyNullException {
            if (hh.getMaHongHoc().equals(""))
            {
                    throw new MyNullException("Mã hỏng hóc đang bị trống");
            }
            if (hh.getTenKhachHang().equals(""))
            {
                    throw new MyNullException("Tên khách hàng đang bị trống");
            }
            if (hh.getDienThoai().equals(""))
            {
                    throw new MyNullException("Số điện thoại đang bị trống");
            }
            if (hh.getBienSoXe().equals(""))
            {
                    throw new MyNullException("Biển số xe đang bị trống");
            }
            if (hh.getTinhTrangXe().equals(""))
            {
                    throw new MyNullException("Tình trạng xe đang bị trống");
            }
            if(hh.getNgayBaoHong().compareTo(new Date())>0){
                throw new MyNullException("Ngày báo hỏng không hợp lệ");
            }
            return true;
    }
    public String addProcessing(HongHocDTO hh) {
		try{
			checkData(hh);
			String msg;
			int result = HongHocDAL.getInstance().addHongHoc(hh);
			switch(result)
			{
			case -1:
				//msg = "Error";
			case 0:
				msg = "Thêm không thành công! Vui lòng thử lại";
				break;
				default:
					msg = "Đã thêm";
			}
			return msg;
		}
                
		catch(MyNullException ex1) {
			return ex1.getMessage();
		}
		catch(ContainException ex2) {
			return ex2.getMessage();
		}
	}
    
    public String changeProcessing(HongHocDTO hh) {
		String msg;
		
		try {
			checkData(hh);
			int result = HongHocDAL.getInstance().changeProcessing1(hh);
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
    
    	public String deleteProcessing(String maHH) {
		
		if (maHH.equals(""))
			return "Không có tài khoản nào được chọn để xóa";
		int result = HongHocDAL.getInstance().deleteProcessing(maHH);
		if (result > 0)
			return "Xóa thành công";
		else
			return "Xóa không thành công! Vui lòng kiểm tra lại";
	}
}
