package util;

import javax.swing.plaf.ScrollBarUI;

import database.Database;
import model.HangThanhVien;
import model.KhachHang;
import model.NhanVien;
import model.PhieuTraHang;
import model.SanPham;
import model.TinNhan;
import service.HangThanhVienService;
import service.KhacHangService;
import service.SanPhamService;
import ui.Nhap;

public class TaoDoiTuong {
    public static TinNhan taoTinNhan(String maNG, String tenNG) {
        String noiDung = Nhap.nhapStr("Nhap noi dung : ");
        return new TinNhan(maNG, tenNG, noiDung, ThoiGian.layNgayHienTaiStr());
    }

    public static NhanVien taoNhanVien() {
        String ma = Nhap.nhapStr("Nhap ma nhan vien: ");
        String cccd = Nhap.nhapStr("Nhap cccd: ");
        String ten = Nhap.nhapStr("Nhap ten: ");
        String ngaySinh = Nhap.nhapStr("Nhap ngay sinh (dd/MM/yyyy): ");
        String sdt = Nhap.nhapStr("Nhap so dien thoai: ");
        String gioiTinh = Nhap.nhapStr("Nhap gioi tinh: ");
        return new NhanVien(ma, cccd, ten, ngaySinh, sdt, gioiTinh);
    }

    public static SanPham taoSanPham() {
        String ma = Nhap.nhapStr("Nhap ma san pham: ");
        String ten = Nhap.nhapStr("Nhap ten san pham: ");
        String danhMuc = Nhap.nhapStr("Nhap danh muc: ");
        String thuongHieu = Nhap.nhapStr("Nhap thuong hieu: ");
        long gia = Nhap.nhapLong("Nhap gia: ");
        int tonKho = Nhap.nhapInt("Nhap so luong : ");
        String moTa = Nhap.nhapStr("Nhap mo ta: ");
        String trangThai = Nhap.nhapStr("Nhap trang thai (Con Hang,Het Hang,Ngung Kinh doanh): ");
        return new SanPham(ma, ten, danhMuc, thuongHieu, gia, tonKho, moTa, trangThai);
    }

    public static PhieuTraHang taoPhieuTraHang(Database db) {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        String maTraHang = CapMa.capMaBaoHanh(db);
        KhachHang khachHang = khacHangService.timKhachHang(Nhap.nhapStr("Nhap ma khach hang can them : "));
        SanPham sanPham = sanPhamService.timSanPham(Nhap.nhapStr("Nhap ma san pham can them : "));
        String ngayTra = Nhap.nhapStr("Nhap ngay tra : ");
        String lyDoTra = Nhap.nhapStr("Nhap ly do tra : ");
        return new PhieuTraHang(maTraHang, khachHang, sanPham, ngayTra, lyDoTra);
    }

    public static KhachHang taoKhachHang(Database db) {
        String maKh = Nhap.nhapStr("Nhap ma khach hang: ");
        String tenKh = Nhap.nhapStr("Nhap ten khach hang: ");
        String sdt = Nhap.nhapStr("Nhap so dien thoai: ");
        String tenHangThanhVien = Nhap.nhapStr("Nhap ten hang thanh vien : ");
        HangThanhVienService hangThanhVienService = new HangThanhVienService(db.getListHangThanhVien());
        HangThanhVien hangThanhVien = hangThanhVienService.timHangThanhVien(tenHangThanhVien);
        return new KhachHang(maKh, tenKh, sdt, hangThanhVien);
    }

}