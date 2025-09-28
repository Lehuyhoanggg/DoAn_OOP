package ui;

import database.Database;
import interfaces.QuanLiChung;
import model.QuanLy;
import service.TaiKhoanService;

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

    }

    public void xemTatCaTinNhan() {

    }

    public void xemDoanhThu() {
        MenuHoaDon menuHoaDon = new MenuHoaDon(db);
        menuHoaDon.xemDoanhThu();
    }

    public void xemLichTuan() {

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
        System.out.println("0. Thoat");
        System.out.println("--------------------------------");
    }

    public void doiMatKhau() {
        TaiKhoanService tKhoanService = new TaiKhoanService(db.getListTaiKhoan());
        System.out.println("Doi mat khau:");
        String matKhauMoi = Nhap.nhapStr("Nhap mat khau moi : ");
        tKhoanService.doiMatKhau(matKhauMoi, ql.getTaiKhoan());
    }

    public void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 1 -> System.out.println(ql);
            case 2 -> quanLyNhanVien();
            case 3 -> quanLySanPham();
            case 4 -> quanLyDonHang();
            case 5 -> quanLyBaoHanh();
            case 6 -> xemDoanhThu();
            case 7 -> guiTinNhan();
            case 8 -> xemTatCaTinNhan();
            case 9 -> xemLichTuan();
            case 10 -> doiMatKhau();
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
