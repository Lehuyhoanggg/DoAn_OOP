package ui;

import java.util.ArrayList;
import database.Database;
import service.BaoHanhService;
import service.KhachHangService;
import service.SanPhamService;
import util.TaoDoiTuong;
import model.BaoHanh;
import model.KhachHang;
import model.SanPham;

public class MenuBaoHanh {
    private Database db;

    public MenuBaoHanh(Database db) {
        this.db = db;
    }

    public void taoBaoHanh() {
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        KhachHangService khacHangService = new KhachHangService(db.getListKhachHang());
        KhachHang khachHang = khacHangService.timKhachHang(Nhap.nhapStr("Nhap ma khach hang de tao bao hanh"));
        if (khachHang == null) {
            System.out.println("Khong tim thay khach hang");
            return;
        }
        BaoHanh baoHanh = TaoDoiTuong.taoBaoHanh(db);
        if (baoHanh == null) {
            System.out.println("Tao bao hanh that bai");
            return;
        }
        khachHang.themBaoHanh(baoHanh);
        baoHanhService.themBaoHanh(baoHanh);
        System.out.println("Da tao bao hanh thanh cong.");
    }

    public void xoaBaoHanh() {
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        String ma = Nhap.nhapStr("Nhap ma bao hanh can xoa: ");
        BaoHanh baoHanh = baoHanhService.timBaoHanh(ma);
        if (baoHanh == null) {
            System.out.println("Khong tim thay bao hanh");
            return;
        }
        if (baoHanhService.xoaBaoHanh(ma)) {
            System.out.println("Da xoa bao hanh (neu ton tai).");
        } else {
            System.out.println("Xoa khong thanh cong");
        }
    }

    private void xuatSuaBaoHanh() {
        System.out.println("1. Sua so thang bao hanh");
        System.out.println("2. Sua san pham");
        System.out.println("3. Sua ngay bat dau");
        System.out.println("4. Sua gia");
        System.out.println("0. Thoat");
    }

    private void suaThanhPhanBaoHanh(BaoHanh baoHanh, int luaChon) {
        switch (luaChon) {
            case 0:
                System.out.println("Thoat sua bao hanh");
                break;
            case 1:
                int soThang = Nhap.nhapInt("Nhap so thang bao hanh moi");
                baoHanh.setLoaiBaoHanh(soThang);
                System.out.println("Da sua loai bao hanh");
                break;
            case 2:
                SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
                SanPham sanPham = sanPhamService.timSanPham("Nhap ma san pham moi trong phieu");
                if (sanPham == null) {
                    System.out.println("Ma san pham khong hop le");
                } else {
                    baoHanh.setSanPham(sanPham);
                    System.out.println("Da sua san pham");
                }
                break;
            case 3:
                baoHanh.setNgayBatDau(Nhap.nhapStr("Nhap ngay bat dau bao hanh moi : "));
                baoHanh.setNgayKetThuc();
                break;
            case 4:
                baoHanh.setGia(Nhap.nhapLong(Nhap.nhapStr("Nhap gia moi : ")));
                break;
            default:
                System.out.println("lua chon khong hop le");
                break;
        }
    }

    public void suaBaoHanh() {
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        String maBaoHanh = Nhap.nhapStr("Nhap ma phieu bao hanh can sua: ");
        BaoHanh baoHanh = baoHanhService.timBaoHanh(maBaoHanh);
        if (baoHanh == null) {
            System.out.println("Khong tim thay bao hanh");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatSuaBaoHanh();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            suaThanhPhanBaoHanh(baoHanh, luaChon);
            xacNhan = Nhap.nhapInt("(1) Tiep tuc sua (Khac) Thoat");
        }
        System.out.println("Da cap nhat bao hanh.");
    }

    public void xemTatCaBaoHanh() {
        ArrayList<BaoHanh> listBaoHanh = db.getListBaoHanh();
        if (listBaoHanh == null || listBaoHanh.size() == 0) {
            System.out.println("khong co bao hanh nao");
        }
        for (int i = 0; i < listBaoHanh.size(); i++) {
            System.out.println(listBaoHanh.get(i));
        }
    }

    public void traCuuBaoHanh() {
        String ma = Nhap.nhapStr("Nhap ma bao hanh can tra cuu : ");
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        BaoHanh baoHanh = baoHanhService.timBaoHanh(ma);
        if (baoHanh == null) {
            System.out.println("khong tim thay bao hanh");
            return;
        }
        System.out.println(baoHanh);
    }

    public void xuatMenu() {
        System.out.println("\nQUAN LY PHIEU BAO HANH");
        System.out.println("1. Tao bao hanh");
        System.out.println("2. Sua bao hanh");
        System.out.println("3. Xoa bao hanh");
        System.out.println("4. Tra cuu bao hanh");
        System.out.println("5. Xem tat ca bao hanh bao hanh");
        System.out.println("0. Thoat");
    }

    public void menu() {
        while (true) {
            xuatMenu();
            int luaChon = Nhap.nhapInt("Chon chuc nang: ");
            switch (luaChon) {
                case 0 -> {
                    System.out.println("Thoat menu phieu bao hanh");
                    return;
                }
                case 1 -> taoBaoHanh();
                case 2 -> suaBaoHanh();
                case 3 -> xoaBaoHanh();
                case 4 -> traCuuBaoHanh();
                case 5 -> xemTatCaBaoHanh();
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}