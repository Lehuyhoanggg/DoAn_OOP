package danhsach;

import java.util.ArrayList;
import model.SanPham;

public class DanhSachSanPham {
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

    public boolean themSanPham(SanPham sanPham) {
        if (sanPham == null) {
            return false;
        }
        soLuong++;
        return listSanPham.add(sanPham);
    }

    public boolean xoaSanPham(String ma) {
        if (listSanPham == null) {
            return false;
        }
        SanPham sanPham = timSanPham(ma);
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

    public SanPham timSanPham(String ma) {
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
