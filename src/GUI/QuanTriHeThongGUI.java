package GUI;

import BLL.ThongTinCaNhanBLL;
import DTO.NhanVienDTO;
import GUI.QuanTriHeThongGUI;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class QuanTriHeThongGUI {
    private JFrame frmMain;
    private JMenuBar mbMenu;
    private JPanel pnMain;
    private JPanel pnMenu;
    private JButton btnQuanlynhansu;
    private JButton btnQuanlyBaiXe;
    private JButton btnQuanlyDoanhThu;
//  private JButton btnQuanlyLuong;

    NhanVienDTO nv;

    private static QuanTriHeThongGUI instance = null;
    private QuanTriHeThongGUI(){
        init();
    }

    public static QuanTriHeThongGUI getInstance() {
        if (instance == null){
            instance = new QuanTriHeThongGUI();
        }
        return instance;
    }

    public JFrame getFrmMain() {
        return frmMain;
    }

    void init() {
        frmMain = new JFrame("Quản lý bãi xe");
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setBounds(0, 0, 1100, 600);
        frmMain.getContentPane().setLayout(null);

        pnMenu = new JPanel();
        pnMenu.setBackground(new Color(237,223,179));
        pnMenu.setBounds(0, 0, 1065, 560);
        frmMain.getContentPane().add(pnMenu);
        pnMenu.setLayout(null);

        JLabel lbltitle=new JLabel("QUẢN LÝ HỆ THỐNG");
        lbltitle.setBounds(400,50,400,50);
        lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lbltitle.setForeground(new Color(161,0,53));
        pnMenu.add(lbltitle);

        JLabel lblHOTRO=new JLabel("Mã số doanh nghiệp 1241241241 do Sở Kế hoạch Đầu tư Hà Nội cấp lần 1 ngày 20/06/2022");
        lblHOTRO.setBounds(50,500,800,50);
        lblHOTRO.setForeground(new Color(161,0,53));
        lblHOTRO.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnMenu.add(lblHOTRO);

         JLabel lblHOTRO2=new JLabel("");
        lblHOTRO2.setBounds(50,450,800,50);
        lblHOTRO2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblHOTRO2.setIcon(new ImageIcon("icon//logo2.png"));
        pnMenu.add(lblHOTRO2);

        btnQuanlyBaiXe=new JButton("QUẢN LÝ BÃI XE");
        btnQuanlyBaiXe.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnQuanlyBaiXe.setIcon(new ImageIcon("icon//home.png"));
        btnQuanlyBaiXe.setBounds(150, 150, 300, 50);
        btnQuanlyBaiXe.setForeground(new Color(161,0,53));
        btnQuanlyBaiXe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMain.setVisible(false);
                TrangChuGUI.getInstance().getFrmTrangChu().setVisible(true);
            }
        });
        pnMenu.add(btnQuanlyBaiXe);
        pnMenu.setBackground(new Color(237,223,179));
        frmMain.repaint();
        frmMain.invalidate();

        btnQuanlynhansu=new JButton("QUẢN LÝ NHÂN SỰ");
        btnQuanlynhansu.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnQuanlynhansu.setIcon(new ImageIcon("icon//people.png"));
        btnQuanlynhansu.setBounds(650, 150, 300, 50);
        btnQuanlynhansu.setForeground(new Color(161,0,53));
        btnQuanlynhansu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMain.setVisible(false);
                QLNhanVienGUI.getInstance().getFrmNhanVien().setVisible(true);
            }
        });
        pnMenu.add(btnQuanlynhansu);
        pnMenu.setBackground(new Color(237,223,179));
        frmMain.repaint();
        frmMain.invalidate();

        JButton btnQuanlyLuong = new JButton("ĐĂNG KÝ VÉ THÁNG");
                btnQuanlyLuong.setFont(new Font("Times New Roman", Font.BOLD, 17));
                btnQuanlyLuong.setIcon(new ImageIcon("icon//muontra.png"));
		btnQuanlyLuong.setBounds(150, 300, 300, 50);
                btnQuanlyLuong.setForeground(new Color(161,0,53));
		btnQuanlyLuong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmMain.setVisible(false);
                                QLVeThangGUI.getInstances().reloadResources();
                                QLVeThangGUI.getInstances().getFormVe().setVisible(true);
                                
                                			}
		});
                pnMenu.add(btnQuanlyLuong);
		pnMenu.setBackground(SystemColor.activeCaption);
		frmMain.repaint();
		frmMain.invalidate();

        btnQuanlyDoanhThu=new JButton("QUẢN LÝ DOANH THU");
        btnQuanlyDoanhThu.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnQuanlyDoanhThu.setIcon(new ImageIcon("icon//System.png"));
        btnQuanlyDoanhThu.setBounds(650, 300, 300, 50);
        btnQuanlyDoanhThu.setForeground(new Color(161,0,53));
        btnQuanlyDoanhThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMain.setVisible(false);
                QLDoanhThuGUI.getInstance().getPnMain().setVisible(true);
            }
        });
        pnMenu.add(btnQuanlyDoanhThu);
        pnMenu.setBackground(new Color(237,223,179));
        frmMain.repaint();
        frmMain.invalidate();


        JButton btnThoat = new JButton("Thoát");
        btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnThoat.setIcon(new ImageIcon("icon//logout.png"));
        btnThoat.setBounds(896, 500, 138, 41);
        btnThoat.setForeground(new Color(161,0,53));
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nv = ThongTinCaNhanBLL.getInstance().getNhanVien();
                frmMain.setVisible(false);
                QLDangNhapGUI.getInstance().getFrame().setVisible(true);
            }
        });
        pnMenu.add(btnThoat);
        pnMenu.setBackground(new Color(237,223,179));
        frmMain.repaint();
        frmMain.invalidate();
    }
}
