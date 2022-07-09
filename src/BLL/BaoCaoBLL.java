package BLL;
    
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import Controller.DAL.*;
import Controller.HoaDonDAL;
import Controller.RaVaoBenDAL;
import Controller.VeDAL;
import GUI.*;
import DTO.*;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Random;
import org.apache.commons.collections4.iterators.EmptyListIterator;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;


public class BaoCaoBLL {
	
	private static BaoCaoBLL instance;
	DefaultTableModel dtm;
       
	private ArrayList<Object[]> dataRow;
	
	private BaoCaoBLL(){
		dataRow = new ArrayList<Object[]>();
	}
	
	public static BaoCaoBLL getInstance() {
		if (instance == null)
			instance = new BaoCaoBLL();
		return instance;
	}
        
        public ArrayList<RaVaoBenDTO> reloadRVB(){
            ArrayList<RaVaoBenDTO> dsXe = RaVaoBenDAL.getInstance().getResources();
            return dsXe;
        }
        
        public ArrayList<HoaDonDTO> reloadTien(){
            ArrayList<HoaDonDTO> dsTien = HoaDonDAL.getInstance().getResources();
            return dsTien;
        }
        
	@SuppressWarnings("deprecation")
	public DefaultTableModel thongKe(String startDate,String endDate) {
                DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//                Date currentDate = new Date();
                
                Date date1 = null;
                Date date2 = null;
                
		dtm = new DefaultTableModel();
                dtm.addColumn("Ngày");
		dtm.addColumn("Tổng số xe vào");
		dtm.addColumn("Tổng số xe ra ");
		dtm.addColumn("Tổng tiền");
		
               try{  
//                    ArrayList<RaVaoBenDTO> dsXe = RaVaoBenDAL.getInstance().reloadResources();
//                    ArrayList<HoaDonDTO> dsTien = HoaDonDAL.getInstance().reloadResources();
                    
                    ArrayList<RaVaoBenDTO> dsXe = reloadRVB();
                    ArrayList<HoaDonDTO> dsTien = reloadTien();
                    
//                    Date dateStart = simpleDateFormat.parse(startDate);
//                    Date dateEnd = simpleDateFormat.parse(endDate);
                    date1 = simpleDateFormat.parse(startDate);
                    date2 = simpleDateFormat.parse(endDate);
                    ArrayList<Date> dates = new ArrayList<Date>();
                    long interval = 24*1000 * 60 * 60; // 1 hour in millis
                    long endTime =date2.getTime() ; // create your endtime here, possibly using Calendar or Date
                    long curTime =date1.getTime();
                    while (curTime <= endTime) {
                        dates.add(new Date(curTime));
                        curTime += interval;
                    }
                    
                   
                    for(int i=0;i<dates.size();i++){
                        Date lDate =(Date)dates.get(i);
                        int tongSoXeVaoNgay=0;
                        int tongSoXeRaNgay=0;
                        for(RaVaoBenDTO xe: dsXe) {
				if(xe.getNgayVao().equals(lDate))
                                {   
                                    tongSoXeVaoNgay++;
                                     
                                }
                                if(xe.getNgayRa()!=null)
                                {
                                if(xe.getNgayRa().equals(lDate) )
                                {  
                                    if(xe.getTrangThaiRvb().equals("ĐÃ LẤY"))
                                     tongSoXeRaNgay++;
                                }
                               
                        }
                        }
                       
                          int TongSoTien=0;
                         for(HoaDonDTO money: dsTien) {
				if(money.getNgayLap().equals(lDate))
                                {    
                                    
                                     String[] splits = money.getThanhTien().split(" VNÐ");
                                
                                    for (String item : splits)
                                        
                                    {
                                       //System.out.println(item);
                                      TongSoTien+=Integer.parseInt(item);
                                    }
                                }
                        }
                        String ds = simpleDateFormat.format(lDate);    
                        Object[] row={
                                      ds,
                                      tongSoXeVaoNgay,
                                      tongSoXeRaNgay,
                                      TongSoTien
                                             };
                            dataRow.add(row);
                            dtm.addRow(row);
                                      }
                    
               }
               
               catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	        }
        
                

	public void lapBaoCao() {
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph p1 = document.createParagraph();
		p1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run = p1.createRun();
		run.setFontSize(12);
		run.setBold(true);
		run.setText("TỔNG CÔNG TY LEGON-CAR         CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");
		
		XWPFParagraph p6=document.createParagraph();
		p6.setAlignment(ParagraphAlignment.LEFT);
		run=p6.createRun();
		run.setFontSize(10);
		run.setBold(true);
		run.setText("               BÃI XE TOÀN ĐẠT"+ "                                        "   +     " Độc lập - Tự do - Hạnh phúc  ");
		
                XWPFParagraph pkt=document.createParagraph();
		pkt.setAlignment(ParagraphAlignment.LEFT);
		run=pkt.createRun();
		run.setFontSize(10);
		run.setBold(true);
		run.setText("");
                
		XWPFParagraph p5=document.createParagraph();
		p5.setAlignment(ParagraphAlignment.CENTER);
		run=p5.createRun();
		run.setFontSize(12);
		run.setBold(true);
		run.setText("BÁO CÁO THỐNG KÊ");
		
		XWPFParagraph p2 = document.createParagraph();
		p2.setAlignment(ParagraphAlignment.CENTER);
		run = p2.createRun();
		run.setFontSize(12);
		run.setBold(true);
		run.setText("TÌNH HÌNH XE TRONG BẾN");
		
		XWPFParagraph p3 = document.createParagraph();
		p3.setAlignment(ParagraphAlignment.RIGHT);
		run = p3.createRun();
		run.setFontSize(12);
		SimpleDateFormat sdfNgay = new SimpleDateFormat("dd");
		SimpleDateFormat sdfThang = new SimpleDateFormat("MM");
		SimpleDateFormat sdfNam = new SimpleDateFormat("YYYY");
		Date now = new Date();
		run.setText("Ngày "+ sdfNgay.format(now) + " tháng "+ sdfThang.format(now) + " năm "+ sdfNam.format(now));
		
		XWPFParagraph p4 = document.createParagraph();
		run = p4.createRun();
		p4.setAlignment(ParagraphAlignment.CENTER);
		XWPFTable tb = document.createTable();
		XWPFTableRow row = tb.getRow(0);
		
		row.getCell(0).setText("Ngày");
		row.addNewTableCell().setText("Số Xe Vào");
		row.addNewTableCell().setText("Số Xe Ra");
		row.addNewTableCell().setText("Tổng Số Tiền");
		//tb.setWidth(600);
                
		tb.setCellMargins(200, 50, 100, 1200);
		for (int i = 0; i< dataRow.size(); i++) {
			Object[] iRow = dataRow.get(i);
			XWPFTableRow tableRow = tb.createRow();
			tableRow.setHeight(20);
			tableRow.getCell(0).setText(iRow[0].toString());
			tableRow.getCell(1).setText(iRow[1].toString());
			tableRow.getCell(2).setText(iRow[2].toString());
                        tableRow.getCell(3).setText(iRow[3].toString());  
		}
                XWPFParagraph pkt1=document.createParagraph();
		pkt1.setAlignment(ParagraphAlignment.LEFT);
		run=pkt1.createRun();
		run.setFontSize(10);
		run.setBold(true);
		run.setText("");
                
                XWPFParagraph pstxv=document.createParagraph();
		pstxv.setAlignment(ParagraphAlignment.LEFT);
		run=pstxv.createRun();
		run.setFontSize(10);
		run.setBold(true);
		run.setText("                                           Tổng xe vào :"+String.valueOf(DoanhThuGUI.getInstance().sumIntTXV())
                +"                Tổng xe ra :"+String.valueOf(DoanhThuGUI.getInstance().sumIntTXR())
                +"                 Tổng tiền :"+String.valueOf(DoanhThuGUI.getInstance().sumIntTT()));
                
                
                XWPFParagraph pkt2=document.createParagraph();
		pkt2.setAlignment(ParagraphAlignment.LEFT);
		run=pkt2.createRun();
		run.setFontSize(10);
		run.setBold(true);
		run.setText("");
                
		XWPFParagraph p7=document.createParagraph();
		p7.setAlignment(ParagraphAlignment.RIGHT);
		run=p7.createRun();
		run.setFontSize(10);
		run.setBold(true);
		run.setText("Người lập báo cáo");
                
                XWPFParagraph pkt3=document.createParagraph();
		pkt3.setAlignment(ParagraphAlignment.LEFT);
		run=pkt3.createRun();
		run.setFontSize(80);
		run.setBold(true);
		run.setText("");
                
                XWPFParagraph p8=document.createParagraph();
		p8.setAlignment(ParagraphAlignment.RIGHT);
		run=p8.createRun();
		run.setFontSize(10);
		run.setBold(true);
		run.setText(ThongTinCaNhanBLL.getInstance().getNhanVien().getTenNhanVien());
                
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                
                
	try {           
                        Random random =new Random();
                        int rand=random.nextInt(1000);
			FileOutputStream out = new FileOutputStream(new File("BaoCao//Báo cáo MS-"+rand+", "+sdf.format(now)+" .docx"));
			document.write(out);
			out.close();
			document.close();
			JOptionPane.showMessageDialog(null, "Thành công!","Thông báo",1);
			System.out.println("Thành công");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


