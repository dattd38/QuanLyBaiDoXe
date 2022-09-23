package BLL;


import Controller.NhanVienDAL;
import DTO.NhanVienDTO;
import GUI.QLThongTinCaNhanGUI;

public class ThongTinCaNhanBLL {
	private static ThongTinCaNhanBLL instance;
	NhanVienDTO nv;
	
	public  ThongTinCaNhanBLL() {
	
	}
	
	public static ThongTinCaNhanBLL getInstance() {
		if (instance == null) {
			instance = new ThongTinCaNhanBLL();
		}
		return instance;
	}

    public NhanVienDTO getNhanVien() {
        return nv;
    }
        
        
	
	public void setNhanVien(NhanVienDTO nv) {
		this.nv = nv;
	}

	public void luu() {
		if (QLThongTinCaNhanGUI.getInstance().tfMatKhau.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mật khẩu đang bị trống");
			return;
		}
		if (QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mật khẩu mới đang bị trống");
			return;
		}
		if (QLThongTinCaNhanGUI.getInstance().tfNhapLaiMatKhauMoi.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Nhập lại mật khẩu mới đang bị trống");
			return;
		}
		if(!QLThongTinCaNhanGUI.getInstance().tfNhapLaiMatKhauMoi.getText().equals(QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText())) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Nhập lại mật khẩu khác với Mật khẩu mới");
			return;
		}
		if (!QLThongTinCaNhanGUI.getInstance().tfMatKhau.getText().equals(nv.getMatKhau())) {
			System.out.println(nv.getMatKhau());
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mật khẩu sai");
			return;
		}
		nv.setMatKhau(QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText());
		int result = NhanVienDAL.getInstance().changeProcessing(nv);
		if (result > 0)
                {
                    QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Đổi mật khẩu thành công");
			QLThongTinCaNhanGUI.getInstance().huyPro();
		}
		else
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Đổi mật khẩu thất bại");
	}
	
	public void LoadResources() {
	
		QLThongTinCaNhanGUI.getInstance().tfMaNhanVien.setText(nv.getMaNhanVien());
		QLThongTinCaNhanGUI.getInstance().tfChucVu.setText(nv.getLoaiTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfTenNhanVien.setText(nv.getTenNhanVien());
                
	}
        
        public String getLTK(){
            NhanVienDTO g=ThongTinCaNhanBLL.getInstance().getNhanVien();
            String ltk=g.getLoaiTaiKhoan();   
            return ltk;
        }
	
	
}
