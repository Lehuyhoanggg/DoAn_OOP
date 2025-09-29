package service;

import java.util.ArrayList;
import model.TaiKhoan;
import model.User;

public class UserService {
    private ArrayList<User> listUser;

    public UserService(ArrayList<User> listUser) {
        this.listUser = listUser;
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

    public boolean ganTaiKhoanChoUser(TaiKhoan taiKhoan) {
        if (taiKhoan == null) {
            return false;
        }
        String ma = taiKhoan.getTenDangNhap();
        User user = timUser(ma);
        if (user == null) {
            return false;
        }
        return user.capTaiKhoan(taiKhoan);
    }
}
