package danhsach;

import java.util.ArrayList;

import model.ChiTietHoaDon;
import model.KhachHang;
import model.MaGiamGia;
import model.SanPham;
import util.ThoiGian;

public class DanhSachChiTietHoaDon {
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

    public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDon == null) {
            return false;
        }
        soLuong++;
        return listChiTietHoaDon.add(chiTietHoaDon);
    }

    public boolean xoaChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDon == null) {
            return false;
        }
        soLuong--;
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

    public ArrayList<MaGiamGia> xoaSanPhamThuHoiMa(SanPham sanPham, ChiTietHoaDon chiTietHoaDon, KhachHang khachHang) {
        chiTietHoaDon.xoaSanPham(sanPham);
        if (!chiTietHoaDon.getDanhSachSanPham().tonTaiSanPham(sanPham)) {
            return thuHoiMaGiamGiaSauKhiXoa(sanPham, chiTietHoaDon, khachHang); // gia sua neu da go san pham thi thu
                                                                                // hoi , con // so luong nhieu hon 1 thi
                                                                                // thoi
        }
        return null;
    }

    public ArrayList<MaGiamGia> thuHoiMaGiamGiaSauKhiXoa(SanPham sanPham, ChiTietHoaDon chiTietHoaDon,
            KhachHang khachHang) {
        ArrayList<MaGiamGia> listMaThuHoi = new ArrayList<>();
        ArrayList<MaGiamGia> listMaGiamGia = chiTietHoaDon.getListMaGiamGiaDaDung();
        if (listMaGiamGia == null) {
            return null;
        }
        for (int i = listMaGiamGia.size() - 1; i >= 0; i--) {
            if (listMaGiamGia.get(i).getSanPhamDaDung().equals(sanPham)
                    && ThoiGian.ngayTrongKhoan(ThoiGian.layNgayHienTaiStr(), listMaGiamGia.get(i).getNgayBatDau(),
                            listMaGiamGia.get(i).getNgayKetThuc())) {
                khachHang.themMaGiamGia(listMaGiamGia.get(i));
                listMaGiamGia.remove(i);
                listMaThuHoi.add(listMaGiamGia.get(i));
            }
        }
        return listMaThuHoi;
    }
}
