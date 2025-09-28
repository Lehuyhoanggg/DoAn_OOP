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

    public void ganTaiKhoanChoUser(TaiKhoan taiKhoan) {
        String ma = taiKhoan.getTenDangNhap();
        User user = null;
        if ((user = timUser(ma)) != null) {
            user.capTaiKhoan(taiKhoan);
        }
    }
}
