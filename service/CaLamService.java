package service;

import java.util.ArrayList;

import model.CaLam;

public class CaLamService {
    private ArrayList<CaLam> listCaLam;

    public CaLamService(ArrayList<CaLam> listCaLam) {
        this.listCaLam = listCaLam;
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
        return listCaLam.add(caLam);
    }

    public boolean xoaCaLam(CaLam caLam) {
        if (caLam == null) {
            return false;
        }
        return listCaLam.remove(caLam);
    }

    public boolean xoaCaLam(String ma) {
        CaLam caLam = timCaLam(ma);
        if (caLam == null) {
            return false;
        }
        return listCaLam.remove(caLam);
    }
}
