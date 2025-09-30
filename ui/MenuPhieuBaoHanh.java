package ui;

import java.util.ArrayList;

import database.Database;
import model.BaoHanh;
import model.KhachHang;
import model.PhieuBaoHanh;
import model.SanPham;
import service.BaoHanhService;
import service.KhacHangService;
import service.PhieuBaoHanhService;
import service.SanPhamService;
import util.TaoDoiTuong;

public class MenuPhieuBaoHanh {
    private Database db;

    public MenuPhieuBaoHanh(Database db) {
        this.db = db;
    }

    public void taoPhieuBaoHanh() {
        PhieuBaoHanhService phieuBaoHanhService = new PhieuBaoHanhService(db.getListPhieuBaoHanh());
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());

        BaoHanh baoHanh = baoHanhService.timBaoHanh("Nhap ma bao hanh de tao phieu bao hanh");
        if (baoHanh == null) {
            System.out.println("Khong tim thay bao hanh de tao phieu");
            return;
        }
        PhieuBaoHanh phieuBaoHanh = TaoDoiTuong.taoPhieuBaoHanh(baoHanh, db);
        phieuBaoHanhService.themPhieuBaoHanh(phieuBaoHanh);
        System.out.println("Da tao phieu bao hanh thanh cong.");
    }

    public void xuatSuaPhieuBaoHanh() {
        System.out.println("1. Sua khach hang");
        System.out.println("2. Sua san pham");
        System.out.println("3. Sua ngay bao hanh");
        System.out.println("4. Sua chi tiet loi");
        System.out.println("0. Thoat");
    }

    private void suaThanhPhanPhieu(PhieuBaoHanh phieuBaoHanh, int luaChon) {
        switch (luaChon) {
            case 0:
                System.out.println("Thoat sua khach hang");
                break;
            case 1:
                KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
                KhachHang khachHang = khacHangService.timKhachHang("Nhap ma khach hang can thay doi vao trong phieu");
                if (khachHang == null) {
                    System.out.println("Ma khach hang khong hop le");
                } else {
                    phieuBaoHanh.setKhachHang(khachHang);
                    System.out.println("Da sua khach hang");
                }
                break;
            case 2:
                SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
                SanPham sanPham = sanPhamService.timSanPham("Nhap ma san pham moi trong phieu");
                if (sanPham == null) {
                    System.out.println("Ma san pham khong hop le");
                } else {
                    phieuBaoHanh.setSanPham(sanPham);
                    System.out.println("Da sua san pham");
                }
                break;
            case 3:
                phieuBaoHanh.setNgayBaoHanh(Nhap.nhapStr("Nhap ngay bao hanh moi : "));
                break;
            case 4:
                phieuBaoHanh.setChiTietLoi(Nhap.nhapStr("Nhap chi tiet loi moi : "));
                break;
            default:
                System.out.println("lua chon khong hop le");
                break;
        }
    }

    public void suaPhieuBaoHanh() {
        PhieuBaoHanhService phieuBaoHanhService = new PhieuBaoHanhService(db.getListPhieuBaoHanh());
        String maPhieu = Nhap.nhapStr("Nhap ma phieu bao hanh can sua: ");
        PhieuBaoHanh phieuBaoHanh = phieuBaoHanhService.timPhieuBaoHanh(maPhieu);
        if (phieuBaoHanh == null) {
            System.out.println("Khong tim thay phieu bao hanh");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatSuaPhieuBaoHanh();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            suaThanhPhanPhieu(phieuBaoHanh, luaChon);
            xacNhan = Nhap.nhapInt("(1) Tiep tuc sua (Khac) Thoat");
        }
        System.out.println("Da cap nhat phieu bao hanh.");
    }

    public void xoaPhieuBaoHanh() {
        PhieuBaoHanhService phieuBaoHanhService = new PhieuBaoHanhService(db.getListPhieuBaoHanh());
        String ma = Nhap.nhapStr("Nhap ma phieu bao hanh can xoa: ");
        PhieuBaoHanh phieuBaoHanh = phieuBaoHanhService.timPhieuBaoHanh(ma);
        if (phieuBaoHanh == null) {
            System.out.println("Khong tim thay phieu bao hanh");
            return;
        }
        KhachHang khachHang = phieuBaoHanh.getKhachHang();
        khachHang.getListPhieuBaoHanh().remove(phieuBaoHanh);
        phieuBaoHanhService.xoaPhieuBaoHanh(ma);
        System.out.println("Da xoa phieu bao hanh (neu ton tai).");
    }

    public void xemTatCaPhieu() {
        ArrayList<PhieuBaoHanh> listPhieuBaoHanh = db.getListPhieuBaoHanh();
        if (listPhieuBaoHanh == null || listPhieuBaoHanh.size() == 0) {
            System.out.println("Chua co phieu bao hanh nao.");
            return;
        }
        System.out.println("Danh sach tat ca phieu bao hanh:");
        for (int i = 0; i < listPhieuBaoHanh.size(); i++) {
            System.out.println(listPhieuBaoHanh.get(i));

        }
    }

    public void traCuuPhieuBaoHanh() {
        PhieuBaoHanhService phieuBaoHanhService = new PhieuBaoHanhService(db.getListPhieuBaoHanh());
        PhieuBaoHanh phieuBaoHanh = phieuBaoHanhService
                .timPhieuBaoHanh(Nhap.nhapStr("Nhap ma phieu bao hanh can tim : "));
        if (phieuBaoHanh == null) {
            System.out.println("khong tim thay phieu bao hanh");
            return;
        }
        System.out.println(phieuBaoHanh);
    }

    private void xuatMenu() {
        System.out.println("\nQUAN LY PHIEU BAO HANH");
        System.out.println("1. Tao phieu bao hanh");
        System.out.println("2. Sua phieu bao hanh");
        System.out.println("3. Xoa phieu bao hanh");
        System.out.println("4. Tra cuu phieu bao hanh");
        System.out.println("5. Xem phieu bao hanh");
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
                case 1 -> taoPhieuBaoHanh();
                case 2 -> suaPhieuBaoHanh();
                case 3 -> xoaPhieuBaoHanh();
                case 4 -> traCuuPhieuBaoHanh();
                case 5 -> xemTatCaPhieu();

                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
