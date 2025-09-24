package service;

import java.util.ArrayList;

import model.BaoHanh;

public class BaoHanhService {
    private ArrayList<BaoHanh> listBaoHanh;

    public BaoHanhService(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public ArrayList<BaoHanh> getListBaoHanh() {
        return listBaoHanh;
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public void themBaoHanh(BaoHanh baoHanh) {
        listBaoHanh.add(baoHanh);
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
    // listBaoHanh
    // them
    // xoa
    // sua
    // tim kiem

}
