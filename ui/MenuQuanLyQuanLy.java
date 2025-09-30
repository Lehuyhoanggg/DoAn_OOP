package ui;

import java.util.ArrayList;

import database.Database;
import model.QuanLy;
import service.QuanLyService;
import util.TaoDoiTuong;

public class MenuQuanLyQuanLy {
    Database db;
    QuanLy ql;

    // hien thi tat ca
    public void hienThiTatCaQuanLy() {
        ArrayList<QuanLy> listQuanLy = db.getListQuanLy();
        if (listQuanLy == null || listQuanLy.isEmpty()) {
            System.out.println("chua co quang ly nao");
            return;
        }
        System.out.println("====list quan ly====");
        ;
        for (int i = 0; i < listQuanLy.size(); i++) {
            System.out.println(listQuanLy.get(i));
        }
    }

    // them quan ly
    public void themQuanLy() {
        QuanLy ql = TaoDoiTuong.TaoDoiTuongQuanLy(db);
        QuanLyService quanLyService = new QuanLyService(db.getListQuanLy());
        if (quanLyService.themQuanLy(ql)) {
            System.out.println("them quan ly thanh cong!");
        } else {
            System.out.println("them quang ly that bai!");
        }
    }

    // xoa quan ly
    public void xoaQuanLy() {
        QuanLyService quanLyService = new QuanLyService(db.getListQuanLy());
        String ma = Nhap.nhapStr("nhap ma quang ly can xoa: ");
        QuanLy ql = quanLyService.timQuanLy(ma);
        if (ql == null) {
            System.out.println("khong tim thay quang ly can xoa!");
        }
        if (quanLyService.xoaQuanLy(ma)) {
            System.out.println("xoa quan ly thanh cong");
        } else {
            System.out.println("xoa quan ly that bai!");
        }
    }

    // tra cuu quang ly theo ma
    public void traCuuQuangLy() {
        String ma = Nhap.nhapStr("nhap ma quang ly can tra cuu: ");
        QuanLyService quanLyService = new QuanLyService(db.getListQuanLy());
        QuanLy ql = quanLyService.timQuanLy(ma);
        if (ql == null) {
            System.out.println("khong tim thay quang ly can tra cuu!");
        }
        System.out.println(ql);
    }

    // sua quan ly
    public void xuatSuaQuanLy() {
        System.out.println("1. Sua ten");
        System.out.println("2. Sua sdt");
        System.out.println("3. Sua gioi tinh");
        System.out.println("4. Sua ngay sinh");
        System.out.println("5. Sua cccd");
        System.out.println("0. Thoat");
    }

    public void thucHienChucNangSuaQuanLy(QuanLy ql, int luaChon) {
        switch (luaChon) {
            case 1 -> ql.setTen(Nhap.nhapStr("Nhap ten moi: "));
            case 2 -> ql.setSdt(Nhap.nhapStr("Nhap sdt moi: "));
            case 3 -> ql.setGioiTinh(Nhap.nhapStr("Nhap gioi tinh moi: "));
            case 4 -> ql.setNgaySinh(Nhap.nhapStr("Nhap ngay sinh moi: "));
            case 5 -> ql.setCccd(Nhap.nhapStr("Nhap cccd moi: "));
            case 0 -> System.out.println("Thoat sua");
            default -> System.out.println("Lua chon khong hop le");
        }
    }

    public void SuaQuanLy() {
        QuanLyService qlService = new QuanLyService(db.getListQuanLy());
        String ma = Nhap.nhapStr("Nhap ma quan ly can sua: ");
        QuanLy ql = qlService.timQuanLy(ma);
        if (ql == null) {
            System.out.println("Khong tim thay quan ly can sua.");
            return;
        }
        int tiep = 1;
        while (tiep == 1) {
            xuatSuaQuanLy();
            int chon = Nhap.nhapInt("Chon muc: ");
            thucHienChucNangSuaQuanLy(ql, chon);
            tiep = Nhap.nhapInt("(1) Tiep tuc sua | (Khac) Thoat: ");
        }
        System.out.println("Da cap nhat thong tin quang ly.");
    }
}