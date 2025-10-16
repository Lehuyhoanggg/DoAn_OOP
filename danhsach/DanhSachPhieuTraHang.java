package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.PhieuTraHang;

public class DanhSachPhieuTraHang implements QuanLyDanhSach<PhieuTraHang> {
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

    public boolean them(PhieuTraHang phieuTraHang) {
        if (phieuTraHang == null) {
            return false;
        }
        soLuong++;
        return listPhieuTrahang.add(phieuTraHang);
    }

    public PhieuTraHang tim(String ma) {
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

    public boolean xoa(String ma) {
        PhieuTraHang phieuTraHang = tim(ma);
        if (phieuTraHang == null) {
            return false;
        }
        soLuong--;
        return listPhieuTrahang.remove(phieuTraHang);
    }

    public boolean xoa(PhieuTraHang phieuTraHang) {
        if (phieuTraHang == null) {
            return false;
        }
        soLuong--;
        return listPhieuTrahang.remove(phieuTraHang);
    }
}
