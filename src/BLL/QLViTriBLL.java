package BLL;

import Controller.ViTriDAL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DTO.ViTriDTO;
import javax.swing.table.TableModel;

public class QLViTriBLL {
	public static QLViTriBLL instance;
	private  QLViTriBLL() {
		
	}
	public static QLViTriBLL getInstance() {
		if (instance == null)
			instance = new QLViTriBLL();
		return instance;
	}

	public DefaultTableModel getResources(String tenKhuVuc) {
		ArrayList<ViTriDTO> dsViTri = new ArrayList<ViTriDTO>();
		dsViTri=ViTriDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			
			dtm.addColumn("Tên Vị Trí");
                        dtm.addColumn("Tình Trạng");
			dtm.addColumn("Khu Vực");
			
			int i = 1;
			for (ViTriDTO vt : dsViTri) {
				if(vt.getTenKhuVuc().equals(tenKhuVuc) == false || vt.getTrangThaiViTri().equals("ĐẦY")) {
					continue;
				}
				Object[] row = { vt.getTenViTri(), vt.getTrangThaiViTri(),vt.getTenKhuVuc()};
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
               public TableModel reloadResources(String tenKhuVuc) {
		ArrayList<ViTriDTO> dsViTri = new ArrayList<ViTriDTO>();
		dsViTri=ViTriDAL.getInstance().reloadResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			
			dtm.addColumn("Tên Vị Trí");
                        dtm.addColumn("Tình Trạng");
			dtm.addColumn("Khu Vực");
			
			int i = 1;
			for (ViTriDTO vt : dsViTri) {
				if(vt.getTenKhuVuc().equals(tenKhuVuc) == false || vt.getTrangThaiViTri().equals("ĐẦY")) {
					continue;
				}
				Object[] row = {  vt.getTenViTri(), vt.getTrangThaiViTri(),vt.getTenKhuVuc()};
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
    
    public int isCount(){ 
        ArrayList<ViTriDTO> dsViTri = new ArrayList<ViTriDTO>();
        dsViTri = ViTriDAL.getInstance().reloadResources();
        DefaultTableModel dtm = new DefaultTableModel();
        int soChoTrong=0;
        for (ViTriDTO vt : dsViTri) {
            if( vt.getTrangThaiViTri().equals("ĐẦY"))
                continue;
            else soChoTrong++;   
        }
        return soChoTrong;
    }
}


