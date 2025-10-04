package danhsach;

import java.util.ArrayList;

import model.HangThanhVien;
import model.KhachHang;

public class DanhSachHangThanhVien {
    private ArrayList<HangThanhVien> listHangThanhVien;
    private int soLuong = 0;

    public DanhSachHangThanhVien(ArrayList<HangThanhVien> listHangThanhVien) {
        this.listHangThanhVien = listHangThanhVien;
    }

    public ArrayList<HangThanhVien> getListHangThanhVien() {
        return listHangThanhVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListHangThanhVien(ArrayList<HangThanhVien> listHangThanhVien) {
        this.listHangThanhVien = listHangThanhVien;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public HangThanhVien timHangThanhVien(String ten) {
        if (listHangThanhVien == null) {
            return null;
        }
        for (int i = 0; i < listHangThanhVien.size(); i++) {
            if (listHangThanhVien.get(i).getTenHang().equals(ten)) {
                return listHangThanhVien.get(i);
            }
        }
        return null;
    }

    public boolean themHangThanhVien(HangThanhVien hangThanhVien) {
        if (hangThanhVien == null || timHangThanhVien(hangThanhVien.getTenHang()) != null) {
            return false; // đã tồn tại hoac truyen null vao
        }
        soLuong++;
        return listHangThanhVien.add(hangThanhVien);
    }

    public boolean xoaHangThanhVien(String ten) {
        HangThanhVien htv = timHangThanhVien(ten);
        if (htv != null) {
            return listHangThanhVien.remove(htv);
        }
        soLuong--;
        return false;
    }

    public void setHangThanhVienChoKhachHang(KhachHang khachHang) {
        long tienDaChi = khachHang.getTienDaChi();
        if (tienDaChi >= HangThanhVien.mucDong && tienDaChi < HangThanhVien.mucBac
                && tienDaChi < HangThanhVien.mucVang) {
            khachHang.setHangThanhVien(timHangThanhVien("Dong"));
        } else if (tienDaChi >= HangThanhVien.mucBac && tienDaChi < HangThanhVien.mucVang) {
            khachHang.setHangThanhVien(timHangThanhVien("Bac"));
        } else {
            khachHang.setHangThanhVien(timHangThanhVien("Vang"));
        }
    }
}