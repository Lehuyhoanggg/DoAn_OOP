package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.ChiTietHoaDon;
import model.SanPhamDaBan;

public class DanhSachChiTietHoaDon implements QuanLyDanhSach<ChiTietHoaDon> {
    private ArrayList<ChiTietHoaDon> listChiTietHoaDon;
    private int soLuong = 0;

    public DanhSachChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public DanhSachChiTietHoaDon() {
    };

    public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public boolean them(ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDon == null) {
            return false;
        }
        soLuong++;
        return listChiTietHoaDon.add(chiTietHoaDon);
    }

    public boolean xoa(ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDon == null) {
            return false;
        }
        soLuong--;
        return listChiTietHoaDon.remove(chiTietHoaDon);
    }

    public ChiTietHoaDon tim(String ma) {
        if (listChiTietHoaDon == null) {
            return null;
        }
        for (int i = 0; i < listChiTietHoaDon.size(); i++) {
            if (listChiTietHoaDon.get(i).getMa().equals(ma)) {
                return listChiTietHoaDon.get(i);
            }
        }
        return null;
    }

    public ChiTietHoaDon tim(SanPhamDaBan sanPhamDaBan) {
        for (ChiTietHoaDon chiTietHoaDon : listChiTietHoaDon) {
            for (SanPhamDaBan spDaBan : chiTietHoaDon.getSanPhamDaBan()) {
                if (spDaBan.equals(sanPhamDaBan)) {
                    return chiTietHoaDon;
                }
            }
        }
        return null;
    }

}
