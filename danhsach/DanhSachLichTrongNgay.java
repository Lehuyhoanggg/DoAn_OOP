package danhsach;

import java.util.ArrayList;

import model.LichTrongNgay;

public class DanhSachLichTrongNgay {
    private ArrayList<LichTrongNgay> listLichTrongNgay;
    private int soLuong = 0;

    public DanhSachLichTrongNgay(ArrayList<LichTrongNgay> listLichTrongNgay) {
        this.listLichTrongNgay = listLichTrongNgay;
    }

    public DanhSachLichTrongNgay() {

    }

    public ArrayList<LichTrongNgay> getListLichTrongNgay() {
        return listLichTrongNgay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListLichTrongNgay(ArrayList<LichTrongNgay> listLichTrongNgay) {
        this.listLichTrongNgay = listLichTrongNgay;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public LichTrongNgay timLichTrongNgay(String ma) {
        if (listLichTrongNgay == null) {
            return null;
        }
        for (int i = 0; i < listLichTrongNgay.size(); i++) {
            if (listLichTrongNgay.get(i).getMa().equals(ma)) {
                return listLichTrongNgay.get(i);
            }
        }
        return null;
    }

    public boolean themLichTrongNgay(LichTrongNgay lichTrongNgay) {
        if (lichTrongNgay == null) {
            return false;
        }
        soLuong++;
        return listLichTrongNgay.add(lichTrongNgay);
    }

    public boolean themLichTrongNgay(String ma) {
        LichTrongNgay lichTrongNgay = timLichTrongNgay(ma);
        if (lichTrongNgay == null) {
            return false;
        }
        soLuong++;
        return listLichTrongNgay.add(lichTrongNgay);
    }

    public boolean xoaLichTrongNgay(LichTrongNgay lichTrongNgay) {
        if (lichTrongNgay == null) {
            return false;
        }
        soLuong--;
        return listLichTrongNgay.remove(lichTrongNgay);
    }

    public boolean xoaLichTrongNgay(String ma) {
        LichTrongNgay lichTrongNgay = timLichTrongNgay(ma);
        if (lichTrongNgay == null) {
            return false;
        }
        soLuong--;
        return listLichTrongNgay.remove(lichTrongNgay);
    }
}
