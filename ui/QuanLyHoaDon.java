package ui;

import java.util.ArrayList;

import danhsach.DanhSachBaoHanh;
import danhsach.DanhSachChiTietHoaDon;
import danhsach.DanhSachHoaDon;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachMaGiamGia;
import database.Database;
import model.BaoHanh;
import model.ChiTietHoaDon;
import danhsach.DanhSachSanPham;
import model.HoaDon;
import model.KhachHang;
import model.LuuTruSanPham;
import model.MaGiamGia;
import model.SanPham;
import util.TaoDoiTuong;
import util.ThoiGian;
import util.XoaManHinh;

public class QuanLyHoaDon {
    private Database db;

    public QuanLyHoaDon(Database db) {
        this.db = db;
    }

    public void taoHoaDon() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        HoaDon hoaDon = TaoDoiTuong.taoHoaDon(db);
        if (danhSachHoaDon.themHoaDon(hoaDon)) {
            System.out.println("Tao hoa don thanh cong");
        } else {
            System.out.println("Tao hoa don that bai");
        }
    }

    // 2. xoa hao don mua hang
    public void xoaHoaDon() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        String ma = Nhap.nhapStr("nhap ma hoa don can xoa: ");
        if (danhSachHoaDon.xoaHoaDon(ma)) {
            System.out.println("xoa hoa don thanh cong!");
        } else {
            System.out.println("xoa hoa don that bai!");
        }
    }

    /// sua hoa don
    private void xuatSuaHoaDon_BaoHanh() {
        System.out.println("1. them san pham");
        System.out.println("2. Xoa san pham");
        System.out.println("3. Them bao hanh");
        System.out.println("4. Xoa bao hanh");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void suaThanhPhanChiTietHoaDon(ChiTietHoaDon chiTietHoaDon, KhachHang khachHang, int luaChon) {
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        DanhSachBaoHanh danhSachBaoHanh = db.getDanhSachBaoHanh();
        DanhSachChiTietHoaDon danhSachChiTietHoaDon = db.getDanhSachChiTietHoaDon();
        switch (luaChon) {
            case 0:
                System.out.println("Da Thoat");
                break;
            case 1:
                SanPham sanPham = danhSachSanPham.timSanPham(Nhap.nhapStr("Nhap ma san pham can them : "));
                if (sanPham == null) {
                    System.out.println("Khong tim thay san pham");
                    return;
                }
                chiTietHoaDon.themSanPham(sanPham);
                System.out.println("Them thanh cong");
                break;
            case 2:
                SanPham sanPham1 = danhSachSanPham.timSanPham(Nhap.nhapStr("Nhap ma san pham can xoa : "));
                if (sanPham1 == null) {
                    System.out.println("Khong tim thay san pham");
                    return;
                }
                ArrayList<MaGiamGia> listThuHoi = danhSachChiTietHoaDon.xoaSanPhamThuHoiMa(sanPham1, chiTietHoaDon,
                        khachHang);
                if (listThuHoi.size() > 0) {
                    System.out.println("Ma giam gia da duoc thu hoi cho khanh hang " + khachHang.getSdt() + " "
                            + khachHang.getTenKh());
                    for (MaGiamGia maGiamGia : listThuHoi) {
                        System.out.println(maGiamGia);
                    }
                }
                DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(chiTietHoaDon.getListMaGiamGiaDaDung());
                long thanhTienTruoc = chiTietHoaDon.getThanhTien();
                danhSachMaGiamGia.setThanhTienDaApMaGG(chiTietHoaDon);
                System.out.println("Thanh tien truoc : " + thanhTienTruoc);
                System.out.println("Thanh tien sau : " + chiTietHoaDon.getThanhTien());
                System.out.println("xoa thanh cong");
                break;
            case 3:
                BaoHanh baoHanh = danhSachBaoHanh.timBaoHanh(Nhap.nhapStr("Nhap ma bao hanh can them : "));
                if (baoHanh == null) {
                    System.out.println("Khong tim thay bao hanh");
                    return;
                }
                chiTietHoaDon.themBaoHanh(baoHanh);
                System.out.println("Da them bao hanh");
                break;
            case 4:
                BaoHanh baoHanh1 = danhSachBaoHanh.timBaoHanh(Nhap.nhapStr("Nhap ma bao hanh can them : "));
                if (baoHanh1 == null) {
                    System.out.println("Khong tim thay bao hanh");
                    return;
                }
                chiTietHoaDon.xoaBaoHanh(baoHanh1);
                System.out.println("Da xoa bao hanh");
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }

    private void xuatSuaHoaDon() {
        System.out.println("1. Sua Khach hang");
        System.out.println("2. Sua bao hanh");
        System.out.println("3. Sua ngay tao hoa don");
        System.out.println("4. Sua ghi chu");
        System.out.println("5. Sua chi tiet tiet hoa don");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void suaThanhPhanHoaDon(HoaDon hoaDon, int luaChon) {
        switch (luaChon) {
            case 1:
                DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
                KhachHang khachHang = danhSachKhachHang.timKhachHang(Nhap.nhapStr("Nhap ma khach hang moi : "));
                if (khachHang == null) {
                    System.out.println("Khong tim thay khach hang");
                    return;
                }
                hoaDon.setKhachHang(khachHang);
                System.out.println("Da thay doi khach hang");
                break;
            case 2:
                suaHoaDon_ChiTietHoaDon(hoaDon.getChiTietHoaDon(), hoaDon.getKhachHang());
                break;
            case 3:
                hoaDon.setNgayTaoHoaDon(Nhap.nhapStr("Nhap ngay tao hoa don moi : "));
                break;
            case 4:
                hoaDon.setGhiChu(Nhap.nhapStr("Nhap ghi chu moi : "));
                break;
            case 5:
                suaHoaDon_ChiTietHoaDon(hoaDon.getChiTietHoaDon(), hoaDon.getKhachHang());
                break;
            default:
                break;
        }
    }

    private void suaHoaDon_ChiTietHoaDon(ChiTietHoaDon chiTietHoaDon, KhachHang khachHang) {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatSuaHoaDon_BaoHanh();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            suaThanhPhanChiTietHoaDon(chiTietHoaDon, khachHang, luaChon);
            xacNhan = Nhap.nhapInt("(1) Tiep tuc sua (Khac)Thoat");
        }
    }

    public void suaHoaDon() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        HoaDon hoaDon = danhSachHoaDon.timHoaDon(Nhap.nhapStr("Nhap hoa don can sua : "));
        if (hoaDon == null) {
            System.out.println("khong tim thay hoa don");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatSuaHoaDon();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            suaThanhPhanHoaDon(hoaDon, luaChon);
            xacNhan = Nhap.nhapInt("(1) Tiep tuc sua (Khac)Thoat");
        }
    }

    // 4.xem doanh thu
    private void xuatXemDoanhThu() {
        System.out.println("1. xem doanh thu hom nay");
        System.out.println("2. xem doanh thu tuan");
        System.out.println("3. xem doanh thu thang");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void xemDoanhthuHomNay() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        String ngayHomNay = ThoiGian.layNgayHienTaiStr();
        long tong = danhSachHoaDon.tinhDoanhThuTrongNgay(ngayHomNay);
        System.out.println("doanh thu ngay hom nay: " + tong);
    }

    private void xemDoanhThuTuan() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        String ngayDauTuan = ThoiGian.layNgayDauTuanStr();
        String ngayCuoiTuan = ThoiGian.layNgayCuoiTuanStr();
        long tongTien = danhSachHoaDon.tinhDoanhThuTrongKhoan(ngayDauTuan, ngayCuoiTuan);
        System.out.println("doanh thu trong tuan: " + tongTien);
    }

    public void xemDoanhThuThang() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        String ngayDauThang = ThoiGian.layNgayDauThangStr();
        String ngayCuoiThang = ThoiGian.layNgayCuoiThangStr();
        long tongTien = danhSachHoaDon.tinhDoanhThuTrongKhoan(ngayDauThang, ngayCuoiThang);
        System.out.println("doanh thu trong thang : " + tongTien);
    }

    private void thucHienChucNangDoanhThu(int choice) {
        switch (choice) {
            case 0 -> System.out.println("Da thoat xem doanh thu");
            case 1 -> xemDoanhthuHomNay();
            case 2 -> xemDoanhThuTuan();
            case 3 -> xemDoanhThuThang();
            default -> System.out.println("Lua chon khong hop le");
        }
    }

    public void xemDoanhThu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatXemDoanhThu();
            int choice = Nhap.nhapInt("nhap lua chon: ");
            thucHienChucNangDoanhThu(choice);
            xacNhan = Nhap.nhapInt("nhan (1) de tiep tuc xem doanh thu (khac) de thoat: ");
        }
    }

    // 6.tra cuu hoa don mua hang
    public void traCuuHoaDonMuaHang() {
        String ma = Nhap.nhapStr("nhap ma hoa don muon tra cuu: ");
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        HoaDon hoaDon = danhSachHoaDon.timHoaDon(ma);
        if (hoaDon == null) {
            System.out.println("khong tim thay hoa don muon tra cuu!");
            return;
        } else {
            System.out.println("---------------------------");
            System.out.println(hoaDon);
            LuuTruSanPham mapListSanPham = hoaDon.getChiTietHoaDon().getDanhSachSanPham();
            if (mapListSanPham.getMapSanPham().size() > 0) {
                System.out.println("Danh sach san pham gom :");
            }
            for (SanPham sanPham : mapListSanPham.getMapSanPham().keySet()) {
                System.out.println(sanPham);
            }
            ArrayList<BaoHanh> listBaoHanh = hoaDon.getChiTietHoaDon().getListBaoHanh();
            if (listBaoHanh.size() > 0) {
                System.out.println("Danh sach bao hanh bao gom :");
            }
            for (BaoHanh baoHanh : listBaoHanh) {
                System.out.println(baoHanh);
            }
            System.out.println("---------------------------");
        }
    }

    // 7. xem tat ca hoa don
    public void xemTatCaHoaDon() {
        ArrayList<HoaDon> listHoaDon = db.getListHoaDon();
        if (listHoaDon == null) {
            System.out.println("khong co hoa don de in!");
        }
        for (int i = 0; i < listHoaDon.size(); i++) {
            System.out.println("---------------------------");
            System.out.println(listHoaDon.get(i));
        }
    }

    private void xuatMenu() {
        System.out.println("1. Tao hoa don mua hang cho khach");
        System.out.println("2. Xoa hoa don mua Hang");
        System.out.println("3. Sua hoa don mua hang theo ma");
        System.out.println("4. Xem doanh thu");
        System.out.println("5. Tra cuu hoa don mua hang");
        System.out.println("6. Xem tat ca hoa don mua hang");
        System.out.println("0. Thoat");
        System.out.println("-----------------------------------");
    }

    private void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 0:
                System.out.println("da thoat");
                break;
            case 1:
                taoHoaDon();
                break;
            case 2:
                xoaHoaDon();
                break;
            case 3:
                suaHoaDon();
                break;
            case 4:
                xemDoanhThu();
                break;
            case 5:
                traCuuHoaDonMuaHang();
                break;
            case 6:
                xemTatCaHoaDon();
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }

    public void menu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            XoaManHinh.xoa();
            xuatMenu();
            int luaChon = Nhap.nhapInt("Nhap lua Chon : ");
            if (luaChon == 0) {
                return;
            }
            thucHienChucNang(luaChon);
            Nhap.pause();
        }
    }
}