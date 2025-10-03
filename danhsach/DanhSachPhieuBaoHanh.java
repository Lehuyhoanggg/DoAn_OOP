package danhsach;

import java.util.ArrayList;

import model.PhieuBaoHanh;

public class DanhSachPhieuBaoHanh {
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;
    private int soLuong = 0;

    public DanhSachPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public DanhSachPhieuBaoHanh() {
    }

    public ArrayList<PhieuBaoHanh> getListPhieuBaoHanh() {
        return listPhieuBaoHanh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean themPhieuBaoHanh(PhieuBaoHanh phieuBaoHanh) {
        if (phieuBaoHanh == null) {
            return false;
        }
        soLuong++;
        return listPhieuBaoHanh.add(phieuBaoHanh);
    }

    public PhieuBaoHanh timPhieuBaoHanh(String ma) {
        if (listPhieuBaoHanh == null) {
            return null;
        }
        for (int i = 0; i < listPhieuBaoHanh.size(); i++) {
            if (listPhieuBaoHanh.get(i).getMaBaoHanh().equals(ma)) {
                return listPhieuBaoHanh.get(i);
            }
        }
        return null;
    }

    public boolean xoaPhieuBaoHanh(String ma) {
        PhieuBaoHanh phieuBaoHanh = timPhieuBaoHanh(ma);
        if (phieuBaoHanh != null) {
            return listPhieuBaoHanh.remove(phieuBaoHanh);
        }
        soLuong--;
        return false;
    }
}
