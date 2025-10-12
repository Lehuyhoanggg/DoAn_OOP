package ui;

import java.util.ArrayList;

import danhsach.DanhSachHangThanhVien;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachMaGiamGia;
import danhsach.DanhSachPhieuTraHang;
import danhsach.DanhSachSanPham;
import database.Database;
import model.HoaDon;
import model.KhachHang;
import model.PhieuTraHang;
import model.SanPham;
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
        ArrayList<HoaDon> listHoaDon = khachHang.getListHoaDon();
        if (listHoaDon.size() == 0) {
            System.out.println("Khong co hoa don de tra hang");
            return;
        }
        System.out.println("Danh sach hoa don : ");
        for (int i = 0; i < listHoaDon.size(); i++) {
            System.out.println(i + ". " + listHoaDon.get(i));
        }
        int luaChon = Nhap.nhapInt("chon hoa don chua san can tra : ");
        if (luaChon < 0 || luaChon >= listHoaDon.size()) {
            System.out.println("Lua chon khong hop le");
            return;
        }
        HoaDon hoaDon = listHoaDon.get(luaChon);
        if (ThoiGian.khoangCachNgay(hoaDon.getNgayTaoHoaDon(), ThoiGian.layNgayHienTaiStr()) >= 3) {
            System.out.println("Da qua thoi gian tra hang , chi duoc tra hang trong 7 ngay tu khi mua hang");
            return;
        }
        System.out.println("Danh sach san pham trong hoa don");
        for (SanPham sanPham : hoaDon.getChiTietHoaDon().getDanhSachSanPham().getMapSanPham().keySet()) {
            System.out.println(sanPham.getMa() + " " + sanPham.getTen());
        }
        String maSp = Nhap.nhapStr("Nhap ma san pham trong hoa don : ");
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        SanPham sanPham = danhSachSanPham.timSanPham(maSp);
        if (!hoaDon.getChiTietHoaDon().getDanhSachSanPham().tonTaiSanPham(sanPham)) {
            System.out.println("Khong ton tai san pham nay trong hoa don");
            return;
        }
        PhieuTraHang pth = TaoDoiTuong.taoPhieuTraHang(hoaDon.getKhachHang(), sanPham, db);
        long tienTraLai = 0;
        if (hoaDon.getChiTietHoaDon().getDanhSachSanPham().getMapSanPham().get(sanPham) == 1) {
            DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(
                    hoaDon.getChiTietHoaDon().getListMaGiamGiaDaDung());
            tienTraLai = danhSachMaGiamGia.giaSanPhamSauKhiApDungTatCa(sanPham);
        } else {
            tienTraLai = sanPham.getGia();
        }
        System.out.println("So tien hoan lai cho khach hang : " + tienTraLai);
        khachHang.giamTienDaChi(tienTraLai);
        DanhSachHangThanhVien danhSachHangThanhVien = db.getDanhSachHangThanhVien();
        danhSachHangThanhVien.setHangThanhVienChoKhachHang(khachHang);
        if (danhSachPhieuTraHang.themPhieuTraHang(pth)) {
            System.out.println("Tao phieu tra hang thanh cong!");
            hoaDon.getKhachHang().themPhieuTraHang(pth);

        } else {
            System.out.println("Tao phieu tra hang that bai!");
        }
    }

    public void xoaPhieuTraHang() {
        DanhSachPhieuTraHang danhSachPhieuTraHang = db.getDanhSachPhieuTraHang();
        String ma = Nhap.nhapStr("Nhap ma phieu can xoa: ");
        if (danhSachPhieuTraHang.xoaPhieuTraHang(ma)) {
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
                pth.setKhachHang(danhSachKhachHang.timKhachHang(Nhap.nhapStr("Nhap ma khach hang de them vao : ")));
                System.out.println("Da thay doi khach hang");
                break;

            case 2:
                DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
                pth.setSanPham(danhSachSanPham.timSanPham("Nhap ma san pham de them vao : "));
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
        PhieuTraHang pth = danhSachPhieuTraHang.timPhieuTraHang(ma);

        if (pth == null) {
            System.out.println("Khong tim thay phieu tra hang!");
            return;
        }

        int tiep = 1;
        while (tiep == 1) {
            xuatSuaTraHang();
            int chon = Nhap.nhapInt("Chon muc can sua: ");
            if (chon==0){
                return;
            }
            suaThanhPhanPhieuTraHang(pth, chon);
            Nhap.pause();
        }
    }

    public void traCuuPhieuTraHang() {
        DanhSachPhieuTraHang danhSachPhieuTraHang = db.getDanhSachPhieuTraHang();
        String ma = Nhap.nhapStr("Nhap ma phieu bao hanh can tim : ");
        PhieuTraHang phieuTraHang = danhSachPhieuTraHang.timPhieuTraHang(ma);
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
