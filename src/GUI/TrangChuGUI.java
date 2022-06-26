package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BLL.QLViTriBLL;
import BLL.QLRaVaoBenBLL;
import javax.swing.*;

import com.toedter.calendar.JCalendar;
import java.util.prefs.Preferences;



public class TrangChuGUI {

	private JFrame frmTrangChu;
	private JPanel pnTitle;
	private JPanel pnMenu;
	private JPanel pnMain;
	private JPanel pnTrangChu;
	private JMenuBar mbMenu;
        private int soXe;
	private int soChoTrong;
	
	static TrangChuGUI instance = null;
	
	private TrangChuGUI() {
		
		initialize();
	}
	
	public static TrangChuGUI getInstance() {
		if (instance == null)
			instance = new TrangChuGUI();
		return instance;
	}
	
	public JFrame getFrmTrangChu() {
		return frmTrangChu;
	}
        public void initittle()
        {       pnTitle = new JPanel();
		pnTitle.setBounds(10, 0, 1060, 118);
		pnTrangChu.add(pnTitle);
		pnTitle.setBackground(SystemColor.activeCaption);
		pnTitle.setLayout(null);
                
                JLabel lblSoChoTrong= new JLabel("Số Chỗ Trống: ");
                lblSoChoTrong.setBounds(150, 10, 300, 118);
		lblSoChoTrong.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblSoChoTrong.setForeground(Color.BLACK);
                lblSoChoTrong.setIcon(new ImageIcon("icon\\park.jpg"));
                pnTitle.add(lblSoChoTrong);
                
                soChoTrong=QLViTriBLL.getInstance().isCount();
                JLabel lTSoChoTrong= new JLabel("");
                lTSoChoTrong.setBounds(400, 10, 300, 118);
		lTSoChoTrong.setFont(new Font("Times New Roman", Font.BOLD, 25));
                lTSoChoTrong.setText(soChoTrong+"");
		lTSoChoTrong.setForeground(Color.BLACK);
                pnTitle.add(lTSoChoTrong);
		
		JLabel lblSoXe= new JLabel("Số Xe:");
                lblSoXe.setBounds(700, 10, 300, 118);
		lblSoXe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblSoXe.setForeground(Color.BLACK);
                lblSoXe.setIcon(new ImageIcon("icon\\msd.png"));
                pnTitle.add(lblSoXe);
                
                soXe=QLRaVaoBenBLL.getInstance().SoXe();
                JLabel lTSoXe= new JLabel("");
                lTSoXe.setBounds(900, 10, 300, 118);
		lTSoXe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lTSoXe.setForeground(Color.BLACK);
                lTSoXe.setText(soXe+"");
                pnTitle.add(lTSoXe);
        }
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		//init the container
		frmTrangChu = new JFrame("Quản lý bãi xe");
		frmTrangChu.setBounds(10, 10, 1341, 720);
		frmTrangChu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrangChu.getContentPane().setLayout(null);
		//frmTrangChu.setResizable(false);
		
		pnTrangChu = new JPanel();
		pnTrangChu.setBounds(260, 0, 1065, 681);
		frmTrangChu.getContentPane().add(pnTrangChu);
		pnTrangChu.setLayout(null);
		
		
                
                initittle();
                
		pnMain = new JPanel();
		pnMain.setBackground(SystemColor.inactiveCaptionBorder);
		pnMain.setBounds(10, 121, 1060, 560);
                pnMain.setBackground(SystemColor.activeCaption);
		pnTrangChu.add(pnMain);
		pnMain.setLayout(null);
		
		
		
		JLabel lblTenBaiXe = new JLabel("BÃI XE TOÀN - ĐẠT");
		lblTenBaiXe.setBounds(380, 15, 769, 86);
		lblTenBaiXe.setForeground(Color.RED);
		lblTenBaiXe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnMain.add(lblTenBaiXe);
                
          
		
		JPanel pnLich = new JPanel();
		pnLich.setBackground(SystemColor.controlHighlight);
		pnLich.setBounds(710, 145, 326, 404);
		pnMain.add(pnLich);
		pnLich.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(0, 25, 326, 359);
		pnLich.add(calendar);
		
		JLabel lblNewLabel = new JLabel("Lịch năm:");
		lblNewLabel.setBounds(0, 0, 316, 25);
		pnLich.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblTruong = new JLabel("");
		lblTruong.setIcon(new ImageIcon("icon\\trangchu.jpg"));
		lblTruong.setBounds(12, 145, 680, 404);
		pnMain.add(lblTruong);
		
		
		pnMenu = new JPanel();
		pnMenu.setBackground(SystemColor.activeCaption);
		pnMenu.setBounds(0, 0, 261, 681);
		frmTrangChu.getContentPane().add(pnMenu);
		pnMenu.setLayout(null);
		
		
		//init the control
		mbMenu = new JMenuBar();
		mbMenu.setBounds(2, 2, 259, 679);
		mbMenu.setLayout(new GridLayout(0,1));
		mbMenu.setBackground(SystemColor.textHighlight);
		pnMenu.add(mbMenu);
		JMenuItem mnTrangChu = new JMenuItem("TRANG CHỦ", new ImageIcon("icon\\home.png"));
		mnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		mnTrangChu.setBackground(SystemColor.textHighlight);
		mnTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnTrangChu.setForeground(Color.BLACK);
		mnTrangChu.addActionListener(new ActionListener() {
			
			@Override// sủa de kh m
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				QLTrangChuGUI qlTrangChu=QLTrangChuGUI.getInstance();
				pnMain.add(qlTrangChu.getPnTongQuanQLTrangChu());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		
		JMenuItem mnChaoMung = new JMenuItem("THÔNG TIN CÁ NHÂN");
		mnChaoMung.setForeground(Color.BLACK);
		mnChaoMung.setIcon(new ImageIcon("icon\\taikhoan.png"));
		mnChaoMung.setBackground(SystemColor.textHighlight);
		mnChaoMung.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnChaoMung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				
				QLThongTinCaNhanGUI qlThongtinCaNhan=QLThongTinCaNhanGUI.getInstance();
				qlThongtinCaNhan.loadResources();
				pnMain.add(qlThongtinCaNhan.getPnTongQuanQLChaoMung());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		mbMenu.add(mnChaoMung);
		
		
		mbMenu.add(mnTrangChu);
		
		JMenu mnQLBaiXe = new JMenu("QUẢN LÝ BÃI XE");
		mnQLBaiXe.setHorizontalAlignment(SwingConstants.LEFT);
		mnQLBaiXe.setIcon(new ImageIcon("icon\\chart2.png"));
		mnQLBaiXe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnQLBaiXe.setBackground(SystemColor.textHighlight);
		mnQLBaiXe.setForeground(Color.BLACK);
		mbMenu.add(mnQLBaiXe);
		JMenuItem mnQuanLyKhuVuc = new JMenuItem("         GỬI XE                    ");
		mnQuanLyKhuVuc.setHorizontalAlignment(SwingConstants.LEFT);
		mnQuanLyKhuVuc.setIcon(new ImageIcon("icon\\car2.png"));
		mnQuanLyKhuVuc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnQuanLyKhuVuc.setBackground(SystemColor.inactiveCaptionBorder);
		mnQuanLyKhuVuc.setForeground(SystemColor.menuText);
		mnQLBaiXe.add(mnQuanLyKhuVuc);
		mnQuanLyKhuVuc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				QLKhuVucGUI qlKhuVuc = QLKhuVucGUI.getInstance();
				qlKhuVuc.initialize();
				qlKhuVuc.reloadResources();
				pnMain.add(qlKhuVuc.getPnMain());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		
		JMenuItem mnQuanLyViTriDo=new JMenuItem("         LẤY XE                    ");
		mnQuanLyViTriDo.setHorizontalAlignment(SwingConstants.LEFT);
		mnQuanLyViTriDo.setIcon(new ImageIcon("icon\\Car.png"));
		mnQuanLyViTriDo.setFont(new Font("Times New Roman", Font.BOLD,16));
		mnQuanLyViTriDo.setBackground(SystemColor.inactiveCaptionBorder);
		mnQuanLyViTriDo.setForeground(SystemColor.menuText);
		mnQLBaiXe.add(mnQuanLyViTriDo);
		mnQuanLyViTriDo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				QLRaVaoBenGUI qlRaVaoBen = QLRaVaoBenGUI.getInstance();
                                qlRaVaoBen.initialize();
				qlRaVaoBen.reloadResources();
				pnMain.add(qlRaVaoBen.getPnMain());
				pnMain.revalidate();
				pnMain.repaint();
				
			}
		});
		
		JMenuItem mnSuCo = new JMenuItem("QUẢN LÍ HÓA ĐƠN");
		mnSuCo.setIcon(new ImageIcon("icon\\suco1.png"));
		mnSuCo.setHorizontalAlignment(SwingConstants.LEFT);
		mnSuCo.setForeground(Color.BLACK);
		mnSuCo.setBackground(SystemColor.textHighlight);
		mnSuCo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mbMenu.add(mnSuCo);
		mnSuCo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
                               QLHoaDonGUI QlHoaDon = new QLHoaDonGUI().getInstance();
                               QlHoaDon.initialize();
                               QlHoaDon.reloadResources();
                               pnMain.add(QlHoaDon.getPnMain());
                               frmTrangChu.revalidate();
			       frmTrangChu.repaint();
			}
		});
		
		
		
		
		JMenuItem QlDoanhThu = new JMenuItem("DOANH THU");
		QlDoanhThu.setIcon(new ImageIcon("icon\\phattien.png"));
		QlDoanhThu.setHorizontalAlignment(SwingConstants.LEFT);
		QlDoanhThu.setForeground(Color.BLACK);
		QlDoanhThu.setBackground(SystemColor.textHighlight);
		QlDoanhThu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mbMenu.add(QlDoanhThu);
		QlDoanhThu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				DoanhThuGUI qlDoanhThu = DoanhThuGUI.getInstance();
				pnMain.add(qlDoanhThu.getPnTongQuanQLDT());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		
		
		
              
		
	}
}
