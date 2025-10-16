package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.NhanVien;

public class DanhSachNhanVien implements QuanLyDanhSach<NhanVien> {
    private ArrayList<NhanVien> listNhanVien;
    private int soLuong = 0;

    // contructor
    public DanhSachNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public DanhSachNhanVien() {
    };

    public ArrayList<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // them nhan vien
    public boolean them(NhanVien nhanVien) {
        if (nhanVien == null) {
            return false;
        }
        soLuong++;
        return listNhanVien.add(nhanVien);
    }

    // tim nhan vien theo ma tra ve NhanVien
    public NhanVien tim(String ma) {
        if (listNhanVien == null) {
            return null;
        }
        for (int i = 0; i < listNhanVien.size(); i++) {
            NhanVien nv = listNhanVien.get(i);
            if (nv.getMa().equals(ma))
                return nv;
        }
        return null;
    }

    // xoa nhan vien
    public boolean xoa(String ma) {
        NhanVien nv = tim(ma);
        if (nv == null) {
            return false;
        }
        soLuong--;
        return listNhanVien.remove(nv);
    }

    public boolean xoa(NhanVien nv) {
        if (nv == null) {
            return false;
        }
        soLuong--;
        return listNhanVien.remove(nv);
    }
}