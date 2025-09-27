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

    public boolean themMaGiamGia(MaGiamGia ma) {
        return listMaGiamGia.add(ma);
    }

    public boolean xoaMaGiamGia(MaGiamGia ma) {
        return listMaGiamGia.remove(ma);
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
}