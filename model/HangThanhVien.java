package model;

import java.util.ArrayList;

public class HangThanhVien {
    private String tenHang;
    private ArrayList<MaGiamGia> listMaGiamGiaDQ;

    public HangThanhVien(String tenHang) {
        this.tenHang = tenHang;
        this.listMaGiamGiaDQ = new ArrayList<>();
    }

    public void setListMaGiamGiaDQ(ArrayList<MaGiamGia> listMaGiamGiaDQ) {
        this.listMaGiamGiaDQ = listMaGiamGiaDQ;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public ArrayList<MaGiamGia> getListMaGiamGiaDQ() {
        return listMaGiamGiaDQ;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void themMaGiamGia(MaGiamGia maGiamGia) {
        listMaGiamGiaDQ.add(maGiamGia);
    }
}
