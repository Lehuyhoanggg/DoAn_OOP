package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.ChiTietHoaDon;
import model.HoaDon;
import util.ThoiGian;

public class DanhSachHoaDon implements QuanLyDanhSach<HoaDon> {
    private ArrayList<HoaDon> listHoaDon;
    private int soLuong = 0;

    public DanhSachHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public DanhSachHoaDon() {
    };

    public ArrayList<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // tim hoa don theo ma
    public HoaDon tim(String ma) {
        if (listHoaDon == null) {
            return null;
        }
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (listHoaDon.get(i).getMa().equals(ma)) {
                return listHoaDon.get(i);
            }
        }
        return null;
    }

    // xoa hoa don
    public boolean xoa(String ma) {
        HoaDon hoaDon = tim(ma);
        if (hoaDon == null) {
            return false;
        }
        soLuong--;
        return listHoaDon.remove(hoaDon);
    }

    public boolean xoa(HoaDon hoaDon) {
        if (hoaDon == null) {
            return false;
        }
        soLuong--;
        return listHoaDon.remove(hoaDon);
    }

    // them hoa don
    public boolean them(HoaDon hd) {
        if (hd == null) {
            return false;
        }
        soLuong++;
        return listHoaDon.add(hd);
    }

    public HoaDon tim(ChiTietHoaDon chiTietHoaDon) {
        for (HoaDon hoaDon : listHoaDon) {
            for (ChiTietHoaDon chiTietHd : hoaDon.getListChiTietHoaDon()) {
                if (chiTietHd.equals(chiTietHoaDon)) {
                    return hoaDon;
                }
            }
        }
        return null;
    }

    public long tinhDoanhThuTrongKhoan(String ngayBatDau, String ngayKetThuc) {
        long tongTien = 0;
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (ThoiGian.ngayTrongKhoan(listHoaDon.get(i).getNgayTaoHoaDon(), ngayBatDau, ngayKetThuc)) {
                tongTien += listHoaDon.get(i).getThanhTien();
            }
        }
        return tongTien;
    }

    public long tinhDoanhThuTrongNgay(String ngay) {
        long tongTien = 0;
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (listHoaDon.get(i).getNgayTaoHoaDon().equals(ngay)) {
                tongTien += listHoaDon.get(i).getThanhTien();
            }
        }
        return tongTien;
    }

    public int soHoaDonTrongNgay() {
        int count = 0;
        for (HoaDon hoaDon : listHoaDon) {
            if (hoaDon.getNgayTaoHoaDon().equals(ThoiGian.layNgayHienTaiStr())) {
                count++;
            }
        }
        return count;
    }

    public int soHoaDonTrongKhoan(String ngayBd, String ngayKt) {
        int count = 0;
        for (HoaDon hoaDon : listHoaDon) {
            if (ThoiGian.ngayTrongKhoan(hoaDon.getNgayTaoHoaDon(), ngayBd, ngayKt)) {
                count++;
            }
        }
        return count;
    }

}