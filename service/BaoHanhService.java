package service;

import java.util.ArrayList;

import model.BaoHanh;

public class BaoHanhService {
    private ArrayList<BaoHanh> listBaoHanh;

    public BaoHanhService(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public boolean themBaoHanh(BaoHanh baoHanh) {
        if (baoHanh == null) {
            return false;
        }
        return listBaoHanh.add(baoHanh);
    }

    public BaoHanh timBaoHanh(String ma) {
        if (listBaoHanh == null) {
            return null;
        }
        for (int i = 0; i < listBaoHanh.size(); i++) {
            if (listBaoHanh.get(i).getMaBh().equals(ma)) {
                return listBaoHanh.get(i);
            }
        }
        return null;
    }

    public boolean xoaBaoHanh(String ma) {
        BaoHanh baoHanh = timBaoHanh(ma);
        if (baoHanh != null) {
            return false;
        }
        return listBaoHanh.remove(baoHanh);
    }
}
