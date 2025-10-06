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
    }

    public void xemTatCaTinNhan() {
        QuanLyTinNhan quanLyTinNhan = new QuanLyTinNhan(db);
        quanLyTinNhan.xemTatCaTinNhan(ql);
    }

    public void xemTinNhanGanDay() {
        QuanLyTinNhan quanLyTinNhan = new QuanLyTinNhan(db);
        quanLyTinNhan.xemTinNhanGanDay(ql);
    }

    public void xemDoanhThu() {
        QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon(db);
        quanLyHoaDon.xemDoanhThu();
    }

    public void xemLichLamViecTrongTuan() {
        QuanLyDanhSachLichTrongTuan danhSachLichTrongTuan = new QuanLyDanhSachLichTrongTuan(db);
        danhSachLichTrongTuan.xemLichLamViecTrongTuanNay();
    }

    public void quanLyDanhSachLichLamViec() {
        QuanLyDanhSachLichTrongTuan quanLyDanhSachLichTrongTuan = new QuanLyDanhSachLichTrongTuan(db);
        quanLyDanhSachLichTrongTuan.menu();
    }

    public void quanLyPhieuBaoHanh() {
        QuanLyPhieuBaoHanh quanLyPhieuBaoHanh = new QuanLyPhieuBaoHanh(db);
        quanLyPhieuBaoHanh.menu();
    }

    public void quanLyPhieuTraHang() {
        QuanLyPhieuTraHang quanLyPhieuTraHang = new QuanLyPhieuTraHang(db);
        quanLyPhieuTraHang.menu();
    }

    public void QuanLyMaGiamGia() {
        QuanLyMaGiamGia quanLyMaGiamGia = new QuanLyMaGiamGia(db);
        quanLyMaGiamGia.menu();
    }

    public void doiMatKhau() {
        QuanLyTaiKhoan quanLyTaiKhoan = new QuanLyTaiKhoan(db);
        quanLyTaiKhoan.doiMatKhau(ql);
    }

    public void hienThiThongTin() {
        System.out.println(ql);
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
        System.out.println("9. Quan ly ma giam gia");
        System.out.println("10. Xem doanh thu");
        System.out.println("11. Gui Tin Nhan");
        System.out.println("12. Hop Thu");
        System.out.println("13. Xem lich tuan");
        System.out.println("14. Quan ly danh sach lich lam viec trong tuan");
        System.out.println("15. Doi mat khau");
        System.out.println("0. Thoat");
        System.out.println("--------------------------------");
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
            case 9 -> QuanLyMaGiamGia();
            case 10 -> xemDoanhThu();
            case 11 -> guiTinNhan();
            case 12 -> xemTatCaTinNhan();
            case 13 -> xemLichLamViecTrongTuan();
            case 14 -> quanLyDanhSachLichLamViec();
            case 15 -> doiMatKhau();
            case 0 -> System.out.println("Da thoat!");
            default -> System.out.println("Lua chon khong hop le!");
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
