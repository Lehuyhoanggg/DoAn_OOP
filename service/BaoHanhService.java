package service;

import java.util.ArrayList;

import model.BaoHanh;
import model.SanPham;

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

    public ArrayList<BaoHanh> timBaoHanh(SanPham sanPham) {
        if (listBaoHanh == null) {
            System.out.println("Khong co gi ca");
            return null;
        }
        ArrayList<BaoHanh> listBaoHanhs = new ArrayList<>();
        for (int i = 0; i < listBaoHanh.size(); i++) {
            if (listBaoHanh.get(i).getSanPham().equals(sanPham)) {
                listBaoHanhs.add(listBaoHanh.get(i));
            }
        }
        return listBaoHanhs;
    }

    public boolean xoaBaoHanh(String ma) {
        BaoHanh baoHanh = timBaoHanh(ma);
        if (baoHanh != null) {
            return false;
        }
        return listBaoHanh.remove(baoHanh);
    }
}
