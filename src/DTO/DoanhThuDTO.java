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
public class DoanhThuDTO {
    private Date ngay;
    private int soXeVao;
    private int soXeRa;
    private int soVeThang;
    private int tongTien;

    public DoanhThuDTO() {
        super();
    }
    
    
    public DoanhThuDTO(Date ngay, int soXeVao, int soXeRa,int soVeThang, int tongTien) {
        super();
        this.ngay = ngay;
        this.soXeVao = soXeVao;
        this.soXeRa = soXeRa;
        this.soVeThang=soVeThang;
        this.tongTien = tongTien;
    }

    public Date getNgay() {
        return ngay;
    }

    public int getSoXeVao() {
        return soXeVao;
    }

    public int getSoXeRa() {
        return soXeRa;
    }

    public int getSoVeThang() {
        return soVeThang;
    }
    

    public int getTongTien() {
        return tongTien;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public void setSoXeVao(int soXeVao) {
        this.soXeVao = soXeVao;
    }

    public void setSoXeRa(int soXeRa) {
        this.soXeRa = soXeRa;
    }

    public void setSoVeThang(int soVeThang) {
        this.soVeThang = soVeThang;
    }
    
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
}
