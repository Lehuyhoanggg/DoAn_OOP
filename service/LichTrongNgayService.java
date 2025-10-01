package service;

import java.util.ArrayList;

import model.LichTrongNgay;

public class LichTrongNgayService {
    private ArrayList<LichTrongNgay> listLichTrongNgay;

    public LichTrongNgayService(ArrayList<LichTrongNgay> listLichTrongNgay) {
        this.listLichTrongNgay = listLichTrongNgay;
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
        return listLichTrongNgay.add(lichTrongNgay);
    }

    public boolean themLichTrongNgay(String ma) {
        LichTrongNgay lichTrongNgay = timLichTrongNgay(ma);
        if (lichTrongNgay == null) {
            return false;
        }
        return listLichTrongNgay.add(lichTrongNgay);
    }

    public boolean xoaLichTrongNgay(LichTrongNgay lichTrongNgay) {
        if (lichTrongNgay == null) {
            return false;
        }
        return listLichTrongNgay.remove(lichTrongNgay);
    }

    public boolean xoaLichTrongNgay(String ma) {
        LichTrongNgay lichTrongNgay = timLichTrongNgay(ma);
        if (lichTrongNgay == null) {
            return false;
        }
        return listLichTrongNgay.remove(lichTrongNgay);
    }
}
