package service;

import java.util.ArrayList;

import model.NhanVien;

public class NhanVienService {
    ArrayList<NhanVien> listNhanVien;

    public NhanVienService() {

    }

    public NhanVienService(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public ArrayList<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public void themNhanVien(NhanVien nhanVien) {
        listNhanVien.add(nhanVien);
    }

}