package ui;

import model.User;
import model.NhanVien;
import model.TinNhan;

import java.util.ArrayList;
import service.TaiKhoanService;
import database.Database;
import interfaces.GiaoTiep;
import interfaces.LamViec;
import model.MaGiamGia;

public class MenuNhanVien implements LamViec, GiaoTiep {
    private Database db;
    private NhanVien nv;

    public MenuNhanVien(Database db, NhanVien nv) {
        this.db = db;
        this.nv = nv;
    }

    public void diemDanhCaLam() {

    }

    public void xemLichLamViec() {

    }

    public void traCuuThongTinKhachHang() {
        MenuKhachHang menuKhachHang = new MenuKhachHang(db);
        menuKhachHang.traCuuThongTinKhachHang();
    }

    public void taoHoaDon() {
        MenuHoaDon menuHoaDon = new MenuHoaDon(db);
        menuHoaDon.taoHoaDon();

    }

    public void taoPhieuTraHang() {
        MenuPhieuTraHang menuPhieuTraHang = new MenuPhieuTraHang(db);
        menuPhieuTraHang.taoPhieuTraHang();
    }

    public void traCuuSanPham() {
        MenuSanPham menuSanPham = new MenuSanPham(db);
        menuSanPham.traCuuSanPham();
    }

    public void TraCuuBaoHanh() {
        MenuBaoHanh menuBaoHanh = new MenuBaoHanh(db);
        menuBaoHanh.traCuuBaoHanh();
    }

    public void taoBaoHanh() {
        MenuBaoHanh menuBaoHanh = new MenuBaoHanh(db);
        menuBaoHanh.taoBaoHanh();
    }

    public void xemTatCaMaGiamGia() {
        ArrayList<MaGiamGia> listmGiamGia = db.getListMaGiamGia();
        System.out.println("list ma giam gia:");
        for (int i = 0; i < listmGiamGia.size(); i++) {
            System.out.println(listmGiamGia.get(i));
        }
    }

    //
    public void doiMatKhau() {
        TaiKhoanService tKhoanService = new TaiKhoanService(db.getListTaiKhoan());
        System.out.println("Doi mat khau:");
        String matKhauMoi = Nhap.nhapStr("Nhap mat khau moi : ");
        tKhoanService.doiMatKhau(matKhauMoi, nv.getTaiKhoan());
    }

    public void doiTraHang() {
        MenuPhieuTraHang menuPhieuTraHang = new MenuPhieuTraHang(db);
        menuPhieuTraHang.taoPhieuTraHang();
    }

    public void hienThiThongTin() {
        System.out.println(nv);
    }

    public void guiTinNhan(String maNguoiNhan, TinNhan tinNhan) {

    }

    public void xemTatCaTinNhan(User user) {

    }

    public void xemTinNhanTrongNgay() {

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
            case 8 -> xemLichLamViec();
            case 9 -> doiMatKhau();
            case 10 -> TraCuuBaoHanh();
            case 11 -> taoBaoHanh();
            default -> System.out.println("Da thoat Menu!");
        }
    }

    // nhap lua chon thuc hien chuc nang
    public void menu() {
        int thoat = 1;
        while (thoat == 1) {
            xuatMenu();
            int choice = Nhap.nhapInt("Nhap lua chon");
            thucHienChucNang(choice);
            thoat = Nhap.nhapXacNhanThoat();
        }
    }
}
