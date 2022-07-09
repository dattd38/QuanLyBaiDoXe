package BLL;

import Controller.KhuVucDAL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import DTO.KhuVucDTO;

public class QLKhuVucBLL {
	
    public static QLKhuVucBLL instance;
    private  QLKhuVucBLL() {

    }
    public static QLKhuVucBLL getInstance() {
            if (instance == null)
                    instance = new QLKhuVucBLL();
            return instance;
    }

    public DefaultTableModel getResources() {
            ArrayList<KhuVucDTO> dsKhuVuc = new ArrayList<KhuVucDTO>();
            dsKhuVuc=KhuVucDAL.getInstance().getResources();
            DefaultTableModel dtm = new DefaultTableModel();

            try {

                    dtm.addColumn("Tên Khu Vực");
                    dtm.addColumn("Tình Trạng");
                    for(KhuVucDTO kv : dsKhuVuc) {

                            if(kv.getTrangThaiKhuVuc().equals("HẾT CHỖ")) {
                                    continue;
                            }
                            Object[] row = {  kv.getTenKhuVuc(), kv.getTrangThaiKhuVuc()};
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
            ArrayList<KhuVucDTO> dsKhuVuc = new ArrayList<KhuVucDTO>();
            dsKhuVuc=KhuVucDAL.getInstance().getResources();
            DefaultTableModel dtm = new DefaultTableModel();

            try {


                    dtm.addColumn("Tên Khu Vực");
                    dtm.addColumn("Tình Trạng");
                    for(KhuVucDTO kv : dsKhuVuc) {
                            if(kv.getTrangThaiKhuVuc().equals("HẾT CHỖ")) {
                                    continue;
                            }
                            Object[] row = { kv.getTenKhuVuc(), kv.getTrangThaiKhuVuc()};
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
