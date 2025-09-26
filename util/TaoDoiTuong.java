package util;

import database.Database;
import model.BaoHanh;
import model.HangThanhVien;
import model.KhachHang;
import model.MaGiamGia;
import model.NhanVien;
import model.PhieuBaoHanh;
import model.PhieuTraHang;
import model.SanPham;
import model.TinNhan;
import service.BaoHanhService;
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

    public static HangThanhVien taoHangThanhVien(Database db) {
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien: ");
        String moTa = Nhap.nhapStr("Nhap mo ta: ");
        return new HangThanhVien(ten, moTa);
    }

    public static MaGiamGia taoMaGiamGia() {
        String ma = Nhap.nhapStr("Nhập mã giảm giá: ");
        String tenMa = Nhap.nhapStr("Nhập tên mã: ");
        String loaiDoanhMuc = Nhap.nhapStr("Nhập loại danh mục (để trống nếu không muốn): ");
        String loaiThuongHieu = Nhap.nhapStr("Nhập loại thương hiệu (để trống nếu không muốn): ");
        String mucGiamGiaStr = Nhap.nhapStr("Nhập số tiền giảm (để trống nếu không muốn): ");
        long soTienGiam = 0;
        if (!mucGiamGiaStr.isEmpty()) {
            soTienGiam = Long.parseLong(mucGiamGiaStr);
        }

        String ngayBatDau = Nhap.nhapStr("Nhập ngày bắt đầu (yyyy-MM-dd): ");
        String ngayKetThuc = Nhap.nhapStr("Nhập ngày kết thúc (yyyy-MM-dd): ");

        return new MaGiamGia(ma, tenMa, loaiDoanhMuc, loaiThuongHieu, soTienGiam, ngayBatDau, ngayKetThuc);
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

    public static PhieuBaoHanh taoPhieuBaoHanh(Database db) {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        System.out.println("Tao phieu bao hanh");
        String maPhieuBaoHanh = CapMa.capMaPhieuBaoHanh(db);
        String maKhachHang = Nhap.nhapStr("Nhap ma khach hang: ");
        KhachHang khachHang = khacHangService.timKhachHang(maKhachHang);

        String maSanPham = Nhap.nhapStr("Nhap ma san pham : ");
        SanPham sanPham = sanPhamService.timSanPham(maSanPham);

        String ngayBaoHanh = Nhap.nhapStr("Nhap ngay bao hanh (dd/MM/yyyy): ");
        String chiTietLoi = Nhap.nhapStr("Nhap chi tiet loi");
        PhieuBaoHanh phieuBaoHanh = new PhieuBaoHanh(maPhieuBaoHanh, khachHang, sanPham, ngayBaoHanh, chiTietLoi);
        khachHang.themPhieuBaoHanh(phieuBaoHanh);
        return phieuBaoHanh;
    }

    public static BaoHanh taoBaoHanh(Database db) {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());

        System.out.println("Tao bao hanh");
        String maBaoHanh = CapMa.capMaBaoHanh(db);
        String tenBaoHanh = Nhap.nhapStr("Nhap ten bao hanh : ");
        String maKhachHang = Nhap.nhapStr("Nhap ma khach hang: ");
        KhachHang khachHang = khacHangService.timKhachHang(maKhachHang);

        String maSanPham = Nhap.nhapStr("Nhap ma san pham : ");
        SanPham sanPham = sanPhamService.timSanPham(maSanPham);

        String ngayBatDau = Nhap.nhapStr("Nhap ngay bat dau bao hanh  ");
        String ngayKetThuc = Nhap.nhapStr("Nhap ngay ket thuc bao hanh (dd/MM/yyyy): ");
        if (sanPham == null || khachHang == null) {
            return null;
        }
        BaoHanh baoHanh = new BaoHanh(maBaoHanh, tenBaoHanh, khachHang, sanPham, ngayBatDau, ngayKetThuc);
        khachHang.themBaoHanh(baoHanh);
        return baoHanh;
    }
}