package service;

import java.util.ArrayList;
import model.TaiKhoan;
import model.User;

public class TaiKhoanService {
    private ArrayList<TaiKhoan> listTaiKhoan;

    public TaiKhoanService(ArrayList<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    public ArrayList<TaiKhoan> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public void setListTaiKhoan(ArrayList<TaiKhoan> listTaiKhoan) {
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

    public void themTaiKhoan(TaiKhoan tk) {
        if (tk == null) {
            return;
        }
        listTaiKhoan.add(tk);
    }

    public void xoaTaiKhoan(TaiKhoan tk) {
        if (tk == null) {
            return;
        }
        tk.getUser().goTaiKhoan();
        listTaiKhoan.remove(tk);
    }

    public void doiTaiKhoan(TaiKhoan tk, String tenDangNhap, String matKhau) {
        if (tk == null) {
            return;
        }
        tk.setTenDangNhap(tenDangNhap);
        tk.setMatKhau(matKhau);
    }

    public void doiMatKhau(String matKhauMoi, TaiKhoan tk) {
        tk.setMatKhau(matKhauMoi);
    }
}
