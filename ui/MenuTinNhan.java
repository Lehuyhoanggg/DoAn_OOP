package ui;

import java.util.ArrayList;

import database.Database;
import model.TinNhan;
import model.User;
import service.UserService;
import util.TaoDoiTuong;
import util.ThoiGian;

public class MenuTinNhan {
    private ArrayList<User> listUser;

    public MenuTinNhan(Database db) {
        this.listUser = db.getListUser();
    }

    public void guiTinNhan(User nguoiGui) {
        UserService userService = new UserService(listUser);
        User nguoiNhan = userService.timUser(Nhap.nhapStr("Nhap ma nhan : "));
        TinNhan tinNhan = TaoDoiTuong.taoTinNhan(nguoiGui.getMa(), nguoiGui.getTen());
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
            System.out.println(tinNhan);
        }
    }
}
