package GUI;

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

import BLL.QLKhuVucBLL;
import BLL.QLViTriBLL;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class QLDoanhThuGUI {
	static QLDoanhThuGUI instance = null;
	private JPanel pnMain;
        private JFrame jfMain;
	private JTable tbViTri;
	private JTextField tfTenViTri;
	private JTextField tfMaViTri;
	private JRadioButton rdbtnTrong;
	private JLabel lblMessage;

	
	private boolean isEdit = true;
	private JTextField tfTimKiem;
        
        
        public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ DOANH THU",
                "THÁNG", "SỐ TIỀN",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
                return barChart;
                                                 }
	 private static CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         dataset.addValue(0000000, "SỐ TIỀN", "T 1 ");
        dataset.addValue(000000, "SỐ TIỀN", "T 2");
        dataset.addValue(00000, "SỐ TIỀN", "T 3");
        dataset.addValue(000000, "SỐ TIỀN", "T 4 ");
        dataset.addValue(000000, "SỐ TIỀN", "T 5 ");
        dataset.addValue(6200000, "SỐ TIỀN", "T 6");
        dataset.addValue(11100000, "SỐ TIỀN", "T 7");
        dataset.addValue(17500000, "SỐ TIỀN", "T 8 ");
        dataset.addValue(0000000, "SỐ TIỀN", "T 9 ");
        dataset.addValue(0000000, "SỐ TIỀN", "T 10 ");
        dataset.addValue(000000, "SỐ TIỀN", "T 11 ");
        dataset.addValue(00000000, "SỐ TIỀN", "T 12 ");
        return dataset;
    }
	public QLDoanhThuGUI() {
		initialize();
		loadResources();
		
	}

	private void loadResources() {
		//tbViTri.setModel(QLViTriBLL.getInstance().getResources(tenKhuVuc));
	}
	
	public static QLDoanhThuGUI getInstance() {
		if (instance == null)
			instance = new QLDoanhThuGUI();
			
		return instance;
	}
	
	public JFrame getPnMain() {
		return jfMain;
	}
			

	
	private void setStateForTexfeild() {
		tfMaViTri.setEditable(isEdit);
	}
	
	private void clearField() {

		tfMaViTri.setText("");

		tfMaViTri.setText("");

	}
	
	@SuppressWarnings("deprecation")
	public void initialize() {
		jfMain = new JFrame();
                ChartPanel chartPanel = new ChartPanel(createChart());
                chartPanel.setPreferredSize(new java.awt.Dimension(200, 70));
                chartPanel.setSize(200,100);
                jfMain.add(chartPanel);
                jfMain.setTitle("Quản Lý Doanh Thu");
                jfMain.setSize(1200, 560);
                jfMain.setLocationRelativeTo(null);
                jfMain.setResizable(false);
                jfMain.setVisible(true);
		
	}
		

}
