package model;

import java.time.LocalDate;

public class LichLamViec {
    private String maNv;
    private LichLamViec[] lichLamViec = new LichLamViec[7];
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    public LichLamViec[] getLichLamViec() {
        return lichLamViec;
    }

    public String getMaNv() {
        return maNv;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setLichLamViec(LichLamViec[] lichLamViec) {
        this.lichLamViec = lichLamViec;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

}
