package ui;

import java.util.ArrayList;

import danhsach.DanhSachHangThanhVien;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachMaGiamGia;
import danhsach.DanhSachPhieuTraHang;
import danhsach.DanhSachSanPham;
import database.Database;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.PhieuTraHang;
import model.SanPham;
import model.SanPhamDaBan;
import util.TaoDoiTuong;
import util.ThoiGian;
import util.XoaManHinh;

public class QuanLyPhieuTraHang {
    private Database db;

    public QuanLyPhieuTraHang(Database db) {
        this.db = db;
    }

    public void hienThiTatCaPhieuTraHang() {
        System.out.println("===== DANH SACH PHIEU TRA HANG =====");
        ArrayList<PhieuTraHang> listPhieuTraHang = db.getListPhieuTraHang();

        if (listPhieuTraHang.size() == 0) {
            System.out.println("khong tim thay phieu tra hang nao");
            return;
        }

        for (int i = 0; i < listPhieuTraHang.size(); i++) {
            System.out.println("---------------------------");
            System.out.println(listPhieuTraHang.get(i));
        }
    }

    public void taoPhieuTraHang() {
        DanhSachPhieuTraHang danhSachPhieuTraHang = db.getDanhSachPhieuTraHang();
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        KhachHang khachHang = danhSachKhachHang.timKhachHangTheoSdt(Nhap.nhapStr("Nhap sdt khach hang de tra hang : "));
        if (khachHang == null) {
            System.out.println("Khong tim thay khach hang");
            return;
        }
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        SanPham sanPham = danhSachSanPham.tim(Nhap.nhapStr("Hay hay nhap ma san pham can tra hang : "));
        if (sanPham == null) {
            System.out.println("Khong tim thay san pham");
            return;             
        }
        SanPhamDaBan spDaBan = null;

        String serial = Nhap.nhapStr("Nhap so serial cua san pham : ");
        String ngayTaoHd = null;
        HoaDon hd = null;
        for (HoaDon hoaDon : khachHang.getListHoaDon()) {
            for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {
                for (SanPhamDaBan sanPhamDaBan : chiTietHoaDon.getSanPhamDaBan()) {
                    if (sanPhamDaBan.getSanPham().getMa().equals(sanPham.getMa())
                            && sanPhamDaBan.getSerial().equals(serial)) {
                        ngayTaoHd = hoaDon.getNgayTaoHoaDon();
                        spDaBan = sanPhamDaBan;
                        hd = hoaDon;
                    }
                }
            }
        }
        if (ngayTaoHd == null) {
            System.out.println("Khach hang chua tung mua san pham " + serial);
            return;
        }
        if (ThoiGian.khoangCachNgay(ngayTaoHd, ThoiGian.layNgayHienTaiStr()) > 3) {
            System.out.println("Chi duoc tra hang neu loi trong vong 3 ngay");
            return;
        }

        spDaBan.getSanPham().setTraHang(true);

        DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(spDaBan.getListMaGiamGiaDaDung());
        long tienTraLai = 0;

        tienTraLai = danhSachMaGiamGia.giaSanPhamSauKhiApDungTatCa(sanPham);

        System.out.println("So tien hoan lai cho khach hang : " + tienTraLai);
        khachHang.giamTienDaChi(tienTraLai);
        hd.giamThanhTien(tienTraLai);

        DanhSachHangThanhVien danhSachHangThanhVien = db.getDanhSachHangThanhVien();
        danhSachHangThanhVien.setHangThanhVienChoKhachHang(khachHang);

        PhieuTraHang pth = TaoDoiTuong.taoPhieuTraHang(khachHang, sanPham, spDaBan.getSerial(), db);

        if (danhSachPhieuTraHang.them(pth)) {
            System.out.println("Tao phieu tra hang thanh cong!");
            khachHang.themPhieuTraHang(pth);

        } else {
            System.out.println("Tao phieu tra hang that bai!");
        }
    }

    public void xoaPhieuTraHang() {
        DanhSachPhieuTraHang danhSachPhieuTraHang = db.getDanhSachPhieuTraHang();
        String ma = Nhap.nhapStr("Nhap ma phieu can xoa: ");
        if (danhSachPhieuTraHang.xoa(ma)) {
            System.out.println("Xoa phieu tra hang thanh cong!");
        } else {
            System.out.println("Khong tim thay ma phieu hoac xoa that bai!");
        }
    }

    /// sua phieu tra hang
    private void xuatSuaTraHang() {
        System.out.println("===== SUA PHIEU TRA HANG =====");
        System.out.println("1. Sua khach hang");
        System.out.println("2. Sua san pham");
        System.out.println("3. Sua ngay tra");
        System.out.println("4. Sua ly do tra");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void suaThanhPhanPhieuTraHang(PhieuTraHang pth, int chon) {
        switch (chon) {
            case 1:
                DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
                pth.setKhachHang(danhSachKhachHang.tim(Nhap.nhapStr("Nhap ma khach hang de them vao : ")));
                System.out.println("Da thay doi khach hang");
                break;

            case 2:
                DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
                pth.setSanPham(danhSachSanPham.tim("Nhap ma san pham de them vao : "));
                System.out.println("da thay doi san pham");
                break;
            case 3:
                pth.setNgayTra(Nhap.nhapNgay("Nhap ngay tra moi (yyyy-MM-dd): "));
                System.out.println("Da thay doi ngay tra");
                break;
            case 4:
                pth.setLyDoTra(Nhap.nhapStr("Nhap ly do moi: "));
                System.out.println("Da thay doi ly do tra");
                break;
            case 0:
                System.out.println("Thoat sua phieu tra hang.");
                break;

            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    }

    public void suaPhieuTraHang() {
        DanhSachPhieuTraHang danhSachPhieuTraHang = db.getDanhSachPhieuTraHang();
        String ma = Nhap.nhapStr("Nhap ma phieu can sua: ");
        PhieuTraHang pth = danhSachPhieuTraHang.tim(ma);

        if (pth == null) {
            System.out.println("Khong tim thay phieu tra hang!");
            return;
        }

        int tiep = 1;
        while (tiep == 1) {
            System.out.println();
            System.out.println("------------------------");
            System.out.println(pth);
            System.out.println("------------------------");
            xuatSuaTraHang();
            int chon = Nhap.nhapInt("Chon muc can sua: ");
            if (chon == 0) {
                return;
            }
            suaThanhPhanPhieuTraHang(pth, chon);
            Nhap.pause();
        }
    }

    public void traCuuPhieuTraHang() {
        DanhSachPhieuTraHang danhSachPhieuTraHang = db.getDanhSachPhieuTraHang();
        String ma = Nhap.nhapStr("Nhap ma phieu bao hanh can tim : ");
        PhieuTraHang phieuTraHang = danhSachPhieuTraHang.tim(ma);
        if (phieuTraHang == null) {
            System.out.println("khong tim thay");
        } else {
            System.out.println("---------------------------");
            System.out.println(phieuTraHang);
            System.out.println("---------------------------");
        }
    }

    ////////
    private void xuatMenu() {
        System.out.println("===== MENU PHIEU TRA HANG =====");
        System.out.println("1. Tao phieu tra hang");
        System.out.println("2. Sua phieu tra hang");
        System.out.println("3. Tra cuu phieu tra hang");
        System.out.println("4. Xoa phieu tra hang");
        System.out.println("5. Hien thi tat ca phieu tra hang");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void thucHienChucNang(int chon) {
        switch (chon) {
            case 1 -> taoPhieuTraHang();
            case 2 -> suaPhieuTraHang();
            case 3 -> traCuuPhieuTraHang();
            case 4 -> xoaPhieuTraHang();
            case 5 -> hienThiTatCaPhieuTraHang();
            case 0 -> System.out.println("Da thoat menu phieu tra hang!");
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
