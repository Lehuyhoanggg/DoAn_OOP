package service;

import java.util.ArrayList;

import model.PhieuTraHang;

public class PhieuTraHangService {
    private ArrayList<PhieuTraHang> listPhieuTrahang;

    public PhieuTraHangService(ArrayList<PhieuTraHang> listPhieuTraHang) {
        this.listPhieuTrahang = listPhieuTraHang;
    }

    public ArrayList<PhieuTraHang> getListPhieuTrahang() {
        return listPhieuTrahang;
    }

    public void setListPhieuTrahang(ArrayList<PhieuTraHang> listPhieuTrahang) {
        this.listPhieuTrahang = listPhieuTrahang;
    }

    public boolean themPhieuTraHang(PhieuTraHang phieuTraHang) {
        return listPhieuTrahang.add(phieuTraHang);
    }

    public PhieuTraHang timPhieuTraHang(String ma) {
        if (listPhieuTrahang == null) {
            return null;
        }
        for (int i = 0; i < listPhieuTrahang.size(); i++) {
            if (listPhieuTrahang.get(i).getMaTraHang().equals(ma)) {
                return listPhieuTrahang.get(i);
            }
        }
        return null;
    }

    public boolean xoaPhieuTraHang(String ma) {
        PhieuTraHang phieuTraHang = timPhieuTraHang(ma);
        if (phieuTraHang == null) {
            return false;
        }
        return listPhieuTrahang.remove(phieuTraHang);
    }
}
