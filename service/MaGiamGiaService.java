package service;

import java.util.ArrayList;

import model.MaGiamGia;

public class MaGiamGiaService {
    ArrayList<MaGiamGia> listMaGiamGia;

    public MaGiamGiaService(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public ArrayList<MaGiamGia> ListMaApDungChoSp() {
        return null;
    }

    public void themMaGiamGia(MaGiamGia ma) {
        listMaGiamGia.add(ma);
    }

    public void xoaMaGiamGia(MaGiamGia ma) {
        listMaGiamGia.remove(ma);
    }

    public MaGiamGia timMaGiamGia(String ma) {
        if (listMaGiamGia == null) {
            return null;
        }
        for (int i = 0; i < listMaGiamGia.size(); i++) {
            if (listMaGiamGia.get(i).getMa() == ma) {
                return listMaGiamGia.get(i);
            }
        }
        return null;
    }

    public int timMaGiamGiaIndex(String ma) {
        if (listMaGiamGia == null) {
            return -1;
        }
        for (int i = 0; i < listMaGiamGia.size(); i++) {
            if (listMaGiamGia.get(i).getMa() == ma) {
                return i;
            }
        }
        return -1;
    }
}
