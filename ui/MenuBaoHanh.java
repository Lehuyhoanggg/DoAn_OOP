package ui;

import java.util.ArrayList;
import database.Database;
import service.BaoHanhService;
import service.KhacHangService;
import service.SanPhamService;
import util.CapMa;
import model.BaoHanh;
import model.KhachHang;
import model.SanPham;

public class MenuBaoHanh {
    private Database db;

    public MenuBaoHanh(Database db) {
        this.db = db;
    }

    public void taoBaoHanh() {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        System.out.println("Tao bao hanh");
        String maBaoHanh = CapMa.capMaBaoHanh(db);
        String tenBaoHanh = Nhap.nhapStr("Nhap ten bao hanh : ");
        String maKhachHang = Nhap.nhapStr("Nhap ma khach hang: ");
        KhachHang khachHang = khacHangService.timKhachHang(maKhachHang);

        String maSanPham = Nhap.nhapStr("Nhap ma san pham : ");
        SanPham sanPham = sanPhamService.timSanPham(maSanPham);

        String ngayBatDau = Nhap.nhapStr("Nhap ngay bat dau bao hanh  ");
        String ngayKetThuc = Nhap.nhapStr("Nhap ngay ket thuc bao hanh (dd/MM/yyyy): ");
        BaoHanh baoHanh = new BaoHanh(maBaoHanh, tenBaoHanh, khachHang, sanPham, ngayBatDau, ngayKetThuc);
        baoHanhService.themBaoHanh(baoHanh);
        khachHang.themBaoHanh(baoHanh);
        System.out.println("Da tao bao hanh thanh cong.");
    }

    public void xuatSuaBaoHanh() {
        System.out.println("1. Sua khach hang");
        System.out.println("2. Sua ten bao hanh");
        System.out.println("3. Sua san pham");
        System.out.println("4. Sua ngay bat dau");
        System.out.println("4. Sua ngay ket thuc");
    }

    private void suaThanhPhanBaoHanh(BaoHanh baoHanh, int luaChon) {
        switch (luaChon) {
            case 1:
                KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
                KhachHang khachHang = khacHangService.timKhachHang("Nhap ma khach hang can thay doi vao trong phieu");
                if (khachHang == null) {
                    System.out.println("Ma khach hang khong hop le");
                } else {
                    baoHanh.setKhachHang(khachHang);
                    System.out.println("Da sua khach hang");
                }
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
                break;
            case 4:
                baoHanh.setNgayKetThuc(Nhap.nhapStr("Nhap ngay chi tiet bao hanh moi : "));
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
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatSuaBaoHanh();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            suaThanhPhanBaoHanh(baoHanh, luaChon);
            xacNhan = Nhap.nhapInt("(1) Tiep tuc sua (Khac) Thoat");
        }
        System.out.println("Da cap nhat bao hanh.");
    }

    public void xoaPhieuBaoHanh() {
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        String ma = Nhap.nhapStr("Nhap ma bao hanh can xoa: ");
        BaoHanh baoHanh = baoHanhService.timBaoHanh(ma);
        baoHanh.getKhachHang().getListBaoHanh().remove(baoHanh);
        System.out.println("Da xoa bao hanh (neu ton tai).");
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
                case 3 -> xoaPhieuBaoHanh();
                case 4 -> traCuuBaoHanh();
                case 5 -> xemTatCaBaoHanh();
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}