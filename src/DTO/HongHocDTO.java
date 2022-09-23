/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Duc_Dat
 */
public class HongHocDTO {
    private String MaHongHoc;
    private String TenKhachHang;
    private String DienThoai;
    private String BienSoXe;
    private String TinhTrangXe;
    private Date NgayBaoHong;

    public HongHocDTO() {
        super();
    }

    public HongHocDTO(String MaHongHoc, String TenKhachHang, String DienThoai, String BienSoXe, String TinhTrangXe, Date NgayBaoHong) {
       
        this.MaHongHoc = MaHongHoc;
        this.TenKhachHang = TenKhachHang;
        this.DienThoai = DienThoai;
        this.BienSoXe = BienSoXe;
        this.TinhTrangXe = TinhTrangXe;
        this.NgayBaoHong = NgayBaoHong;
    }

    public String getMaHongHoc() {
        return MaHongHoc;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public String getBienSoXe() {
        return BienSoXe;
    }

    public String getTinhTrangXe() {
        return TinhTrangXe;
    }

    public Date getNgayBaoHong() {
        return NgayBaoHong;
    }

    public void setMaHongHoc(String MaHongHoc) {
        this.MaHongHoc = MaHongHoc;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public void setBienSoXe(String BienSoXe) {
        this.BienSoXe = BienSoXe;
    }

    public void setTinhTrangXe(String TinhTrangXe) {
        this.TinhTrangXe = TinhTrangXe;
    }

    public void setNgayBaoHong(Date NgayBaoHong) {
        this.NgayBaoHong = NgayBaoHong;
    }
    
    
    
}
