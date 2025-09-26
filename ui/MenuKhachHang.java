package ui;

import java.util.ArrayList;

import database.Database;
import model.HangThanhVien;
import model.KhachHang;
import service.HangThanhVienService;
import service.KhacHangService;
import util.TaoDoiTuong;

public class MenuKhachHang {
    private Database db;

    public MenuKhachHang(Database db) {
        this.db = db;
    }

    public void taoKhachHang() {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        KhachHang khachHang = TaoDoiTuong.taoKhachHang(db);
        khacHangService.themKhachHang(khachHang);
        System.out.println("Da tao khach hang thanh cong");
    }

    public void traCuuThongTinKhachHang() {
        String tuKhoa = Nhap.nhapStr("Nhap tu khoa de tim : ");
        boolean timThay = false;
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        if (listKhachHang == null || listKhachHang.size() == 0) {
            System.out.println("khong tim thay khach hang");
            return;
        }
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getSdt().contains(tuKhoa)) {
                timThay = true;
                System.out.println(i + " " + listKhachHang.get(i).getMaKh() + " " + listKhachHang.get(i).getTenKh()
                        + " " + listKhachHang.get(i).getSdt());
            }
        }

        if (timThay) {
            int luaChon = Nhap.nhapInt("lua chon san pham de hien thi : ");
            if (listKhachHang.size() > luaChon && 0 < luaChon) {
                System.out.println(listKhachHang.get(luaChon));
            } else {
                System.out.println("lua chon khong hop le");
            }
        } else {
            // neu tim theo ten khong thay thi tim theo ma
            for (int i = 0; i < listKhachHang.size(); i++) {
                if (listKhachHang.get(i).getMaKh().equals(tuKhoa)) {
                    System.out.println(i + " " + listKhachHang.get(i).getMaKh() + " " + listKhachHang.get(i).getTenKh()
                            + " " + listKhachHang.get(i).getSdt());
                    timThay = true;
                    break;
                }
            }

        }

        if (!timThay) {
            System.out.println("khong tim thay san pham");
        }
    }

    public void xoaKhachHang() {
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        String ma = Nhap.nhapStr("Nhap ma khach hang can xoa : ");
        if (listKhachHang == null || listKhachHang.size() == 0) {
            System.out.println("Khong co khach hang de xoa");
            return;
        }
        if (khacHangService.xoaKhachHang(ma)) {
            System.out.println("Xoa khach hang thanh cong");
        } else {
            System.out.println("Xoa khong thanh cong");
        }
    }

    public void suaThanhPhanKhachHang(KhachHang khachHang, int luaChon) {
        switch (luaChon) {
            case 1:
                khachHang.setTenKh(Nhap.nhapStr("Nhap ten khach hang de thay doi : "));
                System.out.println("Da thay doi");
                break;
            case 2:
                khachHang.setSdt(Nhap.nhapStr("Nhap so dien thoai de thay doi : "));
                System.out.println("Da thay doi");
                break;
            case 3:
                HangThanhVienService hangThanhVienService = new HangThanhVienService(db.getListHangThanhVien());
                HangThanhVien hangThanhVienMoi = hangThanhVienService.timHangThanhVien(Nhap.nhapStr(null));
                if (hangThanhVienMoi == null) {
                    System.out.println("Khong tim thay hang thanh vien");
                    return;
                }
                khachHang.setHangThanhVien(hangThanhVienMoi);
                System.out.println("Da thay doi");
                break;
            default:
                break;
        }
    }

    public void menuSuaKhachHang() {
        System.out.println("1. Sua ten khach hang");
        System.out.println("2. Sua so dien thoai");
        System.out.println("3. Sua hang thanh vien");
    }

    public void suaThongTinKhachHang() {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        KhachHang khachHang = khacHangService.timKhachHang(Nhap.nhapStr("Nhap ma khach hang can sau : "));
        if (khachHang == null) {
            System.out.println("Khong tim thay khach hang");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatMenu();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            suaThanhPhanKhachHang(khachHang, luaChon);
            xacNhan = Nhap.nhapInt("(1)Tiep tuc sua (Khac)Thoat");
        }
    }

    private void xuatMenu() {
        System.out.println("1. Tao khach hang");
        System.out.println("2. Tra cuu thong tin khach hang");// theo ten(chon trong nhieu khach hang) , theo ma, theo
                                                              // // so dien thoai, hoac thu tat ca cach
        System.out.println("3. Xoa khach hang");
        System.out.println("4. Sua thong tin khach hang");
        System.out.println("0. Thoat");
    }

    private void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 0:
                System.out.println("Da thoat");
                break;
            case 1:
                taoKhachHang();
                break;
            case 2:
                traCuuThongTinKhachHang();
                break;
            case 3:
                xoaKhachHang();
                break;
            case 4:
                suaThongTinKhachHang();
                break;
            default:
                break;
        }
    }

    public void menu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatMenu();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            thucHienChucNang(luaChon);
            xacNhan = Nhap.nhapXacNhanThoat();
        }
    }
}
