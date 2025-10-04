package util;

import java.util.ArrayList;

import danhsach.DanhSachBaoHanh;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachMaGiamGia;
import danhsach.DanhSachSanPham;
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
        String tenKh = Nhap.nhapStr("Nhap ten khach hang: ");///
        String sdt = Nhap.nhapStr("Nhap so dien thoai: ");
        KhachHang khachHang = new KhachHang(maKh, tenKh, sdt);
        khachHang.getListMaGiamGia().addAll(db.getListMaGiamGia());
        return khachHang;
    }

    public static KhachHang taoKhachHang(Database db, String sdt) {
        String maKh = CapMa.capMaKhachHang(db);
        String tenKh = Nhap.nhapStr("Nhap ten khach hang: ");////
        KhachHang khachHang = new KhachHang(maKh, tenKh, sdt);
        khachHang.getListMaGiamGia().addAll(db.getListMaGiamGia());
        return khachHang;
    }

    public static PhieuBaoHanh taoPhieuBaoHanh(BaoHanh baoHanh, KhachHang khachHang, Database db) {
        System.out.println("Tao phieu bao hanh");
        String maPhieuBaoHanh = CapMa.capMaPhieuBaoHanh(db);
        SanPham sanPham = baoHanh.getSanPham();
        String ngayBaoHanh = ThoiGian.layNgayHienTaiStr();
        String chiTietLoi = Nhap.nhapStr("Nhap chi tiet loi : ");
        PhieuBaoHanh phieuBaoHanh = new PhieuBaoHanh(maPhieuBaoHanh, khachHang, sanPham, ngayBaoHanh, chiTietLoi);
        khachHang.themPhieuBaoHanh(phieuBaoHanh);
        return phieuBaoHanh;
    }

    public static BaoHanh taoBaoHanh(Database db) {
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham(db.getListSanPham());
        String maBaoHanh = CapMa.capMaBaoHanh(db);
        String loaiBaoHanh = Nhap.nhapStr("Nhap so thang bao hanh : ");
        loaiBaoHanh = "BaoHanh" + loaiBaoHanh + "T";
        String maSanPham = Nhap.nhapStr("Nhap ma san pham : ");
        SanPham sanPham = danhSachSanPham.timSanPham(maSanPham);

        String ngayBatDau = ThoiGian.layNgayHienTaiStr();
        String ngayKetThuc = ThoiGian.ngaySauNThang(ngayBatDau, Integer.parseInt(loaiBaoHanh.replace("\\D+", "")));
        if (sanPham == null) {
            return null;
        }
        return new BaoHanh(maBaoHanh, loaiBaoHanh, sanPham, ngayBatDau, ngayKetThuc);
    }

    public static ChiTietHoaDon taoChiTietHoaDon(Database db, KhachHang khachHang) {
        String ma = CapMa.capMaChiTietHoaDon(db);
        DanhSachBaoHanh danhSachBaoHanh = new DanhSachBaoHanh(db.getListBaoHanh());
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham(db.getListSanPham());
        DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(khachHang.getListMaGiamGia());/// lay ma giam gia
                                                                                                  /// cua doi tuong
                                                                                                  /// khach hang
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(ma);
        int soSp = Nhap.nhapInt("Nhap so san pham can them : ");

        for (int i = 0; i < soSp; i++) {
            String maSp = Nhap.nhapStr("Nhap ma san Pham " + (i + 1) + " : ");
            SanPham sanPham = danhSachSanPham.timSanPham(maSp);
            if (sanPham == null) {
                System.out.println("Ko tim thay san pham cua ma " + maSp);
                continue;
            }
            if (sanPham.getTonKho() == 0) {
                System.out.println("San pham da het hang , vui long chon san pham khac");
                i--;
                continue;
            }
            chiTietHoaDon.themSanPham(sanPham);
            sanPham.giamTonKho();
            ;
            System.out.println("Them san pham thanh cong");
            ArrayList<BaoHanh> listBaoHanh = danhSachBaoHanh.timBaoHanh(sanPham);
            if (listBaoHanh.size() == 0) {
                continue;
            }
            int luaChon = Nhap.nhapInt("Them bao hanh cho san pham nay khong? (1)Co (soKhac)Khong: ");
            if (luaChon != 1) {
                continue;
            }
            for (int j = 0; j < listBaoHanh.size(); j++) {
                BaoHanh baoHanh = listBaoHanh.get(j);
                System.out.println(j + ". " + baoHanh.getLoaiBaoHanh());
            }
            luaChon = Nhap.nhapInt("Chon bao hanh : ");
            if (luaChon < 0 || luaChon >= listBaoHanh.size()) {
                System.out.println("Lua chon khong hop le");
            } else {
                BaoHanh baoHanh = new BaoHanh(listBaoHanh.get(luaChon));
                baoHanh.setNgayBatDau(ThoiGian.layNgayHienTaiStr());
                baoHanh.setNgayKetThuc();
                khachHang.themBaoHanh(baoHanh);
                chiTietHoaDon.themBaoHanh(baoHanh);
            }

        }
        danhSachMaGiamGia.setThanhTienDaApMaGG(chiTietHoaDon);
        return chiTietHoaDon;
    }

    public static HoaDon taoHoaDon(Database db) {
        String ma = CapMa.capMaHoaDon(db);
        DanhSachKhachHang danhSachKhachHang = new DanhSachKhachHang(db.getListKhachHang());
        String sdt = Nhap.nhapStr("Nhap so dien thoai khach hang : ");
        KhachHang khachHang = danhSachKhachHang.timKhachHangTheoSdt(sdt);
        if (khachHang == null) {
            System.out.println("Khach hang khong ton tai");
            System.out.println("Tao moi khach hang");
            khachHang = taoKhachHang(db, sdt);
            danhSachKhachHang.themKhachHang(khachHang);
        }

        ChiTietHoaDon chiTietHoaDon = taoChiTietHoaDon(db, khachHang);
        String ngayTaoHoaDon = ThoiGian.layNgayHienTaiStr();
        String ghiChu = Nhap.nhapStr("Nhap ghi chu neu co : ");
        HoaDon hoaDon = new HoaDon(ma, khachHang, chiTietHoaDon, ngayTaoHoaDon, ghiChu);
        ArrayList<MaGiamGia> listMaGiamGia = chiTietHoaDon.getListMaGiamGiaDaDung();
        if (listMaGiamGia.size() > 0) {
            System.out.println("Danh sach ma giam gia da dung :");
            for (int i = 0; i < listMaGiamGia.size(); i++) {
                System.out.println(listMaGiamGia.get(i));
            }
        }
        khachHang.themHoaDon(hoaDon);
        khachHang.tangTienDaChi(hoaDon.getThanhTien());
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