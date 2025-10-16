package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.LichTrongTuan;
import util.ThoiGian;

public class DanhSachLichTrongTuan implements QuanLyDanhSach<LichTrongTuan> {
    private ArrayList<LichTrongTuan> listLichTrongTuan;

    public DanhSachLichTrongTuan(ArrayList<LichTrongTuan> listLichTrongTuan) {
        this.listLichTrongTuan = listLichTrongTuan;
    }

    public DanhSachLichTrongTuan() {

    }

    public ArrayList<LichTrongTuan> getListLichTrongTuan() {
        return listLichTrongTuan;
    }

    public void setListLichTrongTuan(ArrayList<LichTrongTuan> listLichTrongTuan) {
        this.listLichTrongTuan = listLichTrongTuan;
    }

    public LichTrongTuan lichTrongTuanNay() {
        for (LichTrongTuan lichTrongTuan : listLichTrongTuan) {
            if (ThoiGian.ngayTrongKhoan(ThoiGian.layNgayHienTaiStr(), lichTrongTuan.getNgayThu2(),
                    lichTrongTuan.getNgayCn())) {
                return lichTrongTuan;
            }
        }
        return null;
    }

    public LichTrongTuan tim(String ma) {
        if (listLichTrongTuan == null) {
            return null;
        }
        for (LichTrongTuan lichTrongTuan : listLichTrongTuan) {
            if (lichTrongTuan.getMa().equals(ma)) {
                return lichTrongTuan;
            }
        }
        return null;
    }

    public LichTrongTuan tim(int soTuan) {
        String ngay = ThoiGian.layNgayDauTuanStr(soTuan);
        for (LichTrongTuan lichTrongTuan : listLichTrongTuan) {
            if (ThoiGian.ngayTrongKhoan(ngay, lichTrongTuan.getNgayThu2(), lichTrongTuan.getNgayCn())) {
                return lichTrongTuan;
            }
        }
        return null;
    }

    public boolean them(LichTrongTuan lichTrongTuan) {
        if (lichTrongTuan == null) {
            return false;
        }
        return listLichTrongTuan.add(lichTrongTuan);
    }

    public boolean xoa(LichTrongTuan lichTrongTuan) {
        if (lichTrongTuan == null) {
            return false;
        }
        return listLichTrongTuan.remove(lichTrongTuan);
    }

}
