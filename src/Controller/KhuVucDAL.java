package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;

public class KhuVucDAL {
	
    private static KhuVucDAL instance;
    private ArrayList<KhuVucDTO> dsKhuVuc;
    public KhuVucDAL() {
        dsKhuVuc=new ArrayList<KhuVucDTO>();
        loadResources();
    }

    public static KhuVucDAL getInstance() {
        if(instance==null){
            instance = new KhuVucDAL();             
        }
        return instance;
    }

    private void  loadResources() {
        String query = new String("SELECT * FROM dbo.KHUVUC");
        try {
            ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);	
            while(resultSet.next()) {			
                KhuVucDTO kv=new KhuVucDTO();
                kv.setTenKhuVuc(resultSet.getString(1));
                kv.setTrangThaiKhuVuc(resultSet.getString(2));
                dsKhuVuc.add(kv);
            }      		
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private boolean isContain(KhuVucDTO kv) {
        for (KhuVucDTO item: dsKhuVuc)
            if (item.getTenKhuVuc().equals(kv.getTenKhuVuc())){
                return true;
            }
        return false;
    }

    public KhuVucDTO getSach(String khuVuc) {
        for (KhuVucDTO item:dsKhuVuc) {
            if (item.getTenKhuVuc().equals(khuVuc)){
                return item;
            }
        }
        return null;
    }

    public ArrayList<KhuVucDTO> getResources(){
        return  dsKhuVuc;
    }

    public String getThongTin(String maSach) {
        for (KhuVucDTO s: dsKhuVuc) {
            if (s.getTenKhuVuc().equals(maSach)){
                return s.getTenKhuVuc()+s.getTenKhuVuc()+ s.getTrangThaiKhuVuc();
            }
        }
        return "";
    }


}
