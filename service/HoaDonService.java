package service;

import java.util.ArrayList;

import model.ChiTietHoaDon;
import model.HoaDon;
import ui.Nhap;

public class HoaDonService {
    private ArrayList<HoaDon> listHoaDon;

    public HoaDonService(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    // tim hoa don theo ma
    public HoaDon timHoaDon(String ma) {
        if (listHoaDon == null) {
            return null;
        } else {
            for (int i = 0; i < listHoaDon.size(); i++) {
                if (listHoaDon.get(i).equals(ma)) {
                    return listHoaDon.get(i);
                }
            }
        }
        return null;
    }

    // xoa hoa don
    public boolean xoaHoaDon(String ma) {
        HoaDon hoaDon = timHoaDon(ma);
        ma = Nhap.nhapStr("nhap ma hoa don can xoa: ");
        if (hoaDon == null) {
            return false;
        }
        xoaHoaDon(ma);
        return true;
    }

    // them hoa don
    public boolean themHoaDon(HoaDon hd) {
        listHoaDon.add(hd);
        return true;
    }

    // sua hoa don
    public boolean suaHoaDon(String ma, HoaDon hdMoi) {
        HoaDon hd2 = timHoaDon(ma);
        if (hd2 == null) {
            return false;
        } else {
            hd2.setMa(hdMoi.getMa());
            hd2.setKhachHang(hdMoi.getKhachHang());
            hd2.setChiTietHoaDon(hdMoi.getChiTietHoaDon());
            hd2.setMaNgTaoHoaDon(hdMoi.getMaNgTaoHoaDon());
            hd2.setNgayTaoHoaDon(hdMoi.getNgayTaoHoaDon());
            hd2.setGhiChu(hdMoi.getGhiChu());
            return true;
        }
    }
}