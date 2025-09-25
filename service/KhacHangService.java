package service;

import java.util.ArrayList;

import model.KhachHang;

public class KhacHangService {
    private ArrayList<KhachHang> listKhachHang;

    public KhacHangService(ArrayList<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }

    public boolean themKhachHang(KhachHang khachHang) {
        return listKhachHang.add(khachHang);
    }

    public KhachHang timKhachHang(String ma) {
        if (listKhachHang == null) {
            return null;
        }
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getMaKh().equals(ma)) {
                return listKhachHang.get(i);
            }
        }
        return null;
    }

    public KhachHang timKhachHangTheoSdt(String sdt) {
        if (listKhachHang == null) {
            return null;
        }
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getSdt().equals(sdt)) {
                return listKhachHang.get(i);
            }
        }
        return null;
    }

    public boolean xoaKhachHang(String ma) {
        KhachHang khachHang = timKhachHang(ma);
        return listKhachHang.remove(khachHang);
    }

}
