package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.toedter.calendar.JCalendar;

public class QLTrangChuGUI {

	private JPanel pnTongQuanQLTrangChu;
	

	static QLTrangChuGUI instance=null;
	
	public QLTrangChuGUI() {
		initialize();
	}
	
	public static QLTrangChuGUI getInstance() {
		if(instance == null)
			instance = new QLTrangChuGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLTrangChu() {
		return pnTongQuanQLTrangChu;
	}
	private void initialize() {
		
		
		pnTongQuanQLTrangChu = new JPanel();
		pnTongQuanQLTrangChu.setBounds(0, 0, 1065, 560);
		pnTongQuanQLTrangChu.setLayout(null);
               
		
		
		
		JPanel pnBaiXe= new JPanel();
		pnBaiXe.setBackground(SystemColor.inactiveCaptionBorder);
		pnBaiXe.setBounds(0, 0, 1065, 560);
		pnTongQuanQLTrangChu.add(pnBaiXe);
		pnBaiXe.setBackground(Color.WHITE);
                
                
		JLabel lblLoGoBaiXe = new JLabel("");
		lblLoGoBaiXe.setBounds(0, 100, 1065, 460);
		lblLoGoBaiXe.setIcon(new ImageIcon("icon\\HeThong.png"));
                
		pnBaiXe.add(lblLoGoBaiXe);
		
		JLabel lblTenBaiXe = new JLabel("BÃI XE LUXURY");
		lblTenBaiXe.setBounds(200, 25, 769, 86);
		lblTenBaiXe.setForeground(Color.RED);
		lblTenBaiXe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnBaiXe.add(lblTenBaiXe);
		
		
		
		
	}
}
