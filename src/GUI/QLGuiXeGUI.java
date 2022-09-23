package GUI;

import BLL.QLNhanVienBLL;
import BLL.QLRaVaoBenBLL;
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
import java.sql.Date;
import BLL.QLVeBLL;
import BLL.QLViTriBLL;
import Controller.VeDAL;
import DTO.NhanVienDTO;
import DTO.RaVaoBenDTO;
import DTO.VeDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JFrame;



public final class QLGuiXeGUI {
    static QLGuiXeGUI instance = null;
    private static String bienSoXe;
    private JPanel pnMain;
    private JTable tbViTriTrong;
    private JTextField tfTenViTri;
    private JTextField tfRavaoBen;
    private JTextField tfMaViTri;
    private JTextField tfBienSoXe;
    private JDateChooser jdNgayVao;
    private JRadioButton rdbtnTrong;
    private JLabel ltNgayVao;
    private JLabel lblMessage;
    private JLabel lblTenKhuVuc;
    private JLabel lTTenKhuVuc;
    private JLabel lblMaVe;
    private JTextField lTMaVe;
    private JLabel lblTenViTri;
    private JLabel lTTenViTri;
    private JLabel lblBienSoXe;
    private JLabel lblNgayVao;
    private JLabel lblThongBao;
    private JComboBox<String> cbbMaVe;
    
    private boolean isEdit = true;
    private JTextField tfTimKiem;

    public QLGuiXeGUI(String tenKhuVuc) {
        initialize(tenKhuVuc);
        loadResources(tenKhuVuc);
    }

    public void loadResources(String tenKhuVuc) {
        tbViTriTrong.setModel(QLViTriBLL.getInstance().getResources(tenKhuVuc));
    }

    public static QLGuiXeGUI getInstance(String tenKhuVuc) {
        if (instance == null)
                instance = new QLGuiXeGUI(tenKhuVuc);
        return instance;
    }


    public JPanel getPnMain() {
        return pnMain;
    }

    public void reloadResources(String tenKhuVuc) {
        DefaultTableModel dm = (DefaultTableModel) tbViTriTrong.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        tbViTriTrong.setModel(QLViTriBLL.getInstance().reloadResources(tenKhuVuc));
    }

    private void setStateForTexfeild() {
        tfMaViTri.setEditable(isEdit);
    }

    private void clearField() {
        lTTenViTri.setText("");
        tfBienSoXe.setText("");

        cbbMaVe.setSelectedIndex(0);
    }

    @SuppressWarnings("deprecation")
    public void initialize(String tenKhuVuc) {
        pnMain = new JPanel();
        pnMain.setLayout(null);
        pnMain.setBounds(0, 0, 1065, 560);
        pnMain.setBackground(Color.WHITE);

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(null);
        pnTitle.setBackground(new Color(237,223,179));
        pnTitle.setBounds(0, 0, 1078, 90);
        pnMain.add(pnTitle);

        JPanel pnDanhSachKhuVuc = new JPanel();
        pnDanhSachKhuVuc.setLayout(null);
        pnDanhSachKhuVuc.setBackground(new Color(237,223,179));
        pnDanhSachKhuVuc.setBounds(0, 92, 300, 468);
        pnMain.add(pnDanhSachKhuVuc);

        JPanel pnThongTinKhuVuc = new JPanel();
        pnThongTinKhuVuc.setLayout(null);
        pnThongTinKhuVuc.setBackground(new Color(237,223,179));
        pnThongTinKhuVuc.setBounds(303, 92, 770, 468);
        pnMain.add(pnThongTinKhuVuc);

        // add control
        // control of Title
        JLabel lblTitle = new JLabel("GỬI XE");
        lblTitle.setForeground(new Color(161,0,53));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblTitle.setBounds(419, 11, 239, 39);
        lblTitle.setForeground(new Color(161,0,53));
        pnTitle.add(lblTitle);

        // control cho danh sach
        tbViTriTrong = new JTable();
        tbViTriTrong.setBounds(0, 0, 300, 468);
        JScrollPane sc = new JScrollPane(tbViTriTrong, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setBounds(0, 0, 300, 468);
        tbViTriTrong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(tbViTriTrong.getSelectedRow()<0)
                    return ;
                lTTenViTri.setText(tbViTriTrong.getValueAt(tbViTriTrong.getSelectedRow(), 0).toString());

            }
        });
        tbViTriTrong.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnDanhSachKhuVuc.add(sc, BorderLayout.CENTER);

        lblThongBao = new JLabel("(*) Không được bỏ trống ");
        lblThongBao.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        lblThongBao.setForeground(new Color(161,0,53));
        lblThongBao.setBounds(50, 35, 300, 40);
        pnThongTinKhuVuc.add(lblThongBao);

        JLabel lblMaVe = new JLabel("Mã Vé          : ");
        lblMaVe.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblMaVe.setBounds(50, 100, 140, 40);
        lblMaVe.setForeground(new Color(161,0,53));
        pnThongTinKhuVuc.add(lblMaVe);

        cbbMaVe = new JComboBox<String>();
        ArrayList<VeDTO> dsVe = new ArrayList<VeDTO>();
        dsVe=VeDAL.getInstance().reloadResources();
        cbbMaVe.setBounds(200, 100, 140, 30);
        cbbMaVe.setForeground(new Color(161,0,53));
        for (VeDTO veDTO : dsVe) {
            if(veDTO.getTinhTrangVe().equals("ĐANG SỬ DỤNG")) {
                    continue;
            }
            if(veDTO.getBienSoXe()!=null){
                continue;
            }
            cbbMaVe.addItem(veDTO.getMaVe());
        }
        pnThongTinKhuVuc.add(cbbMaVe);

        JLabel lblTenKhuVuc = new JLabel("Tên Khu Vực : ");
        lblTenKhuVuc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTenKhuVuc.setForeground(new Color(161,0,53));
        lblTenKhuVuc.setBounds(400, 100, 140, 40);
        pnThongTinKhuVuc.add(lblTenKhuVuc);

        lTTenKhuVuc = new JLabel(tenKhuVuc);
        lTTenKhuVuc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lTTenKhuVuc.setForeground(new Color(161,0,53));
        lTTenKhuVuc.setBounds(550, 100, 140, 40);
        pnThongTinKhuVuc.add(lTTenKhuVuc);

        lblNgayVao = new JLabel("Ngày Vào    : ");
        lblNgayVao.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNgayVao.setForeground(new Color(161,0,53));
        lblNgayVao.setBounds(50, 190, 140, 40);
        pnThongTinKhuVuc.add(lblNgayVao);

        ltNgayVao = new JLabel("*");
       // ltNgayVao = new JDateChooser();
        ltNgayVao.setBounds(200, 190, 140, 40);
        ltNgayVao.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ltNgayVao.setForeground(new Color(161,0,53));
        SimpleDateFormat fm=new SimpleDateFormat("dd-MM-yyyy");
        Calendar   cal = Calendar.getInstance();
        java.util.Date date = cal.getTime();
        ltNgayVao.setText(fm.format(date));

        pnThongTinKhuVuc.add(ltNgayVao);

        lblTenViTri = new JLabel("Tên Vị Trí       : ");
        lblTenViTri.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTenViTri.setForeground(new Color(161,0,53));
        lblTenViTri.setBounds(400, 190, 140, 40);
        pnThongTinKhuVuc.add(lblTenViTri);

        lTTenViTri = new JLabel("Chọn Vị Trí");
        lTTenViTri.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lTTenViTri.setForeground(new Color(161,0,53));
        lTTenViTri.setBounds(550, 190, 140, 40);
        pnThongTinKhuVuc.add(lTTenViTri);

        lblBienSoXe = new JLabel("Biển Số Xe   : ");
        lblBienSoXe.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblBienSoXe.setForeground(new Color(161,0,53));
        lblBienSoXe.setBounds(50, 280, 140, 40);
        pnThongTinKhuVuc.add(lblBienSoXe);

        tfBienSoXe = new JTextField();
        tfBienSoXe.setBounds(200, 280, 140, 30);
        tfBienSoXe.setForeground(new Color(161,0,53));
        tfBienSoXe.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pnThongTinKhuVuc.add(tfBienSoXe);

        Button btnLap = new Button(" Lập ");
        btnLap.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnLap.setBounds(300, 370, 150, 50);
        btnLap.setForeground(Color.white);
        btnLap.setBackground(new Color(161,0,53));
        btnLap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{      
                    SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
                    Calendar   cal = Calendar.getInstance();
                    java.util.Date date = cal.getTime();
                    String ngayvao = fm.format(date);
                    RaVaoBenDTO rvb= new RaVaoBenDTO(cbbMaVe.getSelectedItem().toString(), lTTenViTri.getText(),
                    lTTenKhuVuc.getText(), tfBienSoXe.getText(), Date.valueOf(ngayvao));
                    String result = QLRaVaoBenBLL.getInstance().addProcessing(rvb);
                    lblThongBao.setText(result);
                    if(result.equals("Xe Vào Thành Công")){   
                    cbbMaVe.removeItem(cbbMaVe.getSelectedItem());
                    reloadResources(tenKhuVuc);
                    TrangChuGUI.getInstance().initittle();
                    clearField();
                    }
                }   
               catch(Exception ex)
               {
                   ex.printStackTrace();
               }
            }
        });
        pnThongTinKhuVuc.add(btnLap);
        
        JButton btnTroVe = new JButton("Trở về");
        btnTroVe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                pnMain.removeAll();
                QLKhuVucGUI qlKhuVuc = QLKhuVucGUI.getInstance();
                qlKhuVuc.initialize();
                qlKhuVuc.reloadResources();
                pnMain.add(qlKhuVuc.getPnMain());
                pnMain.revalidate();
                pnMain.repaint();
                }
        });
        btnTroVe.setIcon(new ImageIcon("icon\\logout.png"));
        btnTroVe.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnTroVe.setBounds(570, 410, 168, 41);
        btnTroVe.setForeground(new Color(161,0,53));
        pnThongTinKhuVuc.add(btnTroVe);
        
        
        JButton btnVeThang = new JButton("Vé tháng");
        btnVeThang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                pnMain.removeAll();
                QLGuiXeVTGUI qlGuiXeVT = QLGuiXeVTGUI.getInstance(tenKhuVuc);
                qlGuiXeVT.initialize(tenKhuVuc);
                qlGuiXeVT.reloadResources(tenKhuVuc);
                pnMain.add(qlGuiXeVT.getPnMain());
                pnMain.revalidate();
                pnMain.repaint();
                }
        });
        btnVeThang.setIcon(new ImageIcon("icon\\ticket.png"));
        btnVeThang.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVeThang.setBounds(20, 410, 168, 41);
        btnVeThang.setForeground(new Color(161,0,53));
        pnThongTinKhuVuc.add(btnVeThang);
    }
    
    
}
