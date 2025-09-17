package model;

import util.ThoiGian;

public class TaiKhoan {
    private String ngayTao;
    private String tenDangNhap;
    private String matKhau;
    private User user;

    public TaiKhoan(String tenDangNhap, String matKhau, User user) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.user = user;
        user.capTaiKhoan(this);
        this.ngayTao = ThoiGian.layNgayHienTai();
    }

    public TaiKhoan(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.ngayTao = ThoiGian.layNgayHienTai();
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

    public String getNgayTao() {
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
        this.ngayTao = ngayTao;
    }
}
