package service;

import java.util.ArrayList;

import model.HoaDon;
import model.KhachHang;

public class KhachHangService {
    private ArrayList<KhachHang> listKhachHang;

    public KhachHangService(ArrayList<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }

    public boolean themKhachHang(KhachHang khachHang) {
        if (khachHang == null) {
            return false;
        }
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
