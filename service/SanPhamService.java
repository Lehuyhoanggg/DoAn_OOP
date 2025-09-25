package service;

import java.util.ArrayList;
import model.SanPham;

public class SanPhamService {
    private ArrayList<SanPham> listSanPham;

    public SanPhamService(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public void themSanPham(SanPham sanPham) {
        listSanPham.add(sanPham);
    }

    public void xoaSanPham(String ma) {
        if (listSanPham == null)
            return;
        listSanPham.removeIf(sp -> sp.getMa().equals(ma));
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
