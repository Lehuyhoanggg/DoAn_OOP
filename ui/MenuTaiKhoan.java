package ui;

import java.util.ArrayList;

import database.Database;
import model.TaiKhoan;
import model.User;
import util.ThoiGian;

public class MenuTaiKhoan {
    private ArrayList<TaiKhoan> listTaiKhoan;

    public MenuTaiKhoan(Database db) {
        this.listTaiKhoan = db.getListTaiKhoan();
    }

    public void doiMatKhau(User user) {
        String matKhau = Nhap.nhapStr("Nhap mat khau moi : ");
        user.getTaiKhoan().setMatKhau(matKhau);
        user.getTaiKhoan().setNgayTao(ThoiGian.layNgayHienTaiStr());
    }
}
