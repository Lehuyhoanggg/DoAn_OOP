package ui;

import database.Database;
import interfaces.QuanLiChung;
import model.QuanLy;

public class MenuQuanLy implements QuanLiChung {
    private Database db;
    private QuanLy ql;

    public MenuQuanLy(Database db, QuanLy ql) {
        this.ql = ql;
        this.db = db;
    }

    public void quanLySanPham() {
        MenuSanPham menuSanPham = new MenuSanPham(db);
        menuSanPham.menu();
    }

    public void quanLyNhanVien() {
        MenuQuanLyNhanVien menuQuanLyNhanVien = new MenuQuanLyNhanVien(db);
        menuQuanLyNhanVien.menu();
    }

    public void quanLyHoaDon() {
        MenuHoaDon menuHoaDon = new MenuHoaDon(db);
        menuHoaDon.menu();
    }

    public void quanLyBaoHanh() {
        MenuBaoHanh menuBaoHanh = new MenuBaoHanh(db);
        menuBaoHanh.menu();
    }

    public void QuanLyKhacHang() {
        MenuKhachHang menuKhachHang = new MenuKhachHang(db);
        menuKhachHang.menu();
    }

    public void guiTinNhan() {
        MenuTinNhan menuTinNhan = new MenuTinNhan(db);
        menuTinNhan.guiTinNhan(ql);
    }

    public void xemTatCaTinNhan() {
        MenuTinNhan menuTinNhan = new MenuTinNhan(db);
        menuTinNhan.xemTatCaTinNhan(ql);
    }

    public void xemTinNhanGanDay() {
        MenuTinNhan menuTinNhan = new MenuTinNhan(db);
        menuTinNhan.xemTinNhanGanDay(ql);
    }

    public void xemDoanhThu() {
        MenuHoaDon menuHoaDon = new MenuHoaDon(db);
        menuHoaDon.xemDoanhThu();
    }

    public void xemLichTuan() {
        MenuLichLamViec menuLichLamViec = new MenuLichLamViec(db);
        menuLichLamViec.xemLichLamViec();
    }

    public void xepLichDiLam() {
        MenuLichLamViec menuLichLamViec = new MenuLichLamViec(db);
        menuLichLamViec.xepLichLamViec();
    }

    public void xuatMenu() {
        System.out.println("1. Hien thong tin");
        System.out.println("2. Quan ly nhan vien");
        System.out.println("3. Quan ly San Pham");
        System.out.println("4. Quan ly Don Hang");
        System.out.println("5. Quan ly Bao Hanh San Pham");
        System.out.println("6. Xem doanh thu");
        System.out.println("7. Gui Tin Nhan");
        System.out.println("8. Hop Thu");
        System.out.println("9. Xem lich tuan");
        System.out.println("10. Doi mat khau");
        System.out.println("11. Xep lich di lam viec");
        System.out.println("0. Thoat");
        System.out.println("--------------------------------");
    }

    public void doiMatKhau() {
        MenuTaiKhoan menuTaiKhoan = new MenuTaiKhoan(db);
        menuTaiKhoan.doiMatKhau(ql);
    }

    public void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 1 -> System.out.println(ql);
            case 2 -> quanLyNhanVien();
            case 3 -> quanLySanPham();
            case 4 -> quanLyHoaDon();
            case 5 -> quanLyBaoHanh();
            case 6 -> xemDoanhThu();
            case 7 -> guiTinNhan();
            case 8 -> xemTatCaTinNhan();
            case 9 -> xemLichTuan();
            case 10 -> doiMatKhau();
            case 11 -> xepLichDiLam();
            default -> System.out.println("da thoat");
        }
    }

    public void menu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatMenu();
            int luaChon = Nhap.nhapInt("Nhap lua Chon : ");
            thucHienChucNang(luaChon);
            xacNhan = Nhap.nhapXacNhanThoat();
        }
    }

}
