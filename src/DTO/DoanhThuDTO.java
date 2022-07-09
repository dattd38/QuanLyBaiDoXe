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
    private double tongTien;

    public DoanhThuDTO() {
        super();
    }

    public DoanhThuDTO(Date ngay, int soXeVao, int soXeRa, double tongTien) {
        super();
        this.ngay = ngay;
        this.soXeVao = soXeVao;
        this.soXeRa = soXeRa;
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

    public double getTongTien() {
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

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
}
