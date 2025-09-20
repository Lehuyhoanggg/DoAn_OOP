package service;

import java.util.ArrayList;

import model.KhachHang;

public class KhacHangService {
    private ArrayList<KhachHang> listKhachHang;

    public KhacHangService(ArrayList<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }

    public void themKhachHang(KhachHang khachHang) {
        listKhachHang.add(khachHang);
    }
}
