package model;

public class NhanVien extends User {
    private LichLamViec lichLamViec;
    private long luong;

    public NhanVien() {
    }

    public NhanVien(String ma, String cccd, String ten,
            String ngaySinh, String sdt, String gioiTinh) {
        super(ma, cccd, ten, ngaySinh, sdt, gioiTinh);
        setQuyenHang("NhanVien");
    }

    public long getLuong() {
        return luong;
    }

    public LichLamViec getLichLamViec() {
        return lichLamViec;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public void setLichLamViec(LichLamViec lichLamViec) {
        this.lichLamViec = lichLamViec;
    }

}
