package ui;

import database.Database;

public class MenuHoaDon {
    private Database db;

    public MenuHoaDon(Database db) {
        this.db = db;
    }

    public void xuatMenu() {
        System.out.println("1. Tao hoa don mua hang cho khach");
        System.out.println("2. Xoa hoa don mua Hang");
        System.out.println("3. Sua hoa don mua hang theo ma");
        System.out.println("3. Xem doanh thu");
        System.out.println("4. Xem tinh trang ban san pham");
        System.out.println("7. Tra cuu hoa don mua hang");
        System.out.println("8. Xem tat ca hoa don mua hang");
        System.out.println("0. Thoat");
        System.out.println("---------------------------------------");
    }
}
