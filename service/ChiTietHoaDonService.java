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

    public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDon == null) {
            return false;
        }
        return listChiTietHoaDon.add(chiTietHoaDon);
    }

    public boolean xoaChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDon == null) {
            return false;
        }
        return listChiTietHoaDon.remove(chiTietHoaDon);
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
        if (!chiTietHoaDon.getDanhSachSanPham().tonTaiSanPham(sanPham)) {
            thuHoiMaGiamGiaSauKhiXoa(sanPham, chiTietHoaDon, khachHang); // gia sua neu da go san pham thi thu hoi , con
                                                                         // so luong nhieu hon 1 thi thoi
        }
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
