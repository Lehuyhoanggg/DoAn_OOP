package ui;

import java.util.ArrayList;

import database.Database;
import model.MaGiamGia;
import service.MaGiamGiaService;
import util.TaoDoiTuong;

public class MenuMaGiamGia {
    private Database db;

    // contructor
    public MenuMaGiamGia(Database db) {
        this.db = db;
    }

    // tim kiem ma giam gia
    public void timKiemMaGiamGia() {
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(db.getListMaGiamGia());
        String ma = Nhap.nhapStr("nhap ma cua ma giam gia can tim: ");
        MaGiamGia mGG = maGiamGiaService.timMaGiamGia(ma);
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
        if (listMaGiamGia.size() == 0 || listMaGiamGia == null) {
            System.out.println("khong tim thay ma giam gia nao");
        }
        for (int i = 0; i < listMaGiamGia.size(); i++) {
            System.out.println(listMaGiamGia.get(i));
        }
    }

    // them ma giam gia
    public void themMaGiamGia() {
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(db.getListMaGiamGia());
        MaGiamGia mGG = TaoDoiTuong.taoMaGiamGia(db);
        if (maGiamGiaService.themMaGiamGia(mGG)) {
            System.out.println("them ma giam gia thanh cong!");
        } else {
            System.out.println("them ma giam gia that bai!");
        }
    }

    // xoa ma giam gia
    public void xoaMaGiamGia() {
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(db.getListMaGiamGia());
        String ma = Nhap.nhapStr("nhap ma cua ma giam gia can xoa: ");
        MaGiamGia mGG = maGiamGiaService.timMaGiamGia(ma);
        if (mGG == null) {
            System.out.println("khong tim thay ma giam gia can xoa!");
        } else {
            if (maGiamGiaService.xoaMaGiamGia(mGG)) {
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

    private void thucHienChucNang(MaGiamGia mGG, int choice) {
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
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(db.getListMaGiamGia());
        String ma = Nhap.nhapStr("nhap ma cua ma giam gia can xoa: ");
        MaGiamGia mGG = maGiamGiaService.timMaGiamGia(ma);
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatMenuSuaMaGiamGia();
            int choice = Nhap.nhapInt("nhap lua chon: ");
            thucHienChucNang(mGG, choice);
            xacNhan = Nhap.nhapXacNhanThoat();
        }
    }

}