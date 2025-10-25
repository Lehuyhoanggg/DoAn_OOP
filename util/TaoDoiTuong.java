package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import danhsach.DanhSachBaoHanh;
import danhsach.DanhSachChiTietHoaDon;
import danhsach.DanhSachHangThanhVien;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachMaGiamGia;
import danhsach.DanhSachSanPham;
import danhsach.DanhSachThongTinSanPham;
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
import model.ThongTinSanPham;
import model.TaiKhoan;
import model.TinNhan;

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

    public static ThongTinSanPham taoSanPham(Database db) {
        String ma = CapMa.capMaThongTinSanPham(db);
        String ten = Nhap.nhapStr("Nhap ten san pham: ");
        String danhMuc = Nhap.nhapStr("Nhap danh muc: ");
        String thuongHieu = Nhap.nhapStr("Nhap thuong hieu: ");
        long gia = Nhap.nhapLong("Nhap gia: ");
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
        return new ThongTinSanPham(ma, ten, danhMuc, thuongHieu, gia, moTa, trangThaiStr);
    }

    public static PhieuTraHang taoPhieuTraHang(KhachHang khachHang, SanPham sanPham,
            Database db) {
        String maTraHang = CapMa.capMaPhieuTraHang(db);
        String ngayTra = ThoiGian.layNgayHienTaiStr();
        String lyDoTra = Nhap.nhapStr("Nhap ly do tra : ");
        PhieuTraHang phieuTraHang = new PhieuTraHang(maTraHang, khachHang, sanPham, ngayTra, lyDoTra);
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
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        String maBaoHanh = CapMa.capMaBaoHanh(db);
        String loaiBaoHanh = Nhap.nhapStr("Nhap so thang bao hanh : ");

        String maSanPham = Nhap.nhapStr("Nhap so serial san pham : ");
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

    public static ArrayList<ChiTietHoaDon> taoListChiTietHoaDon(Database db,
            KhachHang khachHang) {
        ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();// list chứa chi tiết hóa đơn của 1 hóa đơn

        DanhSachBaoHanh danhSachBaoHanh = db.getDanhSachBaoHanh();
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        DanhSachThongTinSanPham danhSachThongTinSanPham = db.getDanhSachThongTinSanPham();
        do {
            // chon san pham
            ThongTinSanPham thongTinSanPham = null;
            int soLuong=0;
            do {
                String ma = Nhap.nhapStr("Nhap ma thong tin san pham de tao ChiTietHoaDon hoac nhan 0 de thoat: ");
                if (ma.replaceAll("\\s+", "").equals("0")) {
                    return listChiTietHoaDon;
                }
                thongTinSanPham = danhSachThongTinSanPham.tim(ma);
                if (thongTinSanPham == null) {
                    System.out.println("Khong ton tai thong tin cua san pham nay, vui long nhap lai");
                    continue;
                }
                soLuong = Nhap.nhapInt("Nhap so luong san pham nay can them vao: ");
                if (thongTinSanPham.getTonKho() == 0) {
                    System.out.println("So luong san pham trong kho khong du");
                    continue;//////////
                }
            } while (thongTinSanPham == null);

            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(CapMa.capMaChiTietHoaDon(db));
            Set<String> set = new HashSet<>();

            do { /////////////// nhập sao cho đủ số lượng thì thôi

                String maSr = Nhap.nhapStr("Nhap ma serial san pham cua " +
                        thongTinSanPham.getMa() + " : ");
                SanPham sanPham = danhSachSanPham.timSanPhamChuaBan(maSr);

                if (sanPham == null) {
                    System.out.println("Khong co san pham voi serial " + maSr + " trong kho san pham kha dung");
                    continue;
                }

                if (!sanPham.getMa().equals(thongTinSanPham.getMa())) {
                    System.out.println("Da khong phai la san pham cua " +
                            thongTinSanPham.getMa());
                    continue;
                }
                if (set.contains(maSr)) {
                    System.out.println("Ban da them san pham nay roi");
                    continue;
                }

                if (sanPham.getTrangThai().equals("Ngung Kinh Doanh")) {
                    System.out.println("San pham da ngung kinh doanh");
                    continue;
                }
                if (sanPham.getTrangThai().equals("Het Hang")) {
                    System.out.println("San pham da het hang");
                    continue;
                }

                thongTinSanPham.giamTonKho();
                soLuong--;
                System.out
                        .println("Da them san pham : " + sanPham.getTen() + " voi serial : " +
                                sanPham.getSerial()
                                + " vao hoa don");
                sanPham.setDaBan(true);
                chiTietHoaDon.themSanPham(sanPham);

                set.add(maSr);
                ArrayList<BaoHanh> listBaoHanh = danhSachBaoHanh.timBaoHanh(sanPham); // check danh sách bảo hành sản
                // phẩm
                if (listBaoHanh.size() == 0) {// ko có bảo hành
                    continue;
                }

                int luaChon = Nhap.nhapInt("Them bao hanh cho san pham nay khong? (1)Co (soKhac)Khong: ");
                if (luaChon != 1) {// ko them
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
                    baoHanh.setSanPham(sanPham);

                    sanPham.setBaoHanh(baoHanh);
                    khachHang.themBaoHanh(baoHanh);
                    chiTietHoaDon.setSoBh(chiTietHoaDon.getSoBh() + 1);
                }
            } while (soLuong > 0);

            listChiTietHoaDon.add(chiTietHoaDon);
        } while (true);

    }

    // public static ArrayList<ChiTietHoaDon> taoListChiTietHoaDon(Database db,
    // KhachHang khachHang) {
    // ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();
    // do {
    // ThongTinSanPham thongTinSanPham = null;
    // DanhSachThongTinSanPham danhSachThongTinSanPham =
    // db.getDanhSachThongTinSanPham();
    // DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
    // int soLuong;
    // do {
    // String ma = Nhap.nhapStr("Nhap ma thong tin san pham de them vao hoa don hoac
    // nhap 0 de thoat");
    // if (ma.replaceAll("\\s+", "").equals("0")) {
    // return listChiTietHoaDon;
    // }
    // thongTinSanPham = danhSachThongTinSanPham.tim(ma);
    // if (thongTinSanPham == null) {
    // System.out.println("Khong tim thay thong tin san pham");
    // }
    // soLuong = Nhap.nhapInt("Nhap so luong san pham can them vao chitiethoadon");
    // if (soLuong > thongTinSanPham.getTonKho()) {
    // System.out.println("So luong ton kho khong du");
    // continue;
    // }
    // } while (thongTinSanPham == null);

    // Set<String> khoSerial = new HashSet<>();
    // ChiTietHoaDon chiTietHoaDon = new
    // ChiTietHoaDon(CapMa.capMaChiTietHoaDon(db));
    // DanhSachChiTietHoaDon danhSachChiTietHoaDon = db.getDanhSachChiTietHoaDon();
    // danhSachChiTietHoaDon.them(chiTietHoaDon);

    // do {
    // String maSr = Nhap.nhapStr("Nhap serial san pham cua " +
    // thongTinSanPham.getMa() + " ");
    // SanPham sanPham = danhSachSanPham.timSanPhamChuaBan(maSr);
    // if (sanPham == null) {
    // System.out.println("Khong tim thay san pham " + maSr + " kha dung");
    // continue;
    // }
    // if (!sanPham.getThongTinSanPham().equals(thongTinSanPham)) {
    // System.out.println("San pham khong phai cua " + thongTinSanPham.getMa());
    // }

    // if (khoSerial.contains(maSr)) {
    // System.out.println("San pham nay da duoc them vao");
    // continue;
    // }

    // if (sanPham.getTrangThai().equals("Ngung kinh doanh")) {
    // System.out.println("San pham da ngung kinh doanh");
    // continue;
    // }

    // chiTietHoaDon.themSanPham(sanPham);
    // System.out.println("Da them san pham " + sanPham.getSerial() + " vao chi tiet
    // hoa don");
    // thongTinSanPham.giamTonKho();
    // soLuong--;
    // khoSerial.add(maSr);
    // sanPham.setDaBan(true);

    // DanhSachBaoHanh danhSachBaoHanh = db.getDanhSachBaoHanh();
    // ArrayList<BaoHanh> listBaoHanh = danhSachBaoHanh.timBaoHanh(sanPham);
    // if (listBaoHanh.size() == 0) {
    // continue;
    // }
    // int luaChon = Nhap.nhapInt("Ban co muon them bao hanh cho san pham khong (1)
    // co (khach) khong : ");
    // if (luaChon != 1) {
    // continue;
    // }

    // for (int i = 0; i < listBaoHanh.size(); i++) {
    // System.out.println(i + ". " + listBaoHanh.get(i).getLoaiBaoHanh());
    // }

    // luaChon = Nhap.nhapInt("Nhap lua chon : ");
    // if (luaChon >= 0 && luaChon < listBaoHanh.size()) {
    // BaoHanh baoHanhGoc = listBaoHanh.get(luaChon);
    // BaoHanh baoHanh = new BaoHanh(baoHanhGoc);
    // baoHanh.setNgayBatDau(ThoiGian.layNgayHienTaiStr());
    // baoHanh.setNgayKetThuc();
    // baoHanh.setSanPham(sanPham);

    // sanPham.setBaoHanh(baoHanh);
    // khachHang.themBaoHanh(baoHanh);

    // } else {
    // System.out.println("Lua chon khong hop le");
    // }
    // } while (soLuong > 0);

    // listChiTietHoaDon.add(chiTietHoaDon);
    // } while (true);
    // }

    public static HoaDon taoHoaDon(Database db) {
        String ma = CapMa.capMaHoaDon(db);
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
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

        if (hoaDon != null) {
            // đưa danh sách mã giảm giá của khách hàng để xử lí
            DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(khachHang.getListMaGiamGia());
            danhSachMaGiamGia.setThanhTienDaApMaGG(hoaDon, db.getListMaGiamGiaDaDung()); // tính thành tiền tổng cho hóa
                                                                                         // đơn , và áp dụng mã giảm giá
            // nếu có
        }

        // xử lí đưa hoadon cho khách hàng
        khachHang.themHoaDon(hoaDon);
        khachHang.tangTienDaChi(hoaDon.getThanhTien());
        ////// thêm hạng thành viên mới (nếu có) cho khách hàng
        DanhSachHangThanhVien danhSachHangThanhVien = db.getDanhSachHangThanhVien();
        danhSachHangThanhVien.setHangThanhVienChoKhachHang(khachHang);

        // hiễn thị các mã giảm giá đã áp dụng
        System.out.println("Danh sach ma giam gia da dung :");
        boolean timThay = false;

        for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {
            for (MaGiamGia maGiamGia : chiTietHoaDon.getListMaGiamGia()) {
                System.out.println(maGiamGia);
                timThay = true;
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