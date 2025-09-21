package model;

public class HoaDon {
    private String ma;
    private String khachHang;
    private ChiTietHoaDon chiTietHoaDon;
    private String maNgTaoHoaDon;
    private String ngayTaoHoaDon;
    private String ghiChu;

    public ChiTietHoaDon getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public String getMa() {
        return ma;
    }

    public String getMaNgTaoHoaDon() {
        return maNgTaoHoaDon;
    }

    public String getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public void setChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setMaNgTaoHoaDon(String maNgTaoHoaDon) {
        this.maNgTaoHoaDon = maNgTaoHoaDon;
    }

    public void setNgayTaoHoaDon(String ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

}
