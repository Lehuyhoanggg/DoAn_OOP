package service;

import java.util.ArrayList;

import model.PhieuBaoHanh;

public class PhieuBaoHanhService {
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;

    public PhieuBaoHanhService(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public ArrayList<PhieuBaoHanh> getListPhieuBaoHanh() {
        return listPhieuBaoHanh;
    }

    public void setListPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public void themPhieuBaoHanh(PhieuBaoHanh phieuBaoHanh) {
        listPhieuBaoHanh.add(phieuBaoHanh);
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
}
