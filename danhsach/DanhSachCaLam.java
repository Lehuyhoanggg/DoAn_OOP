package danhsach;

import java.util.ArrayList;

import model.CaLam;

public class DanhSachCaLam {
    private ArrayList<CaLam> listCaLam;
    private int soLuong = 0;

    public DanhSachCaLam(ArrayList<CaLam> listCaLam) {
        this.listCaLam = listCaLam;
    }

    public DanhSachCaLam() {
    }

    public ArrayList<CaLam> getListCaLam() {
        return listCaLam;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListCaLam(ArrayList<CaLam> listCaLam) {
        this.listCaLam = listCaLam;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public CaLam timCaLam(String ma) {
        if (listCaLam == null) {
            return null;
        }
        for (int i = 0; i < listCaLam.size(); i++) {
            if (listCaLam.get(i).getMa().equals(ma)) {
                return listCaLam.get(i);
            }
        }
        return null;
    }

    public boolean themCaLam(CaLam caLam) {
        if (caLam == null) {
            return false;
        }
        soLuong++;
        return listCaLam.add(caLam);
    }

    public boolean xoaCaLam(CaLam caLam) {
        if (caLam == null) {
            return false;
        }
        soLuong--;
        return listCaLam.remove(caLam);
    }

    public boolean xoaCaLam(String ma) {
        CaLam caLam = timCaLam(ma);
        if (caLam == null) {
            return false;
        }
        soLuong--;
        return listCaLam.remove(caLam);
    }
}
