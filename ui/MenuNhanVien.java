package ui;

import model.User;
import model.NhanVien;
import java.util.ArrayList;
import service.TaiKhoanService;
import database.Database;
import file.DocFile;
import file.GhiFile;
import interfaces.GiaoTiep;
import interfaces.LamViec;
import service.MaGiamGiaService;
import service.NhanVienService;
import model.MaGiamGia;

public class MenuNhanVien implements LamViec {
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

    }

    public void taoHoaDon() {
        MenuHoaDon menuDonHang = new MenuHoaDon(db);
    }

    public void taoPhieuTraHang() {
        MenuPhieuTraHang menuPhieuTraHang = new MenuPhieuTraHang(db);
    }

    public void timKiemSanPham() {
        MenuSanPham menuSanPham = new MenuSanPham(db);
    }

    public void TimKiemBaoHanh() {

    }

    public void taoBaoHanh() {

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

    }

    public void hienThiThongTin() {
        System.out.println(nv);
    }

    public void xuatMenu() {
        System.out.println("1. Hien thi thong tin");
        System.out.println("2. Diem danh ca lam");
        System.out.println("3. Tra cuu thong tin khanh hang");
        System.out.println("4. Tao hoa don");
        System.out.println("5. Doi/Tra hang");
        System.out.println("6. Tim kiem san pham");
        System.out.println("7. Xem tat ca ma giam gia");
        System.out.println("8. Xem lich lam trong tuan");
        System.out.println("9. Doi mat khau");
        System.out.println("10. Tra cuu thong tin bao hanh");
        System.out.println("11. Tao phieu bao hanh");
        System.out.println("0. Thoat Menu");

    }

    // thuc hien chuc nang
    public void thucHienChucNang(int choice) {
        switch (choice) {
            case 1 -> hienThiThongTin();
            case 2 -> diemDanhCaLam();
            case 3 -> traCuuThongTinKhachHang();
            case 4 -> taoHoaDon();
            case 5 -> doiTraHang();
            case 6 -> timKiemSanPham();
            case 7 -> xemTatCaMaGiamGia();
            case 8 -> xemLichLamViec();
            case 9 -> doiMatKhau();
            case 10 -> TimKiemBaoHanh();
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
