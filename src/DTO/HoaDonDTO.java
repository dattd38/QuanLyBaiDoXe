/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author MY LAPTOP
 */
public class HoaDonDTO {
        private String maHoaDon;
        private String maVe;
        private String tenViTri;
        private String tenKhuVuc;
        private String tenNhanVien;      
        private String soNgayGui;
        private String bienSoXe;
        private String thanhTien;      
        private Date ngayLap;
     public HoaDonDTO()
     {
         super();
     }

    public HoaDonDTO(String maHoaDon, String maVe, String tenViTri, String tenKhuVuc, String maNhanVien, String soNgayGui, String bienSoXe, String thanhTien, Date ngayLap) {
         super();
        this.maHoaDon = maHoaDon;
        this.maVe = maVe;
        this.tenViTri = tenViTri;
        this.tenKhuVuc = tenKhuVuc;
        this.tenNhanVien = maNhanVien;
        this.soNgayGui = soNgayGui;
        this.bienSoXe = bienSoXe;
        this.thanhTien = thanhTien;
        this.ngayLap = ngayLap;
    }
    
    public HoaDonDTO(String maHoaDon,String maVe,String bienSoXe,String thanhTien,Date ngayLap){
        super();
        this.maHoaDon=maHoaDon;
        this.maVe=maVe;
        this.bienSoXe=bienSoXe;
        this.thanhTien=thanhTien;
        this.ngayLap=ngayLap;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getSoNgayGui() {
        return soNgayGui;
    }

    public void setSoNgayGui(String soNgayGui) {
        this.soNgayGui = soNgayGui;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

   

   
}
