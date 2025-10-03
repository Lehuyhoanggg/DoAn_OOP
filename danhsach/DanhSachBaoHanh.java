package danhsach;

import java.util.ArrayList;

import model.BaoHanh;
import model.SanPham;

public class DanhSachBaoHanh {
    private ArrayList<BaoHanh> listBaoHanh;
    private int soLuong = 0;

    public DanhSachBaoHanh() {
    }

    public DanhSachBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public ArrayList<BaoHanh> getListBaoHanh() {
        return listBaoHanh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean themBaoHanh(BaoHanh baoHanh) {
        if (baoHanh == null) {
            return false;
        }
        soLuong++;
        return listBaoHanh.add(baoHanh);
    }

    public BaoHanh timBaoHanh(String ma) {
        if (listBaoHanh == null) {
            return null;
        }
        for (int i = 0; i < listBaoHanh.size(); i++) {
            if (listBaoHanh.get(i).getMaBh().equals(ma)) {
                return listBaoHanh.get(i);
            }
        }
        return null;
    }

    public ArrayList<BaoHanh> timBaoHanh(SanPham sanPham) {
        ArrayList<BaoHanh> listBaoHanhs = new ArrayList<>();
        for (int i = 0; i < listBaoHanh.size(); i++) {
            if (listBaoHanh.get(i).getSanPham().equals(sanPham)) {
                listBaoHanhs.add(listBaoHanh.get(i));
            }
        }
        return listBaoHanhs;
    }

    public boolean xoaBaoHanh(String ma) {
        BaoHanh baoHanh = timBaoHanh(ma);
        if (baoHanh != null) {
            return false;
        }
        soLuong--;
        return listBaoHanh.remove(baoHanh);
    }
}
