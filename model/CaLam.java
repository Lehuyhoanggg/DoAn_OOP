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
    public Calam(){}

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

    public boolean diemDanh(NhanVien nhanVien) {
        return listNhanVien.diemDanhNhanVien(nhanVien);
    }

    public int soNguoiTrongCa() {
        return this.listNhanVien.soNhanVienDaXep();
    }

    public boolean tonTaiNhanVien(NhanVien nhanVien) {
        return listNhanVien.tonTaiNhanVien(nhanVien);
    }

    public boolean caLamChuaCoNguoi() {
        if (soNguoiTrongCa() == 0) {
            return true;
        }
        return false;
    }

    public boolean themNhanVienVaoCa(NhanVien nhanVien) {
        return listNhanVien.themNhanVien(nhanVien);
    }

    public boolean xoaNhanVienKhoiCa(NhanVien nhanVien) {
        return listNhanVien.xoaNhanVien(nhanVien);
    }
    @Overrive
    public String toString(){
        return "Gio bat dau: " + getGioBatDau() + "\n" +
                "Gio ket thuc: " + getGioKetThuc() + "\n" +
                "So: " + getSo() + "\n" +
                "So luong can: " + getSoLuongCan() + '\n" +
                "Nhan vien: " + getListNhanVien() + "\n";
    }
}
