package service;

import java.util.ArrayList;

import model.PhieuBaoHanh;

public class PhieuBaoHanhService {
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;

    public PhieuBaoHanhService(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public boolean themPhieuBaoHanh(PhieuBaoHanh phieuBaoHanh) {
        if (phieuBaoHanh == null) {
            return false;
        }
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
        return false;
    }
}
