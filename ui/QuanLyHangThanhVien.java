package ui;

import java.util.ArrayList;

import danhsach.DanhSachHangThanhVien;
import danhsach.DanhSachMaGiamGia;
import database.Database;
import model.HangThanhVien;
import model.MaGiamGia;
import util.TaoDoiTuong;

public class QuanLyHangThanhVien {
    private Database db;

    public QuanLyHangThanhVien(Database db) {
        this.db = db;
    }

    public void xemTatCaHangThanhVien() {
        ArrayList<HangThanhVien> listHangThanhVien = db.getListHangThanhVien();
        if (listHangThanhVien == null || listHangThanhVien.size() == 0) {
            System.out.println("Khong tim thay hang thanh vien nao");
            return;
        }
        System.out.println("DANH SACH HANG THANH VIEN");
        for (int i = 0; i < listHangThanhVien.size(); i++) {
            System.out.println(listHangThanhVien.get(i));
        }
    }

    public void taoHangThanhVien() {
        DanhSachHangThanhVien service = new DanhSachHangThanhVien(db.getListHangThanhVien());
        HangThanhVien htv = TaoDoiTuong.taoHangThanhVien(db);
        if (service.themHangThanhVien(htv)) {
            System.out.println("Tao hang thanh vien thanh cong!");
        } else {
            System.out.println("Tao hang thanh vien that bai!");
        }
    }

    public void xoaHangThanhVien() {
        DanhSachHangThanhVien service = new DanhSachHangThanhVien(db.getListHangThanhVien());
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien can xoa: ");
        if (service.xoaHangThanhVien(ten)) {
            System.out.println("Xoa hang thanh vien thanh cong!");
        } else {
            System.out.println("Khong tim thay hang thanh vien hoac xoa that bai!");
        }
    }

    /// sua hang thanh vien

    private void xuatSuaHangThanhVien() {
        System.out.println("1. Sua ten hang thanh vien");
        System.out.println("2. Sua mo ta hang thanh vien");
        System.out.println("3. Them ma giam gia cho hang thanh vien");
        System.out.println("4. Xoa ma giam gia cho hang thanh vien");
        System.out.println("0. Thoat");
    }

    private void suaThanhPhanHangThanhVien(HangThanhVien hangThanhVien, int luachon) {
        switch (luachon) {
            case 1:
                hangThanhVien.setTenHang(Nhap.nhapStr("Nhap ten hang thanh vien moi : "));
                System.out.println("Da sua ten cua hang thanh vien");
                break;
            case 2:
                hangThanhVien.setMoTa(Nhap.nhapStr("Nhap mo ta cua hang thanh vien : "));
                System.out.println("Da sua mo ta cua hang thanh vien");
                break;
            case 3:
                DanhSachMaGiamGia maGiamGiaService = new DanhSachMaGiamGia(db.getListMaGiamGia());
                MaGiamGia maGiamGia = maGiamGiaService.timMaGiamGia("Nhap ma giam gia de them vao hang thanh vien : ");
                if (maGiamGia == null) {
                    System.out.println("Khong tim thay ma giam gia");
                    return;
                }
                hangThanhVien.themMaGiamGia(maGiamGia);
                System.out.println("Them ma giam gia thanh cong");
                break;
            case 4:
                DanhSachMaGiamGia maGiamGiaService1 = new DanhSachMaGiamGia(db.getListMaGiamGia());
                MaGiamGia maGiamGia1 = maGiamGiaService1
                        .timMaGiamGia("Nhap ma giam gia de them vao hang thanh vien : ");
                if (maGiamGia1 == null) {
                    System.out.println("Khong tim thay ma giam gia");
                    return;
                }
                hangThanhVien.xoaMaGiamGia(maGiamGia1);
                System.out.println("Da xoa ma giam gia thanh cong");
                break;
            case 0:
                System.out.println("Thoat sua hang thanh vien");
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }

    }

    public void suaHangThanhVien() {
        DanhSachHangThanhVien hangThanhVienService = new DanhSachHangThanhVien(db.getListHangThanhVien());
        HangThanhVien hangThanhVien = hangThanhVienService.timHangThanhVien("Nhap ten hang thanh vien can sua : ");
        if (hangThanhVien == null) {
            System.out.println("Khong tim thay hang thanh vien");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatSuaHangThanhVien();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            suaThanhPhanHangThanhVien(hangThanhVien, luaChon);
            xacNhan = Nhap.nhapInt("(1)Tiep tuc sua (Khac)Thoat");
        }
    }

    /////
    public void traCuuHangThanhVien() {
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien can tra cuu: ");
        DanhSachHangThanhVien service = new DanhSachHangThanhVien(db.getListHangThanhVien());
        HangThanhVien htv = service.timHangThanhVien(ten);
        if (htv == null) {
            System.out.println("Khong tim thay hang thanh vien!");
            return;
        }
        System.out.println("Thong tin hang thanh vien: ");
        System.out.println(htv);
    }

    private void xuatMenu() {
        System.out.println("1. Tao hang thanh vien moi");
        System.out.println("2. Xoa hang thanh vien");
        System.out.println("3. Tra cuu hang thanh vien");
        System.out.println("4. Sua hang thanh vien");
        System.out.println("5. hien thi thong tin tat ca hang thanh vien");
        System.out.println("0. Thoat");
    }

    private void thucHienChucNang(int chon) {
        switch (chon) {
            case 1:
                taoHangThanhVien();
                break;
            case 2:
                xoaHangThanhVien();
                break;
            case 3:
                traCuuHangThanhVien();
                break;
            case 4:
                suaHangThanhVien();
                break;
            case 5:
                xemTatCaHangThanhVien();
                break;
            case 0:
                System.out.println("Thoat menu hang thanh vien");
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }

    public void menu() {
        int tiep = 1;
        while (tiep == 1) {
            xuatMenu();
            int chon = Nhap.nhapInt("Nhap lua chon: ");
            thucHienChucNang(chon);
            tiep = Nhap.nhapInt("(1)Tiep tuc menu hang thanh vien (khac)Thoat");
        }
    }
}
