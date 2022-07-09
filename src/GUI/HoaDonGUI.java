/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BLL.HoaDonBLL;
import BLL.QLRaVaoBenBLL;
import BLL.QLNhanVienBLL;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

//import BLL.QLVeBLL;
import BLL.QLViTriBLL;
import BLL.ThongTinCaNhanBLL;
import Controller.HoaDonDAL;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author MY LAPTOP
 */
public class HoaDonGUI {
    static HoaDonGUI instance = null;
        private JPanel pnMainHoaDon;
        private JLabel lblMaHoaDon;
        private JTextField jTMaHoaDon;
        private JLabel lblMaNhanVien;
        private JLabel lTTenNhanVien;
        private JLabel lblBienSoXe;
        private JLabel lTBienSoXe;
        private JLabel lblMaVe;
        private JLabel lTMaVe;
        private JDateChooser jdNgayLap;
        private JLabel lTTenViTri;
	private JLabel lTTenKhuVuc;
        private JLabel lblSoNgayGui;
        private JLabel lTThanhTien;
        private JLabel lTSoNgayGui;
        private JLabel lTMaHoaDon;
        private JTextField jTSoNgayGui;
	private JLabel lblThanhTien;
        private JTextField jTThanhTien;
        private JLabel ltNgayVao;
        private JLabel lblMessage;
        private JTable tbHoaDon;
        private JFrame jfHoaDon;
        NhanVienDTO nv;
         int donGia;
	
	private boolean isEdit = true;
	private JTextField tfTimKiem;
	
	private HoaDonGUI(String maVe, String tenViTri, String tenKhuVuc, String bienSoxe,int soNgayGui) {
		initialize(maVe, tenViTri, tenKhuVuc,  bienSoxe,soNgayGui);
		
	}
        
        private void clearField() {

		lTTenViTri.setText("");
	        lTTenKhuVuc.setText("");
                lTBienSoXe.setText("");
                lTMaHoaDon.setText("");
                lTThanhTien.setText("");
                lTSoNgayGui.setText("");
                lTMaVe.setText("");
                

	}
	
	public static HoaDonGUI getInstance(String maVe, String tenViTri, String tenKhuVuc, String bienSoxe,int soNgayGui) {
		if (instance == null)
			instance = new HoaDonGUI(maVe, tenViTri, tenKhuVuc,  bienSoxe,soNgayGui);
		return instance;
	}
	
	public JPanel getPnMain() {
		return pnMainHoaDon;
	}
	

	@SuppressWarnings("deprecation")
        public void initialize(String maVe, String tenViTri, String tenKhuVuc, String bienSoxe,int soNgayGui) {
          
                
                pnMainHoaDon = new JPanel();
		pnMainHoaDon.setLayout(null);
		pnMainHoaDon.setBounds(0, 0, 1065, 560);
		pnMainHoaDon.setBackground(new Color(237,223,179));
              
                
                JPanel pnTitle = new JPanel();
		pnTitle.setLayout(null);
		pnTitle.setBackground(new Color(237,223,179));
		pnTitle.setBounds(0, 0, 1078, 90);
		pnMainHoaDon.add(pnTitle);
		
		JPanel pnHoaDon = new JPanel();
		pnHoaDon.setLayout(null);
		pnHoaDon.setBackground(new Color(237,223,179));
		pnHoaDon.setBounds(0, 92, 1078, 468);
		pnMainHoaDon.add(pnHoaDon);
                
                JLabel lblTitle = new JLabel("Lập Hóa Đơn");
		lblTitle.setForeground(new Color(161,0,53));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblTitle.setBounds(350, 30, 300, 40);
		pnTitle.add(lblTitle);
                
                lblMessage = new JLabel("(*) Không được bỏ trống ");
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblMessage.setForeground(new Color(161,0,53));
		lblMessage.setBounds(50, 35, 300, 40);
		pnHoaDon.add(lblMessage);
                
                JLabel lblMaHoaDon = new JLabel("Mã Hóa Đơn   : ");
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblMaHoaDon.setForeground(new Color(161,0,53));
		lblMaHoaDon.setBounds(100, 80, 140, 50);
		pnHoaDon.add(lblMaHoaDon);
                
                String maHD="";
                      int hoaDon=0;
                      ArrayList<HoaDonDTO> dsHoaDon = new ArrayList<HoaDonDTO>();
		      dsHoaDon=HoaDonDAL.getInstance().reloadResources();
                                if(dsHoaDon.size()<1)
                                {
                                    maHD="HD1";
                                    
                                }
                                else 
                                {   
                                    hoaDon=dsHoaDon.size();
                                    maHD="HD"+(1+hoaDon);
                                    
                                }
                lTMaHoaDon = new JLabel(maHD);
		lTMaHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lTMaHoaDon.setBounds(250, 80, 100, 50);
                lTMaHoaDon.setForeground(new Color(161,0,53));
		pnHoaDon.add(lTMaHoaDon);
                
                JLabel lblMaNhanVien = new JLabel("Tên Nhân Viên : ");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblMaNhanVien.setForeground(new Color(161,0,53));
		lblMaNhanVien.setBounds(400, 80, 150, 50);
		pnHoaDon.add(lblMaNhanVien);
                
                nv = ThongTinCaNhanBLL.getInstance().getNhanVien();
                lTTenNhanVien = new JLabel(nv.getTenNhanVien());
		lTTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lTTenNhanVien.setBounds(550, 80, 150, 50);
                lTTenNhanVien.setForeground(new Color(161,0,53));
		pnHoaDon.add(lTTenNhanVien);
                
                JLabel lblBienSoXe = new JLabel("Biển Số Xe       : ");
		lblBienSoXe.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblBienSoXe.setForeground(new Color(161,0,53));
		lblBienSoXe.setBounds(750, 80, 150, 50);
		pnHoaDon.add(lblBienSoXe);
                
                lTBienSoXe = new JLabel(bienSoxe);
		lTBienSoXe.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lTBienSoXe.setForeground(new Color(161,0,53));
		lTBienSoXe.setBounds(900, 80, 140, 50);
		pnHoaDon.add(lTBienSoXe);
                
                JLabel lblMaVe = new JLabel("Mã Vé             : ");
		lblMaVe.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblMaVe.setForeground(new Color(161,0,53));
		lblMaVe.setBounds(100, 170, 140, 50);
		pnHoaDon.add(lblMaVe);
                
                lTMaVe = new JLabel(maVe);
		lTMaVe.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lTMaVe.setForeground(new Color(161,0,53));
		lTMaVe.setBounds(250, 170, 150, 50);
		pnHoaDon.add(lTMaVe);
                
                JLabel lblNgayLap= new JLabel("Ngày Lập           : ");
		lblNgayLap.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblNgayLap.setForeground(new Color(161,0,53));
		lblNgayLap.setBounds(400, 170, 150, 50);
		pnHoaDon.add(lblNgayLap);
                
                ltNgayVao = new JLabel("*");
		ltNgayVao.setBounds(550, 170, 140, 50);
		ltNgayVao.setFont(new Font("Times New Roman", Font.BOLD, 20));
                ltNgayVao.setForeground(new Color(161,0,53));
                SimpleDateFormat fm=new SimpleDateFormat("dd-MM-yyyy");
                Date date= new Date();
                ltNgayVao.setText(fm.format(date));
		pnHoaDon.add(ltNgayVao);
                
                
                JLabel lblMaViTri = new JLabel("Tên Vị Trí       : ");
		lblMaViTri.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblMaViTri.setForeground(new Color(161,0,53));
		lblMaViTri.setBounds(750, 170, 150, 50);
		pnHoaDon.add(lblMaViTri);
                
                lTTenViTri = new JLabel(tenViTri);
		lTTenViTri.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lTTenViTri.setForeground(new Color(161,0,53));
		lTTenViTri.setBounds(900, 170, 150, 50);
		pnHoaDon.add(lTTenViTri);
                
                lblSoNgayGui= new JLabel("Số Ngày Gửi   : ");
		lblSoNgayGui.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblSoNgayGui.setForeground(new Color(161,0,53));
		lblSoNgayGui.setBounds(100, 260, 140, 50);
		pnHoaDon.add(lblSoNgayGui);
                
                lTSoNgayGui= new JLabel();
                lTSoNgayGui.setText(soNgayGui+"");
		lTSoNgayGui.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lTSoNgayGui.setForeground(new Color(161,0,53));
		lTSoNgayGui.setBounds(250, 260, 100, 50);
		pnHoaDon.add(lTSoNgayGui);
                
                JLabel lblThanhTien = new JLabel("Thành Tiền       : ");
		lblThanhTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblThanhTien.setForeground(new Color(161,0,53));
		lblThanhTien.setBounds(400, 260, 200, 50);
		pnHoaDon.add(lblThanhTien);
                
               
                try{
                String line;
                File file = new File("D:\\QuanLyBaiDoXe\\src\\ThanhTien.txt");
                InputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufR = new BufferedReader(inputStreamReader);
                
                while ((line = bufR.readLine()) != null) {
					if (line.startsWith("#"))
						continue;
                String []part=line.split(",");
                donGia=Integer.parseInt(part[1]);
					
				}
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                lTThanhTien = new JLabel();
                lTThanhTien.setText(soNgayGui*donGia+" VNĐ");
		lTThanhTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lTThanhTien.setForeground(new Color(161,0,53));
		lTThanhTien.setBounds(550, 260, 120, 50);
		pnHoaDon.add(lTThanhTien);
                
                JLabel lblTenKhuVuc = new JLabel("Tên Khu Vực     : ");
		lblTenKhuVuc.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lblTenKhuVuc.setForeground(new Color(161,0,53));
		lblTenKhuVuc.setBounds(750, 260, 200, 50);
		pnHoaDon.add(lblTenKhuVuc);
                
                lTTenKhuVuc = new JLabel(tenKhuVuc);
		lTTenKhuVuc.setFont(new Font("Times New Roman", Font.BOLD, 20));
                lTTenKhuVuc.setForeground(new Color(161,0,53));
		lTTenKhuVuc.setBounds(900, 260, 150, 50);
		pnHoaDon.add(lTTenKhuVuc);
                
                Button btnLap = new Button(" Lập ");
                btnLap.setFont(new Font("Times New Roman", Font.BOLD, 24));
                btnLap.setBounds(425,370 , 150, 50);
                btnLap.setForeground(Color.white);
                btnLap.setBackground(new Color(161,0,53));
                btnLap.addActionListener(new ActionListener() {
                    @Override
                    
                    public void actionPerformed(ActionEvent e) {
                      
                  
                       SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
                       Calendar   cal = Calendar.getInstance();
                       java.util.Date date = cal.getTime();
	               String ngaylap = fm.format(date);
                       HoaDonDTO hd= new HoaDonDTO(
                                lTMaHoaDon.getText(),
                                lTMaVe.getText(),
                                lTTenViTri.getText(),
                                lTTenKhuVuc.getText(),
                                lTTenNhanVien.getText(),
                                lTSoNgayGui.getText(),
                                lTBienSoXe.getText(),
                                lTThanhTien.getText(),
                                java.sql.Date.valueOf(ngaylap)
                        );
                        String result = HoaDonBLL.getInstance().addProcessing(hd);
                        lblMessage.setText(result);
                        clearField();                   
                        TrangChuGUI.getInstance().initittle();
                    }
                });
                pnHoaDon.add(btnLap);
                
                JButton btnTroVe = new JButton("Trở về");
		btnTroVe.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
				
                        pnMainHoaDon.removeAll();
                        QLRaVaoBenGUI qlRaVaoBen = QLRaVaoBenGUI.getInstance();
                        qlRaVaoBen.initialize();
                        qlRaVaoBen.reloadResources();
                        pnMainHoaDon.add(qlRaVaoBen.getPnMain());
                        pnMainHoaDon.revalidate();
                        pnMainHoaDon.repaint();
			}
		});
		btnTroVe.setIcon(new ImageIcon("icon\\logout.png"));
		btnTroVe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTroVe.setBounds(867, 400, 168, 41);
                btnTroVe.setForeground(new Color(161,0,53));
		pnHoaDon.add(btnTroVe);
        }
}
