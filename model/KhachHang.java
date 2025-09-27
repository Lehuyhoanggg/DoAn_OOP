package model;

import java.util.ArrayList;

public class KhachHang {
    private String maKh;
    private String tenKh;
    private String sdt;
    private HangThanhVien hangThanhVien;
    private DanhSachSanPham listSanDaMua;
    private long tienDaChi;
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;
    private ArrayList<BaoHanh> listBaoHanh;

    public KhachHang() {

    }

    public KhachHang(String maKh, String tenKh, String sdt, HangThanhVien hangThanhVien, long tienDaChi) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.hangThanhVien = hangThanhVien;
        this.tienDaChi = tienDaChi;
        this.listBaoHanh = new ArrayList<>();
        this.listSanDaMua = new DanhSachSanPham();
        this.listPhieuBaoHanh = new ArrayList<>();
    }

    public KhachHang(String maKh, String tenKh, String sdt, HangThanhVien hangThanhVien) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.hangThanhVien = hangThanhVien;
        this.listBaoHanh = new ArrayList<>();
        this.listSanDaMua = new DanhSachSanPham();
        this.listPhieuBaoHanh = new ArrayList<>();
    }

    public KhachHang(String maKh, String tenKh, String sdt) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.listBaoHanh = new ArrayList<>();
        this.listSanDaMua = new DanhSachSanPham();
        this.listPhieuBaoHanh = new ArrayList<>();
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

    public void setListSanDaMua(DanhSachSanPham listSanDaMua) {
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

    public DanhSachSanPham getListSanDaMua() {
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

    public void themBaoHanh(BaoHanh baoHanh) {
        listBaoHanh.add(baoHanh);
    }

    public void themPhieuBaoHanh(PhieuBaoHanh phieuBaoHanh) {
        listPhieuBaoHanh.add(phieuBaoHanh);
    }
}
