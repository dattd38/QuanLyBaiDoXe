package GUI;
import BLL.HoaDonBLL;
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

import BLL.QLDoanhThuBLL;
import BLL.QLVeBLL;
import BLL.QLViTriBLL;
import static GUI.HoaDonGUI.instance;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
public class QLHoaDonGUI {
static QLHoaDonGUI instance = null;
private JPanel pnMain;
private JTable tbHoaDon;
private JLabel lblNhanVienxs;
private JLabel lTNhanVienxs;
private JLabel lblMaxNgayGui;
private JLabel lTMaxNgayGui;
private JLabel lblAvgTien;
private JLabel lTAvgTien;


private void loadResources() {
		tbHoaDon.setModel(HoaDonBLL.getInstance().getResources());
	}
public QLHoaDonGUI() {
       initialize();
       loadResources();
	}

public JPanel getPnMain() {
		return pnMain;
	}
public void reloadResources() {
		DefaultTableModel dm = (DefaultTableModel) tbHoaDon.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
		tbHoaDon.setModel(HoaDonBLL.getInstance().reloadResources());
	}

public static QLHoaDonGUI getInstance() {
		if (instance == null)
			instance = new QLHoaDonGUI();
		return instance;
	}

    @SuppressWarnings("deprecation")
    public void initialize() {
                pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 0, 1065, 560);
		pnMain.setBackground(Color.WHITE);
                
                JPanel pnTitle = new JPanel();
		pnTitle.setLayout(null);
		pnTitle.setBackground(new Color(237,223,179));
		pnTitle.setBounds(0, 0, 1078, 110);
		pnMain.add(pnTitle);
		
		JPanel pnDoanhThu=new JPanel();
                pnDoanhThu.setLayout(null);
		pnDoanhThu.setBackground(new Color(237,223,179));
		pnDoanhThu.setBounds(0, 115, 1065, 560-115);
		pnMain.add(pnDoanhThu);
                
                JPanel pnQLDoanhThu=new JPanel();
                pnQLDoanhThu.setLayout(null);
		pnQLDoanhThu.setBackground(new Color(237,223,179));
		pnQLDoanhThu.setBounds(0, 447, 1065, 445-352);
		pnMain.add(pnQLDoanhThu);
                
                JLabel lblTitle = new JLabel("QUẢN LÝ HÓA ĐƠN ");
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
                lblTitle.setForeground(new Color(161,0,53));
		lblTitle.setBounds(350, 35, 350, 39);
		pnTitle.add(lblTitle);
                
                JLabel lblThang = new JLabel();
		lblThang.setForeground(new Color(161,0,53));
		lblThang.setHorizontalAlignment(SwingConstants.CENTER);
		lblThang.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblThang.setBounds(550, 23, 239, 39);
		pnTitle.add(lblThang);
                
                tbHoaDon = new JTable();
		tbHoaDon.setBounds(0, 0, 1050, 350);
		JScrollPane sc = new JScrollPane(tbHoaDon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1055,350);
		tbHoaDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
			}
			
		});
		pnDoanhThu.add(sc,BorderLayout.CENTER);
                  
                 
                
//                lblNhanVienxs= new JLabel("Nhân Viên Tích Cực  : ");
//		lblNhanVienxs.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		lblNhanVienxs.setBounds(150, 380, 200, 50);
//		pnDoanhThu.add(lblNhanVienxs);
//                
//                lblMaxNgayGui= new JLabel("Số Ngày Gửi Nhiều Nhất  : ");
//		lblMaxNgayGui.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		lblMaxNgayGui.setBounds(480, 380, 200, 50);
//		pnDoanhThu.add(lblMaxNgayGui);
//                
//                lblAvgTien= new JLabel("Trung Bình Tiền Gửi  : ");
//		lblAvgTien.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		lblAvgTien.setBounds(760, 380, 200, 50);
//		pnDoanhThu.add(lblAvgTien);
                
//                int TongTien=0;
//                
//                int count=tbHoaDon.getRowCount();
//                ArrayList<Integer> list= new ArrayList<Integer>();
//                for(int i=0;i<count;i++ )
//                {    
//                    list.add(Integer.parseInt(tbHoaDon.getValueAt(i, 5).toString()));
//                    TongTien+=TongTien+Integer.parseInt(tbHoaDon.getValueAt(i, 7).toString());
//                }
                
             
                    
//                int avgTien=TongTien/count;

                
//                lTNhanVienxs= new JLabel(" Trần Đức Đạt");
//		lTNhanVienxs.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		lTNhanVienxs.setBounds(310, 380, 150, 50);
//		pnDoanhThu.add(lTNhanVienxs);
//                
//                lTMaxNgayGui = new JLabel("15");
//		lTMaxNgayGui.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		lTMaxNgayGui.setBounds(670, 380, 100, 50);
//		pnDoanhThu.add(lTMaxNgayGui);
//                
//                lTAvgTien = new JLabel( "125000 VNĐ");
//		lTAvgTien.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		lTAvgTien.setBounds(930,380,200, 50);
//		pnDoanhThu.add(lTAvgTien);
}}

