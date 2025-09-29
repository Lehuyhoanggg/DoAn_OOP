package service;

import java.util.ArrayList;
import model.TaiKhoan;
import model.User;

public class TaiKhoanService {
    private ArrayList<TaiKhoan> listTaiKhoan;

    public TaiKhoanService(ArrayList<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    ////////////

    public User layUserBangTk(String tenDangNhap, String matKhau) {
        if (listTaiKhoan == null) {
            return null;
        }
        for (int i = 0; i < listTaiKhoan.size(); i++) {
            if (listTaiKhoan.get(i).kiemTraTaiKhoan(tenDangNhap, matKhau)) {
                return listTaiKhoan.get(i).getUser();
            }
        }
        return null;
    }

    public boolean themTaiKhoan(TaiKhoan tk) {
        if (tk == null) {
            return false;
        }
        return listTaiKhoan.add(tk);
    }

    public boolean xoaTaiKhoan(TaiKhoan tk) {
        if (tk == null) {
            return false;
        }
        tk.getUser().goTaiKhoan();
        return listTaiKhoan.remove(tk);
    }
}
