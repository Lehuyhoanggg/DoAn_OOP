package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class LichTrongNgay {
    private ArrayList<CaLam> listCaLam;
    private LocalDate ngay;
    private int thu;

    public void setListCaLam(ArrayList<CaLam> listCaLam) {
        this.listCaLam = listCaLam;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public ArrayList<CaLam> getListCaLam() {
        return listCaLam;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public int getThu() {
        return thu;
    }
}
