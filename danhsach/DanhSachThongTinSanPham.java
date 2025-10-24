package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.ThongTinSanPham;

public class DanhSachThongTinSanPham implements QuanLyDanhSach<ThongTinSanPham> {
    private ArrayList<ThongTinSanPham> listThongTinSanPham;
    private int soLuong = 0;

    public DanhSachThongTinSanPham(ArrayList<ThongTinSanPham> listSanPham) {
        this.listThongTinSanPham = listSanPham;
    }

    public DanhSachThongTinSanPham() {
    }

    public ArrayList<ThongTinSanPham> getListThongTinSanPham() {
        return listThongTinSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListThongTinSanPham(ArrayList<ThongTinSanPham> listSanPham) {
        this.listThongTinSanPham = listSanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean them(ThongTinSanPham sanPham) {
        if (sanPham == null) {
            return false;
        }
        soLuong++;
        return listThongTinSanPham.add(sanPham);
    }

    public boolean xoa(String ma) {
        if (listThongTinSanPham == null) {
            return false;
        }
        ThongTinSanPham sanPham = tim(ma);
        if (sanPham == null) {
            return false;
        }
        soLuong--;
        return listThongTinSanPham.remove(sanPham);
    }

    public boolean xoa(ThongTinSanPham sanPham) {
        if (listThongTinSanPham == null) {
            return false;
        }
        if (sanPham == null) {
            return false;
        }
        soLuong--;
        return listThongTinSanPham.remove(sanPham);
    }

    public ThongTinSanPham timSanPhamTheoTen(String ten) {
        if (listThongTinSanPham == null) {
            return null;
        }
        for (int i = 0; i < listThongTinSanPham.size(); i++) {
            if (listThongTinSanPham.get(i).getTen().equals(ten)) {
                return listThongTinSanPham.get(i);
            }
        }
        return null;
    }

    public ThongTinSanPham tim(String ma) {
        if (listThongTinSanPham == null) {
            return null;
        }
        for (int i = 0; i < listThongTinSanPham.size(); i++) {
            if (listThongTinSanPham.get(i).getMa().equals(ma)) {
                return listThongTinSanPham.get(i);
            }
        }
        return null;
    }
}
