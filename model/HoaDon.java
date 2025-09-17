package model;

import java.time.LocalDate;

public class HoaDon {
    private String ma;
    private String khachHang;
    private ChiTietHoaDon chiTietHoaDon;
    private String maNgTaoHoaDon;
    private LocalDate ngayTaoHoaDon;
    private String ghiChu;
    private long thanhTien;

    public ChiTietHoaDon getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public String getMa() {
        return ma;
    }

    public String getMaNgTaoHoaDon() {
        return maNgTaoHoaDon;
    }

    public LocalDate getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setMaNgTaoHoaDon(String maNgTaoHoaDon) {
        this.maNgTaoHoaDon = maNgTaoHoaDon;
    }

    public void setNgayTaoHoaDon(LocalDate ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }
}
