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

    public ArrayList<BaoHanh> timKiemBaoHanh(String ten) {
        ArrayList<BaoHanh> ketQua = new ArrayList<>();
        if (ten == null || listBaoHanh == null) {
            return ketQua;
        }
        if (listBaoHanh != null) {
            for (int i = 0; i < listBaoHanh.size(); i++) {
                if (listBaoHanh.get(i).getTenBaoHanh().toLowerCase().contains(ten.toLowerCase())) {
                    ketQua.add(listBaoHanh.get(i));
                }
            }
        }
        return ketQua;
    }

    public void xoaBaoHanh(String ma) {
        BaoHanh baoHanh = timBaoHanh(ma);
        if (baoHanh != null) {
            listBaoHanh.remove(baoHanh);
        }
    }

    public void suaBaoHanh(String ma, BaoHanh baoHanhMoi) {
        BaoHanh baoHanh = timBaoHanh(ma);
        if (baoHanh != null) {
            int index = listBaoHanh.indexOf(baoHanh);
            listBaoHanh.set(index, baoHanhMoi);
        }
    }

    // listBaoHanh
    // them
    // xoa
    // sua
    // tim kiem

}
