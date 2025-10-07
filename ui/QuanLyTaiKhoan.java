package ui;

import java.util.ArrayList;

import danhsach.DanhSachTaiKhoan;
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
        DanhSachUser danhSachUser = db.getDanhSachUser();
        danhSachUser.ganTaiKhoanChoUser(taiKhoan);
        listTaiKhoan.add(taiKhoan);
    }

    public void capTaiKhoanChoUser() {
        ArrayList<User> listUser = db.getListUser();
        ArrayList<User> listUserChuaCoTk = new ArrayList<>();
        boolean timThay = false;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getTaiKhoan() == null) {
                listUserChuaCoTk.add(listUser.get(i));
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Tat ca user da duoc cap tai khoan");
            return;
        }
        System.out.println("Danh sach user chua co tai khoan");
        for (User user : listUserChuaCoTk) {
            System.out.println(user);
            System.out.println("--------------------------");
        }
        System.out.println();
        String ma = Nhap.nhapStr("Nhap ma user can cap tai khoan : ");
        User user = db.getDanhSachUser().timUser(ma);
        if (user == null) {
            System.out.println("Khong tim thay user");
            return;
        }
        TaiKhoan taiKhoan = new TaiKhoan(ma, "123");
        DanhSachTaiKhoan danhSachTaiKhoan = db.getDanhSachTaiKhoan();
        danhSachTaiKhoan.themTaiKhoan(taiKhoan);
        user.capTaiKhoan(taiKhoan);
        System.out.println("Da cap tai khoan cho user");
        System.out.println(taiKhoan);
    }
}
