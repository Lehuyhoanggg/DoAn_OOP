package model;

import java.util.ArrayList;

public class LichLamViec {
    ArrayList<LichTrongNgay> listLichTrongNgay;// 7 phan tu

    public LichLamViec(ArrayList<LichTrongNgay> lichTuan) {
        this.listLichTrongNgay = lichTuan;
    }

    public LichLamViec() {
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
