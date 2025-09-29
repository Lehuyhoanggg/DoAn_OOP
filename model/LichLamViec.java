package model;

import java.util.ArrayList;

public class LichLamViec {
    ArrayList<LichTrongNgay> lichTuan;// 7 phan tu

    public LichLamViec(ArrayList<LichTrongNgay> lichTuan) {
        this.lichTuan = lichTuan;
    }

    public LichLamViec() {
    }

    public void setLichTuan(ArrayList<LichTrongNgay> lichTuan) {
        this.lichTuan = lichTuan;
    }

    public ArrayList<LichTrongNgay> getLichTuan() {
        return lichTuan;
    }
}
