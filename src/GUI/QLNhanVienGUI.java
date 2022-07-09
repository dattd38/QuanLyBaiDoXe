package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import BLL.QLNhanVienBLL;
import DTO.NhanVienDTO;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import java.sql.Date;
import javax.swing.JFrame;


public class QLNhanVienGUI {
	
	
	
	
	private JTable 	   tbQLNhanVien;
        private JTextField tfTimKiem;
	private JTextField tfTenTaiKhoan;
	private JTextField tfTenNhanVien;
	private JTextField tfSoDienThoai;
        private JDateChooser dcNgaySinh;
        private JTextField tfGioiTinh;
        private JTextField tfDiaChi;
        private JTextField tfMaNhanVien;
        private JLabel lblMessage;
        private JFrame jFNhanVien;
	
	
	
	
	private JPanel pnTongQuanQLNhanVien;
	private JComboBox<String> cbbLoaiTaiKhoan;
        private JComboBox<String> cbbGioiTinh;

	static QLNhanVienGUI instance=null;
	private JPasswordField pfPass;
	private boolean isShow = false;
	
	
	private QLNhanVienGUI(){
		initialize();
		loadResources();
	}
	
	public void loadResources() {
		tbQLNhanVien.setModel(QLNhanVienBLL.getInstance().getResources());
	}
	
	private void reloadResources() {
		DefaultTableModel dm = (DefaultTableModel) tbQLNhanVien.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
		tbQLNhanVien.setModel(QLNhanVienBLL.getInstance().reloadResources());
	}
	
	
	public static QLNhanVienGUI getInstance() {
		if(instance == null)
			instance = new QLNhanVienGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLNhanVien() {
		return pnTongQuanQLNhanVien;
               
	}
        public JFrame getFrmNhanVien() {
		return jFNhanVien;
	}
	
	private void clearField() {
                tfTenNhanVien.setText("");
                tfDiaChi.setText("");
                tfMaNhanVien.setText("");
                cbbGioiTinh.setSelectedIndex(0);
                dcNgaySinh.setDate(null);
		tfSoDienThoai.setText("");
		pfPass.setText("");
		tfTenTaiKhoan.setText("");
		cbbLoaiTaiKhoan.setSelectedIndex(0);
                
	}
	
	private void initialize() {
		jFNhanVien = new JFrame("Quản lý Nhân Viên");
		jFNhanVien.setBounds(0, 0, 1065, 600);
		jFNhanVien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFNhanVien.getContentPane().setLayout(null);
		  
		pnTongQuanQLNhanVien = new JPanel();
		pnTongQuanQLNhanVien.setBackground(new Color(237,223,179));
		pnTongQuanQLNhanVien.setBounds(0, 0, 1065, 560);
		pnTongQuanQLNhanVien.setLayout(null);
                jFNhanVien.getContentPane().add(pnTongQuanQLNhanVien);
                
		JPanel pnTieuDeQLNhanVien = new JPanel();
		pnTieuDeQLNhanVien.setBackground(new Color(237,223,179));
		pnTieuDeQLNhanVien.setBounds(0, 0, 1065, 71);
		pnTongQuanQLNhanVien.add(pnTieuDeQLNhanVien);
		pnTieuDeQLNhanVien.setLayout(null);
                
		
		JLabel lblQLNhanVien = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQLNhanVien.setForeground(new Color(161,0,53));
		lblQLNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLNhanVien.setBounds(394, 20, 291, 31);
		pnTieuDeQLNhanVien.add(lblQLNhanVien);
		
		JPanel pnQLNhanVien = new JPanel();
		pnQLNhanVien.setBounds(0, 71, 1065, 150);
		pnTongQuanQLNhanVien.add(pnQLNhanVien);
		pnQLNhanVien.setLayout(null);
		
		tbQLNhanVien = new JTable();
		tbQLNhanVien.setBounds(0, 0, 1050, 150);
		JScrollPane sc = new JScrollPane(tbQLNhanVien, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1055, 150);
		tbQLNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (tbQLNhanVien.getSelectedRow()<0)
					return;
				tfTenTaiKhoan.setText(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 6).toString());
				pfPass.setText(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 7).toString());
				tfTenNhanVien.setText(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 1).toString());
				cbbLoaiTaiKhoan.setSelectedItem(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 8).toString());
				tfSoDienThoai.setText(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 3).toString());
                                dcNgaySinh.setDate(Date.valueOf(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 4).toString()));
                                tfMaNhanVien.setText(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 0).toString());
                                cbbGioiTinh.setSelectedItem(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 2).toString());
                                tfDiaChi.setText(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 5).toString());
			}
		});
		pnQLNhanVien.add(sc,BorderLayout.CENTER);
		
		JPanel pnThongTinNhanVien = new JPanel();
		pnThongTinNhanVien.setBackground(new Color(237,223,179));
		pnThongTinNhanVien.setBounds(0, 225, 1065, 560-225);
		pnTongQuanQLNhanVien.add(pnThongTinNhanVien);
		pnThongTinNhanVien.setLayout(null);
		
		JLabel lblThongTinNhanVien = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblThongTinNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 17));
                lblThongTinNhanVien.setForeground(new Color(161,0,53));
		lblThongTinNhanVien.setBounds(10, 5, 208, 22);
		pnThongTinNhanVien.add(lblThongTinNhanVien);
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 50, 850, 600);
		pnThongTinNhanVien.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		lblMessage = new JLabel("(*) Không được bỏ trống");
		lblMessage.setForeground(new Color(161,0,53));
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblMessage.setBounds(125, 20, 654, 34);
		pnThongTinNhanVien.add(lblMessage);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên:*");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblTenNhanVien.setForeground(new Color(161,0,53));
		lblTenNhanVien.setBounds(24, 25, 91, 30);
		pnThongTinNhap.add(lblTenNhanVien);
		
		tfTenNhanVien = new JTextField();
		tfTenNhanVien.setBounds(125, 25, 258, 31);
                tfTenNhanVien.setForeground(new Color(161,0,53));
		pnThongTinNhap.add(tfTenNhanVien);
		tfTenNhanVien.setColumns(10);
		
		JLabel lblLoaiTaiKhoan = new JLabel("Loại tài khoản:*");
		lblLoaiTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblLoaiTaiKhoan.setForeground(new Color(161,0,53));
		lblLoaiTaiKhoan.setBounds(420, 25, 91, 30);
		pnThongTinNhap.add(lblLoaiTaiKhoan);
		
		cbbLoaiTaiKhoan = new JComboBox<String>();
		cbbLoaiTaiKhoan.setBounds(521,  25, 258, 31);
                cbbLoaiTaiKhoan.setForeground(new Color(161,0,53));
		cbbLoaiTaiKhoan.addItem("1");
                cbbLoaiTaiKhoan.addItem("2");
		cbbLoaiTaiKhoan.addItem("3");
		pnThongTinNhap.add(cbbLoaiTaiKhoan);
		
		
		JLabel lblTaiKhoan = new JLabel("Tên tài khoản:*");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblTaiKhoan.setForeground(new Color(161,0,53));
		lblTaiKhoan.setBounds(24, 75, 91, 30);
		pnThongTinNhap.add(lblTaiKhoan);
		
		tfTenTaiKhoan = new JTextField();
		tfTenTaiKhoan.setBounds(125, 75, 258, 31);
                tfTenTaiKhoan.setForeground(new Color(161,0,53));
		pnThongTinNhap.add(tfTenTaiKhoan);
		tfTenTaiKhoan.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu:*");
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblMatKhau.setForeground(new Color(161,0,53));
		lblMatKhau.setBounds(420, 75, 91, 30);
		pnThongTinNhap.add(lblMatKhau);
                
                pfPass = new JPasswordField();
		pfPass.setBounds(521, 75, 152, 30);
                pfPass.setForeground(new Color(161,0,53));
		pnThongTinNhap.add(pfPass);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblSoDienThoai.setForeground(new Color(161,0,53));
		lblSoDienThoai.setBounds(24, 130, 91, 30);
		pnThongTinNhap.add(lblSoDienThoai);
		
		tfSoDienThoai = new JTextField();
		tfSoDienThoai.setColumns(10);
		tfSoDienThoai.setBounds(125, 130, 258, 31);
                tfSoDienThoai.setForeground(new Color(161,0,53));
		pnThongTinNhap.add(tfSoDienThoai);
                
                JButton btnBack = new JButton(new ImageIcon("icon//logout.png"));
                btnBack.setBounds(900, 30, 120, 40);
                btnBack.setText("Back");
                btnBack.setForeground(new Color(161,0,53));
                btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnTieuDeQLNhanVien.add(btnBack);
                btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                                
				jFNhanVien.setVisible(false);
				QuanTriHeThongGUI.getInstance().getFrmMain().setVisible(true);
			}
		});
                jFNhanVien.repaint();
		jFNhanVien.invalidate();
                
		
		tfMaNhanVien = new JTextField();
		tfMaNhanVien.setColumns(10);
		tfMaNhanVien.setBounds(521, 130, 0, 0);
                tfMaNhanVien.setForeground(new Color(161,0,53));
		pnThongTinNhap.add(tfMaNhanVien);
                
                JLabel lblGioiTinh = new JLabel("Giới tính:"); 
		lblGioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblGioiTinh.setForeground(new Color(161,0,53));
		lblGioiTinh.setBounds(420, 130, 91, 30);
		pnThongTinNhap.add(lblGioiTinh);
		
		cbbGioiTinh = new JComboBox<String>();
		cbbGioiTinh.setBounds(521, 130, 258, 31);
                cbbGioiTinh.setForeground(new Color(161,0,53));
		cbbGioiTinh.addItem("Nam");
                cbbGioiTinh.addItem("Nữ");
		pnThongTinNhap.add(cbbGioiTinh);
                
                JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblNgaySinh.setForeground(new Color(161,0,53));
		lblNgaySinh.setBounds(24, 185, 91, 30);
		pnThongTinNhap.add(lblNgaySinh);
		
		dcNgaySinh = new JDateChooser();
		dcNgaySinh.setBounds(125, 185, 258, 30);
                dcNgaySinh.setForeground(new Color(161,0,53));
                dcNgaySinh.setDateFormatString("yyyy-MM-dd");
		pnThongTinNhap.add(dcNgaySinh);
                
                JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 13));
                lblDiaChi.setForeground(new Color(161,0,53));
		lblDiaChi.setBounds(24, 240, 91, 30);
		pnThongTinNhap.add(lblDiaChi);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(125, 240, 258, 31);
                tfDiaChi.setForeground(new Color(161,0,53));
		pnThongTinNhap.add(tfDiaChi);
		
		
		JButton btnShowPass = new JButton("Hiển thị");
		btnShowPass.setBounds(683, 75, 97, 30);
                btnShowPass.setForeground(new Color(161,0,53));
		pnThongTinNhap.add(btnShowPass);
		btnShowPass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isShow) {
					isShow = false;
					pfPass.setEchoChar((char)0);
				}
				else {
					isShow = true;
					pfPass.setEchoChar('*');
				}
			}
		});
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(896, 48, 138, 41);
                btnThem.setForeground(new Color(161,0,53));
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maNv;
                                if(tbQLNhanVien.getRowCount()<=0)
                                {
                                    maNv="NV01";
                                    
                                }
                                else 
                                {
                                    maNv="NV0"+(1+Integer.parseInt(tbQLNhanVien.getValueAt(tbQLNhanVien.getRowCount()-1,0).toString().substring(3)));
                                    
                                }
                                Calendar cal = dcNgaySinh.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngaySinh = sdf.format(date);
                                NhanVienDTO nv= new NhanVienDTO(maNv,tfTenNhanVien.getText(),cbbGioiTinh.getSelectedItem().toString(),
                                        tfSoDienThoai.getText(),Date.valueOf(ngaySinh),tfDiaChi.getText(),
                                tfTenTaiKhoan.getText(),pfPass.getText(),cbbLoaiTaiKhoan.getSelectedItem().toString());
                               String result = QLNhanVienBLL.getInstance().addProcessing(nv);
                               lblMessage.setText(result);
                               reloadResources();
                               
			}
		});
		pnThongTinNhanVien.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(896, 125, 138, 41);
                btnSua.setForeground(new Color(161,0,53));
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Calendar cal = dcNgaySinh.getCalendar();
				java.util.Date date = cal.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ngaySinh = sdf.format(date);
				NhanVienDTO nv = new NhanVienDTO(
				tfMaNhanVien.getText(), 
				tfTenNhanVien.getText(),
                                cbbGioiTinh.getSelectedItem().toString(),
                                tfSoDienThoai.getText(),
                                Date.valueOf(ngaySinh),
                                tfDiaChi.getText(),
                                tfTenTaiKhoan.getText(),
                                pfPass.getText(),
                                cbbLoaiTaiKhoan.getSelectedItem().toString());
				String result = QLNhanVienBLL.getInstance().changeProcessing(nv);
				lblMessage.setText(result);
				reloadResources();
			}
		});
		pnThongTinNhanVien.add(btnSua);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(896, 200, 138, 41);
                btnHuy.setForeground(new Color(161,0,53));
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearField();
				loadResources();
			}
		});
		pnThongTinNhanVien.add(btnHuy);
             
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(896, 275, 138, 41);
                btnXoa.setForeground(new Color(161,0,53));
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msg = QLNhanVienBLL.getInstance().deleteProcessing(tbQLNhanVien.getValueAt(tbQLNhanVien.getSelectedRow(), 0).toString(),
				cbbLoaiTaiKhoan.getSelectedItem().toString());
				lblMessage.setText(msg);
				reloadResources();
				clearField();
			}
		});
		pnThongTinNhanVien.add(btnXoa);
	}
}
