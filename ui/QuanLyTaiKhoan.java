package ui;

import java.util.ArrayList;

import danhsach.DanhSachUser;
import database.Database;
import model.TaiKhoan;
import model.User;
import util.TaoDoiTuong;
import util.ThoiGian;

public class QuanLyTaiKhoan {
    private ArrayList<TaiKhoan> listTaiKhoan;
    private Database db;

    public QuanLyTaiKhoan(Database db) {
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
        DanhSachUser danhSachUser = new DanhSachUser(db.getListUser());
        danhSachUser.ganTaiKhoanChoUser(taiKhoan);
        listTaiKhoan.add(taiKhoan);
    }
}
