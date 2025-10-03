package danhsach;

import java.util.ArrayList;
import model.NhanVien;

public class DanhSachNhanVien {
    private ArrayList<NhanVien> listNhanVien;
    private int soLuong = 0;

    // contructor
    public DanhSachNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public DanhSachNhanVien() {
    };

    public ArrayList<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // them nhan vien
    public boolean themNhanVien(NhanVien nhanVien) {
        if (nhanVien == null) {
            return false;
        }
        soLuong++;
        return listNhanVien.add(nhanVien);
    }

    // tim nhan vien theo ma tra ve NhanVien
    public NhanVien timNhanVien(String ma) {
        if (listNhanVien == null) {
            return null;
        }
        for (int i = 0; i < listNhanVien.size(); i++) {
            NhanVien nv = listNhanVien.get(i);
            if (nv.getMa().equals(ma))
                return nv;
        }
        return null;
    }

    // xoa nhan vien
    public boolean xoaNhanVien(String ma) {
        NhanVien nv = timNhanVien(ma);
        if (nv == null) {
            return false;
        }
        soLuong--;
        return listNhanVien.remove(nv);
    }
}