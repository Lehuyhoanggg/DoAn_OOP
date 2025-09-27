package model;

public class MaGiamGia {
    private String ma;
    private String tenMa;
    private String loaiDoanhMuc;
    private String loaiThuongHieu;
    private String tienGiam;
    String ngayBatDau;
    String ngayKetThuc;

    public MaGiamGia(String ma, String tenMa, String loaiDoanhMuc, String loaiThuongHieu, String tienGiam,
            String ngayBatDau, String ngayKetThuc) {
        this.ma = ma;
        this.tenMa = tenMa;
        this.loaiDoanhMuc = loaiDoanhMuc;
        this.loaiThuongHieu = loaiDoanhMuc;
        this.tienGiam = tienGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLoaiDoanhMuc() {
        return loaiDoanhMuc;
    }

    public String getLoaiThuongHieu() {
        return loaiThuongHieu;
    }

    public String getMa() {
        return ma;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public String getTienGiam() {
        return tienGiam;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public String getTenMa() {
        return tenMa;
    }

    public void setTienGiam(String tienGiam) {
        this.tienGiam = tienGiam;
    }

    public void setLoaiDoanhMuc(String loaiDoanhMuc) {
        this.loaiDoanhMuc = loaiDoanhMuc;
    }

    public void setLoaiThuongHieu(String loaiThuongHieu) {
        this.loaiThuongHieu = loaiThuongHieu;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTenMa(String tenMa) {
        this.tenMa = tenMa;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
