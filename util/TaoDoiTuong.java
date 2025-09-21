package util;

import model.NhanVien;
import model.TinNhan;
import ui.Nhap;

public class TaoDoiTuong {
    public TinNhan taoTinNhan(String maNG, String tenNG) {
        String noiDung = Nhap.nhapStr("Nhap noi dung : ");
        return new TinNhan(maNG, tenNG, noiDung, ThoiGian.layNgayHienTaiStr());
    }

    public NhanVien taoNhanVien() {
        String ma = Nhap.nhapStr("Nhap ma nhan vien: ");
        String cccd = Nhap.nhapStr("Nhap cccd: ");
        String ten = Nhap.nhapStr("Nhap ten: ");
        String ngaySinh = Nhap.nhapStr("Nhap ngay sinh (dd/MM/yyyy): ");
        String sdt = Nhap.nhapStr("Nhap so dien thoai: ");
        String gioiTinh = Nhap.nhapStr("Nhap gioi tinh: ");
        return new NhanVien(ma, cccd, ten, ngaySinh, sdt, gioiTinh);
    }
}