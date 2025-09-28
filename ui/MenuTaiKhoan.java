package ui;

import java.util.ArrayList;

import database.Database;
import model.TaiKhoan;
import model.User;
import service.UserService;
import util.TaoDoiTuong;
import util.ThoiGian;

public class MenuTaiKhoan {
    private ArrayList<TaiKhoan> listTaiKhoan;
    private Database db;

    public MenuTaiKhoan(Database db) {
        this.db = db;
        this.listTaiKhoan = db.getListTaiKhoan();
    }

    public void doiMatKhau(User user) {
        String matKhau = Nhap.nhapStr("Nhap mat khau moi : ");
        user.getTaiKhoan().setMatKhau(matKhau);
        user.getTaiKhoan().setNgayTao(ThoiGian.layNgayHienTaiStr());
    }

    public void taoTaiKhoan() {
        TaiKhoan taiKhoan = TaoDoiTuong.taoTaiKhoan();
        UserService userService = new UserService(db.getListUser());
        userService.ganTaiKhoanChoUser(taiKhoan);
        listTaiKhoan.add(taiKhoan);
    }
}
