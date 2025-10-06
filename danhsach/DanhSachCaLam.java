package danhsach;

import java.util.ArrayList;

import database.Database;
import model.CaLam;
import model.LichTrongNgay;
import model.NhanVien;
import util.CapMa;
import util.ThoiGian;

public class DanhSachCaLam {
    private ArrayList<CaLam> listCaLam;
    private int soLuong = 0;

    public DanhSachCaLam(ArrayList<CaLam> listCaLam) {
        this.listCaLam = listCaLam;
    }

    public DanhSachCaLam() {
    }

    public ArrayList<CaLam> getListCaLam() {
        return listCaLam;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListCaLam(ArrayList<CaLam> listCaLam) {
        this.listCaLam = listCaLam;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public CaLam timCaLam(String ma) {
        if (listCaLam == null) {
            return null;
        }
        for (int i = 0; i < listCaLam.size(); i++) {
            if (listCaLam.get(i).getMa().equals(ma)) {
                return listCaLam.get(i);
            }
        }
        return null;
    }

    public boolean themCaLam(CaLam caLam) {
        if (caLam == null) {
            return false;
        }
        soLuong++;
        return listCaLam.add(caLam);
    }

    public boolean xoaCaLam(CaLam caLam) {
        if (caLam == null) {
            return false;
        }
        soLuong--;
        return listCaLam.remove(caLam);
    }

    public boolean xoaCaLam(String ma) {
        CaLam caLam = timCaLam(ma);
        if (caLam == null) {
            return false;
        }
        soLuong--;
        return listCaLam.remove(caLam);
    }

    public CaLam timCaLam(int soCa, LichTrongNgay lichTrongNgay) {
        if (lichTrongNgay == null) {
            return null;
        }
        ArrayList<CaLam> listCaLam = lichTrongNgay.getListCaLam();
        for (CaLam caLam : listCaLam) {
            if (caLam.getSo() == soCa) {
                return caLam;
            }
        }
        return null;
    }

    public CaLam caLamHienTai(LichTrongNgay lichTrongNgay) {
        if (lichTrongNgay == null) {
            return null;
        }
        String gio = ThoiGian.layGioHienTai();
        ArrayList<CaLam> listCaLam = lichTrongNgay.getListCaLam();
        if (listCaLam == null) {
            return null;
        }
        for (int i = 0; i < listCaLam.size(); i++) {
            if (ThoiGian.gioTrongKhoan(gio, listCaLam.get(i).getGioBatDau(), listCaLam.get(i).getGioKetThuc())) {
                return listCaLam.get(i);
            }
        }
        return null;
    }
    public ArrayList <CaLam> taoListCaLamTrongTrongNgay(Database db){
        ArrayList <CaLam> listCaLamMau = new ArrayList<>();
        DanhSachCaLam danhSachCaLam = db.getDanhSachCaLam();
        String gioBatDau1 = "06:00";
        String gioKetThuc1 = "12:00";
        CaLam ca1 = new CaLam(CapMa.capMaCaLam(db), 1, gioBatDau1, gioKetThuc1, 2);
        danhSachCaLam.themCaLam(ca1);
        listCaLamMau.add(ca1);
        String gioBatDau2 = "12:00";
        String gioKetThuc2 = "18:00";
        CaLam ca2 = new CaLam(CapMa.capMaCaLam(db), 2, gioBatDau2, gioKetThuc2, 2);
        listCaLamMau.add(ca2);
        danhSachCaLam.themCaLam(ca2);
        String gioBatDau3 = "18:00";
        String gioKetThuc3 = "23:00";
        CaLam ca3 = new CaLam(CapMa.capMaCaLam(db), 3, gioBatDau3, gioKetThuc3, 2);
        danhSachCaLam.themCaLam(ca3);
        listCaLamMau.add(ca3);
        return listCaLamMau;
    }
}
