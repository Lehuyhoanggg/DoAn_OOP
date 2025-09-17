package model;

import java.time.LocalDate;

public class PhieuBaoHanh {
    private String maBaoHanh;
    private KhachHang khachHang;
    private SanPham sanPham;
    private LocalDate ngayBaoHanh;
    private String ChiTietLoi;

    public String getChiTietLoi() {
        return ChiTietLoi;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public String getMaBaoHanh() {
        return maBaoHanh;
    }

    public LocalDate getNgayBaoHanh() {
        return ngayBaoHanh;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setChiTietLoi(String chiTietLoi) {
        ChiTietLoi = chiTietLoi;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setMaBaoHanh(String maBaoHanh) {
        this.maBaoHanh = maBaoHanh;
    }

    public void setNgayBaoHanh(LocalDate ngayBaoHanh) {
        this.ngayBaoHanh = ngayBaoHanh;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
