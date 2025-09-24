package service;

import java.util.ArrayList;

import model.SanPham;

public class SanPhamService {
    ArrayList<SanPham> listSanPham;

    public SanPhamService(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public void themSanPham(SanPham sanPham) {

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
