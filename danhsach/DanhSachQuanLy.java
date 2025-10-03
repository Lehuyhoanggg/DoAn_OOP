package danhsach;

import java.util.ArrayList;

import model.QuanLy;

public class DanhSachQuanLy {
    private ArrayList<QuanLy> listQuanLy;
    private int soLuong = 0;

    public DanhSachQuanLy(ArrayList<QuanLy> listQuanLy) {
        this.listQuanLy = listQuanLy;
    }

    public DanhSachQuanLy() {
    }

    public ArrayList<QuanLy> getListQuanLy() {
        return listQuanLy;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListQuanLy(ArrayList<QuanLy> listQuanLy) {
        this.listQuanLy = listQuanLy;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public QuanLy timQuanLy(String ma) {
        if (listQuanLy == null) {
            return null;
        }
        for (int i = 0; i < listQuanLy.size(); i++) {
            if (listQuanLy.get(i).getMa().equals(ma)) {
                return listQuanLy.get(i);
            }
        }
        return null;
    }

    public boolean themQuanLy(QuanLy quanLy) {
        if (quanLy == null) {
            return false;
        }
        soLuong--;
        return listQuanLy.add(quanLy);
    }

    // xoa quang ly
    public boolean xoaQuanLy(String ma) {
        QuanLy quanLy = timQuanLy(ma);
        if (quanLy == null) {
            return false;
        }
        soLuong--;
        return listQuanLy.remove(quanLy);
    }
    //
}