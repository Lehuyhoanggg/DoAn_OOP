package model;

public class BaoHanh {
    private String maBh;
    private String tenBaoHanh;
    private KhachHang khachHang;
    private SanPham sanPham;
    private String ngayBatDau;
    private String ngayKetThuc;

    public BaoHanh() {
    }

    public BaoHanh(String maBh, String tenBaoHanh, KhachHang khachHang, SanPham sanPham, String ngayBatDau,
            String ngayKetThuc) {
        this.maBh = maBh;
        this.tenBaoHanh = tenBaoHanh;
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaBh() {
        return maBh;
    }

    public void setMaBh(String maBh) {
        this.maBh = maBh;
    }

    public String getTenBaoHanh() {
        return tenBaoHanh;
    }

    public void setTenBaoHanh(String tenBaoHanh) {
        this.tenBaoHanh = tenBaoHanh;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "maBh : " + maBh + "\n" +
                "tenBaoHanh : " + tenBaoHanh + "\n" +
                "khachHangMa : " + (khachHang != null ? khachHang.getMaKh() : "null") + "\n" +
                "sanPhamMa : " + (sanPham != null ? sanPham.getMa() : "null") + "\n" +
                "ngayBatDau : " + ngayBatDau + "\n" +
                "ngayKetThuc : " + ngayKetThuc + "\n";
    }
}
