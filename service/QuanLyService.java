package service;

import java.util.ArrayList;

import model.QuanLy;

public class QuanLyService {
    private ArrayList<QuanLy> listQuanLy;

    public QuanLyService(ArrayList<QuanLy> listQuanLy) {
        this.listQuanLy = listQuanLy;
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
        listQuanLy.add(quanLy);
        return true;
    }

    // xoa quang ly
    public boolean xoaQuanLy(QuanLy quangLy) {
        if (quangLy == null) {
            return false;
        }
        listQuanLy.remove(quangLy);
        return true;
    }
    //
}