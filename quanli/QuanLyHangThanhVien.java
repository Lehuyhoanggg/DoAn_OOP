package quanli;

import java.util.ArrayList;

import danhsach.DanhSachHangThanhVien;
import danhsach.DanhSachMaGiamGia;
import database.Database;
import model.HangThanhVien;
import model.MaGiamGia;
import util.Nhap;
import util.TaoDoiTuong;
import util.XoaManHinh;

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
        for (int i = 0; i < listHangThanhVien.size(); i++) {
            System.out.println("---------------------------");
            System.out.println(listHangThanhVien.get(i));
        }
    }

    public void taoHangThanhVien() {
        DanhSachHangThanhVien service = db.getDanhSachHangThanhVien();
        HangThanhVien htv = TaoDoiTuong.taoHangThanhVien(db);
        if (service.them(htv)) {
            System.out.println("Tao hang thanh vien thanh cong!");
        } else {
            System.out.println("Tao hang thanh vien that bai!");
        }
    }

    public void xoaHangThanhVien() {
        DanhSachHangThanhVien service = db.getDanhSachHangThanhVien();
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien can xoa: ");
        if (service.xoa(ten)) {
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
        System.out.println("---------------------------");
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
                DanhSachMaGiamGia maGiamGiaService = db.getDanhSachMaGiamGia();
                MaGiamGia maGiamGia = maGiamGiaService.tim("Nhap ma giam gia de them vao hang thanh vien : ");
                if (maGiamGia == null) {
                    System.out.println("Khong tim thay ma giam gia");
                    return;
                }
                hangThanhVien.themMaGiamGia(maGiamGia);
                System.out.println("Them ma giam gia thanh cong");
                break;
            case 4:
                DanhSachMaGiamGia maGiamGiaService1 = db.getDanhSachMaGiamGia();
                MaGiamGia maGiamGia1 = maGiamGiaService1
                        .tim("Nhap ma giam gia de them vao hang thanh vien : ");
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
        DanhSachHangThanhVien hangThanhVienService = db.getDanhSachHangThanhVien();
        HangThanhVien hangThanhVien = hangThanhVienService.tim("Nhap ten hang thanh vien can sua : ");
        if (hangThanhVien == null) {
            System.out.println("Khong tim thay hang thanh vien");
            return;
        }
        while (true) {
            XoaManHinh.xoa();
            System.out.println();
            System.out.println("------------------------");
            System.out.println(hangThanhVien);
            System.out.println("------------------------");
            xuatSuaHangThanhVien();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon == 0) {
                return;
            }
            suaThanhPhanHangThanhVien(hangThanhVien, luaChon);
            Nhap.pause();
        }
    }

    /////
    public void traCuuHangThanhVien() {
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien can tra cuu: ");
        DanhSachHangThanhVien service = db.getDanhSachHangThanhVien();
        HangThanhVien htv = service.tim(ten);
        if (htv == null) {
            System.out.println("Khong tim thay hang thanh vien!");
            return;
        }
        System.out.println(htv);
        ArrayList<MaGiamGia> listMaGiamGia = htv.getListMaGiamGiaDQ();
        if (listMaGiamGia != null && listMaGiamGia.size() > 0) {
            System.out.println("Danh sach ma giam gia co trong hang thanh vien : ");
            for (MaGiamGia maGiamGia : listMaGiamGia) {
                System.out.println(maGiamGia);
            }
        }
    }

    private void xuatMenu() {
        System.out.println("1. Tao hang thanh vien moi");
        System.out.println("2. Xoa hang thanh vien");
        System.out.println("3. Tra cuu hang thanh vien");
        System.out.println("4. Sua hang thanh vien");
        System.out.println("5. hien thi thong tin tat ca hang thanh vien");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
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
