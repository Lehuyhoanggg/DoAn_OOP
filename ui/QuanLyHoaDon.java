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
import model.MaGiamGia;
import model.SanPham;
import model.SanPhamDaBan;
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
        if (danhSachHoaDon.them(hoaDon)) {
            System.out.println();
            System.out.println("====Hoa don vua tao====");
            System.out.println();
            System.out.println(hoaDon);
            System.out.println("Tao hoa don thanh cong");
        } else {
            System.out.println("Tao hoa don that bai");
        }
    }

    // 2. xoa hao don mua hang
    public void xoaHoaDon() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        String ma = Nhap.nhapStr("nhap ma hoa don can xoa: ");
        if (danhSachHoaDon.xoa(ma)) {
            System.out.println("xoa hoa don thanh cong!");
        } else {
            System.out.println("xoa hoa don that bai!");
        }
    }

    /// sua hoa don
    private void xuatSuaHoaDon_SanPhamDaBan() {
        System.out.println("1. Sua san pham");
        System.out.println("2. Xoa san pham");
        System.out.println("3. Sua bao hanh");
        System.out.println("4. Xoa bao hanh");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void suaThanhPhanSanPhamDaBan(SanPhamDaBan sanPhamDaBan, HoaDon hoaDon, int chon) {
        DanhSachChiTietHoaDon danhSachChiTietHoaDon = new DanhSachChiTietHoaDon(hoaDon.getListChiTietHoaDon());
        switch (chon) {
            case 1:
                DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
                SanPham sanPham = danhSachSanPham.tim(Nhap.nhapStr("Nhap ma san pham can them vao : "));
                if (sanPham == null) {
                    System.out.println("Khong tim thay san de them vao");
                } else {
                    DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(
                            hoaDon.getKhachHang().getListMaGiamGia());
                    danhSachMaGiamGia.xoaSanPhamThuHoiMa(sanPhamDaBan, hoaDon);
                    sanPhamDaBan.setSanPham(sanPham);
                    ChiTietHoaDon chiTietHoaDon = danhSachChiTietHoaDon.tim(sanPhamDaBan);
                    chiTietHoaDon.setThanhTien(chiTietHoaDon.getThanhTien() + sanPham.getGia());
                    System.out.println("Da thay doi san pham");
                }
                break;
            case 2:
                DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(hoaDon.getKhachHang().getListMaGiamGia());
                ArrayList<MaGiamGia> listMaGiamGia = danhSachMaGiamGia.xoaSanPhamThuHoiMa(sanPhamDaBan, hoaDon);
                if (listMaGiamGia != null) {
                    for (MaGiamGia maGiamGia : listMaGiamGia) {
                        System.out.println("Da thu hoi ma giam gia " + maGiamGia.getMa() + " cho khach hang "
                                + hoaDon.getKhachHang().getSdt());
                    }
                }

                System.out.println("Da xoa san pham");
                break;
            case 3:
                DanhSachBaoHanh danhSachBaoHanh = db.getDanhSachBaoHanh();
                ArrayList<BaoHanh> listBaoHanh = danhSachBaoHanh.tim(sanPhamDaBan.getSanPham());
                if (listBaoHanh.size() == 0) {
                    System.out.println("San pham nay khong co bao hanh nao");
                    return;
                }
                for (int i = 0; i < listBaoHanh.size(); i++) {
                    System.out.println(
                            i + " " + listBaoHanh.get(i).getMaBh() + " " + listBaoHanh.get(i).getLoaiBaoHanh());
                }
                int luaChon = Nhap.nhapInt("Chon bao hanh de thay doi : ");
                BaoHanh baoHanh = null;
                if (luaChon >= 0 && luaChon < listBaoHanh.size()) {
                    baoHanh = listBaoHanh.get(luaChon);
                }
                ChiTietHoaDon chiTietHoaDon = danhSachChiTietHoaDon.tim(sanPhamDaBan);
                chiTietHoaDon.setThanhTien(chiTietHoaDon.getThanhTien() - sanPhamDaBan.getBaoHanh().getGia());
                baoHanh.setSerial(sanPhamDaBan.getSerial());
                baoHanh.setSanPham(sanPhamDaBan.getSanPham());
                sanPhamDaBan.setBaoHanh(baoHanh);

                chiTietHoaDon.setThanhTien(chiTietHoaDon.getThanhTien() + baoHanh.getGia());

                System.out.println("Da thay doi bao hanh");

                break;
            case 4:
                if (sanPhamDaBan.getBaoHanh() == null) {
                    System.out.println("Khong the xoa vi khong co bao hanh");
                } else {
                    sanPhamDaBan.setBaoHanh(null);
                    ChiTietHoaDon chiTietHd = danhSachChiTietHoaDon.tim(sanPhamDaBan);
                    chiTietHd.setThanhTien(chiTietHd.getThanhTien() - sanPhamDaBan.getBaoHanh().getGia());
                    System.out.println("Da xoa bao hanh");
                }
                break;
            default:
                break;
        }

        hoaDon.tinhThanhTien();
    }

    private void suaSanPhamDaBan(SanPhamDaBan sanPhamDaBan, HoaDon hoaDon) {
        while (true) {
            xuatSuaHoaDon_SanPhamDaBan();
            int chon = Nhap.nhapInt("Nhap lua chon : ");
            if (chon == 0) {
                return;
            }
            suaThanhPhanSanPhamDaBan(sanPhamDaBan, hoaDon, chon);
            Nhap.pause();
        }
    }

    private void suaChiTietHoaDon(HoaDon hoaDon) {
        for (int i = 0; i < hoaDon.getListChiTietHoaDon().size(); i++) {
            System.out.println(i + ". " + hoaDon.getListChiTietHoaDon().get(i).getMa());
        }
        int chon = Nhap.nhapInt("Chon chi tiet hoa don can quan li : ");
        ChiTietHoaDon chiTietHoaDon = null;
        if (chon >= 0 && chon < hoaDon.getListChiTietHoaDon().size()) {
            chiTietHoaDon = hoaDon.getListChiTietHoaDon().get(chon);
        }

        while (true) {
            for (int i = 0; i < chiTietHoaDon.getSanPhamDaBan().size(); i++) {
                System.out.println(i + ". " + chiTietHoaDon.getSanPhamDaBan().get(i).getMaSpDaBan()
                        + " voi ma serial :  "
                        + chiTietHoaDon.getSanPhamDaBan().get(i).getSerial()
                        + (chiTietHoaDon.getSanPhamDaBan().get(i).getSanPham().getTraHang() ? "(Da tra hang)" : ""));
            }
            chon = Nhap.nhapInt("Chon san pham da ban de quan li hoac nhan -1 de thoat : ");
            if (chon == -1) {
                return;
            }
            SanPhamDaBan sanPhamDaBan = null;
            if (chon >= 0 && chon < chiTietHoaDon.getSanPhamDaBan().size()) {
                sanPhamDaBan = chiTietHoaDon.getSanPhamDaBan().get(chon);
            } else {
                System.out.println("Lua chon khong hop le");
                return;
            }
            suaSanPhamDaBan(sanPhamDaBan, hoaDon);
            Nhap.pause();
        }

    }

    private void xuatSuaHoaDon() {
        System.out.println("1. Sua Khach hang");
        System.out.println("2. Sua ngay tao hoa don");
        System.out.println("3. Sua ghi chu");
        System.out.println("4. Sua chi tiet tiet hoa don");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void suaThanhPhanHoaDon(HoaDon hoaDon, int luaChon) {
        switch (luaChon) {
            case 1:
                DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
                KhachHang khachHang = danhSachKhachHang.tim(Nhap.nhapStr("Nhap ma khach hang moi : "));
                if (khachHang == null) {
                    System.out.println("Khong tim thay khach hang");
                    return;
                }
                hoaDon.setKhachHang(khachHang);
                System.out.println("Da thay doi khach hang");
                break;
            case 2:
                hoaDon.setNgayTaoHoaDon(Nhap.nhapNgay("Nhap ngay tao hoa don moi : "));
                break;
            case 3:
                hoaDon.setGhiChu(Nhap.nhapStr("Nhap ghi chu moi : "));
                break;
            case 4:
                suaChiTietHoaDon(hoaDon);
                break;
            default:
                break;
        }
    }

    public void suaHoaDon() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        HoaDon hoaDon = danhSachHoaDon.tim(Nhap.nhapStr("Nhap hoa don can sua : "));
        if (hoaDon == null) {
            System.out.println("khong tim thay hoa don");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            System.out.println();
            System.out.println("------------------------");
            System.out.println(hoaDon);
            System.out.println("------------------------");
            xuatSuaHoaDon();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon == 0) {
                return;
            }
            suaThanhPhanHoaDon(hoaDon, luaChon);
            Nhap.pause();
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
        System.out.println("Doanh thu ngay hom nay: " + tong);
        System.out.println("So hoa don ban duoc : " + danhSachHoaDon.soHoaDonTrongNgay());
    }

    private void xemDoanhThuTuan() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        String ngayDauTuan = ThoiGian.layNgayDauTuanStr();
        String ngayCuoiTuan = ThoiGian.layNgayCuoiTuanStr();
        long tongTien = danhSachHoaDon.tinhDoanhThuTrongKhoan(ngayDauTuan, ngayCuoiTuan);
        System.out.println("Doanh thu trong tuan: " + tongTien);
        System.out.println("So hoa don ban duoc : " + danhSachHoaDon.soHoaDonTrongKhoan(ngayDauTuan, ngayCuoiTuan));
    }

    public void xemDoanhThuThang() {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        String ngayDauThang = ThoiGian.layNgayDauThangStr();
        String ngayCuoiThang = ThoiGian.layNgayCuoiThangStr();
        long tongTien = danhSachHoaDon.tinhDoanhThuTrongKhoan(ngayDauThang, ngayCuoiThang);
        System.out.println("Doanh thu trong thang : " + tongTien);
        System.out.println("So hoa don ban duoc : " + danhSachHoaDon.soHoaDonTrongKhoan(ngayDauThang, ngayCuoiThang));
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
            if (choice == 0) {
                return;
            }
            thucHienChucNangDoanhThu(choice);
            Nhap.pause();
        }
    }

    // 6.tra cuu hoa don mua hang
    public void traCuuHoaDonMuaHang() {
        String ma = Nhap.nhapStr("nhap ma hoa don muon tra cuu: ");
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        HoaDon hoaDon = danhSachHoaDon.tim(ma);
        if (hoaDon == null) {
            System.out.println("khong tim thay hoa don muon tra cuu!");
            return;
        } else {
            System.out.println("---------------------------");
            System.out.println(hoaDon);
            System.out.println("Danh sach san pham va bao hanh");
            for (int i = 0; i < hoaDon.getListChiTietHoaDon().size(); i++) {
                ChiTietHoaDon chiTietHoaDon = hoaDon.getListChiTietHoaDon().get(i);
                System.out.println("======================================");
                System.out.println("Chi tiet hoa don : " + chiTietHoaDon.getMa());
                System.out.println("-------------------------------------------");
                for (SanPhamDaBan sanPhamDaBan : chiTietHoaDon.getSanPhamDaBan()) {
                    System.out.println(sanPhamDaBan.getSanPham());
                    System.out.println("So serial cua san pham la : " + sanPhamDaBan.getSerial());
                    if (sanPhamDaBan.getBaoHanh() != null) {
                        System.out.println(sanPhamDaBan.getBaoHanh());
                    }
                    System.out.println("--------------------------------");
                }
                System.out.println("=======================================");
            }
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