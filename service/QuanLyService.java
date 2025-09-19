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
}
