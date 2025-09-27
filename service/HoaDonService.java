package service;

import java.util.ArrayList;

import model.ChiTietHoaDon;
import model.HoaDon;
import ui.Nhap;
import util.ThoiGian;

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
        return listHoaDon.add(hd);
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
}