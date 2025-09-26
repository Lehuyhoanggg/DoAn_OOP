package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.Database;
import model.ChiTietHoaDon;
import model.HoaDon;
import service.HoaDonService;
import util.ThoiGian;

public class MenuHoaDon {
    private Database db;

    public MenuHoaDon(Database db) {
        this.db = db;
    }

    // 2. xoa hao don mua hang
    public void xoaHoaDon_ui() {
        HoaDonService hoaDonService = new HoaDonService(db.getListHoaDon());
        String ma = Nhap.nhapStr("nhap ma hoa don can xoa: ");
        if (hoaDonService.xoaHoaDon(ma) == false) {
            System.out.println("xoa hoa don that bai!");
        } else {
            System.out.println("xoa hoa don thanh cong!");
        }
    }
    // 3. sua hoa don mua hang theo ma
    // public void suaHoaDon_ui(){
    // HoaDonService hoaDonService = new HoaDonService(db.getListHoaDon());
    // HoaDon hdMoi = new HoaDon();
    // String ma = Nhap.nhapStr("nhap ma hoa don can sua");
    // String mamoi = Nhap.nhapStr("nhap ma moi cho hoa don: ");
    // String khachHang = Nhap.nhapStr("nhap ten khach hang moi: ");
    // ChiTietHoaDon chiTietHoaDon =
    // hoaDonService.suaHoaDon(ma,hdmoi);
    // }

    // 4.xem doanh thu
    private void xuatXemDoanhThu() {
        System.out.println("1. xem doanh thu hom nay");
        System.out.println("2. xem doanh thu tuan");
        System.out.println("3. xem doanh thu thang");
    }

    private void xemDoanhthuHomNay() {
        String ngayHomNay = ThoiGian.layNgayHienTaiStr();
        ArrayList<HoaDon> listHoaDon = db.getListHoaDon();
        if (listHoaDon == null) {
            System.out.println("khong co hoa don hom nay de in!");
        }
        long tong = 0;
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (ngayHomNay.equals(listHoaDon.get(i).getNgayTaoHoaDon())) {
                tong += listHoaDon.get(i).getThanhTien();
            }
        }
        System.out.println("doanh thu ngay hom nay: " + tong);
    }

    private void xemDoanhThuTuan() {
        long tong = 0;
        ArrayList<HoaDon> listHoaDon = db.getListHoaDon();
        ArrayList<String> tuan = ThoiGian.layTuanHienTaiStr();
        if (tuan == null) {
            System.out.println("khong co hoa don trong tuan de in!");
        }
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (tuan.get(0).equals(listHoaDon.get(i).getNgayTaoHoaDon())) {
                tong += listHoaDon.get(i).getThanhTien();
            }
            if (tuan.get(1).equals(listHoaDon.get(i).getNgayTaoHoaDon())) {
                tong += listHoaDon.get(i).getThanhTien();
            }
            if (tuan.get(2).equals(listHoaDon.get(i).getNgayTaoHoaDon())) {
                tong += listHoaDon.get(i).getThanhTien();
            }
            if (tuan.get(3).equals(listHoaDon.get(i).getNgayTaoHoaDon())) {
                tong += listHoaDon.get(i).getThanhTien();
            }
            if (tuan.get(4).equals(listHoaDon.get(i).getNgayTaoHoaDon())) {
                tong += listHoaDon.get(i).getThanhTien();
            }
            if (tuan.get(5).equals(listHoaDon.get(i).getNgayTaoHoaDon())) {
                tong += listHoaDon.get(i).getThanhTien();
            }
            if (tuan.get(6).equals(listHoaDon.get(i).getNgayTaoHoaDon())) {
                tong += listHoaDon.get(i).getThanhTien();
            }
        }
        System.out.println("doanh thu trong tuan: " + tong);
    }

    public void xemDoanhThuThang() {
        ArrayList<HoaDon> listHoaDon = db.getListHoaDon();
        String thangNay = ThoiGian.layThangHienTai();
        long tong = 0;
        if (listHoaDon == null) {
            System.out.println("khong co hoa don de in!");
        }
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (thangNay == listHoaDon.get(i).getNgayTaoHoaDon()) {
                tong += listHoaDon.get(i).getThanhTien();
            }
        }
        System.out.println("doanh thu thang nay: " + tong);
    }

    private void thucHienChucNang(int choice) {
        switch (choice) {
            case 1 -> xemDoanhthuHomNay();
            case 2 -> xemDoanhThuTuan();
            case 3 -> xemDoanhThuThang();
            default -> System.out.println("nhap (0) de thoat!");
        }
    }

    public void xemDoanhThu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatXemDoanhThu();
            int choice = Nhap.nhapInt("nhap lua chon: ");
            thucHienChucNang(choice);
            choice = Nhap.nhapInt("nhap lua chon: ");
            xacNhan = Nhap.nhapInt("nhan (1) de tiep tuc (khac) de thoat: ");
        }
    }
    // 5 xem tinh trang san pham trong 1 thang
    // public void xemTinhTrangSanPham(){
    // ArrayList<ChiTietHoaDon> listhHoaDon = db.getListChiTietHoaDon();
    // Map<String, Integer> map = new HashMap<>();
    // for(int i = 0; i < )
    // }

    // 6.tra cuu hoa don mua hang
    public void traCuuHoaDonMuaHang() {
        String ma = Nhap.nhapStr("nhap ma hoa don muon tra cuu: ");
        HoaDonService hoaDonService = new HoaDonService(db.getListHoaDon());
        HoaDon hoaDon = hoaDonService.timHoaDon(ma);
        if (hoaDon == null) {
            System.out.println("khong tim thay hoa don muon tra cuu!");
            return;
        } else {
            System.out.println(hoaDon);
        }
    }

    // 7. xem tat ca hoa don
    public void xemTatCaHoaDon() {
        ArrayList<HoaDon> listHoaDon = db.getListHoaDon();
        if (listHoaDon == null) {
            System.out.println("khong co hoa don de in!");
        }
        for (int i = 0; i < listHoaDon.size(); i++) {
            System.out.println(listHoaDon.get(i));
        }
    }

    public void xuatMenu() {
        System.out.println("1. Tao hoa don mua hang cho khach");
        System.out.println("2. Xoa hoa don mua Hang");
        System.out.println("3. Sua hoa don mua hang theo ma");
        System.out.println("4. Xem doanh thu");
        System.out.println("5. Xem tinh trang ban san pham trong mot thang");
        System.out.println("6. Tra cuu hoa don mua hang");
        System.out.println("7. Xem tat ca hoa don mua hang");
        System.out.println("0. Thoat");
        System.out.println("---------------------------------------");
    }
}