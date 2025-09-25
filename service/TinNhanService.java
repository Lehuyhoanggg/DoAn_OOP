package service;

import java.util.ArrayList;
import interfaces.GiaoTiep;
import model.NhanVien;
import model.QuanLy;
import model.TinNhan;
import model.User;

public class TinNhanService implements GiaoTiep {
    private ArrayList<QuanLy> listQuanLy;
    private ArrayList<NhanVien> listNhanVien;

    public TinNhanService(ArrayList<NhanVien> listNhanVien, ArrayList<QuanLy> listQuanLy) {
        this.listNhanVien = listNhanVien;
        this.listQuanLy = listQuanLy;
    }

    public void guiTinNhan(String maNguoiNhan, TinNhan tinNhan) {
        User nguoiNhan = null;

        nguoiNhan.nhanTinNhan(tinNhan);
    }

    public void xemTatCaTinNhan(User user) {

    }

    public void xemTinNhanTrongNgay() {
    }
}
