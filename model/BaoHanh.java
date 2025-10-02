package model;

import util.ThoiGian;

public class BaoHanh {
    private String maBh;
    private String loaiBaoHanh;
    private SanPham sanPham;
    private String ngayBatDau = "";
    private String ngayKetThuc = "";
    private long gia;

    public BaoHanh() {
    }

    public BaoHanh(String maBh, String loaiBaoHanh, SanPham sanPham, String ngayBatDau,
            String ngayKetThuc) {
        this.maBh = maBh;
        this.loaiBaoHanh = loaiBaoHanh;
        this.sanPham = sanPham;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public BaoHanh(String maBh, String loaiBaoHanh, SanPham sanPham, Long gia) {
        this.maBh = maBh;
        this.loaiBaoHanh = loaiBaoHanh;
        this.sanPham = sanPham;
        this.gia = gia;
    }

    public BaoHanh(BaoHanh baoHanh) {
        this.maBh = baoHanh.getMaBh();
        this.loaiBaoHanh = baoHanh.getLoaiBaoHanh();
        this.sanPham = baoHanh.getSanPham();
        this.gia = baoHanh.getGia();
    }

    public String getMaBh() {
        return maBh;
    }

    public void setMaBh(String maBh) {
        this.maBh = maBh;
    }

    public void setLoaiBaoHanh(String loaiBaoHanh) {
        this.loaiBaoHanh = loaiBaoHanh;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getLoaiBaoHanh() {
        return loaiBaoHanh;
    }

    public long getGia() {
        return gia;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc() {
        this.ngayKetThuc = ThoiGian.ngaySauNThang(ngayBatDau, Integer.parseInt(loaiBaoHanh.replaceAll("\\D+", "")));
    }

    public void setLoaiBaoHanh(int soThang) {
        this.loaiBaoHanh = "BaoHanh" + soThang + "T";
    }

    @Override
    public String toString() {
        return "maBh : " + maBh + "\n" +
                "loaiBaoHanh : " + loaiBaoHanh + "\n" +
                "sanPhamMa : " + (sanPham != null ? sanPham.getMa() : "null") + "\n"
                + "Gia : " + gia + "\n";
    }
}
