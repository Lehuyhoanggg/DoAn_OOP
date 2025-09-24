package service;

import java.util.ArrayList;

import model.NhanVien;
import model.QuanLy;
import model.TaiKhoan;
import model.User;

public class UserService {
    private ArrayList<User> listUser;

    public UserService(ArrayList<NhanVien> listNhanVien, ArrayList<QuanLy> listQuanLy) {
        listUser = new ArrayList<>();
        listUser.addAll(listNhanVien);
        listUser.addAll(listNhanVien);
    }

    public User timUser(String ma) {
        if (listUser == null) {
            return null;
        }
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getMa().equals(ma)) {
                return listUser.get(i);
            }
        }
        return null;
    }

    public void ganTaiKhoanChoUser(TaiKhoan taiKhoan) {
        String ma = taiKhoan.getTenDangNhap();
        User user = null;
        if ((user = timUser(ma)) != null) {
            user.capTaiKhoan(taiKhoan);
        }
    }
}
