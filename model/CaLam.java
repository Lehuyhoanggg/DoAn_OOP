package model;

import java.time.LocalTime;

public class CaLam {
    private int caSo;
    private LocalTime gioBatDau;
    private LocalTime gioKetThuc;

    public int getCaSo() {
        return caSo;
    }

    public LocalTime getGioBatDau() {
        return gioBatDau;
    }

    public LocalTime getGioKetThuc() {
        return gioKetThuc;
    }

    public void setCaSo(int caSo) {
        this.caSo = caSo;
    }

    public void setGioBatDau(LocalTime gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public void setGioKetThuc(LocalTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }
}
