package quanli;

import danhsach.DanhSachLichTrongTuan;
import database.Database;
import interfaces.GiaoTiep;
import model.LichTrongTuan;
import model.QuanLy;
import util.Nhap;
import util.XoaManHinh;

public class QuanLyQuanLyTatCa implements GiaoTiep {
    private Database db;
    private QuanLy ql;

    public QuanLyQuanLyTatCa(Database db, QuanLy ql) {
        this.ql = ql;
        this.db = db;
    }

    public void quanLySanPham() {
        QuanLyThongTinSanPham quanLySanPham = new QuanLyThongTinSanPham(db);
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

    public void quanLyKhachHang() {
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


    public void xemDoanhThu() {
        QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon(db);
        quanLyHoaDon.xemDoanhThu();
    }

    public void xemLichLamViecTrongTuan() {
        DanhSachLichTrongTuan danhSachLichTrongTuan = db.getDanhSachLichTrongTuan();
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.lichTrongTuanNay();
        if (lichTrongTuan == null) {
            System.out.println("Tuan nay chua co lich");
            return;
        }
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
        quanLyLichTrongTuan.xemLichLamViec();
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

    public void quanLyMaGiamGia() {
        QuanLyMaGiamGia quanLyMaGiamGia = new QuanLyMaGiamGia(db);
        quanLyMaGiamGia.menu();
    }

    public void doiMatKhau() {
        QuanLyTaiKhoan quanLyTaiKhoan = new QuanLyTaiKhoan(db);
        quanLyTaiKhoan.doiMatKhau(ql);
    }

    public void hienThiThongTin() {
        System.out.println();
        System.out.println(ql);
    }

    public void capTaiKhoanChoUser() {
        QuanLyTaiKhoan quanLyTaiKhoan = new QuanLyTaiKhoan(db);
        quanLyTaiKhoan.capTaiKhoanChoUser();
    }

    public void xuatMenu() {
        System.out.println("1. Hien thong tin");
        System.out.println("2. Quan ly nhan vien");
        System.out.println("3. Quan ly san pham");
        System.out.println("4. Quan ly don hang");
        System.out.println("5. Quan ly bao hanh san pham");
        System.out.println("6. Quan ly phieu bao hanh san pham");
        System.out.println("7. Quan ly tra hang");
        System.out.println("8. Quan ly khach hang");
        System.out.println("9. Quan ly ma giam gia");
        System.out.println("10. Quan ly danh sach lich lam viec trong tuan");
        System.out.println("11. Xem doanh thu");
        System.out.println("12. Gui tin nhan");
        System.out.println("13. Hop thu");
        System.out.println("14. Xem lich trong tuan nay");
        System.out.println("15. Doi mat khau");
        System.out.println("16. Cap tai khoan cho user");
        System.out.println("0. Thoat");
        System.out.println("-------------------------------------------------");
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
            case 8 -> quanLyKhachHang(); // sửa tên cho đúng chính tả
            case 9 -> quanLyMaGiamGia();
            case 10 -> quanLyDanhSachLichLamViec();
            case 11 -> xemDoanhThu();
            case 12 -> guiTinNhan();
            case 13 -> xemTatCaTinNhan(); // Hop thu
            case 14 -> xemLichLamViecTrongTuan(); // Xem lich trong tuan nay
            case 15 -> doiMatKhau();
            case 16 -> capTaiKhoanChoUser();
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
