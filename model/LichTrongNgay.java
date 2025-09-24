package model;

import java.util.ArrayList;

public class LichTrongNgay {
    private int thu;
    private ArrayList<CaLam> listCaLam;
    private String ngay;

    public LichTrongNgay(int thu, String ngay) {
        this.thu = thu;
        this.ngay = ngay;
    }

    public void setListCaLam(ArrayList<CaLam> listCaLam) {
        this.listCaLam = listCaLam;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public ArrayList<CaLam> getListCaLam() {
        return listCaLam;
    }

    public String getNgay() {
        return ngay;
    }

    public int getThu() {
        return thu;
    }
}
