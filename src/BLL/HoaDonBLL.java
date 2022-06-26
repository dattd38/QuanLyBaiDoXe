package BLL;

import Controller.HoaDonDAL;
import Controller.RaVaoBenDAL;
import Controller.VeDAL;
import DTO.HoaDonDTO;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DTO.RaVaoBenDTO;
import DTO.VeDTO;
import MyException.ContainException;
import MyException.MyNullException;
import javax.swing.table.TableModel;

public class HoaDonBLL {
    public static HoaDonBLL instance;
    private  HoaDonBLL() {

    }
    public static HoaDonBLL getInstance() {
        if (instance == null){
            instance = new HoaDonBLL();
        }
        return instance;
    }

    public DefaultTableModel getResources() {
        ArrayList<HoaDonDTO> dsHoaDon = new ArrayList<HoaDonDTO>();
        dsHoaDon=HoaDonDAL.getInstance().getResources();
        DefaultTableModel dtm = new DefaultTableModel();
        try {
            dtm.addColumn("Mã Hóa Đơn");
            dtm.addColumn("Mã Vé");
            dtm.addColumn("Tên Vị Trí ");
            dtm.addColumn("Tên Khu Vực ");  
            dtm.addColumn("Tên Nhân Viên ");
            dtm.addColumn("Số Ngày Gửi");
            dtm.addColumn("Biển Số");
            dtm.addColumn("Thành Tiền");
            dtm.addColumn("Ngày Lập");
            int i = 0;
            for (HoaDonDTO hoaDonDTO : dsHoaDon) {
                Object[] row = {
                hoaDonDTO.getMaHoaDon(),
                hoaDonDTO.getMaVe(),
                hoaDonDTO.getTenViTri(),
                hoaDonDTO.getTenKhuVuc(),
                hoaDonDTO.getTenNhanVien(),
                hoaDonDTO.getSoNgayGui(),
                hoaDonDTO.getBienSoXe(), 
                hoaDonDTO.getThanhTien(),
                hoaDonDTO.getNgayLap()};
                dtm.addRow(row);
            }

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dtm;
    }
    private boolean checkData(HoaDonDTO hd) throws MyNullException {
        if (hd.getMaHoaDon().equals(""))
        {
            throw new MyNullException("Mã Hóa Đơn đang bị trống");
        }

        if (hd.getSoNgayGui().equals(""))
        {
            throw new MyNullException("Chưa có số ngày gửi");
        }
        if (hd.getThanhTien().equals(""))
        {
            throw new MyNullException("Chưa có số tiền");
        }

        return true;
    }

    public String addProcessing(HoaDonDTO hd) {
        try{    
            checkData(hd);
            ArrayList<HoaDonDTO> dsHoaDon = HoaDonDAL.getInstance().getResources();
            for(HoaDonDTO item: dsHoaDon) {
                if(item.getMaHoaDon().equals(hd.getMaHoaDon())){
                    return "Hóa đơn đã tồn tại";
                }	
            }
            String msg;
            int result = HoaDonDAL.getInstance().addHoaDon(hd);
            switch(result)
            {
            case -1:
                msg = "Error";
            case 0:
                msg = "Thêm không thành công! Vui lòng thử lại";
                    break;
            default:
                msg = "Lập hóa đơn Thành Công ";
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

    public TableModel reloadResources() {
        ArrayList<HoaDonDTO> dsHoaDon = new ArrayList<HoaDonDTO>();
        dsHoaDon=HoaDonDAL.getInstance().reloadResources();
        DefaultTableModel dtm = new DefaultTableModel();
        try {
            dtm.addColumn("Mã Hóa Đơn");
            dtm.addColumn("Mã Vé");
            dtm.addColumn("Tên Vị Trí ");
            dtm.addColumn("Tên Khu Vực ");  
            dtm.addColumn("Tên Nhân Viên ");
            dtm.addColumn("Số Ngày Gửi");
            dtm.addColumn("Biển Số");
            dtm.addColumn("Thành Tiền");
            dtm.addColumn("Ngày Lập");
            int i = 0;
            for (HoaDonDTO hoaDonDTO : dsHoaDon) {
                Object[] row = {
                hoaDonDTO.getMaHoaDon(),
                hoaDonDTO.getMaVe(),
                hoaDonDTO.getTenViTri(),
                hoaDonDTO.getTenKhuVuc(),
                hoaDonDTO.getTenNhanVien(),
                hoaDonDTO.getSoNgayGui(),
                hoaDonDTO.getBienSoXe(), 
                hoaDonDTO.getThanhTien(),
                hoaDonDTO.getNgayLap()};
                dtm.addRow(row);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dtm;
    }
}
