package model;

import java.util.ArrayList;

public class ChiTietHoaDon {
    private String ma;
    private DanhSachSanPham danhSachSanPham;
    private ArrayList<BaoHanh> listBaoHanh;
    private long thanhTien;

    public ChiTietHoaDon(String ma, Long thanhTien) {
        this.ma = ma;
        this.thanhTien = thanhTien;
        listBaoHanh = new ArrayList<>();
        danhSachSanPham = new DanhSachSanPham();
    }

    public String getMa() {
        return ma;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public ArrayList<BaoHanh> getListBaoHanh() {
        return listBaoHanh;
    }

    public DanhSachSanPham getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public void setDanhSachSanPham(DanhSachSanPham danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public void themBaoHanh(BaoHanh baoHanh) {
        listBaoHanh.add(baoHanh);
    }

    public void themSanPham(SanPham sanPham) {
        danhSachSanPham.themSanPham(sanPham);
    }
}
