/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import BLL.QLLuong;
import BLL.QLVeBLL;
import BLL.QLViTriBLL;
import Controller.VeDAL;
import DTO.VeDTO;
import static GUI.HoaDonGUI.instance;
import static GUI.QLHoaDonGUI.instance;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author MY LAPTOP
 */
public class QLLuongGUI {
 static QLLuongGUI instance = null;
private JPanel pnMain;
private JTable tbLuong; 
private JFrame jfLuong;

private void loadResources() {
		tbLuong.setModel(QLLuong.getInstance().getResources());
	}
public QLLuongGUI() {
       initialize();
       loadResources();
	}

public JPanel getPnMain() {
		return pnMain;
	}
public void reloadResources() {
		DefaultTableModel dm = (DefaultTableModel) tbLuong.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
		tbLuong.setModel(QLLuong.getInstance().reloadResources());
	}

public static QLLuongGUI getInstance() {
		if (instance == null)
			instance = new QLLuongGUI();
		return instance;
	}
 public JFrame getFrmLuong() {
		return jfLuong;
	}
	
    @SuppressWarnings("deprecation")
    public void initialize() {
                jfLuong = new JFrame("Quản lý Lương");
		jfLuong.setBounds(0, 0, 1110, 600);
		jfLuong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfLuong.getContentPane().setLayout(null);
                
                pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 0, 1100, 600);
		pnMain.setBackground(Color.WHITE);
                jfLuong.getContentPane().add(pnMain);
                
                JPanel pnTitle = new JPanel();
		pnTitle.setLayout(null);
		pnTitle.setBackground(SystemColor.activeCaption);
		pnTitle.setBounds(0, 0, 1100, 110);
		pnMain.add(pnTitle);
		
		JPanel pnLuong=new JPanel();
                pnLuong.setLayout(null);
		pnLuong.setBackground(SystemColor.activeCaption);
		pnLuong.setBounds(0, 115, 1100, 600-115);
		pnMain.add(pnLuong);
                
                JPanel pnQLLuong=new JPanel();
                pnQLLuong.setLayout(null);
		pnQLLuong.setBackground(SystemColor.activeCaption);
		pnQLLuong.setBounds(0, 447, 1065, 445-352);
		pnMain.add(pnQLLuong);
                
                JLabel lblTitle = new JLabel("QUẢN LÝ LƯƠNG NHÂN VIÊN ");
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBounds(250, 40, 600, 39);
		pnTitle.add(lblTitle);
                
                JLabel lblThang = new JLabel();
		lblThang.setForeground(Color.RED);
		lblThang.setHorizontalAlignment(SwingConstants.CENTER);
		lblThang.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblThang.setBounds(550, 23, 239, 39);
		pnTitle.add(lblThang);
                
                tbLuong = new JTable();
		tbLuong.setBounds(0, 0, 1100, 350);
		JScrollPane sc = new JScrollPane(tbLuong, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1100,350);
		tbLuong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
			}
			
		});
		pnLuong.add(sc,BorderLayout.CENTER);
                
                JLabel hoTroLuong= new JLabel("Hỗ trợ Lương: ");
                hoTroLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
                hoTroLuong.setBounds(10, 380, 200, 30);
                pnLuong.add(hoTroLuong); 
                
                JComboBox cbbLuong = new JComboBox<String>();
		cbbLuong.setBounds(130, 380, 200, 30);
                cbbLuong.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        cbbLuong.addItem("Tăng 10% lương");
                cbbLuong.addItem("Tăng 5% lương");
                cbbLuong.addItem("Trừ 5% lương");
                cbbLuong.addItem("Trừ 10% lương");
                cbbLuong.addItem("Hỗ trợ khác");
		pnLuong.add(cbbLuong);  
                
                JLabel Luong= new JLabel("Thưởng/Phạt : ");
                Luong.setFont(new Font("Times New Roman", Font.BOLD, 16));
                Luong.setBounds(400, 380, 150, 30);
                pnLuong.add(Luong); 
                
                JTextField jtLuong = new JTextField();
		jtLuong.setBounds(520, 380, 200, 30);
                cbbLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnLuong.add(jtLuong);  
                
                JButton xuatLuong = new JButton(new ImageIcon("icon\\print.png"));
                xuatLuong.setBounds(850, 375, 150, 40);
                xuatLuong.setText("Xuất Exel");
                cbbLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
                xuatLuong.addActionListener(new ActionListener() {
                @Override
			public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Thành công!","Thông báo",1);
     }
                });
        pnLuong.add(xuatLuong);
    
                
                JButton btnBack = new JButton(new ImageIcon("icon//logout.png"));
                btnBack.setBounds(950, 75, 120, 40);
                btnBack.setText("Back");
                cbbLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnTitle.add(btnBack);
                btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                                
				jfLuong.setVisible(false);
				QuanTriHeThongGUI.getInstance().getFrmMain().setVisible(true);
			}
		});
                jfLuong.repaint();
		jfLuong.invalidate();
                
    }
}
