package ui;

import database.Database;
import model.LichLamViec;
import model.NhanVien;
import service.LichLamViecService;
import service.NhanVienService;

public class MenuLichLamViec {
    private Database db;

    public MenuLichLamViec(Database db) {
        this.db = db;
    }

    public void diemDanh(NhanVien nhanVien) {
        LichLamViecService lichLamViecService = new LichLamViecService(db.getLichTuan());
        if (lichLamViecService.diemDanh(nhanVien)) {
            System.out.println("Diem danh thanh cong");
        } else {
            System.out.println("Hien tai khong co lich cua ban");
        }
    }

    public void diemDanh() {
        NhanVienService nhanVienService = new NhanVienService(db.getListNhanVien());
        NhanVien nhanVien = nhanVienService.timnhanvien(Nhap.nhapStr("Nhap ma nhan vien de diem danh : "));
        if (nhanVien == null) {
            System.out.println("Khong tim thay nhan vien");
            return;
        }
        diemDanh(nhanVien);
    }

    public void xepLichLamViec() {

    }

    public void xemLichLamViec() {

    }

    private void xuatMenuLichLamViec() {
        System.out.println("");
    }

    private void thucHienChucNang(int luaChon) {

    }

    public void menu() {

    }
}
