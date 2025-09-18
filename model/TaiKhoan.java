package model;

import java.time.LocalDate;

import util.ThoiGian;

public class TaiKhoan {
    private LocalDate ngayTao;
    private String tenDangNhap;
    private String matKhau;
    private User user;

    public TaiKhoan(String tenDangNhap, String matKhau, User user) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.user = user;
        user.capTaiKhoan(this);
    }

    public TaiKhoan(String tenDangNhap, String matKhau, String ngay) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.ngayTao = ThoiGian.chuyenStrThanhDate(ngay);
    }

    public TaiKhoan() {
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ThoiGian.chuyenStrThanhDate(ngayTao);
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean kiemTraTaiKhoan(String tenDangNhap, String matKhau) {
        if (getTenDangNhap().equals(tenDangNhap) && getMatKhau().equals(matKhau)) {
            return true;
        }
        return false;
    }
}