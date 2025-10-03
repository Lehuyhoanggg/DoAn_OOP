package model;

public class HoaDon {
    private String ma;
    private KhachHang khachHang;
    private ChiTietHoaDon chiTietHoaDon;
    private String ngayTaoHoaDon;
    private String ghiChu;

    public HoaDon() {

    }

    public HoaDon(String ma, KhachHang khachHang, ChiTietHoaDon chiTietHoaDon, String ngayTaoHoaDon,
            String ghiChu) {
        this.ma = ma;
        this.khachHang = khachHang;
        this.chiTietHoaDon = chiTietHoaDon;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
        this.ghiChu = ghiChu;
    }

    public ChiTietHoaDon getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public String getMa() {
        return ma;
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

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setNgayTaoHoaDon(String ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

    public long getThanhTien() {
        return chiTietHoaDon.getThanhTien();
    }

    @Override
    public String toString() {
        return chiTietHoaDon.getMa() + " " +
                khachHang.getMaKh() + " " +
                getMa() + " " +
                getGhiChu() + " " +
                getNgayTaoHoaDon() + " " +
                getThanhTien();
    }
}