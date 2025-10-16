package model;

import java.util.ArrayList;

public class SanPhamDaBan {
    private String maSpDaBan;
    private SanPham sanPham = null;
    private String serial;
    private BaoHanh baoHanh = null;
    private ArrayList<MaGiamGia> listMaGiamGiaDaDung;

    public SanPhamDaBan() {
        listMaGiamGiaDaDung = new ArrayList<>();
    }

    public SanPhamDaBan(String ma,SanPham sanPham, String serial, BaoHanh baoHanh) {
        this.sanPham = sanPham;
        this.serial = serial;
        this.baoHanh = baoHanh;
        this.maSpDaBan = ma;
        listMaGiamGiaDaDung = new ArrayList<>();
    }

    public BaoHanh getBaoHanh() {
        return baoHanh;
    }
    public String getMaSpDaBan() {
        return maSpDaBan;
    }
    public SanPham getSanPham() {
        return sanPham;
    }

    public ArrayList<MaGiamGia> getListMaGiamGiaDaDung() {
        return listMaGiamGiaDaDung;
    }

    public String getSerial() {
        return serial;
    }

    public void setBaoHanh(BaoHanh baoHanh) {
        this.baoHanh = baoHanh;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    public void setMaSpDaBan(String maSpDaBan) {
        this.maSpDaBan = maSpDaBan;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setListMaGiamGiaDaDung(ArrayList<MaGiamGia> listMaGiamGiaDaDung) {
        this.listMaGiamGiaDaDung = listMaGiamGiaDaDung;
    }

    public boolean themMaGiamGiaDaDung(MaGiamGia maGiamGia) {
        if (maGiamGia == null) {
            return false;
        }
        return listMaGiamGiaDaDung.add(maGiamGia);
    }

    public boolean xoaMaGiamGiaDaDung(MaGiamGia maGiamGia) {
        if (maGiamGia == null) {
            return false;
        }
        return listMaGiamGiaDaDung.remove(maGiamGia);
    }

    public void xoaSanPham() {
        sanPham = null;
    }
}
