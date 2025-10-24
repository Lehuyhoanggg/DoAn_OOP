package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.SanPham;

public class DanhSachSanPham implements QuanLyDanhSach<SanPham> {
    private ArrayList<SanPham> listSanPham;

    public DanhSachSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public DanhSachSanPham() {
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public boolean them(SanPham sanPham) {
        if (sanPham == null) {
            return false;
        }
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
        return listSanPham.remove(sanPham);
    }

    public boolean xoa(SanPham sanPham) {
        if (listSanPham == null) {
            return false;
        }
        if (sanPham == null) {
            return false;
        }
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
            if (listSanPham.get(i).getSerial().equals(ma)) {
                return listSanPham.get(i);
            }
        }
        return null;
    }

    public SanPham timSanPhamChuaBan(String serial) {
        if (listSanPham == null) {
            return null;
        }
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getSerial().equals(serial) && !listSanPham.get(i).getDaBan()
                    && !listSanPham.get(i).getTraHang()) {
                return listSanPham.get(i);
            }
        }
        return null;
    }
}
