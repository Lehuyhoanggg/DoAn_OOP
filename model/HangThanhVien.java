package model;

import java.util.ArrayList;

public class HangThanhVien {
    private String tenHang;
    private ArrayList<MaGiamGia> listMaGiamGiaDQ;
    private String moTa;

    public HangThanhVien(String tenHang, String moTa) {
        this.tenHang = tenHang;
        this.moTa = moTa;
        this.listMaGiamGiaDQ = new ArrayList<>();
    }

    public void setListMaGiamGiaDQ(ArrayList<MaGiamGia> listMaGiamGiaDQ) {
        this.listMaGiamGiaDQ = listMaGiamGiaDQ;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public ArrayList<MaGiamGia> getListMaGiamGiaDQ() {
        return listMaGiamGiaDQ;
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void themMaGiamGia(MaGiamGia maGiamGia) {
        listMaGiamGiaDQ.add(maGiamGia);
    }
}