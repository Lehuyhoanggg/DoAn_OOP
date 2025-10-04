package danhsach;

import java.util.ArrayList;
import java.util.Map;

import model.BaoHanh;
import model.ChiTietHoaDon;
import model.KhachHang;
import model.MaGiamGia;
import model.SanPham;
import util.ThoiGian;

public class DanhSachMaGiamGia {
    ArrayList<MaGiamGia> listMaGiamGia;
    private int soLuong = 0;

    public DanhSachMaGiamGia(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public DanhSachMaGiamGia() {

    }

    public ArrayList<MaGiamGia> getListMaGiamGia() {
        return listMaGiamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListMaGiamGia(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean themMaGiamGia(MaGiamGia maGiamGia) {
        if (maGiamGia == null) {
            return false;
        }
        if (timMaGiamGia(maGiamGia.getMa()) != null) {
            return false;
        }
        soLuong++;
        return listMaGiamGia.add(maGiamGia);
    }

    public boolean xoaMaGiamGia(MaGiamGia ma) {
        if (ma == null) {
            return false;
        }
        soLuong--;
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

    private boolean trungDanhMuc(MaGiamGia maGiamGia, SanPham sanPham) {
        return maGiamGia.getLoaiDoanhMuc().equals(sanPham.getDanhMuc());
    }

    private boolean trungThuongHieu(MaGiamGia maGiamGia, SanPham sanPham) {
        return maGiamGia.getLoaiThuongHieu().equals(sanPham.getThuongHieu());
    }

    public boolean maGiamGiaThoaMan(SanPham sanPham, MaGiamGia maGiamGia) {
        if ((trungDanhMuc(maGiamGia, sanPham) || maGiamGia.getLoaiDoanhMuc().equals("Tat_Ca"))
                && (trungThuongHieu(maGiamGia, sanPham)
                        || maGiamGia.getLoaiThuongHieu().equals("Tat_Ca"))
                && ((maGiamGia.getNgayBatDau().equals("Vinh_Vien") || maGiamGia.getNgayKetThuc().equals("Vinh_Vien") ||
                        ThoiGian.ngayTrongKhoan(ThoiGian.layNgayHienTaiStr(), maGiamGia.getNgayBatDau(),
                                maGiamGia.getNgayKetThuc())))) {
            return true;
        }
        return false;
    }

    private long appDungMaGiamGia(SanPham sanPham, MaGiamGia maGiamGia, long giaDangXuLi) {
        if (maGiamGiaThoaMan(sanPham, maGiamGia)) {
            String tienGiam = maGiamGia.getTienGiam();
            if (tienGiam != null && tienGiam.length() >= 2 && tienGiam.charAt(tienGiam.length() - 1) == '%') {
                Long phanTram = Long.parseLong(tienGiam.substring(0, tienGiam.length() - 1));
                maGiamGia.setSanPhamDaDung(sanPham);
                return giaDangXuLi - (sanPham.getGia() * phanTram) / 100;
            } else {
                maGiamGia.setSanPhamDaDung(sanPham);
                return giaDangXuLi - Long.parseLong(tienGiam);
            }

        }
        return giaDangXuLi;
    }

    public void setThanhTienDaApMaGG(ChiTietHoaDon chiTietHoaDon) {
        long thanhTien = 0;
        Map<SanPham, Integer> mapSanPham = chiTietHoaDon.getDanhSachSanPham().getMapSanPham();

        for (SanPham sanPham : mapSanPham.keySet()) {
            ArrayList<MaGiamGia> listRemove = new ArrayList<>();
            long giaSanPham = sanPham.getGia();
            ArrayList<MaGiamGia> maGiamGiaSp = listMaGiamGiaChoSp(sanPham);
            for (int i = 0; i < maGiamGiaSp.size(); i++) {
                giaSanPham = appDungMaGiamGia(sanPham, maGiamGiaSp.get(i), giaSanPham);
                chiTietHoaDon.themMaGiamGiaDaDung(maGiamGiaSp.get(i));
                listRemove.add(maGiamGiaSp.get(i));
                if (giaSanPham <= 0) {
                    giaSanPham = 0;
                    break;
                }
            }
            for (int i = listRemove.size() - 1; i >= 0; i--) {
                listMaGiamGia.remove(listRemove.get(i));
            }
            thanhTien += giaSanPham;
        }
        ArrayList<BaoHanh> listBaoHanh = chiTietHoaDon.getListBaoHanh();
        for (int i = 0; i < listBaoHanh.size(); i++) {
            thanhTien += listBaoHanh.get(i).getGia();
        }
        chiTietHoaDon.setThanhTien(thanhTien);
    }

    public void ganSanPhamChoMaGiamGia(SanPham sanPham, String ma) {
        MaGiamGia maGiamGia = timMaGiamGia(ma);
        if (maGiamGia == null) {
            return;
        }
        maGiamGia.setSanPhamDaDung(sanPham);
    }

    public ArrayList<MaGiamGia> listMaGiamGiaChoSp(SanPham sanPham) {
        ArrayList<MaGiamGia> listMaGiamGiaTM = new ArrayList<>();
        for (int i = 0; i < listMaGiamGia.size(); i++) {
            if (maGiamGiaThoaMan(sanPham, listMaGiamGia.get(i))) {
                listMaGiamGiaTM.add(listMaGiamGia.get(i));
            }
        }
        return listMaGiamGiaTM;
    }

    private boolean maDocQuyen(String ma) {
        String maDong = "MGGDONG";
        String maBac = "MGGBAC";
        String maVang = "MGGVANG";
        return ma.startsWith(maDong) || ma.startsWith(maBac) || ma.startsWith(maVang);
    }

    public boolean laMaGiamGiaDocQuyen(MaGiamGia maGiamGia) {
        if (maDocQuyen(maGiamGia.getMa())) {
            return true;
        }
        return false;
    }
}