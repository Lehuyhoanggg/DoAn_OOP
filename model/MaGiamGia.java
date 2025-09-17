package model;

public class MaGiamGia {
    private String ma;
    private String tenMa;
    private String loaiDoanhMuc;
    private String loaiThuongHieu;
    private long soTieniam;

    public long getGiam() {
        return soTieniam;
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

    public long getSoTieniam() {
        return soTieniam;
    }

    public String getTenMa() {
        return tenMa;
    }

    public void setGiam(long soTieniam) {
        this.soTieniam = soTieniam;
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

    public void setSoTieniam(long soTieniam) {
        this.soTieniam = soTieniam;
    }

    public void setTenMa(String tenMa) {
        this.tenMa = tenMa;
    }
}
