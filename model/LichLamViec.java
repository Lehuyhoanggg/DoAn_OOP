package model;

import java.util.ArrayList;

public class LichLamViec {
    ArrayList<LichTrongNgay> listLichTrongNgay;// 7 phan tu

    public LichLamViec() {
        listLichTrongNgay = new ArrayList<>();
    }

    public void setLichTuan(ArrayList<LichTrongNgay> lichTuan) {
        this.listLichTrongNgay = lichTuan;
    }

    public ArrayList<LichTrongNgay> getLichTuan() {
        return listLichTrongNgay;
    }

    public boolean themLichTrongNgay(LichTrongNgay lichTrongNgay) {
        if (lichTrongNgay == null) {
            return false;
        }
        return listLichTrongNgay.add(lichTrongNgay);
    }
}
