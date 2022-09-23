/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.HongHocBLL;
import BLL.QLNhanVienBLL;
import DTO.HongHocDTO;
import DTO.NhanVienDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
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
public class HongHocGUI {
    private JTable tbHongHoc;
    private JTextField tfMaHH;
    private JTextField tfTenKH;
    private JTextField tfSDT;
    private JTextField tfBienSoXe;
    private JTextField tfTinhTrangXe;
    private JDateChooser tfNgayHH;
    private JLabel lblMessage;
    private JFrame jFHongHoc;
    
    private JPanel pnTongQLHH;
    
    static  HongHocGUI instance=null;
    private HongHocGUI(){
        initialize();
        loadResources();
    }
    
    public void loadResources(){
        tbHongHoc.setModel(HongHocBLL.getInstance().getResources());
    }
    
    public void reloadResources(){
        DefaultTableModel dm=(DefaultTableModel) tbHongHoc.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        tbHongHoc.setModel(HongHocBLL.getInstance().reloadResources());
    }
    
    public static HongHocGUI getInstance(){
        if(instance==null){
            instance= new HongHocGUI();
        }
        return instance;
    }
    
    public JPanel getPnTongQLHH(){
        return pnTongQLHH;
    }
    
    public JFrame getFormHH(){
        return jFHongHoc;
    }
    
    private void clearField(){
        tfTenKH.setText("");
        tfSDT.setText("");
        tfBienSoXe.setText("");
        tfTinhTrangXe.setText("");
        tfNgayHH.setDate(new Date());
    }
    
    private void initialize(){
        jFHongHoc = new JFrame("Quản lý Hỏng Hóc");
        jFHongHoc.setBounds(0, 0, 1065, 600);
        jFHongHoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFHongHoc.getContentPane().setLayout(null);
        
        pnTongQLHH = new JPanel();
        pnTongQLHH.setBackground(new Color(237,223,179));
        pnTongQLHH.setBounds(0, 0, 1065, 560);
        pnTongQLHH.setLayout(null);
        jFHongHoc.getContentPane().add(pnTongQLHH);
        
        JPanel pnTieuDeQLHH = new JPanel();
        pnTieuDeQLHH.setBackground(new Color(237,223,179));
        pnTieuDeQLHH.setBounds(0, 0, 1065, 71);
        pnTongQLHH.add(pnTieuDeQLHH);
        pnTieuDeQLHH.setLayout(null);
        
        JLabel lblQLHH = new JLabel("QUẢN LÝ HỎNG HÓC");
        lblQLHH.setForeground(new Color(161,0,53));
        lblQLHH.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblQLHH.setBounds(394, 20, 291, 31);
        pnTieuDeQLHH.add(lblQLHH);

        JPanel pnQLHH = new JPanel();
        pnQLHH.setBounds(0, 71, 1065, 150);
        pnTongQLHH.add(pnQLHH);
        pnQLHH.setLayout(null);
        
        tbHongHoc= new JTable();
        tbHongHoc.setBounds(0, 0, 1050, 150);
        JScrollPane sc = new JScrollPane(tbHongHoc, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setBounds(0, 0, 1055, 150);
        tbHongHoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(tbHongHoc.getSelectedRow()<0)
                    return;
                tfMaHH.setText(tbHongHoc.getValueAt(tbHongHoc.getSelectedRow(), 0).toString());
                tfTenKH.setText(tbHongHoc.getValueAt(tbHongHoc.getSelectedRow(), 1).toString());
                tfSDT.setText(tbHongHoc.getValueAt(tbHongHoc.getSelectedRow(), 2).toString());
                tfBienSoXe.setText(tbHongHoc.getValueAt(tbHongHoc.getSelectedRow(), 3).toString());
                tfTinhTrangXe.setText(tbHongHoc.getValueAt(tbHongHoc.getSelectedRow(), 4).toString());
                tfNgayHH.setDate(java.sql.Date.valueOf(tbHongHoc.getValueAt(tbHongHoc.getSelectedRow(), 5).toString()));
            }
        });
        pnQLHH.add(sc,BorderLayout.CENTER);
        
        JPanel pnThongTinHH = new JPanel();
        pnThongTinHH.setBackground(new Color(237,223,179));
        pnThongTinHH.setBounds(0, 225, 1065, 560-225);
        pnTongQLHH.add(pnThongTinHH);
        pnThongTinHH.setLayout(null);

        JLabel lblThongHH = new JLabel("THÔNG TIN NHÂN VIÊN");
        lblThongHH.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblThongHH.setForeground(new Color(161,0,53));
        lblThongHH.setBounds(10, 5, 208, 22);
        pnThongTinHH.add(lblThongHH);

        JPanel pnThongTinNhap = new JPanel();
        pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
        pnThongTinNhap.setBounds(10, 50, 850, 600);
        pnThongTinHH.add(pnThongTinNhap);
        pnThongTinNhap.setLayout(null);

        lblMessage = new JLabel("(*) Không được bỏ trống");
        lblMessage.setForeground(new Color(161,0,53));
        lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblMessage.setBounds(125, 20, 654, 34);
        pnThongTinHH.add(lblMessage);
        
        JLabel lblTenKH = new JLabel("Tên khách hàng:*");
        lblTenKH.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblTenKH.setForeground(new Color(161,0,53));
        lblTenKH.setBounds(24, 35, 100, 30);
        pnThongTinNhap.add(lblTenKH);

        tfTenKH = new JTextField();
        tfTenKH.setBounds(125, 35, 258, 31);
        tfTenKH.setForeground(new Color(161,0,53));
        pnThongTinNhap.add(tfTenKH);
        tfTenKH.setColumns(10);
        
        JLabel lblDT= new JLabel("Số điện thoại:*");
        lblDT.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblDT.setForeground(new Color(161,0,53));
        lblDT.setBounds(24, 90, 91, 30);
        pnThongTinNhap.add(lblDT);

        tfSDT = new JTextField();
        tfSDT.setBounds(125, 90, 258, 31);
        tfSDT.setForeground(new Color(161,0,53));
        pnThongTinNhap.add(tfSDT);
        tfSDT.setColumns(10);
        
        JLabel lblBSX = new JLabel("Biển số xe:");
        lblBSX.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblBSX.setForeground(new Color(161,0,53));
        lblBSX.setBounds(24, 145, 91, 30);
        pnThongTinNhap.add(lblBSX);

        tfBienSoXe = new JTextField();
        tfBienSoXe.setColumns(10);
        tfBienSoXe.setBounds(125, 145, 258, 31);
        tfBienSoXe.setForeground(new Color(161,0,53));
        pnThongTinNhap.add(tfBienSoXe);
        
        
        JLabel lblNgayHH = new JLabel("Ngày Báo Hỏng:");
        lblNgayHH.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNgayHH.setForeground(new Color(161,0,53));
        lblNgayHH.setBounds(24, 200, 100, 30);
        pnThongTinNhap.add(lblNgayHH);

        tfNgayHH = new JDateChooser();
        tfNgayHH.setBounds(125, 200, 258, 30);
        tfNgayHH.setForeground(new Color(161,0,53));
        tfNgayHH.setDateFormatString("yyyy-MM-dd");
        pnThongTinNhap.add(tfNgayHH);
                
        JLabel lblTTX = new JLabel("Tình trạng xe*");
        lblTTX.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblTTX.setForeground(new Color(161,0,53));
        lblTTX.setBounds(420, 35, 91, 30);
        pnThongTinNhap.add(lblTTX);
        
        tfTinhTrangXe = new JTextField();
        tfTinhTrangXe.setColumns(10);
        tfTinhTrangXe.setBounds(512, 35, 258, 200);
        tfTinhTrangXe.setForeground(new Color(161,0,53));
        pnThongTinNhap.add(tfTinhTrangXe);
        
         JButton btnBack = new JButton(new ImageIcon("icon//logout.png"));
                btnBack.setBounds(900, 30, 120, 40);
                btnBack.setText("Back");
                btnBack.setForeground(new Color(161,0,53));
                btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnTieuDeQLHH.add(btnBack);
                btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                                
				jFHongHoc.setVisible(false);
				QuanTriHeThongGUI.getInstance().getFrmMain().setVisible(true);
			}
		});
                jFHongHoc.repaint();
		jFHongHoc.invalidate();
                
		
		tfMaHH = new JTextField();
		tfMaHH.setColumns(10);
		tfMaHH.setBounds(521, 130, 0, 0);
                tfMaHH.setForeground(new Color(161,0,53));
		pnThongTinNhap.add(tfMaHH);
        
                JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(896, 48, 138, 41);
                btnThem.setForeground(new Color(161,0,53));
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maHH;
                                if(tbHongHoc.getRowCount()<=0)
                                {
                                    maHH="HH01";
                                    
                                }
                                else 
                                {
                                    maHH="HH0"+(1+Integer.parseInt(tbHongHoc.getValueAt(tbHongHoc.getRowCount()-1,0).toString().substring(3)));
                                    
                                }
                                Calendar cal = tfNgayHH.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngayBH = sdf.format(date);
                                HongHocDTO hh= new HongHocDTO(maHH,tfTenKH.getText(),
                                        tfSDT.getText(),tfBienSoXe.getText(),tfTinhTrangXe.getText(),java.sql.Date.valueOf(ngayBH));
                               String result = HongHocBLL.getInstance().addProcessing(hh);
                               lblMessage.setText(result);
                               reloadResources();
                               
			}
		});
		pnThongTinHH.add(btnThem);
                
        JButton btnSua = new JButton("Sửa");
        btnSua.setIcon(new ImageIcon("icon\\setting.png"));
        btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnSua.setBounds(896, 125, 138, 41);
        btnSua.setForeground(new Color(161,0,53));
        btnSua.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                        Calendar cal = tfNgayHH.getCalendar();
                        java.util.Date date = cal.getTime();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String ngayHH = sdf.format(date);
                        HongHocDTO hh = new HongHocDTO(
                        tfMaHH.getText(), 
                        tfTenKH.getText(),
                        tfSDT.getText(),
                        tfBienSoXe.getText(),
                        tfTinhTrangXe.getText(),
                        java.sql.Date.valueOf(ngayHH));
                        String result = HongHocBLL.getInstance().changeProcessing(hh);
                        lblMessage.setText(result);
                        reloadResources();
                }
        });
        pnThongTinHH.add(btnSua);
        
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
        pnThongTinHH.add(btnHuy);
        
        JButton btnXoa = new JButton("Xóa");
        btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
        btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnXoa.setBounds(896, 275, 138, 41);
        btnXoa.setForeground(new Color(161,0,53));
        btnXoa.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                        String msg = HongHocBLL.getInstance().deleteProcessing(tbHongHoc.getValueAt(tbHongHoc.getSelectedRow(), 0).toString());
                        lblMessage.setText(msg);
                        reloadResources();
                        clearField();
                }
        });
        pnThongTinHH.add(btnXoa);
}
}
