package ui;

import java.util.ArrayList;

import danhsach.DanhSachNhanVien;
import database.Database;
import model.NhanVien;
import util.TaoDoiTuong;
import util.XoaManHinh;

public class QuanLyNhanVien {
    private Database db;

    public QuanLyNhanVien(Database db) {
        this.db = db;
    }

    private void taoNhanVien() {
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
        // Tao nhan vien moi bang ham ho tro
        NhanVien nv = TaoDoiTuong.taoNhanVien(db);
        danhSachNhanVien.themNhanVien(nv);
        System.out.println("Da them nhan vien thanh cong.");
    }

    private void xuatSuaNhanVien() {
        System.out.println("1. Sua ten");
        System.out.println("2. Sua sdt");
        System.out.println("3. Sua gioi tinh");
        System.out.println("4. Sua ngay sinh");
        System.out.println("5. Sua cccd");
        System.out.println("6. Sua luong");
        System.out.println("0. Thoat");
    }

    private void suaThanhPhan(NhanVien nv, int luaChon) {
        switch (luaChon) {
            case 1 -> nv.setTen(Nhap.nhapStr("Nhap ten moi: "));
            case 2 -> nv.setSdt(Nhap.nhapStr("Nhap sdt moi: "));
            case 3 -> nv.setGioiTinh(Nhap.nhapStr("Nhap gioi tinh moi: "));
            case 4 -> nv.setNgaySinh(Nhap.nhapStr("Nhap ngay sinh moi: "));
            case 5 -> nv.setCccd(Nhap.nhapStr("Nhap cccd moi: "));
            case 6 -> nv.setLuong(Nhap.nhapLong("Nhap luong moi: "));
            case 0 -> System.out.println("Thoat sua");
            default -> System.out.println("Lua chon khong hop le");
        }
    }

    private void suaNhanVien() {
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
        String ma = Nhap.nhapStr("Nhap ma nhan vien can sua: ");
        NhanVien nv = danhSachNhanVien.timNhanVien(ma);
        if (nv == null) {
            System.out.println("Khong tim thay nhan vien.");
            return;
        }
        int tiep = 1;
        while (tiep == 1) {
            xuatSuaNhanVien();
            int chon = Nhap.nhapInt("Chon muc: ");
            suaThanhPhan(nv, chon);
            tiep = Nhap.nhapInt("(1) Tiep tuc sua | (Khac) Thoat: ");
        }
        System.out.println("Da cap nhat thong tin nhan vien.");
    }

    private void xoaNhanVien() {
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
        String ma = Nhap.nhapStr("Nhap ma nhan vien can xoa: ");
        danhSachNhanVien.xoaNhanVien(ma);
        System.out.println("Da xoa nhan vien");
    }

    private void traCuuNhanVien() {
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
        String ma = Nhap.nhapStr("Nhap ma nhan vien: ");
        NhanVien nv = danhSachNhanVien.timNhanVien(ma);
        if (nv == null)
            System.out.println("Khong tim thay.");
        else
            System.out.println(nv);
    }

    private void xemTatCaNhanVien() {
        ArrayList<NhanVien> list = db.getListNhanVien();
        if (list == null || list.isEmpty()) {
            System.out.println("Chua co nhan vien nao.");
            return;
        }
        System.out.println("Danh sach nhan vien:");
        for (NhanVien nv : list) {
            System.out.println(nv);
        }
    }

    private void xuatMenu() {
        System.out.println("\nQUAN LY NHAN VIEN");
        System.out.println("1. Them nhan vien");
        System.out.println("2. Sua thong tin");
        System.out.println("3. Xoa nhan vien");
        System.out.println("4. Tra cuu nhan vien");
        System.out.println("5. Xem tat ca nhan vien");
        System.out.println("0. Thoat");
    }

    public void thucHienChucNang(int chon) {
        switch (chon) {
            case 0 -> {
                System.out.println("Thoat menu quan ly nhan vien");
                return;
            }
            case 1 -> taoNhanVien();
            case 2 -> suaNhanVien();
            case 3 -> xoaNhanVien();
            case 4 -> traCuuNhanVien();
            case 5 -> xemTatCaNhanVien();
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
