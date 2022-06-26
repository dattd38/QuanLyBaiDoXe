package GUI;
import BLL.BaoCaoBLL;
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
import DTO.RaVaoBenDTO;
import static GUI.HoaDonGUI.instance;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DoanhThuGUI {
static DoanhThuGUI instance = null;
private JPanel pnMain;
public JTable tbDoanhThu;
private JDateChooser tfTuNgay;
private JDateChooser tfDenNgay;
private Button btnThongKe;
private Button btnLap;
private JLabel lblTongXeVao;
private JLabel lTTongXeVao;
private JLabel lblTongXeRa;
private JLabel lTTongXeRa;
private JLabel lblTongTien;
private JLabel lTTongTien;
private JPanel pnQLDoanhThu;
RaVaoBenDTO rvb;
                
 
                private DoanhThuGUI(){
			initialize();
			loadResources();
                       
		}
                      
                public void reloadResources() {
           
	        }       
             
		private void loadResources() {
			
		}
		
		private void refreshDataTable() {
			
		}
		
		public static DoanhThuGUI getInstance() {
			if(instance == null)
				instance = new DoanhThuGUI();
			return instance;
		}
		
		public JPanel getPnTongQuanQLDT() {
			return pnMain;
		}
                int count=0;
  
    @SuppressWarnings("deprecation")
    private void initialize() {
                pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 0, 1065, 560);
		pnMain.setBackground(Color.WHITE);
                
                JPanel pnTitle = new JPanel();
		pnTitle.setLayout(null);
		pnTitle.setBackground(SystemColor.activeCaption);
		pnTitle.setBounds(0, 0, 1078, 110);
		pnMain.add(pnTitle);
		
		JPanel pnDoanhThu=new JPanel();
                pnDoanhThu.setLayout(null);
		pnDoanhThu.setBackground(SystemColor.activeCaption);
		pnDoanhThu.setBounds(0, 112, 1065, 350);
		pnMain.add(pnDoanhThu);
                
                pnQLDoanhThu=new JPanel();
                pnQLDoanhThu.setLayout(null);
		pnQLDoanhThu.setBackground(SystemColor.activeCaption);
		pnQLDoanhThu.setBounds(0, 462, 1065, 560-462);
		pnMain.add(pnQLDoanhThu);
                
                JLabel lblTitle = new JLabel("DOANH THU");
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBounds(375, 10, 350, 39);
		pnTitle.add(lblTitle);
                
                JLabel lblThang = new JLabel();
		lblThang.setForeground(Color.RED);
		lblThang.setHorizontalAlignment(SwingConstants.CENTER);
		lblThang.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblThang.setBounds(550, 23, 239, 39);
		pnTitle.add(lblThang);
                

                
                JLabel lbTuNgay = new JLabel("Từ Ngày:");
		lbTuNgay.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbTuNgay.setBounds(15, 70, 80, 31);
		pnTitle.add(lbTuNgay);
		
                JDateChooser tfTuNgay = new JDateChooser();
		tfTuNgay.setBounds(90, 70, 120, 28);
		tfTuNgay.setFont(new Font("Times New Roman", Font.BOLD, 16));
                tfTuNgay.setDateFormatString("dd-MM-yyyy");
		pnTitle.add(tfTuNgay);
                
                JLabel lbDenNgay = new JLabel("Đến Ngày:");
		lbDenNgay.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbDenNgay.setBounds(215, 70, 80, 31);
		pnTitle.add(lbDenNgay);
		
                tfDenNgay = new JDateChooser();
		tfDenNgay.setBounds(300, 70, 120, 28);
		tfDenNgay.setFont(new Font("Times New Roman", Font.BOLD, 16));
                tfDenNgay.setDateFormatString("dd-MM-yyyy");
		pnTitle.add(tfDenNgay);
                
                btnThongKe = new Button(" Thống Kê ");
                btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 16));
                btnThongKe.setBounds(750, 70, 100, 28);
                btnThongKe.setForeground(Color.white);
                btnThongKe.setBackground(Color.MAGENTA);
                btnThongKe.addActionListener(new ActionListener() {
                    @Override
                  
                   public void actionPerformed(ActionEvent arg0) {
                       count++;
                       SimpleDateFormat fm=new SimpleDateFormat("dd-MM-yyyy");
                       Calendar   cal = Calendar.getInstance();
                       java.util.Date date1 = tfTuNgay.getDate();
                       java.util.Date date2 = tfDenNgay.getDate();
	               String startDate = fm.format(date1);
                       String endDate   = fm.format(date2);
                                         
                       

		DefaultTableModel dtm = BaoCaoBLL.getInstance().thongKe(startDate,endDate);
                tbDoanhThu = new JTable();
		tbDoanhThu.setBounds(0, 0, 1050, 350);
		JScrollPane sc = new JScrollPane(tbDoanhThu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1055, 350);
                tbDoanhThu.setModel(dtm);
                int count1=tbDoanhThu.getRowCount();
                int TongXeVao=0;
                int TongXeRa=0;
                int TongTien=0;
                for(int i=0;i<count1;i++)
                {
                   TongXeVao = TongXeVao+Integer.parseInt(tbDoanhThu.getValueAt(i, 1).toString());
                   TongXeRa = TongXeRa+Integer.parseInt(tbDoanhThu.getValueAt(i, 2).toString());                
                   TongTien= TongTien+Integer.parseInt(tbDoanhThu.getValueAt(i, 3).toString());
                }
                
                if(count==1)
                {
                lTTongXeVao= new JLabel();
		lTTongXeVao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lTTongXeVao.setBounds(460, 30, 100, 50);
                lTTongXeVao.setText("");
		pnQLDoanhThu.add(lTTongXeVao);
                lTTongXeVao.setVisible(true);
               
                lTTongXeRa= new JLabel();
		lTTongXeRa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lTTongXeRa.setBounds(730, 30, 100, 50);
                lTTongXeRa.setText("");
		pnQLDoanhThu.add(lTTongXeRa);
                lTTongXeRa.setVisible(true);
                
                lTTongTien= new JLabel();
		lTTongTien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lTTongTien.setBounds(930,30,250, 50);
                lTTongTien.setText("");
                pnQLDoanhThu.add(lTTongTien);
                lTTongTien.setVisible(true);
                }
                lTTongXeVao.setText(TongXeVao+"");
                lTTongXeRa.setText(TongXeRa+"");
                lTTongTien.setText(TongTien+" VNĐ");
                lblTongXeVao.setVisible(true);
                lblTongXeRa.setVisible(true);
                lblTongTien.setVisible(true);
               
		tbDoanhThu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
			}
			
		});
		pnDoanhThu.add(sc,BorderLayout.CENTER);
		
                
                    }
                });
                pnTitle.add(btnThongKe);
                
                btnLap = new Button(" Lập ");
                btnLap.setFont(new Font("Times New Roman", Font.BOLD, 16));
                btnLap.setBounds(900, 70, 100, 28);
                btnLap.setForeground(Color.white);
                btnLap.setBackground(Color.MAGENTA);
                btnLap.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    BaoCaoBLL.getInstance().lapBaoCao();
                
                    }
                });
                pnTitle.add(btnLap);
                
                
                lblTongXeVao= new JLabel("Tổng Xe Vào   : ");
		lblTongXeVao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTongXeVao.setBounds(310, 30, 150, 50);
		pnQLDoanhThu.add(lblTongXeVao);
                lblTongXeVao.setVisible(false);
                
                lblTongXeRa= new JLabel("Tổng Xe Ra   : ");
		lblTongXeRa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTongXeRa.setBounds(560, 30, 150, 50);
		pnQLDoanhThu.add(lblTongXeRa);
                lblTongXeRa.setVisible(false);
                
                lblTongTien= new JLabel("Tổng Tiền  : ");
		lblTongTien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTongTien.setBounds(830, 30, 100, 50);
		pnQLDoanhThu.add(lblTongTien);
                lblTongTien.setVisible(false);
                
    }
 
}

