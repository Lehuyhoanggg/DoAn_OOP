package service;

import java.util.ArrayList;
import java.util.Map;

import model.ChiTietHoaDon;
import model.DanhSachSanPham;
import model.HoaDon;
import model.MaGiamGia;
import model.SanPham;
import util.ThoiGian;

public class MaGiamGiaService {
    ArrayList<MaGiamGia> listMaGiamGia;

    public MaGiamGiaService(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public boolean themMaGiamGia(MaGiamGia ma) {
        return listMaGiamGia.add(ma);
    }

    public boolean xoaMaGiamGia(MaGiamGia ma) {
        return listMaGiamGia.remove(ma);
    }

    public MaGiamGia timMaGiamGia(String ma) {
        if (listMaGiamGia == null) {
            return null;
        }
        for (int i = 0; i < listMaGiamGia.size(); i++) {
            if (listMaGiamGia.get(i).getMa().equals(ma)) {
                return listMaGiamGia.get(i);
            }
        }
        return null;
    }

    public boolean maGiamGiaThoaMan(SanPham sanPham, MaGiamGia maGiamGia) {
        if ((maGiamGia.getLoaiDoanhMuc().equals(sanPham.getDanhMuc()) || maGiamGia.getLoaiDoanhMuc().equals("Tat_Ca"))
                && (maGiamGia.getLoaiThuongHieu().equals(sanPham.getThuongHieu())
                        || maGiamGia.getLoaiThuongHieu().equals("Tat_Ca"))
                && ThoiGian.ngayTrongKhoan(ThoiGian.layNgayHienTaiStr(), maGiamGia.getNgayBatDau(),
                        maGiamGia.getNgayKetThuc())) {
            return true;
        }
        return false;
    }

    private long appDungMaGiamGia(SanPham sanPham, MaGiamGia maGiamGia) {
        if (maGiamGiaThoaMan(sanPham, maGiamGia)) {
            String tienGiam = maGiamGia.getTienGiam();
            if (tienGiam != null && tienGiam.length() >= 2 && tienGiam.charAt(tienGiam.length() - 1) == '%') {
                Long phanTram = Long.parseLong(tienGiam.substring(0, tienGiam.length() - 1));
                maGiamGia.setSanPhamDaDung(sanPham);
                return sanPham.getGia() - (sanPham.getGia() * phanTram) / 100;
            } else {
                maGiamGia.setSanPhamDaDung(sanPham);
                return sanPham.getGia() - Long.parseLong(tienGiam);
            }

        }
        return sanPham.getGia();
    }

    public void setThanhTienDaApMaGG(ChiTietHoaDon chiTietHoaDon) {
        long thanhTien = 0;
        ArrayList<Integer> listRemove = new ArrayList<>();
        Map<SanPham, Integer> mapSanPham = chiTietHoaDon.getDanhSachSanPham().getMapSanPham();
        for (SanPham sanPham : mapSanPham.keySet()) {
            for (int i = 0; i < mapSanPham.get(sanPham); i++) {
                for (int j = 0; j < listMaGiamGia.size(); j++) {
                    long giaSauAp = appDungMaGiamGia(sanPham, listMaGiamGia.get(i));
                    if (giaSauAp != sanPham.getGia()) {
                        listRemove.add(i);
                    }

                    thanhTien += giaSauAp;
                }
            }
        }
        for (int i = listRemove.size() - 1; i >= 0; i--) {
            chiTietHoaDon.themMaGiamGiaDaDung(listMaGiamGia.get(i));
            listMaGiamGia.remove(listRemove.get(i).intValue());
        }
        chiTietHoaDon.setThanhTien(thanhTien);
    }
}