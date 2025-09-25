package ui;

import database.Database;

public class MenuKhachHang {
    private Database db;

    public MenuKhachHang(Database db) {
        this.db = db;
    }

    public void taoKhachHang() {

    }

    public void traCuuThongTinKhachHang(String tuKhoa) {

    }

    public void xoaKhachHang(String ma) {

    }

    public void suaThongTinKhachHang() {

    }

    private void xuatMenu() {
        System.out.println("1. Tao khach hang");
        System.out.println("2. Tra cuu thong tin khach hang");// theo ten(chon trong nhieu khach hang) , theo ma, theo
                                                              // // so dien thoai, hoac thu tat ca cach
        System.out.println("3. Xoa khach hang");
        System.out.println("4. Sua thong tin khach hang");
        System.out.println("0. Thoat");
    }

    public void menu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatMenu();

            xacNhan = Nhap.nhapXacNhanThoat();
        }
    }
}
