package model;

import java.util.ArrayList;

public class LichLamViec {
    private String maNv;
    ArrayList<LichTrongNgay> lichTuan;

    public LichLamViec(ArrayList<LichTrongNgay> lichTuan) {
        this.lichTuan = lichTuan;
    }

    public void setLichTuan(ArrayList<LichTrongNgay> lichTuan) {
        this.lichTuan = lichTuan;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public ArrayList<LichTrongNgay> getLichTuan() {
        return lichTuan;
    }
}
