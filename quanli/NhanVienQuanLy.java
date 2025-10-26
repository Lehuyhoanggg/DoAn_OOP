package quanli;

import model.LichTrongTuan;
import model.NhanVien;
import util.Nhap;
import util.ThoiGian;
import util.XoaManHinh;
import database.Database;
import interfaces.GiaoTiep;

public class NhanVienQuanLy implements GiaoTiep {
    private Database db;
    private NhanVien nv;

    public NhanVienQuanLy(Database db, NhanVien nv) {
        this.db = db;
        this.nv = nv;
    }

    public void xemLichLamViecTrongTuanNay() {
        LichTrongTuan lichTrongTuan = db.getLichTrongTuanNay();
        if (lichTrongTuan == null || !ThoiGian.ngayTrongKhoan(ThoiGian.layNgayHienTaiStr(), lichTrongTuan.getNgayThu2(),
                lichTrongTuan.getNgayCn())) {
            System.out.println("Tuan nay chua xep lich");
            return;
        }
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
        quanLyLichTrongTuan.xemLichLamViec();
    }

    public void traCuuThongTinKhachHang() {
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang(db);
        quanLyKhachHang.traCuuThongTinKhachHang();
    }

    public void taoHoaDon() {
        QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon(db);
        quanLyHoaDon.taoHoaDon();

    }

    public void taoPhieuTraHang() {
        QuanLyPhieuTraHang quanLyPhieuTraHang = new QuanLyPhieuTraHang(db);
        quanLyPhieuTraHang.taoPhieuTraHang();
    }

    public void traCuuSanPham() {
        QuanLyThongTinSanPham quanLySanPham = new QuanLyThongTinSanPham(db);
        quanLySanPham.traCuuThongTinSanPham();
    }

    public void TraCuuBaoHanh() {
        QuanLyBaoHanh quanLyBaoHanh = new QuanLyBaoHanh(db);
        quanLyBaoHanh.traCuuBaoHanh();
    }

    public void taoPhieuBaoHanh() {
        QuanLyPhieuBaoHanh quanLyPhieuBaoHanh = new QuanLyPhieuBaoHanh(db);
        quanLyPhieuBaoHanh.taoPhieuBaoHanh();
    }

    public void xemTatCaMaGiamGia() {
        QuanLyMaGiamGia quanLyMaGiamGia = new QuanLyMaGiamGia(db);
        quanLyMaGiamGia.xemTatCaMaGiamGia();
    }

    //
    public void doiMatKhau() {
        QuanLyTaiKhoan quanLyTaiKhoan = new QuanLyTaiKhoan(db);
        quanLyTaiKhoan.doiMatKhau(nv);
    }

    public void doiTraHang() {
        QuanLyPhieuTraHang quanLyPhieuTraHang = new QuanLyPhieuTraHang(db);
        quanLyPhieuTraHang.taoPhieuTraHang();
    }

    public void hienThiThongTin() {
        System.out.println(nv);
    }

    public void guiTinNhan() {
        QuanLyTinNhan quanLyTinNhan = new QuanLyTinNhan(db);
        quanLyTinNhan.guiTinNhan(nv);
    }

    public void xemTatCaTinNhan() {
        QuanLyTinNhan quanLyTinNhan = new QuanLyTinNhan(db);
        quanLyTinNhan.xemTatCaTinNhan(nv);
    }

    public void xemTinNhanGanDay() {
        QuanLyTinNhan quanLyTinNhan = new QuanLyTinNhan(db);
        quanLyTinNhan.xemTatCaTinNhan(nv);
    }

    public void xuatMenu() {
        System.out.println("======= Nhan Vien Quan Ly =======");
        System.out.println("1.  Hien thi thong tin");
        System.out.println("2.  Tra cuu thong tin khach hang");
        System.out.println("3.  Tao hoa don");
        System.out.println("4.  Tao Phieu tra hang");
        System.out.println("5.  Tim kiem san pham");
        System.out.println("6.  Xem tat ca ma giam gia");
        System.out.println("7.  Xem lich lam trong tuan");
        System.out.println("8.  Tra cuu thong tin bao hanh");
        System.out.println("9.  Tao phieu bao hanh");
        System.out.println("10. Gui Tin Nhan");
        System.out.println("11. Hop thu");
        System.out.println("12. Doi mat khau");
        System.out.println("0.  Thoat");
        System.out.println("---------------------------");
    }

    // thuc hien chuc nang
    public void thucHienChucNang(int choice) {
        switch (choice) {
            case 1 -> hienThiThongTin();
            case 2 -> traCuuThongTinKhachHang();
            case 3 -> taoHoaDon();
            case 4 -> doiTraHang();
            case 5 -> traCuuSanPham();
            case 6 -> xemTatCaMaGiamGia();
            case 7 -> xemLichLamViecTrongTuanNay();
            case 8 -> TraCuuBaoHanh();
            case 9 -> taoPhieuBaoHanh();
            case 10 -> guiTinNhan();
            case 11 -> xemTatCaTinNhan();
            case 12 -> doiMatKhau();
            default -> System.out.println("Da thoat Menu!");
        }
    }

    // nhap lua chon thuc hien chuc nang
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
