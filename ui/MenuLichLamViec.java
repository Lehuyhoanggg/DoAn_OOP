package ui;

import database.Database;
import model.CaLam;
import model.LichLamViec;
import model.LichTrongNgay;
import model.NhanVien;
import service.LichLamViecService;
import service.NhanVienService;
import java.util.ArrayList;

public class MenuLichLamViec {
    private Database db;
    private LichLamViec lichLamViec;

    public MenuLichLamViec(Database db) {
        this.db = db;
        this.lichLamViec = db.getLichTuan();
    }

    // diem danh khi da co doi tuong nhan vien
    public void diemDanh(NhanVien nhanVien) {
        LichLamViecService lichLamViecService = new LichLamViecService(db.getLichTuan());
        if (lichLamViecService.diemDanh(nhanVien)) {
            System.out.println("Diem danh thanh cong");
        } else {
            System.out.println("Hien tai khong co lich cua ban");
        }
    }

    // diem danh qua ma nhan vien
    public void diemDanh() {
        NhanVienService nhanVienService = new NhanVienService(db.getListNhanVien());
        NhanVien nv = nhanVienService.timNhanVien(Nhap.nhapStr("Nhap ma nhan vien de diem danh: "));
        if (nv == null) {
            System.out.println("Khong tim thay nhan vien");
            return;
        }
        diemDanh(nv);
    }

    private void xoaNhanVienKhoiCa(CaLam caLam) {
        NhanVienService nhanVienService = new NhanVienService(db.getListNhanVien());
        NhanVien nhanVien = nhanVienService.timNhanVien(Nhap.nhapStr("Nhap ma nhan vien xoa khoi ca lam"));
        if (nhanVien == null) {
            System.out.println("Khong tim thay nhan vien");
            return;
        }
        caLam.xoaNhanVienKhoiCa(nhanVien);
        System.out.println("Da xoa nhan vien khoi ca lam");
    }

    private void themNhanVienVaoCa(CaLam caLam) {
        NhanVienService nhanVienService = new NhanVienService(db.getListNhanVien());
        NhanVien nhanVien = nhanVienService.timNhanVien(Nhap.nhapStr("Nhap ma nhan vien de them vao ca lam"));
        if (nhanVien == null) {
            System.out.println("Khong tim thay nhan vien");
            return;
        }
        ;
        caLam.themNhanVienVaoCa(nhanVien);
        System.out.println("Da them nhan vien vao ca");
    }

    private void thucHienChucNangXepLich(int luaChon, CaLam caLam) {
        switch (luaChon) {
            case 1:
                themNhanVienVaoCa(caLam);
                break;
            case 2:
                xoaNhanVienKhoiCa(caLam);
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }

    // xep lich lam viec moi
    public void xepLichLamViec() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xemLichLamViec();
            int index = Nhap.nhapInt("Chon thu can them nhan vien : ") - 2;
            LichTrongNgay lichTrongNgay = lichLamViec.getLichTuan().get(index);
            int soCa = Nhap.nhapInt("Nhap so ca can them nhan vien : ");
            LichLamViecService lichLamViecService = new LichLamViecService(lichLamViec);
            CaLam caLam = lichLamViecService.timCaLam(soCa, lichTrongNgay);
            if (caLam == null) {
                System.out.println("Khong tim thay ca lam");
            } else {
                System.out.println("1. Them nhan vien vao ca");
                System.out.println("2. Xoa nhan vien khoi ca");
                int luaChon = Nhap.nhapInt("Nhap lua chon : ");
                thucHienChucNangXepLich(luaChon, caLam);
            }
        }
        xacNhan = Nhap.nhapInt("(1)Tiep tuc xep lich (khach)Thoat");
    }

    // xem tat ca lich lam viec
    public void xemLichLamViec() {
        ArrayList<LichTrongNgay> listLichTrongNgay = lichLamViec.getLichTuan();
        for (int i = 0; i < listLichTrongNgay.size(); i++) {
            LichTrongNgay lichTrongNgay = listLichTrongNgay.get(i);
            System.out.println("Thu " + lichTrongNgay.getThu() + "      " + lichTrongNgay.getNgay());
            ArrayList<CaLam> listCaLam = lichTrongNgay.getListCaLam();
            for (int j = 0; j < listCaLam.size(); i++) {
                CaLam caLam = listCaLam.get(i);
                System.out.println(caLam.getGioBatDau() + " " + caLam.getGioKetThuc() + ": Ca " + caLam.getSo()
                        + " " + caLam.soNguoiTrongCa() + "/" + caLam.getSoLuongCan());
                if (!caLam.caLamTrong()) {
                    System.out.println("      gom :");
                    for (NhanVien nhanVien : caLam.getListNhanVien().getMapNhanVien().keySet()) {
                        System.out.println("        " + nhanVien.getMa() + " " + nhanVien.getTen());
                    }
                }
            }
        }
    }

    // menu hien thi
    private void xuatMenuLichLamViec() {
        System.out.println("\nQUAN LY LICH LAM VIEC");
        System.out.println("1. Diem danh");
        System.out.println("2. Xep lich lam viec");
        System.out.println("3. Xem lich lam viec");
        System.out.println("0. Thoat");
    }

    private void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 0 -> System.out.println("Thoat menu lich lam viec");
            case 1 -> diemDanh();
            case 2 -> xepLichLamViec();
            case 3 -> xemLichLamViec();
            default -> System.out.println("Lua chon khong hop le");
        }
    }

    public void menu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatMenuLichLamViec();
            int chon = Nhap.nhapInt("Chon chuc nang: ");
            if (chon == 0) {
                System.out.println("Da thoat menu lich lam viec");
                return;
            }
            thucHienChucNang(chon);
            xacNhan = Nhap.nhapXacNhanThoat();
        }
    }
}
