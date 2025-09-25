package ui;

import database.Database;

public class MenuPhieuTraHang {
    private Database db;

    public MenuPhieuTraHang(Database db) {
        this.db = db;
    }

    public void taoPhieuTraHang() {

    }

    public void xoaPhieuTraHang() {

    }

    public void suaPhieuTraHang() {

    }

    public void timPhieuTraHang() {

    }

    public void hienThiTatCaPhieuTraHang() {

    }

    private void xuatMenu() {
        System.out.println("1. Tao phieu tra hang");
        System.out.println("2. Sua phieu tra hang");
        System.out.println("3. Tra cuu phieu tra hang");
        System.out.println("4. Xoa Phieu Tra Hang");
        System.out.println("5. Hien thi tat ca phieu bao hanh");
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
