package service;

import java.util.ArrayList;

import model.ChiTietHoaDon;

public class ChiTietHoaDonService {
    private ArrayList<ChiTietHoaDon> listChiTietHoaDon;

    public ChiTietHoaDonService(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        listChiTietHoaDon.add(chiTietHoaDon);
    }

    public void xoaChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        listChiTietHoaDon.remove(chiTietHoaDon);
    }

    public ChiTietHoaDon timChiTietHoaDon(String ma) {
        if (listChiTietHoaDon == null) {
            return null;
        }
        for (int i = 0; i < listChiTietHoaDon.size(); i++) {
            if (listChiTietHoaDon.get(i).getMa().equals(ma)) {
                return listChiTietHoaDon.get(i);
            }
        }
        return null;
    }

}
