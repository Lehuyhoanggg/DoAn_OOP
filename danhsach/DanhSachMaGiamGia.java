package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.BaoHanh;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.MaGiamGia;
import model.SanPham;
import model.SanPhamDaBan;
import util.ThoiGian;

public class DanhSachMaGiamGia implements QuanLyDanhSach<MaGiamGia> {
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

    public boolean them(MaGiamGia maGiamGia) {
        if (maGiamGia == null) {
            return false;
        }
        if (tim(maGiamGia.getMa()) != null) {
            return false;
        }
        soLuong++;
        return listMaGiamGia.add(maGiamGia);
    }

    public boolean xoa(MaGiamGia ma) {
        if (ma == null) {
            return false;
        }
        soLuong--;
        return listMaGiamGia.remove(ma);
    }

    public MaGiamGia tim(String ma) {
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

    public void setThanhTienDaApMaGG(HoaDon hoaDon) {
        for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {

            long thanhTien = 0;
            for (int i = 0; i < chiTietHoaDon.getSanPhamDaBan().size(); i++) {
                SanPham sanPham = chiTietHoaDon.getSanPhamDaBan().get(i).getSanPham();
                ArrayList<MaGiamGia> listRemove = new ArrayList<>();
                long giaSanPham = sanPham.getGia();
                ArrayList<MaGiamGia> maGiamGiaSp = listMaGiamGiaChoSp(sanPham);
                for (int k = 0; k < maGiamGiaSp.size(); k++) {
                    giaSanPham = appDungMaGiamGia(sanPham, maGiamGiaSp.get(k), giaSanPham);

                    chiTietHoaDon.getSanPhamDaBan().get(i).themMaGiamGiaDaDung(maGiamGiaSp.get(k));

                    listRemove.add(maGiamGiaSp.get(k));
                    if (giaSanPham <= 0) {
                        giaSanPham = 0;
                        break;
                    }
                }
                BaoHanh baoHanh = chiTietHoaDon.getSanPhamDaBan().get(i).getBaoHanh();
                if (baoHanh != null) {
                    thanhTien += baoHanh.getGia();
                }
                for (int j = listRemove.size() - 1; j >= 0; j--) {
                    listMaGiamGia.remove(listRemove.get(j));
                }
                thanhTien += giaSanPham;
            }
            chiTietHoaDon.setThanhTien(thanhTien);
        }
        hoaDon.tinhThanhTien();
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

    public long giaSanPhamSauKhiApDungTatCa(SanPham sanPham) {
        long gia = sanPham.getGia();
        for (MaGiamGia maGiamGia : listMaGiamGia) {
            gia = appDungMaGiamGia(sanPham, maGiamGia, gia);
        }
        return gia;
    }

    public ArrayList<MaGiamGia> xoaSanPhamThuHoiMa(SanPhamDaBan sanPhamDaBan, HoaDon hoaDon) {
        KhachHang khachHang = hoaDon.getKhachHang();
        if (sanPhamDaBan.getSanPham() == null) {
            return null;
        }
        SanPham sanPham = sanPhamDaBan.getSanPham();

        ArrayList<MaGiamGia> listMaThuHoi = new ArrayList<>();
        ArrayList<MaGiamGia> listMaGiamGiaSp = null;
        listMaGiamGiaSp = sanPhamDaBan.getListMaGiamGiaDaDung();
        DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(listMaGiamGiaSp);
        long tienGiam = danhSachMaGiamGia.giaSanPhamSauKhiApDungTatCa(sanPham);
        DanhSachChiTietHoaDon danhSachChiTietHoaDon = new DanhSachChiTietHoaDon(hoaDon.getListChiTietHoaDon());
        ChiTietHoaDon chiTietHoaDon = danhSachChiTietHoaDon.tim(sanPhamDaBan);
        chiTietHoaDon.setThanhTien(chiTietHoaDon.getThanhTien() - tienGiam);
        hoaDon.tinhThanhTien();////
        sanPhamDaBan.xoaSanPham();
        if (sanPhamDaBan.getBaoHanh() == null) {
            chiTietHoaDon.xoaSanPhamDaBan(sanPhamDaBan);
        }

        if (listMaGiamGia == null) {
            return null;
        }
        for (int i = listMaGiamGiaSp.size() - 1; i >= 0; i--) {
            if (listMaGiamGiaSp.get(i).getSanPhamDaDung().equals(sanPham)
                    && (listMaGiamGiaSp.get(i).getNgayKetThuc().equals("Vinh_Vien")
                            || listMaGiamGiaSp.get(i).getNgayBatDau().equals("Vinh_Vien")
                            || ThoiGian.ngayTrongKhoan(ThoiGian.layNgayHienTaiStr(),
                                    listMaGiamGiaSp.get(i).getNgayBatDau(),
                                    listMaGiamGiaSp.get(i).getNgayKetThuc()))) {
                khachHang.themMaGiamGia(listMaGiamGiaSp.get(i));
                listMaThuHoi.add(listMaGiamGiaSp.get(i));
                listMaGiamGiaSp.remove(i);
            }
        }
        return listMaThuHoi;
    }
}