package ui;

import java.util.ArrayList;

import danhsach.DanhSachMaGiamGia;
import danhsach.DanhSachSanPham;
import database.Database;
import model.MaGiamGia;
import model.SanPham;
import util.TaoDoiTuong;
import util.XoaManHinh;

public class QuanLyMaGiamGia {
    private Database db;

    // contructor
    public QuanLyMaGiamGia(Database db) {
        this.db = db;
    }

    // tim kiem ma giam gia
    public void timKiemMaGiamGia() {
        DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
        String ma = Nhap.nhapStr("nhap ma cua ma giam gia can tim: ");
        MaGiamGia mGG = danhSachMaGiamGia.timMaGiamGia(ma);
        if (mGG == null) {
            System.out.println("khong tim thay ma giam gia!");
        } else {
            System.out.println(mGG);
        }
    }

    // xuat all ma giam gia
    public void xemTatCaMaGiamGia() {
        System.out.println("====Tat ca ma giam gia====");
        ArrayList<MaGiamGia> listMaGiamGia = db.getListMaGiamGia();
        if (!(listMaGiamGia == null || listMaGiamGia.size() == 0)) {
            System.out.println("Danh sach ma giam gia thuong : ");
            for (int i = 0; i < listMaGiamGia.size(); i++) {
                System.out.println(listMaGiamGia.get(i));
            }
        }
        ArrayList<MaGiamGia> listMaGiamGiaDq = db.getListMaGiamGiaDq();
        if (!(listMaGiamGiaDq == null || listMaGiamGiaDq.size() == 0)) {
            System.out.println("Danh sach ma giam gia doc quyen : ");
            for (int i = 0; i < listMaGiamGiaDq.size(); i++) {
                System.out.println(listMaGiamGiaDq.get(i));
            }
        }
    }

    // them ma giam gia
    public void themMaGiamGia() {
        DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
        MaGiamGia mGG = TaoDoiTuong.taoMaGiamGia(db);
        if (danhSachMaGiamGia.themMaGiamGia(mGG)) {
            System.out.println("them ma giam gia thanh cong!");
        } else {
            System.out.println("them ma giam gia that bai!");
        }
    }

    // xoa ma giam gia
    public void xoaMaGiamGia() {
        DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
        String ma = Nhap.nhapStr("nhap ma cua ma giam gia can xoa: ");
        MaGiamGia mGG = danhSachMaGiamGia.timMaGiamGia(ma);
        if (mGG == null) {
            System.out.println("khong tim thay ma giam gia can xoa!");
        } else {
            if (danhSachMaGiamGia.xoaMaGiamGia(mGG)) {
                System.out.println("xoa ma giam gia thanh cong!");
            } else {
                System.out.println("xoa ma giam gia that bai!");
            }
        }
    }

    // sua ma giam gia
    public void xuatMenuSuaMaGiamGia() {
        System.out.println("====Sua Ma Giam Gia====");
        System.out.println("1. sua ten ma giam gia");
        System.out.println("2. sua loai doanh muc");
        System.out.println("3. sua loai thuong hieu");
        System.out.println("4. sua so tien giam");
        System.out.println("5. sua ngay bat dau");
        System.out.println("6. sua ngay ket thuc");
        System.out.println("0. thoat");
    }

    private void thucHienChucNangSua(MaGiamGia mGG, int choice) {
        switch (choice) {
            case 1:
                mGG.setTenMa(Nhap.nhapStr("nhap ten moi: "));
                System.out.println("thay doi ten ma giam gia thanh cong!");
                break;
            case 2:
                mGG.setLoaiDoanhMuc(Nhap.nhapStr("nhap loai danh muc moi "));
                System.out.println("thay doi danh muc moi thanh cong!");
                break;
            case 3:
                mGG.setLoaiThuongHieu(Nhap.nhapStr("nhap loai thuong hieu moi: "));
                System.out.println("thay doi loai thuong hieu thanh cong!");
                break;
            case 4:
                mGG.setTienGiam(Nhap.nhapStr("nhap so phan tram giam moi: "));
                System.out.println("da thay doi so tien giam thanh cong!");
                break;
            case 5:
                mGG.setNgayBatDau("nhap ngay bat dau moi (yyyy-mm-dd): ");
                System.out.println("thay doi ngay batg dau moi thanh cong!");
                break;
            case 6:
                mGG.setNgayKetThuc(Nhap.nhapStr("nhap ngay ket thuc moi (yyyy-mm-dd): "));
                System.out.println("thay doi ngay ket thuc thanh cong!");
                break;
            case 0:
                System.out.println("da thoat!");
            default:
                System.out.println("lua chon khong hop le!");
        }
    }

    public void suaMaGiamGia() {
        DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
        String ma = Nhap.nhapStr("nhap ma cua ma giam gia can xoa: ");
        MaGiamGia mGG = danhSachMaGiamGia.timMaGiamGia(ma);
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatMenuSuaMaGiamGia();
            int choice = Nhap.nhapInt("nhap lua chon: ");
            thucHienChucNangSua(mGG, choice);
            xacNhan = Nhap.nhapInt("(1)Tiep tuc sua ma giam gia (khac)Thoat");
        }
    }

    public void maGiamGiaApDungChoSp() {
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        SanPham sanPham = danhSachSanPham.timSanPham(Nhap.nhapStr("Nhap ma san pham de xem : "));
        if (sanPham == null) {
            System.out.println("Khong tim thay san pham");
            return;
        }
        DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
        ArrayList<MaGiamGia> listMaGiamGia = danhSachMaGiamGia.listMaGiamGiaChoSp(sanPham);
        if (listMaGiamGia.size() == 0) {
            System.out.println("Khong co ma giam gia thoa man");
            return;
        }

        for (int i = 0; i < listMaGiamGia.size(); i++) {
            System.out.println(listMaGiamGia.get(i));
        }
    }

    private void xuatMenu() {
        System.out.println("1. Them ma giam gia");
        System.out.println("2. Xoa ma giam gia");
        System.out.println("3. Tra cuu ma giam gia");
        System.out.println("4. Xem ma giam gia ap dung cho san pham");
        System.out.println("5. Sua ma giam gia");
        System.out.println("6. Xem tat ca ma giam gia");
        System.out.println("0. Thoat");
    }

    private void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 1 -> themMaGiamGia();
            case 2 -> xoaMaGiamGia();
            case 3 -> timKiemMaGiamGia();
            case 4 -> maGiamGiaApDungChoSp();
            case 5 -> suaMaGiamGia();
            case 6 -> xemTatCaMaGiamGia();
            default -> System.out.println("Lua chon khong hop le");
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