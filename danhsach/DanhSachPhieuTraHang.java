package danhsach;

import java.util.ArrayList;

import model.PhieuTraHang;

public class DanhSachPhieuTraHang {
    private ArrayList<PhieuTraHang> listPhieuTrahang;
    private int soLuong = 0;

    public DanhSachPhieuTraHang(ArrayList<PhieuTraHang> listPhieuTraHang) {
        this.listPhieuTrahang = listPhieuTraHang;
    }

    public DanhSachPhieuTraHang() {
    }

    public ArrayList<PhieuTraHang> getListPhieuTraHang() {
        return listPhieuTrahang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListPhieuTraHang(ArrayList<PhieuTraHang> listPhieuTrahang) {
        this.listPhieuTrahang = listPhieuTrahang;
    }

    public boolean themPhieuTraHang(PhieuTraHang phieuTraHang) {
        if (phieuTraHang == null) {
            return false;
        }
        soLuong++;
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
        soLuong--;
        return listPhieuTrahang.remove(phieuTraHang);
    }
}
