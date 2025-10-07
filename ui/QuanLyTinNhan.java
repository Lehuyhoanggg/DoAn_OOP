package ui;

import java.util.ArrayList;

import danhsach.DanhSachUser;
import database.Database;
import model.TinNhan;
import model.User;
import util.TaoDoiTuong;
import util.ThoiGian;

public class QuanLyTinNhan {
    private Database db;

    public QuanLyTinNhan(Database db) {
        this.db = db;
    }

    public void guiTinNhan(User nguoiGui) {
        DanhSachUser danhSachUser = db.getDanhSachUser();
        User nguoiNhan = danhSachUser.timUser(Nhap.nhapStr("Nhap ma nguoi nhan : "));
        TinNhan tinNhan = TaoDoiTuong.taoTinNhan(nguoiGui.getTen(), db);
        nguoiNhan.nhanTinNhan(tinNhan);
        System.out.println("Da gui tin nhan thanh cong");
    }

    public void xemTinNhanGanDay(User user) {
        String ngayDauTuan = ThoiGian.layNgayDauTuanStr();
        String ngayCuoiTuan = ThoiGian.layNgayCuoiTuanStr();
        ArrayList<TinNhan> listTinNhan = user.getListTinNhan();
        if (listTinNhan == null || listTinNhan.size() == 0) {
            System.out.println("Hop thu trong");
            return;
        }
        for (TinNhan tinNhan : listTinNhan) {
            if (ThoiGian.ngayTrongKhoan(tinNhan.getNgayGui(), ngayDauTuan, ngayCuoiTuan)) {
                System.out.println("---------------------------");
                System.out.println(tinNhan);
            }
        }
    }

    public void xemTatCaTinNhan(User user) {
        ArrayList<TinNhan> listTinNhan = user.getListTinNhan();
        if (listTinNhan == null || listTinNhan.size() == 0) {
            System.out.println("Hop thu trong");
            return;
        }
        for (TinNhan tinNhan : listTinNhan) {
            System.out.println("---------------------------");
            System.out.println(tinNhan);
        }
    }
}
