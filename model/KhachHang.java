package model;

import java.util.ArrayList;

public class KhachHang {
    private String maKh;
    private String tenKh;
    private String sdt;
    private HangThanhVien hangThanhVien;
    private ArrayList<HoaDon> listHoaDon;
    private long tienDaChi;

    public void setHangThanhVien(HangThanhVien hangThanhVien) {
        this.hangThanhVien = hangThanhVien;
    }

    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public void setTienDaChi(long tienDaChi) {
        this.tienDaChi = tienDaChi;
    }

    public HangThanhVien getHangThanhVien() {
        return hangThanhVien;
    }

    public ArrayList<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public String getMaKh() {
        return maKh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getTenKh() {
        return tenKh;
    }

    public long getTienDaChi() {
        return tienDaChi;
    }
}
