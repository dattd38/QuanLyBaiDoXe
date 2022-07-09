package DTO;

import java.util.Date;

public class VeDTO {
    private String maVe;
    private String BienSoXe;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private String tinhTrangVe;
    
    public VeDTO() {
            super();
    }

    public VeDTO(String maVe, String BienSoXe, Date NgayBatDau, Date NgayKetThuc, String tinhTrangVe) {
        super();
        this.maVe = maVe;
        this.BienSoXe = BienSoXe;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.tinhTrangVe = tinhTrangVe;
    }
    
    public VeDTO(String maVe,String BienSoXe,Date NgayBatDau){
        super();
        this.maVe=maVe;
        this.BienSoXe=BienSoXe;
        this.NgayBatDau=NgayBatDau;
    }

    public String getMaVe() {
        return maVe;
    }

    public String getBienSoXe() {
        return BienSoXe;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public String getTinhTrangVe() {
        return tinhTrangVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public void setBienSoXe(String BienSoXe) {
        this.BienSoXe = BienSoXe;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public void setTinhTrangVe(String tinhTrangVe) {
        this.tinhTrangVe = tinhTrangVe;
    }

    
}
