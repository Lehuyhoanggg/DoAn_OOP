package danhsach;

import java.util.ArrayList;
import model.TaiKhoan;
import model.User;

public class DanhSachTaiKhoan {
    private ArrayList<TaiKhoan> listTaiKhoan;
    private int soLuong = 0;

    public DanhSachTaiKhoan(ArrayList<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    public DanhSachTaiKhoan() {
    }

    public ArrayList<TaiKhoan> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListTaiKhoan(ArrayList<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
        soLuong++;
        return listTaiKhoan.add(tk);
    }

    public boolean xoaTaiKhoan(TaiKhoan tk) {
        if (tk == null) {
            return false;
        }
        soLuong--;
        tk.getUser().goTaiKhoan();
        return listTaiKhoan.remove(tk);
    }
}
