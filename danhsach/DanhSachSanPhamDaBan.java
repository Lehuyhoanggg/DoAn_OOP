package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.SanPham;
import model.SanPhamDaBan;

public class DanhSachSanPhamDaBan implements QuanLyDanhSach<SanPhamDaBan> {
    private ArrayList<SanPhamDaBan> listSanPhamDaBan;

    public DanhSachSanPhamDaBan() {
        listSanPhamDaBan = new ArrayList<>();
    }

    public DanhSachSanPhamDaBan(ArrayList<SanPhamDaBan> listSanPhamDaBan) {
        this.listSanPhamDaBan = listSanPhamDaBan;
    }

    public ArrayList<SanPhamDaBan> getListSanPhamDaBan() {
        return listSanPhamDaBan;
    }

    public void setListSanPhamDaBan(ArrayList<SanPhamDaBan> listSanPhamDaBan) {
        this.listSanPhamDaBan = listSanPhamDaBan;
    }

    public boolean them(SanPhamDaBan sanPhamDaBan) {
        if (sanPhamDaBan == null) {
            return false;
        }
        return listSanPhamDaBan.add(sanPhamDaBan);
    }

    public SanPhamDaBan tim(SanPham sanPham, String serial) {
        for (SanPhamDaBan sanPhamDaBan : listSanPhamDaBan) {
            if (sanPhamDaBan.getSanPham().equals(sanPham) && (sanPhamDaBan.getSerial().equals(serial))) {
                return sanPhamDaBan;
            }
        }
        return null;
    }

    public SanPhamDaBan tim(String ma) {
        for (SanPhamDaBan sanPhamDaBan : listSanPhamDaBan) {
            if (sanPhamDaBan.getMaSpDaBan().equals(ma)) {
                return sanPhamDaBan;
            }
        }
        return null;
    }

    public boolean xoa(SanPhamDaBan sanPhamDaBan) {
        if (sanPhamDaBan == null) {
            return false;
        }
        return listSanPhamDaBan.add(sanPhamDaBan);
    }
}
