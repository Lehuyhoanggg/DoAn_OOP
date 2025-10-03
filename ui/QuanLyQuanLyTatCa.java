package ui;

import database.Database;
import interfaces.QuanLiChung;
import model.QuanLy;
import util.XoaManHinh;

public class QuanLyQuanLyTatCa implements QuanLiChung {
    private Database db;
    private QuanLy ql;

    public QuanLyQuanLyTatCa(Database db, QuanLy ql) {
        this.ql = ql;
        this.db = db;
    }

    public void quanLySanPham() {
        QuanLySanPham quanLySanPham = new QuanLySanPham(db);
        quanLySanPham.menu();
    }

    public void quanLyNhanVien() {
        QuanLyNhanVien quanLyQuanLyNhanVien = new QuanLyNhanVien(db);
        quanLyQuanLyNhanVien.menu();
    }

    public void quanLyHoaDon() {
        QuanLyHoaDon menuHoaDon = new QuanLyHoaDon(db);
        menuHoaDon.menu();
    }

    public void quanLyBaoHanh() {
        QuanLyBaoHanh quanLyBaoHanh = new QuanLyBaoHanh(db);
        quanLyBaoHanh.menu();
    }

    public void QuanLyKhacHang() {
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang(db);
        quanLyKhachHang.menu();
    }

    public void guiTinNhan() {
        QuanLyTinNhan quanLyTinNhan = new QuanLyTinNhan(db);
        quanLyTinNhan.guiTinNhan(ql);
        Nhap.nhapStr("Nhan bat ki de tiep tuc");
    }

    public void xemTatCaTinNhan() {
        QuanLyTinNhan quanLyTinNhan = new QuanLyTinNhan(db);
        quanLyTinNhan.xemTatCaTinNhan(ql);
        Nhap.nhapStr("Nhan bat ki de tiep tuc");
    }

    public void xemTinNhanGanDay() {
        QuanLyTinNhan quanLyTinNhan = new QuanLyTinNhan(db);
        quanLyTinNhan.xemTinNhanGanDay(ql);
    }

    public void xemDoanhThu() {
        QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon(db);
        quanLyHoaDon.xemDoanhThu();
        Nhap.nhapStr("Nhan bat ki de tiep tuc");
    }

    public void xemLichTuan() {
        QuanLyLichLamViec quanLyLichLamViec = new QuanLyLichLamViec(db);
        quanLyLichLamViec.xemLichLamViec();
        Nhap.nhapStr("Nhan bat ki de tiep tuc");
    }

    public void xepLichDiLam() {
        QuanLyLichLamViec quanLyLichLamViec = new QuanLyLichLamViec(db);
        quanLyLichLamViec.xepLichLamViec();
        Nhap.nhapStr("Nhan bat ki de tiep tuc");
    }

    public void quanLyPhieuBaoHanh() {
        QuanLyPhieuBaoHanh quanLyPhieuBaoHanh = new QuanLyPhieuBaoHanh(db);
        quanLyPhieuBaoHanh.menu();
    }

    public void quanLyPhieuTraHang() {
        QuanLyPhieuTraHang quanLyPhieuTraHang = new QuanLyPhieuTraHang(db);
        quanLyPhieuTraHang.menu();
    }

    public void xuatMenu() {
        System.out.println("1. Hien thong tin");
        System.out.println("2. Quan ly nhan vien");
        System.out.println("3. Quan ly San Pham");
        System.out.println("4. Quan ly Don Hang");
        System.out.println("5. Quan ly Bao Hanh San Pham");
        System.out.println("6. Quan ly phieu bao hanh san pham");
        System.out.println("7. Quan ly tra hang");
        System.out.println("8. Quan ly Khach hang");
        System.out.println("9. Xem doanh thu");
        System.out.println("10. Gui Tin Nhan");
        System.out.println("11. Hop Thu");
        System.out.println("12. Xem lich tuan");
        System.out.println("13. Doi mat khau");
        System.out.println("14. Xep lich di lam viec");
        System.out.println("0. Thoat");
        System.out.println("--------------------------------");
    }

    public void doiMatKhau() {
        QuanLyTaiKhoan quanLyTaiKhoan = new QuanLyTaiKhoan(db);
        quanLyTaiKhoan.doiMatKhau(ql);
    }

    public void hienThiThongTin() {
        System.out.println(ql);
        Nhap.nhapStr("Nhan bat ki de tiep tuc");
    }

    public void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 1 -> hienThiThongTin();
            case 2 -> quanLyNhanVien();
            case 3 -> quanLySanPham();
            case 4 -> quanLyHoaDon();
            case 5 -> quanLyBaoHanh();
            case 6 -> quanLyPhieuBaoHanh();
            case 7 -> quanLyPhieuTraHang();
            case 8 -> QuanLyKhacHang();
            case 9 -> xemDoanhThu();
            case 10 -> guiTinNhan();
            case 11 -> xemTatCaTinNhan();
            case 12 -> xemLichTuan();
            case 13 -> doiMatKhau();
            case 14 -> xepLichDiLam();
            default -> System.out.println("da thoat");
        }
    }

    public void menu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            XoaManHinh.xoa();
            xuatMenu();
            int luaChon = Nhap.nhapInt("Nhap lua Chon : ");
            thucHienChucNang(luaChon);
        }
    }

}
