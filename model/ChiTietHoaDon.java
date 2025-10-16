package model;

import java.util.ArrayList;

public class ChiTietHoaDon {
    private String ma;
    private ArrayList<SanPhamDaBan> sanPhamDaBan; // chứa cùng 1 sanpham , nhưng khác bảo hành hoặc không có bảo hành
    private int soSp;
    private int soBh;
    private long thanhTien;

    public ChiTietHoaDon(String ma, int soSp, int soBh, Long thanhTien) {
        this.ma = ma;
        this.thanhTien = thanhTien;
        this.soSp = soSp;
        this.soBh = soBh;
        sanPhamDaBan = new ArrayList<>();
    }

    public ChiTietHoaDon(String ma) {
        this.ma = ma;
        sanPhamDaBan = new ArrayList<>();
    }

    public ChiTietHoaDon(String ma, SanPham sanPham, long thanhTien) {
        this.ma = ma;
        this.thanhTien = thanhTien;
        sanPhamDaBan = new ArrayList<>();
    }

    public ChiTietHoaDon() {
        sanPhamDaBan = new ArrayList<>();
    };

    public String getMa() {
        return ma;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public ArrayList<SanPhamDaBan> getSanPhamDaBan() {
        return sanPhamDaBan;
    }

    public int getSoBh() {
        return soBh;
    }

    public int getSoSp() {
        return soSp;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setThanhTien(long thanhTien) {
        if (thanhTien < 0)
            thanhTien = 0;
        this.thanhTien = thanhTien;
    }

    public void setSanPhamDaBan(ArrayList<SanPhamDaBan> sanPhamDaBan) {
        this.sanPhamDaBan = sanPhamDaBan;
    }

    public void setSoBh(int soBh) {
        this.soBh = soBh;
    }

    public void setSoSp(int soSp) {
        this.soSp = soSp;
    }

    public boolean themSanPhamDaBan(SanPhamDaBan sanPham) {
        if (sanPham == null)
            return false;
        soSp++;
        if (sanPham.getBaoHanh() != null) {
            soBh++;
        }
        return sanPhamDaBan.add(sanPham);
    }

    public SanPhamDaBan timSanPhamDaBan(SanPham sanPham, String serial) {
        for (SanPhamDaBan sanPhamDaBan : sanPhamDaBan) {
            if (sanPhamDaBan.getSanPham().equals(sanPham) && sanPhamDaBan.getSerial().equals(serial)) {
                return sanPhamDaBan;
            }
        }
        return null;
    }

    public boolean xoaSanPhamDaBan(SanPhamDaBan spDaBan) {
        return sanPhamDaBan.remove(spDaBan);
    }

    @Override
    public String toString() {
        return "Ma: " + getMa() + "\n"
                + "Thanh tien: " + getThanhTien() + "\n";
    }
}
