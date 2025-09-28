package service;

import java.util.ArrayList;
import model.NhanVien;

public class NhanVienService {
    private ArrayList<NhanVien> listNhanVien;

    // contructor
    public NhanVienService(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    // them nhan vien
    public void themNhanVien(NhanVien nhanVien) {
        listNhanVien.add(nhanVien);
    }

    // tim nhan vien theo ma tra ve NhanVien
    public NhanVien timNhanVien(String ma) {
        for (int i = 0; i < listNhanVien.size(); i++) {
            NhanVien nv = listNhanVien.get(i);
            if (nv.getMa().equals(ma))
                return nv;
        }
        return null;
    }

    // xoa nhan vien
    public void xoaNhanVien(String ma) {
        NhanVien nv = timNhanVien(ma);
        listNhanVien.remove(nv);
    }
}