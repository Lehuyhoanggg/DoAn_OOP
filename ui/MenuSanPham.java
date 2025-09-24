package ui;

import database.Database;
import model.SanPham;
import service.SanPhamService;
import util.TaoDoiTuong;

public class MenuSanPham {
    private Database db;
    private SanPhamService sanPhamService;

    public MenuSanPham(Database db, SanPhamService sanPhamService) {
        this.db = db;
        this.sanPhamService = sanPhamService;
    }

    public void hienThiTatCaSanPham() {
        System.out.println("Danh sach san pham:");
        for (SanPham sp : sanPhamService.getListSanPham()) {
            System.out.println(sp);
        }
    }

    public void themSanPham() {
        SanPham sp = TaoDoiTuong.taoSanPham();
        sanPhamService.themSanPham(sp);
        System.out.println("Them san pham thanh cong!");
    }

    public void xoaSanPham() {
        String ma = Nhap.nhapStr("Nhap ma san pham can xoa: ");
        sanPhamService.xoaSanPham(ma);
        System.out.println("Xoa san pham thanh cong!");
    }

    public void suaSanPham() {
        String ma = Nhap.nhapStr("Nhap ma san pham can sua: ");
        SanPham spCu = sanPhamService.getListSanPham().stream()
                .filter(sp -> sp.getMa().equals(ma))
                .findFirst().orElse(null);
        if (spCu == null) {
            System.out.println("Khong tim thay san pham!");
            return;
        }
        System.out.println("Sua san pham thanh cong!");
    }

    public void timSanPham() {
        String ten = Nhap.nhapStr("Nhap ten san pham can tim: ");
        var ketQua = sanPhamService.searchSanPham(ten);
        if (ketQua == null || ketQua.isEmpty()) {
            System.out.println("Khong tim thay san pham!");
            return;
        }
        System.out.println("Ket qua tim kiem:");
        for (SanPham sp : ketQua) {
            System.out.println(sp);
        }
    }

    public void xuatMenu() {
        System.out.println("===== MENU SAN PHAM =====");
        System.out.println("1. Hien thi tat ca san pham");
        System.out.println("2. Them san pham");
        System.out.println("3. Xoa san pham");
        System.out.println("4. Sua san pham");
        System.out.println("5. Doc du lieu khoi dau");
        System.out.println("0. Thoat Menu");
    }

    public void thucHienChucNang(int choice) {
        switch (choice) {
            case 1 -> hienThiTatCaSanPham();
            case 2 -> themSanPham();
            case 3 -> xoaSanPham();
            case 4 -> suaSanPham();
            case 5 -> timSanPham();
            default -> System.out.println("Da thoat Menu!");
        }
    }

    public void menu() {
        int thoat = 1;
        while (thoat == 1) {
            xuatMenu();
            int choice = Nhap.nhapInt("Nhap lua chon: ");
            thucHienChucNang(choice);
            thoat = Nhap.nhapXacNhanThoat();
        }
    }
}
