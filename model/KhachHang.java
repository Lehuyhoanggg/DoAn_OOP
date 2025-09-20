package model;

import java.util.ArrayList;

public class KhachHang {
    private String maKh;
    private String tenKh;
    private String sdt;
    private HangThanhVien hangThanhVien;
    private DanhSachSpDaMua listSanDaMua;
    private long tienDaChi;
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;
    private ArrayList<BaoHanh> listBaoHanh;

    public KhachHang(String maKh, String tenKh, String sdt, HangThanhVien hangThanhVien, long tienDaChi) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.hangThanhVien = hangThanhVien;
        this.tienDaChi = tienDaChi;
    }

    public void setHangThanhVien(HangThanhVien hangThanhVien) {
        this.hangThanhVien = hangThanhVien;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public void setListPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public void setListSanDaMua(DanhSachSpDaMua listSanDaMua) {
        this.listSanDaMua = listSanDaMua;
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

    public ArrayList<BaoHanh> getListBaoHanh() {
        return listBaoHanh;
    }

    public ArrayList<PhieuBaoHanh> getListPhieuBaoHanh() {
        return listPhieuBaoHanh;
    }

    public DanhSachSpDaMua getListSanDaMua() {
        return listSanDaMua;
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
