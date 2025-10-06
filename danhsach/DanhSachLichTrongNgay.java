package danhsach;

import java.util.ArrayList;

import database.Database;
import model.LichTrongNgay;
import model.LichTrongTuan;
import util.CapMa;
import util.ThoiGian;

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

    public LichTrongNgay lichTrongNgayHomNay() {
        for (LichTrongNgay lichTrongNgay : listLichTrongNgay) {
            if (lichTrongNgay.getNgay().equals(ThoiGian.layNgayHienTaiStr())) {
                return lichTrongNgay;
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

    public ArrayList<LichTrongNgay> taoListLichTrongNgay(Database db, String ngay) {
        ArrayList<LichTrongNgay> listLichTrongNgayMau = new ArrayList<>();
        for (int thu = 2; thu <= 8; thu++) {
            String ma = CapMa.capMaLichTrongNgay(db);
            LichTrongNgay lichTrongNgay = new LichTrongNgay(ma, thu, ngay);
            lichTrongNgay.setListCaLam(db.getDanhSachCaLam().taoListCaLamTrongTrongNgay(db));
            listLichTrongNgayMau.add(lichTrongNgay);
            db.getDanhSachLichTrongNgay().themLichTrongNgay(lichTrongNgay);
            ngay = ThoiGian.ngayTiepTheo(ngay);
        }
        return listLichTrongNgayMau;
    }
}
