package BLL;

import Controller.RaVaoBenDAL;
import Controller.VeDAL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DTO.RaVaoBenDTO;
import DTO.VeDTO;
import MyException.ContainException;
import MyException.MyNullException;
import javax.swing.table.TableModel;

public class QLRaVaoBenBLL {
    public static QLRaVaoBenBLL instance;
    private  QLRaVaoBenBLL() {

    }
    public static QLRaVaoBenBLL getInstance() {
        if (instance == null){
            instance = new QLRaVaoBenBLL();
        }
        return instance;
    }

    private boolean checkData(RaVaoBenDTO rvb) throws MyNullException {
        if (rvb.getMaVe().equals(""))
        {
            throw new MyNullException("Mã vé đang bị trống");
        }

        if (rvb.getTenViTri().equals("Chọn Vị Trí"))
        {
            throw new MyNullException("Chưa chọn vị trí");
        }
        if (rvb.getBienSoXe().equals(""))
        {
            throw new MyNullException("Biển số xe đang bị trống");
        }
        return true;
    }
    
    
    public String addProcessing(RaVaoBenDTO rvb) {
        try{    
            checkData(rvb);
            ArrayList<VeDTO> dsVe = VeDAL.getInstance().reloadResources();
            for(VeDTO item: dsVe) {
                if(item.getMaVe().equals(rvb.getMaVe())){
                    if(item.getTinhTrangVe().equals("ĐANG SỬ DỤNG")){
                        return "Vé đã được sử dụng";
                    }
                }	
            }       
            
            ArrayList<RaVaoBenDTO> bienSoXe = RaVaoBenDAL.getInstance().reloadResources();
            for(RaVaoBenDTO bsx: bienSoXe) {
                if(bsx.getTrangThaiRvb().equals("ĐÃ LẤY"))
                    continue;
                    if(bsx.getBienSoXe().equals(rvb.getBienSoXe())){
                        return "Đã có xe này trong bến";
                    }	
            }
            String msg;
            int result = RaVaoBenDAL.getInstance().addRaVaoBen(rvb);
            switch(result)
            {
                case -1:
                    msg = "Error";
                case 0:
                    msg = "Thêm không thành công! Vui lòng thử lại";
                    break;
                default:
                    msg = "Xe Vào Thành Công";
            }
                return msg;
        }
        catch(MyNullException ex1) {
            return ex1.getMessage();
        }
    }

    public DefaultTableModel getResources() {
            ArrayList<RaVaoBenDTO> dsRaVaoBen = new ArrayList<RaVaoBenDTO>();
            dsRaVaoBen=RaVaoBenDAL.getInstance().getResources();
            DefaultTableModel dtm = new DefaultTableModel();
            try {
                    dtm.addColumn("Mã Vé");
                    dtm.addColumn("Tên Vị Trí");
                    dtm.addColumn("Tên Khu Vực");
                    dtm.addColumn("Biển Số");
                    dtm.addColumn("Thời Gian Vào");
//                    int i = 0;

                    for (RaVaoBenDTO raVaoBenDTO : dsRaVaoBen) {
                        if(raVaoBenDTO.getTrangThaiRvb().equals("ĐÃ LẤY")) {
                                continue;
                            }
                            Object[] row = { 
                                raVaoBenDTO.getMaVe(), 
                                raVaoBenDTO.getTenViTri(), 
                                raVaoBenDTO.getTenKhuVuc(), 
                                raVaoBenDTO.getBienSoXe(), 
                                raVaoBenDTO.getNgayVao()};
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
            ArrayList<RaVaoBenDTO> dsRaVaoBen = new ArrayList<RaVaoBenDTO>();
            dsRaVaoBen=RaVaoBenDAL.getInstance().reloadResources();
            
            DefaultTableModel dtm = new DefaultTableModel();
            try {
                    dtm.addColumn("Mã Vé");
                    dtm.addColumn("Tên Vị Trí");
                    dtm.addColumn("Tên Khu Vực");
                    dtm.addColumn("Biển Số");
                    dtm.addColumn("Thời Gian Vào");
//                    (int) /*i*/ = 0;
                    for (RaVaoBenDTO raVaoBenDTO : dsRaVaoBen) {
                        if(raVaoBenDTO.getTrangThaiRvb().equals("ĐÃ LẤY")) {
                                    continue;
                            }
                            Object[] row = { 
                                raVaoBenDTO.getMaVe(), 
                                raVaoBenDTO.getTenViTri(), 
                                raVaoBenDTO.getTenKhuVuc(), 
                                raVaoBenDTO.getBienSoXe(), 
                                raVaoBenDTO.getNgayVao()};
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
    public int SoXe(){
        ArrayList<RaVaoBenDTO> dsRaVaoBen = new ArrayList<RaVaoBenDTO>();
        dsRaVaoBen=RaVaoBenDAL.getInstance().reloadResources();
        DefaultTableModel dtm = new DefaultTableModel();
        int soXe=0;
        for (RaVaoBenDTO raVaoBenDTO : dsRaVaoBen) {
            if(raVaoBenDTO.getTrangThaiRvb().equals("ĐANG GỬI")){
                             soXe++;               
            }
        }
        return soXe;
    }
    public TableModel timKiem(String key) {
            ArrayList<RaVaoBenDTO> dsRaVaoBen = new ArrayList<RaVaoBenDTO>();
            dsRaVaoBen=RaVaoBenDAL.getInstance().reloadResources();
            DefaultTableModel dtm = new DefaultTableModel();
                    dtm.addColumn("Mã Vé");
                    dtm.addColumn("Tên Vị Trí");
                    dtm.addColumn("Tên Khu Vực");
                    dtm.addColumn("Biển Số");
                    dtm.addColumn("Thời Gian Vào");
                    int i = 0;

                    for(RaVaoBenDTO rvb: dsRaVaoBen) {
                        if (rvb.getTrangThaiRvb().equals("ĐÃ LẤY"))//đã lấy xe
                            continue;
                            String thongTin=RaVaoBenDAL.getInstance().getThongTin(rvb.getMaVe())+RaVaoBenDAL.getInstance().getThongTin(rvb.getBienSoXe());
                            thongTin=thongTin.toLowerCase();
                            key=key.toLowerCase();
                            if(thongTin.contains(key)) {
                                    Object[] row= { rvb.getMaVe(),
                                                    rvb.getTenViTri(),
                                                    rvb.getTenKhuVuc(),
                                                    rvb.getBienSoXe(),
                                                    rvb.getNgayVao(),
                                                    rvb.getNgayRa(),
                                                    rvb.getTrangThaiRvb()
                                                    };
                                    dtm.addRow(row);
                                    }
                            }
                    return dtm;
                    }
}
