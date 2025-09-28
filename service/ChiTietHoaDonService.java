package service;

import java.util.ArrayList;

import model.ChiTietHoaDon;
import model.KhachHang;
import model.MaGiamGia;
import model.SanPham;

public class ChiTietHoaDonService {
    private ArrayList<ChiTietHoaDon> listChiTietHoaDon;

    public ChiTietHoaDonService(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        listChiTietHoaDon.add(chiTietHoaDon);
    }

    public void xoaChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        listChiTietHoaDon.remove(chiTietHoaDon);
    }

    public ChiTietHoaDon timChiTietHoaDon(String ma) {
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

    public void xoaSanPhamThuHoiMa(SanPham sanPham, ChiTietHoaDon chiTietHoaDon, KhachHang khachHang) {
        chiTietHoaDon.xoaSanPham(sanPham);
        thuHoiMaGiamGiaSauKhiXoa(sanPham, chiTietHoaDon, khachHang);
    }

    public void thuHoiMaGiamGiaSauKhiXoa(SanPham sanPham, ChiTietHoaDon chiTietHoaDon, KhachHang khachHang) {
        ArrayList<MaGiamGia> listMaGiamGia = chiTietHoaDon.getListMaGiamGiaDaDung();
        if (listMaGiamGia == null) {
            return;
        }
        for (int i = listMaGiamGia.size() - 1; i >= 0; i--) {
            if (listMaGiamGia.get(i).getSanPhamDaDung().equals(sanPham)) {
                khachHang.themMaGiamGia(listMaGiamGia.get(i));
                listMaGiamGia.remove(i);
            }
        }
    }
}
