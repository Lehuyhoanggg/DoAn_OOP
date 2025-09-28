package model;

public class CaLam {
    private int so;
    private String gioBatDau;
    private String gioKetThuc;
    private NhanVienDiemDanh listNhanVien;
    private int soLuongCan;

    public CaLam(int so, String gioBatBau, String gioKetThuc) {
        this.so = so;
        this.gioBatDau = gioBatBau;
        this.gioKetThuc = gioKetThuc;
        listNhanVien = new NhanVienDiemDanh();
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public String getGioKetThuc() {
        return gioKetThuc;
    }

    public int getSo() {
        return so;
    }

    public int getSoLuongCan() {
        return soLuongCan;
    }

    public NhanVienDiemDanh getListNhanVien() {
        return listNhanVien;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public void setSoLuongCan(int soLuongCan) {
        this.soLuongCan = soLuongCan;
    }

    public void setListNhanVien(NhanVienDiemDanh listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public void diemDanh(NhanVien nhanVien) {
        listNhanVien.diemDanhNhanVien(nhanVien);
    }

    public int soNguoiTrongCa() {
        return this.listNhanVien.soNhanVienDaXep();
    }

    public boolean caLamTrong() {
        if (soNguoiTrongCa() == 0) {
            return true;
        }
        return false;
    }

    public void themNhanVienVaoCa(NhanVien nhanVien) {
        listNhanVien.themNhanVien(nhanVien);
    }

    public void xoaNhanVienKhoiCa(NhanVien nhanVien) {
        listNhanVien.xoaNhanVien(nhanVien);
    }
}
