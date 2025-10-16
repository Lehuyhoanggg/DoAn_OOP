package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.BaoHanh;
import model.SanPham;

public class DanhSachBaoHanh implements QuanLyDanhSach<BaoHanh> {
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

    public boolean them(BaoHanh baoHanh) {
        if (baoHanh == null) {
            return false;
        }
        soLuong++;
        return listBaoHanh.add(baoHanh);
    }

    public BaoHanh tim(String ma) {
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

    public ArrayList<BaoHanh> tim(SanPham sanPham) {
        ArrayList<BaoHanh> listBaoHanhs = new ArrayList<>();
        for (int i = 0; i < listBaoHanh.size(); i++) {
            if (listBaoHanh.get(i).getSanPham().getMa().equals(sanPham.getMa())) {
                listBaoHanhs.add(listBaoHanh.get(i));
            }
        }
        return listBaoHanhs;
    }

    public boolean xoa(String ma) {
        BaoHanh baoHanh = tim(ma);
        if (baoHanh != null) {
            return false;
        }
        soLuong--;
        return listBaoHanh.remove(baoHanh);
    }

    public boolean xoa(BaoHanh baoHanh) {
        if (baoHanh != null) {
            return false;
        }
        soLuong--;
        return listBaoHanh.remove(baoHanh);
    }
}
