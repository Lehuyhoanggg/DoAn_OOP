package ui;

import java.util.ArrayList;

import danhsach.DanhSachBaoHanh;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachPhieuBaoHanh;
import danhsach.DanhSachSanPham;
import database.Database;
import model.BaoHanh;
import model.KhachHang;
import model.PhieuBaoHanh;
import model.SanPham;
import util.TaoDoiTuong;
import util.XoaManHinh;

public class QuanLyPhieuBaoHanh {
    private Database db;

    public QuanLyPhieuBaoHanh(Database db) {
        this.db = db;
    }

    public void taoPhieuBaoHanh() {
        DanhSachPhieuBaoHanh danhSachPhieuBaoHanh = db.getDanhSachPhieuBaoHanh();
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        DanhSachBaoHanh danhSachBaoHanh = db.getDanhSachBaoHanh();
        KhachHang khachHang = danhSachKhachHang.timKhachHangTheoSdt(Nhap.nhapStr("Nhap sdt khach hang de bao hanh : "));
        BaoHanh baoHanh = danhSachBaoHanh.timBaoHanh(Nhap.nhapStr("Nhap ma bao hanh de tao phieu bao hanh : "));
        if (baoHanh == null) {
            System.out.println("Khong tim thay bao hanh de tao phieu");
            return;
        }
        PhieuBaoHanh phieuBaoHanh = TaoDoiTuong.taoPhieuBaoHanh(baoHanh, khachHang, db);
        danhSachPhieuBaoHanh.themPhieuBaoHanh(phieuBaoHanh);
        khachHang.themPhieuBaoHanh(phieuBaoHanh);
        System.out.println("Da tao phieu bao hanh thanh cong.");
    }

    public void xuatSuaPhieuBaoHanh() {
        System.out.println("1. Sua khach hang");
        System.out.println("2. Sua san pham");
        System.out.println("3. Sua ngay bao hanh");
        System.out.println("4. Sua chi tiet loi");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void suaThanhPhanPhieu(PhieuBaoHanh phieuBaoHanh, int luaChon) {
        switch (luaChon) {
            case 0:
                System.out.println("Thoat sua khach hang");
                break;
            case 1:
                DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
                KhachHang khachHang = danhSachKhachHang
                        .timKhachHang("Nhap ma khach hang can thay doi vao trong phieu : ");
                if (khachHang == null) {
                    System.out.println("Ma khach hang khong hop le");
                } else {
                    phieuBaoHanh.setKhachHang(khachHang);
                    System.out.println("Da sua khach hang");
                }
                break;
            case 2:
                DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
                SanPham sanPham = danhSachSanPham.timSanPham("Nhap ma san pham moi trong phieu : ");
                if (sanPham == null) {
                    System.out.println("Ma san pham khong hop le");
                } else {
                    phieuBaoHanh.setSanPham(sanPham);
                    System.out.println("Da sua san pham");
                }
                break;
            case 3:
                phieuBaoHanh.setNgayBaoHanh(Nhap.nhapNgay("Nhap ngay bao hanh moi : "));
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
        DanhSachPhieuBaoHanh danhSachPhieuBaoHanh = db.getDanhSachPhieuBaoHanh();
        String maPhieu = Nhap.nhapStr("Nhap ma phieu bao hanh can sua: ");
        PhieuBaoHanh phieuBaoHanh = danhSachPhieuBaoHanh.timPhieuBaoHanh(maPhieu);
        if (phieuBaoHanh == null) {
            System.out.println("Khong tim thay phieu bao hanh");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatSuaPhieuBaoHanh();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon == 0) {
                return;
            }
            suaThanhPhanPhieu(phieuBaoHanh, luaChon);
            Nhap.pause();
        }
        System.out.println("Da cap nhat phieu bao hanh.");
    }

    public void xoaPhieuBaoHanh() {
        DanhSachPhieuBaoHanh danhSachPhieuBaoHanh = db.getDanhSachPhieuBaoHanh();
        String ma = Nhap.nhapStr("Nhap ma phieu bao hanh can xoa: ");
        PhieuBaoHanh phieuBaoHanh = danhSachPhieuBaoHanh.timPhieuBaoHanh(ma);
        if (phieuBaoHanh == null) {
            System.out.println("Khong tim thay phieu bao hanh");
            return;
        }
        KhachHang khachHang = phieuBaoHanh.getKhachHang();
        khachHang.getListPhieuBaoHanh().remove(phieuBaoHanh);
        danhSachPhieuBaoHanh.xoaPhieuBaoHanh(ma);
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
            System.out.println("---------------------------");
            System.out.println(listPhieuBaoHanh.get(i));

        }
    }

    public void traCuuPhieuBaoHanh() {
        DanhSachPhieuBaoHanh danhSachPhieuBaoHanh = db.getDanhSachPhieuBaoHanh();
        PhieuBaoHanh phieuBaoHanh = danhSachPhieuBaoHanh
                .timPhieuBaoHanh(Nhap.nhapStr("Nhap ma phieu bao hanh can tim : "));
        if (phieuBaoHanh == null) {
            System.out.println("khong tim thay phieu bao hanh");
            return;
        }
        System.out.println("---------------------------");
        System.out.println(phieuBaoHanh);
        System.out.println("---------------------------");
    }

    private void xuatMenu() {
        System.out.println("\nQUAN LY PHIEU BAO HANH");
        System.out.println("1. Tao phieu bao hanh");
        System.out.println("2. Sua phieu bao hanh");
        System.out.println("3. Xoa phieu bao hanh");
        System.out.println("4. Tra cuu phieu bao hanh");
        System.out.println("5. Xem phieu bao hanh");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    public void thucHienChucNang(int luaChon) {
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

    public void menu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            XoaManHinh.xoa();
            xuatMenu();
            int luaChon = Nhap.nhapInt("Nhap lua Chon : ");
            if (luaChon == 0) {
                return;
            }
            thucHienChucNang(luaChon);
            Nhap.pause();
        }
    }
}
