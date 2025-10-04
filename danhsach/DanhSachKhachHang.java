package danhsach;

import java.util.ArrayList;

import model.HoaDon;
import model.KhachHang;
import model.MaGiamGia;

public class DanhSachKhachHang {
    private ArrayList<KhachHang> listKhachHang;
    private int soLuong = 0;

    public DanhSachKhachHang(ArrayList<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }

    public DanhSachKhachHang() {
    };

    public ArrayList<KhachHang> getListKhachHang() {
        return listKhachHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListKhachHang(ArrayList<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean themKhachHang(KhachHang khachHang) {
        if (khachHang == null) {
            return false;
        }
        soLuong++;
        return listKhachHang.add(khachHang);
    }

    public KhachHang timKhachHang(String ma) {
        if (listKhachHang == null) {
            return null;
        }
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getMaKh().equals(ma)) {
                return listKhachHang.get(i);
            }
        }
        return null;
    }

    public KhachHang timKhachHangTheoSdt(String sdt) {
        if (listKhachHang == null) {
            return null;
        }
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getSdt().equals(sdt)) {
                return listKhachHang.get(i);
            }
        }
        return null;
    }

    public boolean xoaKhachHang(String ma) {
        KhachHang khachHang = timKhachHang(ma);
        if (khachHang == null) {
            return false;
        }
        soLuong--;
        return listKhachHang.remove(khachHang);
    }

    public void setTienDaChi(KhachHang khachHang) {
        long tong = 0;
        ArrayList<HoaDon> listHoaDon = khachHang.getListHoaDon();
        for (int i = 0; i < listHoaDon.size(); i++) {
            tong += listHoaDon.get(i).getThanhTien();
        }
        khachHang.setTienDaChi(tong);
    }

    public void setTienDaChi() {
        for (int i = 0; i < listKhachHang.size(); i++) {
            setTienDaChi(listKhachHang.get(i));
        }
    }
}
