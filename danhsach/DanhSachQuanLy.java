package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.QuanLy;

public class DanhSachQuanLy implements QuanLyDanhSach<QuanLy> {
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

    public QuanLy tim(String ma) {
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

    public boolean them(QuanLy quanLy) {
        if (quanLy == null) {
            return false;
        }
        soLuong--;
        return listQuanLy.add(quanLy);
    }

    // xoa quang ly
    public boolean xoa(String ma) {
        QuanLy quanLy = tim(ma);
        if (quanLy == null) {
            return false;
        }
        soLuong--;
        return listQuanLy.remove(quanLy);
    }
    
    public boolean xoa(QuanLy quanLy) {
        if (quanLy == null) {
            return false;
        }
        soLuong--;
        return listQuanLy.remove(quanLy);
    }
}