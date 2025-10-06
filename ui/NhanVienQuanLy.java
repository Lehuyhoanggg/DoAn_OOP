package ui;

import model.LichTrongTuan;
import model.NhanVien;
import util.XoaManHinh;
import danhsach.DanhSachLichTrongTuan;
import database.Database;
import interfaces.GiaoTiep;
import interfaces.LamViec;

public class NhanVienQuanLy implements LamViec, GiaoTiep {
    private Database db;
    private NhanVien nv;

    public NhanVienQuanLy(Database db, NhanVien nv) {
        this.db = db;
        this.nv = nv;
    }

    public void diemDanhCaLam() {
        DanhSachLichTrongTuan danhSachLichTrongTuan = db.getDanhSachLichTrongTuan();
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.lichTrongTuanNay();
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
        if (quanLyLichTrongTuan.diemDanh(nv)) {
            System.out.println("Diem danh thanh cong");
        } else {
            System.out.println("Diem danh that bai , hien khong co ca lam");
        }
    }

    public void xemLichLamViecTrongTuanNay() {
        DanhSachLichTrongTuan danhSachLichTrongTuan = db.getDanhSachLichTrongTuan();
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.lichTrongTuanNay();
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
        QuanLySanPham quanLySanPham = new QuanLySanPham(db);
        quanLySanPham.traCuuSanPham();
    }

    public void TraCuuBaoHanh() {
        QuanLyBaoHanh quanLyBaoHanh = new QuanLyBaoHanh(db);
        quanLyBaoHanh.traCuuBaoHanh();
    }

    public void taoBaoHanh() {
        QuanLyBaoHanh quanLyBaoHanh = new QuanLyBaoHanh(db);
        quanLyBaoHanh.taoBaoHanh();
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
        System.out.println("1.  Hien thi thong tin");
        System.out.println("2.  Diem danh ca lam");
        System.out.println("3.  Tra cuu thong tin khanh hang");
        System.out.println("4.  Tao hoa don");
        System.out.println("5.  Doi/Tra hang");
        System.out.println("6.  Tim kiem san pham");
        System.out.println("7.  Xem tat ca ma giam gia");
        System.out.println("8.  Xem lich lam trong tuan");
        System.out.println("9.  Doi mat khau");
        System.out.println("10. Tra cuu thong tin bao hanh");
        System.out.println("11. Tao phieu bao hanh");
        System.out.println("12. Gui Tin Nhan");
        System.out.println("13. Hop thu");
        System.out.println("0.  Thoat Menu");

    }

    // thuc hien chuc nang
    public void thucHienChucNang(int choice) {
        switch (choice) {
            case 1 -> hienThiThongTin();
            case 2 -> diemDanhCaLam();
            case 3 -> traCuuThongTinKhachHang();
            case 4 -> taoHoaDon();
            case 5 -> doiTraHang();
            case 6 -> traCuuSanPham();
            case 7 -> xemTatCaMaGiamGia();
            case 8 -> xemLichLamViecTrongTuanNay();
            case 9 -> doiMatKhau();
            case 10 -> TraCuuBaoHanh();
            case 11 -> taoBaoHanh();
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
