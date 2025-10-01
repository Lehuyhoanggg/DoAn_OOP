package model;

import java.util.ArrayList;

public class ChiTietHoaDon {
    private String ma;
    private DanhSachSanPham danhSachSanPham;
    private ArrayList<BaoHanh> listBaoHanh;
    private long thanhTien;
    private ArrayList<MaGiamGia> listMaGiamGiaDaDung;

    public ChiTietHoaDon(String ma, Long thanhTien) {
        this.ma = ma;
        this.thanhTien = thanhTien;
        listBaoHanh = new ArrayList<>();
        danhSachSanPham = new DanhSachSanPham();
        listMaGiamGiaDaDung = new ArrayList<>();
    }

    public ChiTietHoaDon(String ma) {
        this.ma = ma;
        listBaoHanh = new ArrayList<>();
        danhSachSanPham = new DanhSachSanPham();
        listMaGiamGiaDaDung = new ArrayList<>();
    }

    public String getMa() {
        return ma;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public ArrayList<MaGiamGia> getListMaGiamGiaDaDung() {
        return listMaGiamGiaDaDung;
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

    public void setListMaGiamGiaDaDung(ArrayList<MaGiamGia> listMaGiamGiaDaDung) {
        this.listMaGiamGiaDaDung = listMaGiamGiaDaDung;
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public void setDanhSachSanPham(DanhSachSanPham danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public boolean themBaoHanh(BaoHanh baoHanh) {
        if (baoHanh == null) {
            return false;
        }
        return listBaoHanh.add(baoHanh);
    }

    public boolean themSanPham(SanPham sanPham) {
        if (sanPham == null) {
            return false;
        }
        return danhSachSanPham.themSanPham(sanPham);
    }

    public boolean xoaSanPham(SanPham sanPham) {
        if (sanPham == null) {
            return false;
        }
        return danhSachSanPham.xoa1SanPham(sanPham);
    }

    public boolean xoaBaoHanh(BaoHanh baoHanh) {
        if (baoHanh == null) {
            return false;
        }
        return listBaoHanh.remove(baoHanh);
    }

    public boolean themMaGiamGiaDaDung(MaGiamGia maGiamGia) {
        if (maGiamGia == null) {
            return false;
        }
        return listMaGiamGiaDaDung.add(maGiamGia);
    }

    @Override
    public String toString() {
        return "Ma: " + getMa() + "\n"
                + "Thanh tien: " + getThanhTien() + "\n";
    }
}
