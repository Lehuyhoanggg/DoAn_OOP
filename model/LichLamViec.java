package model;

public class LichLamViec {
    private String maNv;
    private LichTrongNgay[] lichTuan = new LichTrongNgay[7];// Arraylist

    public String getMaNv() {
        return maNv;
    }

    public LichTrongNgay[] getLichTuan() {
        return lichTuan;
    }

    public void setLichTuan(LichTrongNgay[] lichTuan) {
        this.lichTuan = lichTuan;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

}
