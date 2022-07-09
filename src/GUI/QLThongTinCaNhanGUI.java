package GUI;

import BLL.DangNhapBLL;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BLL.ThongTinCaNhanBLL;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLThongTinCaNhanGUI {

	private JPanel pnTongQuanQLChaoMung;

	static QLThongTinCaNhanGUI instance = null;
	public JTextField tfMaNhanVien;
	public JTextField tfTenNhanVien;
	public JTextField tfChucVu;
	public JTextField tfMatKhau;
	public JTextField tfMatKhauMoi;
	public JTextField tfNhapLaiMatKhauMoi;
	public JLabel lblMessage;
	
	public QLThongTinCaNhanGUI() {
		initialize();
	}
	
	public void loadResources() {
		ThongTinCaNhanBLL.getInstance().LoadResources();
	}
	
	public static QLThongTinCaNhanGUI getInstance() {
		if(instance == null)
			instance = new QLThongTinCaNhanGUI();
		return instance;
	}
	
	public void huyPro() {
		tfMatKhau.setText("");
		tfMatKhauMoi.setText("");
		tfNhapLaiMatKhauMoi.setText("");
	}
	
	public JPanel getPnTongQuanQLChaoMung() {
		return pnTongQuanQLChaoMung;
	}
	private void initialize() {
		
		
		pnTongQuanQLChaoMung = new JPanel();
		pnTongQuanQLChaoMung.setBounds(0, 0, 1065, 560);
		pnTongQuanQLChaoMung.setLayout(null);
		
		JPanel pnTieuDeTTCN = new JPanel();
		pnTieuDeTTCN.setBackground(new Color(237,223,179));
		pnTieuDeTTCN.setBounds(0, 0, 1065, 87);
		pnTongQuanQLChaoMung.add(pnTieuDeTTCN);
		pnTieuDeTTCN.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ THÔNG TIN CÁ NHÂN");
		lblNewLabel.setForeground(new Color(161,0,53));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(348, 11, 391, 57);
		pnTieuDeTTCN.add(lblNewLabel);
		
		JPanel pnThongTinCaNhan = new JPanel();
		pnThongTinCaNhan.setBackground(new Color(237,223,179));
		pnThongTinCaNhan.setBounds(0, 90, 1065, 210);
		pnTongQuanQLChaoMung.add(pnThongTinCaNhan);
		pnThongTinCaNhan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("THÔNG TIN CÁ NHÂN");
                lblNewLabel_1.setForeground(new Color(161,0,53));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 5, 226, 34);
		pnThongTinCaNhan.add(lblNewLabel_1);
		
		JPanel pnQLTTCN = new JPanel();
		pnQLTTCN.setBounds(10, 35, 1045, 164);
		pnThongTinCaNhan.add(pnQLTTCN);
		pnQLTTCN.setLayout(null);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblMaNhanVien.setForeground(new Color(161,0,53));
		lblMaNhanVien.setBounds(291, 25, 90, 14);
		pnQLTTCN.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên:");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblTenNhanVien.setForeground(new Color(161,0,53));
		lblTenNhanVien.setBounds(291, 78, 90, 14);
		pnQLTTCN.add(lblTenNhanVien);
		
		JLabel lblChucVu = new JLabel("Loại Tài Khoản:");
		lblChucVu.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblChucVu.setForeground(new Color(161,0,53));
		lblChucVu.setBounds(291, 128, 92, 14);
		pnQLTTCN.add(lblChucVu);
		
		tfMaNhanVien = new JTextField();
		tfMaNhanVien.setBounds(437, 17, 258, 31);
                tfMaNhanVien.setForeground(new Color(161,0,53));
		tfMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfMaNhanVien);
		tfMaNhanVien.setEditable(false);
		tfMaNhanVien.setColumns(10);
		
		tfTenNhanVien = new JTextField();
		tfTenNhanVien.setBounds(437, 70, 258, 31);
                tfTenNhanVien.setForeground(new Color(161,0,53));
		tfTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfTenNhanVien);
		tfTenNhanVien.setEditable(false);
		tfTenNhanVien.setColumns(10);
		
		tfChucVu = new JTextField();
		tfChucVu.setBounds(437, 117, 258, 36);
                tfChucVu.setForeground(new Color(161,0,53));
		tfChucVu.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfChucVu);
		tfChucVu.setEditable(false);
		tfChucVu.setColumns(10);
		
		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setBackground(new Color(237,223,179));
		pnMatKhau.setBounds(0, 303, 1065, 257);
		pnTongQuanQLChaoMung.add(pnMatKhau);
		pnMatKhau.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel_7.setIcon(new ImageIcon("icon\\changpass.png"));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
                lblNewLabel_7.setForeground(new Color(161,0,53));
		lblNewLabel_7.setBounds(10, 5, 174, 24);
		pnMatKhau.add(lblNewLabel_7);
		
		JPanel pnQLMatKhau = new JPanel();
		pnQLMatKhau.setBounds(10, 40, 1045, 206);
		pnMatKhau.add(pnQLMatKhau);
		pnQLMatKhau.setLayout(null);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblMatKhau.setForeground(new Color(161,0,53));
		lblMatKhau.setBounds(289, 27, 109, 14);
		pnQLMatKhau.add(lblMatKhau);
		
		JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới:");
		lblMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblMatKhauMoi.setForeground(new Color(161,0,53));
		lblMatKhauMoi.setBounds(289, 71, 123, 14);
		pnQLMatKhau.add(lblMatKhauMoi);
		
		JLabel lblNhapLaiMatKhauMoi = new JLabel("Nhập lại mật khẩu mới:");
		lblNhapLaiMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblNhapLaiMatKhauMoi.setForeground(new Color(161,0,53));
		lblNhapLaiMatKhauMoi.setBounds(289, 116, 137, 14);
		pnQLMatKhau.add(lblNhapLaiMatKhauMoi);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setBounds(436, 19, 258, 31);
                tfMatKhau.setForeground(new Color(161,0,53));
		pnQLMatKhau.add(tfMatKhau);
		tfMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tfMatKhau.setColumns(10);
		
		tfMatKhauMoi = new JTextField();
		tfMatKhauMoi.setBounds(436, 63, 258, 31);
                tfMatKhauMoi.setForeground(new Color(161,0,53));
		tfMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLMatKhau.add(tfMatKhauMoi);
		tfMatKhauMoi.setColumns(10);
		
		tfNhapLaiMatKhauMoi = new JTextField();
		tfNhapLaiMatKhauMoi.setBounds(436, 108, 258, 31);
                tfNhapLaiMatKhauMoi.setForeground(new Color(161,0,53));
		tfNhapLaiMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLMatKhau.add(tfNhapLaiMatKhauMoi);
		tfNhapLaiMatKhauMoi.setColumns(10);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("icon\\save.png"));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLuu.setBounds(289, 154, 168, 41);
                btnLuu.setForeground(new Color(161,0,53));
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ThongTinCaNhanBLL.getInstance().luu();
				
			}
		});
		pnQLMatKhau.add(btnLuu);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnHuy.setBounds(576, 154, 168, 41);
                btnHuy.setForeground(new Color(161,0,53));
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				huyPro();
			}
		});
		pnQLMatKhau.add(btnHuy);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI.getInstance().getFrmTrangChu().setVisible(false);
                                QLThongTinCaNhanGUI.getInstance().loadResources();
                                QLDangNhapGUI.getInstance().clearField();
				QLDangNhapGUI.getInstance().getFrame().setVisible(true);
			}
		});
		btnDangXuat.setIcon(new ImageIcon("icon\\logout.png"));
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDangXuat.setBounds(867, 156, 168, 41);
                btnDangXuat.setForeground(new Color(161,0,53));
		pnQLMatKhau.add(btnDangXuat);
		
		lblMessage = new JLabel();
		lblMessage.setFont(new Font("Times New Romen", Font.PLAIN, 13));
		lblMessage.setForeground(new Color(161,0,53));
		lblMessage.setBounds(723, 19, 312, 31);
		pnQLMatKhau.add(lblMessage);
	}
}
