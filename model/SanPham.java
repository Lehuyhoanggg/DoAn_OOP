package model;

public class SanPham {
    private String ma;
    private String ten;
    private String danhMuc;
    private String thuongHieu;
    private long gia;
    private int tonKho;
    private String moTa;
    private String trangThai;

    public SanPham(String ma, String ten, String danhMuc, String thuongHieu, long gia, int tonKho, String moTa,
            String trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.danhMuc = danhMuc;
        this.thuongHieu = thuongHieu;
        this.gia = gia;
        this.tonKho = tonKho;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public SanPham() {
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public String getTen() {
        return ten;
    }

    public long getGia() {
        return gia;
    }

    public String getMa() {
        return ma;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public int getTonKho() {
        return tonKho;
    }

    

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
