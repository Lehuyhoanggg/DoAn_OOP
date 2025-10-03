package service;

import java.util.ArrayList;

import model.HangThanhVien;
import model.KhachHang;

public class HangThanhVienService {
    private ArrayList<HangThanhVien> listHangThanhVien;

    public HangThanhVienService(ArrayList<HangThanhVien> listHangThanhVien) {
        this.listHangThanhVien = listHangThanhVien;
    }

    public HangThanhVien timHangThanhVien(String ten) {
        if (listHangThanhVien == null) {
            return null;
        }
        for (int i = 0; i < listHangThanhVien.size(); i++) {
            if (listHangThanhVien.get(i).getTenHang().equals(ten)) {
                return listHangThanhVien.get(i);
            }
        }
        return null;
    }

    public boolean themHangThanhVien(HangThanhVien hangThanhVien) {
        if (hangThanhVien == null || timHangThanhVien(hangThanhVien.getTenHang()) != null) {
            return false; // đã tồn tại hoac truyen null vao
        }
        return listHangThanhVien.add(hangThanhVien);
    }

    public boolean xoaHangThanhVien(String ten) {
        HangThanhVien htv = timHangThanhVien(ten);
        if (htv != null) {
            return listHangThanhVien.remove(htv);
        }
        return false;
    }

    public void setHangThanhVienChoKhachHang(KhachHang khachHang) {

    }
}