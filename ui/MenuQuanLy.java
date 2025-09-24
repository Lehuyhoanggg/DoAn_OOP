package ui;

import database.Database;
import interfaces.QuanLiChung;
import model.QuanLy;

public class MenuQuanLy implements QuanLiChung {
    private Database db;
    private QuanLy user;

    public void QuanLy(Database db, QuanLy user) {
        this.user = user;
        this.db = db;
    }

    public void quanLySanPham() {
        MenuSanPham menu = new MenuSanPham();
        
    }

    public void quanLyNhanVien() {

    }

    public void quanLyDonHang() {

    }

    public void quanLyBaoHanh() {

    }

    public void QuanLyKhacHang() {
    }

    public void giaoDienQuanLy() {

    }

    public void guiTinNhan() {

    }

    public void xemTatCaTinNhan() {

    }

    public void xemDoanhThu() {

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

    }

    public void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 1 -> System.out.println(user);
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
