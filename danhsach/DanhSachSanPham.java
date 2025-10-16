package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.SanPham;

public class DanhSachSanPham implements QuanLyDanhSach<SanPham> {
    private ArrayList<SanPham> listSanPham;
    private int soLuong = 0;

    public DanhSachSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public DanhSachSanPham() {
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean them(SanPham sanPham) {
        if (sanPham == null) {
            return false;
        }
        soLuong++;
        return listSanPham.add(sanPham);
    }

    public boolean xoa(String ma) {
        if (listSanPham == null) {
            return false;
        }
        SanPham sanPham = tim(ma);
        if (sanPham == null) {
            return false;
        }
        soLuong--;
        return listSanPham.remove(sanPham);
    }

    public boolean xoa(SanPham sanPham) {
        if (listSanPham == null) {
            return false;
        }
        if (sanPham == null) {
            return false;
        }
        soLuong--;
        return listSanPham.remove(sanPham);
    }

    public SanPham timSanPhamTheoTen(String ten) {
        if (listSanPham == null) {
            return null;
        }
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getTen().equals(ten)) {
                return listSanPham.get(i);
            }
        }
        return null;
    }

    public SanPham tim(String ma) {
        if (listSanPham == null) {
            return null;
        }
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getMa().equals(ma)) {
                return listSanPham.get(i);
            }
        }
        return null;
    }
}
