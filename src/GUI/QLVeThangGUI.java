/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.QLNhanVienBLL;
import BLL.QLVeBLL;
import DTO.NhanVienDTO;
import DTO.VeDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duc_Dat
 */
public class QLVeThangGUI {
    private JTable tbVeThang;
    private JTextField tfMaVe;
    private JTextField tfBienSoXe;
    private JDateChooser tfNgayBatDau;
    private JLabel lblMessage;
    private JFrame jfVeThang;
    private JPanel pnMain;
    
    static QLVeThangGUI instance=null;
    
    private QLVeThangGUI(){
        initialize();
        loadResources();
    }
    
    public void loadResources(){
        tbVeThang.setModel(QLVeBLL.getInstance().getResources());
    }
    
    public void reloadResources(){
        DefaultTableModel dm = (DefaultTableModel) tbVeThang.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        tbVeThang.setModel(QLVeBLL.getInstance().reloadResources());
    }
    
    public static QLVeThangGUI getInstances(){
        if(instance==null){
            instance=new QLVeThangGUI();
        }
        return instance;
    } 
    
    public JPanel getPnMain(){
        return pnMain;
    }
    
    public JFrame getFormVe(){
        return jfVeThang;
    }
    
    private void clearField(){
        tfMaVe.setText("");
        tfBienSoXe.setText("");
        tfNgayBatDau.setDate(new Date());
    }
    
    private void initialize(){
        jfVeThang = new JFrame("Quản lý Nhân Viên");
        jfVeThang.setBounds(0, 0, 1065, 600);
        jfVeThang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfVeThang.getContentPane().setLayout(null);

        pnMain = new JPanel();
        pnMain.setBackground(new Color(237,223,179));
        pnMain.setBounds(0, 0, 1065, 560);
        pnMain.setLayout(null);
        jfVeThang.getContentPane().add(pnMain);
        
        JPanel pnTieuDeQLVe = new JPanel();
        pnTieuDeQLVe.setBackground(new Color(237,223,179));
        pnTieuDeQLVe.setBounds(0, 0, 1065, 71);
        pnMain.add(pnTieuDeQLVe);
        pnTieuDeQLVe.setLayout(null);


        JLabel lblQLVe = new JLabel("QUẢN LÝ VÉ");
        lblQLVe.setForeground(new Color(161,0,53));
        lblQLVe.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblQLVe.setBounds(394, 20, 291, 31);
        pnTieuDeQLVe.add(lblQLVe);
        
        JPanel pnQLVe = new JPanel();
        pnQLVe.setBounds(0, 71, 1065, 150);
        pnMain.add(pnQLVe);
        pnQLVe.setLayout(null);

        tbVeThang = new JTable();
        tbVeThang.setBounds(0, 0, 1050, 150);
        JScrollPane sc = new JScrollPane(tbVeThang, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setBounds(0, 0, 1055, 150);
        tbVeThang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg) {
                if(tbVeThang.getSelectedRow()<0)
                    return;
                tfMaVe.setText(tbVeThang.getValueAt(tbVeThang.getSelectedRow(), 5).toString());
                tfBienSoXe.setText(tbVeThang.getValueAt(tbVeThang.getSelectedRow(), 1).toString());
                tfNgayBatDau.setDate(java.sql.Date.valueOf(tbVeThang.getValueAt(tbVeThang.getSelectedRow(), 2).toString()));
            }
        });
        pnQLVe.add(sc,BorderLayout.CENTER);
        
        JPanel pnThongTinVe = new JPanel();
        pnThongTinVe.setBackground(new Color(237,223,179));
        pnThongTinVe.setBounds(0, 225, 1065, 560-225);
        pnMain.add(pnThongTinVe);
        pnThongTinVe.setLayout(null);

        JLabel lblThongTinNhanVien = new JLabel("THÔNG TIN VÉ");
        lblThongTinNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblThongTinNhanVien.setForeground(new Color(161,0,53));
        lblThongTinNhanVien.setBounds(10, 5, 208, 22);
        pnThongTinVe.add(lblThongTinNhanVien);

        JPanel pnThongTinNhap = new JPanel();
        pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
        pnThongTinNhap.setBounds(10, 50, 850, 600);
        pnThongTinVe.add(pnThongTinNhap);
        pnThongTinNhap.setLayout(null);
        
        lblMessage = new JLabel("(*) Không được bỏ trống");
        lblMessage.setForeground(new Color(161,0,53));
        lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblMessage.setBounds(125, 20, 654, 34);
        pnThongTinVe.add(lblMessage);
        
        JLabel lblBatDau = new JLabel("Ngày Đăng Ký:");
        lblBatDau.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblBatDau.setForeground(new Color(161,0,53));
        lblBatDau.setBounds(24, 185, 91, 30);
        pnThongTinNhap.add(lblBatDau);

        tfNgayBatDau = new JDateChooser();
        tfNgayBatDau.setBounds(125, 185, 258, 30);
        tfNgayBatDau.setForeground(new Color(161,0,53));
        tfNgayBatDau.setDateFormatString("yyyy-MM-dd");
        pnThongTinNhap.add(tfNgayBatDau);
        
        JLabel lblBSX = new JLabel("Biển Số Xe:");
        lblBSX.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblBSX.setForeground(new Color(161,0,53));
        lblBSX.setBounds(24, 240, 91, 30);
        pnThongTinNhap.add(lblBSX);

        tfBienSoXe = new JTextField();
        tfBienSoXe.setColumns(10);
        tfBienSoXe.setBounds(125, 240, 258, 31);
        tfBienSoXe.setForeground(new Color(161,0,53));
        pnThongTinNhap.add(tfBienSoXe);
        
        JButton btnSua = new JButton("Sửa");
        btnSua.setIcon(new ImageIcon("icon\\setting.png"));
        btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnSua.setBounds(896, 125, 138, 41);
        btnSua.setForeground(new Color(161,0,53));
        btnSua.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                        Calendar cal = tfNgayBatDau.getCalendar();
                        java.util.Date date = cal.getTime();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String ngayDK = sdf.format(date);
                        VeDTO ve = new VeDTO(
                        tfMaVe.getText(), 
                        tfBienSoXe.getText(),
                        java.sql.Date.valueOf(ngayDK));
                        String result = QLVeBLL.getInstance().changeProcessing(ve);
                        lblMessage.setText(result);
                        reloadResources();
                }
        });
        pnThongTinVe.add(btnSua);
        
        JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(896, 200, 138, 41);
                btnHuy.setForeground(new Color(161,0,53));
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearField();
				reloadResources();
			}
		});
		pnThongTinVe.add(btnHuy);
        
        JButton btnBack = new JButton(new ImageIcon("icon//logout.png"));
                btnBack.setBounds(900, 30, 120, 40);
                btnBack.setText("Back");
                btnBack.setForeground(new Color(161,0,53));
                btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnTieuDeQLVe.add(btnBack);
                btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                                
				jfVeThang.setVisible(false);
				QuanTriHeThongGUI.getInstance().getFrmMain().setVisible(true);
			}
		});
                jfVeThang.repaint();
		jfVeThang.invalidate();
}
}
