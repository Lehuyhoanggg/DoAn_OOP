package util;

import java.util.ArrayList;

import danhsach.DanhSachBaoHanh;
import danhsach.DanhSachChiTietHoaDon;
import danhsach.DanhSachHangThanhVien;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachMaGiamGia;
import danhsach.DanhSachSanPham;
import danhsach.DanhSachSanPhamDaBan;
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
import model.SanPhamDaBan;
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
        String ngaySinh = Nhap.nhapNgay("Nhap ngay sinh (dd/MM/yyyy): ");
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
        int trangThai = Nhap.nhapInt("Nhap trang thai (1)Con Hang (2)Het Hang (3)Ngung Kinh Doanh): ");
        String trangThaiStr = "";
        switch (trangThai) {
            case 1:
                trangThaiStr = "Con Hang";
                break;
            case 2:
                trangThaiStr = "Het Hang";
                break;
            case 3:
                trangThaiStr = "Ngung Kinh Doanh";
                break;
            default:
                break;
        }
        return new SanPham(ma, ten, danhMuc, thuongHieu, gia, tonKho, moTa, trangThaiStr);
    }

    public static PhieuTraHang taoPhieuTraHang(KhachHang khachHang, SanPham sanPham, String serial, Database db) {
        String maTraHang = CapMa.capMaBaoHanh(db);
        String ngayTra = ThoiGian.layNgayHienTaiStr();
        String lyDoTra = Nhap.nhapStr("Nhap ly do tra : ");
        PhieuTraHang phieuTraHang = new PhieuTraHang(maTraHang, khachHang, sanPham, serial, ngayTra, lyDoTra);
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
        String ngayBatDau = Nhap.nhapNgay("Nhap ngay bat dau (yyyy-MM-dd): ");
        String ngayKetThuc = Nhap.nhapNgay("Nhap ngay ket thuc (yyyy-MM-dd): ");

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

        String maSanPham = Nhap.nhapStr("Nhap ma san pham : ");
        SanPham sanPham = danhSachSanPham.tim(maSanPham);

        String ngayBatDau = ThoiGian.layNgayHienTaiStr();
        String ngayKetThuc = ThoiGian.ngaySauNThang(ngayBatDau, Integer.parseInt(loaiBaoHanh.replaceAll("\\D+", "")));
        long gia = Nhap.nhapLong("Nhap gia cua bao hanh : ");
        loaiBaoHanh = "BaoHanh" + loaiBaoHanh + "T";
        if (sanPham == null) {
            return null;
        }
        return new BaoHanh(maBaoHanh, loaiBaoHanh, sanPham, ngayBatDau, ngayKetThuc, gia);
    }

    public static ArrayList<ChiTietHoaDon> taoListChiTietHoaDon(Database db, KhachHang khachHang) {
        ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();

        DanhSachBaoHanh danhSachBaoHanh = new DanhSachBaoHanh(db.getListBaoHanh());
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham(db.getListSanPham());
        // lap tao lan luot chi tiet hoa don
        DanhSachSanPhamDaBan danhSachSanPhamDaBan = db.getDanhSachSanPhamDaBan();
        do {
            // chon san pham
            SanPham sanPham = null;
            do {
                String ma = Nhap.nhapStr("Nhap ma san pham can them hoac nhan 0 de thoat: ");
                if (ma.replaceAll("\\s+", "").equals("0")) {
                    return listChiTietHoaDon;
                }
                sanPham = danhSachSanPham.tim(ma);

                if (sanPham == null) {
                    System.out.println("Ma san pham pham khong hop le, vui long nhap lai");
                }
                if (sanPham.getTrangThai().equals("Ngung Kinh Doanh")) {
                    System.out.println("San pham da ngung kinh doanh");
                    sanPham = null;
                }
            } while (sanPham == null);
            ///////////////

            int soSp = Nhap.nhapInt("Nhap so luong : ");
            if (sanPham.getTonKho() < soSp) {
                System.out.println("So luong san pham trong kho khong du");
                continue;//////////
            }

            // tao 1 chi tiet cho vong lap nay
            String ma = CapMa.capMaChiTietHoaDon(db);
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(ma);
            ////

            for (int i = 0; i < soSp; i++) {

                sanPham.giamTonKho();
                String serial = sanPham.getMa() + "-" + ThoiGian.layNgayHienTaiStr().replaceAll("/", "-")
                        + khachHang.getMaKh()
                        + "-" + i; //// tạo mã duy nhất cho sản phẩm sau khi bán để bảo hành hoặc trả hàng

                ArrayList<BaoHanh> listBaoHanh = danhSachBaoHanh.tim(sanPham); // check bảo hành sản phẩm
                if (listBaoHanh.size() == 0) {
                    // ko có bảo hành
                    SanPhamDaBan sanPhamDaBan = new SanPhamDaBan(CapMa.capMaSanPhamDaban(db),new SanPham(sanPham), serial, null);
                    chiTietHoaDon.themSanPhamDaBan(sanPhamDaBan);
                    danhSachSanPhamDaBan.them(sanPhamDaBan);
                    System.out
                            .println("Da them san pham : " + sanPham.getTen() + "    voi serial : " + serial
                                    + " vao hoa don");
                    continue;
                }
                System.out
                        .println("Da them san pham : " + sanPham.getTen() + "    voi serial : " + serial
                                + " vao hoa don");
                int luaChon = Nhap.nhapInt("Them bao hanh cho san pham nay khong? (1)Co (soKhac)Khong: ");
                if (luaChon != 1) {// ko them
                    SanPhamDaBan sanPhamDaBan = new SanPhamDaBan(CapMa.capMaSanPhamDaban(db), new SanPham(sanPham), serial, null);
                    chiTietHoaDon.themSanPhamDaBan(sanPhamDaBan);
                    danhSachSanPhamDaBan.them(sanPhamDaBan);
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
                    baoHanh.setSerial(serial);
                    baoHanh.setSanPham(sanPham);
                    khachHang.themBaoHanh(baoHanh);

                    SanPhamDaBan sanPhamDaBan = new SanPhamDaBan(CapMa.capMaSanPhamDaban(db),new SanPham(sanPham), serial, baoHanh);
                    chiTietHoaDon.themSanPhamDaBan(sanPhamDaBan);
                    danhSachSanPhamDaBan.them(sanPhamDaBan);// them vao db
                }
            }
            listChiTietHoaDon.add(chiTietHoaDon);
        } while (true);

    }

    public static HoaDon taoHoaDon(Database db) {
        String ma = CapMa.capMaHoaDon(db);
        DanhSachKhachHang danhSachKhachHang = new DanhSachKhachHang(db.getListKhachHang());
        String sdt = Nhap.nhapStr("Nhap so dien thoai khach hang : ");
        KhachHang khachHang = danhSachKhachHang.timKhachHangTheoSdt(sdt);
        if (khachHang == null) {
            System.out.println("Khach hang khong ton tai");
            int chon = Nhap.nhapInt("Ban co muon tao moi khach hang khong? (1)Co (khac)khong : ");
            if (chon != 1) {
                return null;
            }
            System.out.println("Tao moi khach hang");
            khachHang = taoKhachHang(db, sdt);
            danhSachKhachHang.them(khachHang);
        }

        ArrayList<ChiTietHoaDon> listChiTietHoaDon = taoListChiTietHoaDon(db, khachHang);
        if (listChiTietHoaDon.size() == 0) {
            return null;
        }
        DanhSachChiTietHoaDon danhSachChiTietHoaDon = db.getDanhSachChiTietHoaDon();
        for (ChiTietHoaDon chiTietHoaDon : listChiTietHoaDon) {/// đưa vào database
            danhSachChiTietHoaDon.them(chiTietHoaDon);
        }

        String ngayTaoHoaDon = ThoiGian.layNgayHienTaiStr();
        String ghiChu = Nhap.nhapStr("Nhap ghi chu neu co : ");
        HoaDon hoaDon = new HoaDon(ma, khachHang, ngayTaoHoaDon, ghiChu);
        hoaDon.setListChiTietHoaDon(listChiTietHoaDon);
        for (ChiTietHoaDon chiTietHoaDon : listChiTietHoaDon) {
            hoaDon.tangThanhTien(chiTietHoaDon.getThanhTien());
        }

        hoaDon.setKhachHang(khachHang);
        khachHang.themHoaDon(hoaDon);
        khachHang.tangTienDaChi(hoaDon.getThanhTien());
        ////// thêm hạng thành viên mới nếu có cho khách hàng
        DanhSachHangThanhVien danhSachHangThanhVien = new DanhSachHangThanhVien(db.getListHangThanhVien());
        danhSachHangThanhVien.setHangThanhVienChoKhachHang(khachHang);
        hoaDon.tinhThanhTien();
        if (hoaDon != null) {
            DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(hoaDon.getKhachHang().getListMaGiamGia());
            danhSachMaGiamGia.setThanhTienDaApMaGG(hoaDon);
        }

        System.out.println("Danh sach ma giam gia da dung :");
        boolean timThay = false;
        for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {
            for (SanPhamDaBan sanPhamDaBan : chiTietHoaDon.getSanPhamDaBan()) {
                ArrayList<MaGiamGia> listMaGiamGia = sanPhamDaBan.getListMaGiamGiaDaDung();
                if (listMaGiamGia.size() > 0) {
                    for (int i = 0; i < listMaGiamGia.size(); i++) {
                        System.out.println(listMaGiamGia.get(i));
                        timThay = true;
                    }
                }
            }
        }
        if (!timThay) {
            System.out.println("Khong co ma giam gia duoc ap dung trong hoa don nay");
        }
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
        String ngaySinh = Nhap.nhapNgay("Nhap ngay sinh (dd/MM/yyyy): ");
        String sdt = Nhap.nhapStr("Nhap so dien thoai: ");
        String gioiTinh = Nhap.nhapStr("Nhap gioi tinh: ");
        return new QuanLy(ma, cccd, ten, ngaySinh, sdt, gioiTinh);
    }
}