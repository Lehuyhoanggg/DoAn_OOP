package util;

import database.Database;
import model.BaoHanh;
import model.ChiTietHoaDon;
import model.HangThanhVien;
import model.HoaDon;
import model.KhachHang;
import model.MaGiamGia;
import model.NhanVien;
import model.PhieuBaoHanh;
import model.PhieuTraHang;
import model.QuanLy;
import model.SanPham;
import model.TaiKhoan;
import model.TinNhan;
import service.BaoHanhService;
import service.KhacHangService;
import service.MaGiamGiaService;
import service.SanPhamService;
import ui.Nhap;

public class TaoDoiTuong {
    public static TinNhan taoTinNhan(String tenNG, Database db) {
        String maNG = CapMa.capMaTinNhan(db);
        String noiDung = Nhap.nhapStr("Nhap noi dung : ");
        return new TinNhan(maNG, tenNG, noiDung, ThoiGian.layNgayHienTaiStr());
    }

    public static NhanVien taoNhanVien(Database db) {
        String ma = CapMa.capMaNhanVien(db);
        String cccd = Nhap.nhapStr("Nhap cccd: ");
        String ten = Nhap.nhapStr("Nhap ten: ");
        String ngaySinh = Nhap.nhapStr("Nhap ngay sinh (dd/MM/yyyy): ");
        String sdt = Nhap.nhapStr("Nhap so dien thoai: ");
        String gioiTinh = Nhap.nhapStr("Nhap gioi tinh: ");
        return new NhanVien(ma, cccd, ten, ngaySinh, sdt, gioiTinh);
    }

    public static SanPham taoSanPham(Database db) {
        String ma = CapMa.capMaSanPham(db);
        String ten = Nhap.nhapStr("Nhap ten san pham: ");
        String danhMuc = Nhap.nhapStr("Nhap danh muc: ");
        String thuongHieu = Nhap.nhapStr("Nhap thuong hieu: ");
        long gia = Nhap.nhapLong("Nhap gia: ");
        int tonKho = Nhap.nhapInt("Nhap so luong : ");
        String moTa = Nhap.nhapStr("Nhap mo ta: ");
        String trangThai = Nhap.nhapStr("Nhap trang thai (Con Hang,Het Hang,Ngung Kinh doanh): ");
        return new SanPham(ma, ten, danhMuc, thuongHieu, gia, tonKho, moTa, trangThai);
    }

    public static PhieuTraHang taoPhieuTraHang(KhachHang khachHang, SanPham sanPham, Database db) {
        String maTraHang = CapMa.capMaBaoHanh(db);
        String ngayTra = ThoiGian.layNgayHienTaiStr();
        String lyDoTra = Nhap.nhapStr("Nhap ly do tra : ");
        PhieuTraHang phieuTraHang = new PhieuTraHang(maTraHang, khachHang, sanPham, ngayTra, lyDoTra);
        khachHang.themPhieuTraHang(phieuTraHang);
        return phieuTraHang;
    }

    public static HangThanhVien taoHangThanhVien(Database db) {
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien: ");
        String moTa = Nhap.nhapStr("Nhap mo ta: ");
        return new HangThanhVien(ten, moTa);
    }

    public static MaGiamGia taoMaGiamGia(Database db) {
        String ma = CapMa.capMaMaGiamGia(db);
        String tenMa = Nhap.nhapStr("Nhap ten ma: ");
        String loaiDoanhMuc = Nhap.nhapStr("Nhap loai danh muc (de trong neu khong muon): ");
        String loaiThuongHieu = Nhap.nhapStr("Nhap loai thuong hieu (de trong neu khong muon): ");
        String soTienGiam = Nhap.nhapStr("Nhap so tien giam(x) hoac % giam(x%) : ");
        String ngayBatDau = Nhap.nhapStr("Nhap ngay bat dau (yyyy-MM-dd): ");
        String ngayKetThuc = Nhap.nhapStr("Nhap ngay ket thuc (yyyy-MM-dd): ");

        return new MaGiamGia(ma, tenMa, loaiDoanhMuc, loaiThuongHieu, soTienGiam, ngayBatDau, ngayKetThuc);
    }

    public static KhachHang taoKhachHang(Database db) {
        String maKh = CapMa.capMaKhachHang(db);
        String tenKh = Nhap.nhapStr("Nhap ten khach hang: ");
        String sdt = Nhap.nhapStr("Nhap so dien thoai: ");
        KhachHang khachHang = new KhachHang(maKh, tenKh, sdt);
        khachHang.getListMaGiamGia().addAll(db.getListMaGiamGia());
        return khachHang;
    }

    public static PhieuBaoHanh taoPhieuBaoHanh(BaoHanh baoHanh, Database db) {
        System.out.println("Tao phieu bao hanh");
        String maPhieuBaoHanh = CapMa.capMaPhieuBaoHanh(db);
        KhachHang khachHang = baoHanh.getKhachHang();
        SanPham sanPham = baoHanh.getSanPham();
        String ngayBaoHanh = ThoiGian.layNgayHienTaiStr();
        String chiTietLoi = Nhap.nhapStr("Nhap chi tiet loi : ");
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

    public static ChiTietHoaDon taoChiTietHoaDon(Database db, KhachHang khachHang) {
        String ma = CapMa.capMaChiTietHoaDon(db);
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(khachHang.getListMaGiamGia());
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(ma);
        int soSp = Nhap.nhapInt("Nhap so san pham can them : ");
        int soBh = Nhap.nhapInt("Nhap so bao hanh can them : ");
        for (int i = 0; i < soSp; i++) {
            String maSp = Nhap.nhapStr("Nhap ma san Pham " + (i + 1) + " : ");
            SanPham sanPham = sanPhamService.timSanPham(maSp);
            if (sanPham == null) {
                System.out.println("Ko tim thay san pham cua ma " + maSp);
                continue;
            }
            chiTietHoaDon.themSanPham(sanPham);
            System.out.println("Them thanh cong");
        }
        maGiamGiaService.setThanhTienDaApMaGG(chiTietHoaDon);
        for (int i = 0; i < soBh; i++) {
            String maBh = Nhap.nhapStr("Nhap ma bao hanh " + (i + 1) + " : ");
            BaoHanh baoHanh = baoHanhService.timBaoHanh(maBh);
            if (baoHanh == null) {
                System.out.println("Ko tim thay bao hanh cua ma " + maBh);
                continue;
            }
            chiTietHoaDon.themBaoHanh(baoHanh);
            khachHang.themBaoHanh(baoHanh);

            System.out.println("Them thanh cong");
        }
        return chiTietHoaDon;
    }

    public static HoaDon taoHoaDon(Database db) {
        String ma = CapMa.capMaHoaDon(db);
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        KhachHang khachHang = khacHangService.timKhachHang(Nhap.nhapStr("Nhap so dien thoai khach hang : "));
        if (khachHang == null) {
            System.out.println("Khach hang khong ton tai");
            System.out.println("Tao moi khach hang");
            khachHang = taoKhachHang(db);
        }

        ChiTietHoaDon chiTietHoaDon = taoChiTietHoaDon(db, khachHang);
        String ngayTaoHoaDon = ThoiGian.layNgayHienTaiStr();
        String ghiChu = Nhap.nhapStr("Nhap ghi chu neu co : ");
        HoaDon hoaDon = new HoaDon(ma, khachHang, chiTietHoaDon, ngayTaoHoaDon, ghiChu);
        khachHang.themHoaDon(hoaDon);
        return hoaDon;
    }

    public static TaiKhoan taoTaiKhoan() {
        String tenDangNhap = Nhap.nhapStr("Nhap ten dang nhap : ");
        String matKhau = Nhap.nhapStr("Nhap mat khau : ");
        return new TaiKhoan(tenDangNhap, matKhau);
    }

    public static QuanLy TaoDoiTuongQuanLy(Database db) {
        String ma = CapMa.capMaQuanly(db);
        String cccd = Nhap.nhapStr("Nhap cccd: ");
        String ten = Nhap.nhapStr("Nhap ten: ");
        String ngaySinh = Nhap.nhapStr("Nhap ngay sinh (dd/MM/yyyy): ");
        String sdt = Nhap.nhapStr("Nhap so dien thoai: ");
        String gioiTinh = Nhap.nhapStr("Nhap gioi tinh: ");
        return new QuanLy(ma, cccd, ten, ngaySinh, sdt, gioiTinh);
    }
}