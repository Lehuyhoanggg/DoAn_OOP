package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.HangThanhVien;
import model.KhachHang;
import model.MaGiamGia;

public class DanhSachHangThanhVien implements QuanLyDanhSach<HangThanhVien> {
    private ArrayList<HangThanhVien> listHangThanhVien;
    private int soLuong = 0;

    public DanhSachHangThanhVien(ArrayList<HangThanhVien> listHangThanhVien) {
        this.listHangThanhVien = listHangThanhVien;
    }

    public ArrayList<HangThanhVien> getListHangThanhVien() {
        return listHangThanhVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListHangThanhVien(ArrayList<HangThanhVien> listHangThanhVien) {
        this.listHangThanhVien = listHangThanhVien;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public HangThanhVien tim(String ten) {
        if (listHangThanhVien == null) {
            return null;
        }
        for (int i = 0; i < listHangThanhVien.size(); i++) {
            if (listHangThanhVien.get(i).getTenHang().equals(ten)) {
                return listHangThanhVien.get(i);
            }
        }
        return null;
    }

    public boolean them(HangThanhVien hangThanhVien) {
        if (hangThanhVien == null || tim(hangThanhVien.getTenHang()) != null) {
            return false; // đã tồn tại hoac truyen null vao
        }
        soLuong++;
        return listHangThanhVien.add(hangThanhVien);
    }

    public boolean xoa(String ten) {
        HangThanhVien htv = tim(ten);
        if (htv != null) {
            return listHangThanhVien.remove(htv);
        }
        soLuong--;
        return false;
    }

    public boolean xoa(HangThanhVien htv) {
        if (htv != null) {
            return listHangThanhVien.remove(htv);
        }
        soLuong--;
        return false;
    }

    public void setHangThanhVienChoKhachHang(KhachHang khachHang) {
        HangThanhVien hangThanhVien = null;
        long tienDaChi = khachHang.getTienDaChi();
        if (tienDaChi >= HangThanhVien.mucDong && tienDaChi < HangThanhVien.mucBac
                && tienDaChi < HangThanhVien.mucVang) {
            hangThanhVien = tim("Dong");
            khachHang.setHangThanhVien(hangThanhVien);
        } else if (tienDaChi >= HangThanhVien.mucBac && tienDaChi < HangThanhVien.mucVang) {
            hangThanhVien = tim("Bac");
            khachHang.setHangThanhVien(hangThanhVien);
        } else {
            hangThanhVien = tim("Vang");
            khachHang.setHangThanhVien(hangThanhVien);
        }
        if (hangThanhVien == null) {
            return;
        }
        DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(khachHang.getListMaGiamGia());

        for (int i = khachHang.getListMaGiamGia().size() - 1; i >= 0; i--) {
            MaGiamGia maGiamGia = khachHang.getListMaGiamGia().get(i);
            if (danhSachMaGiamGia.laMaGiamGiaDocQuyen(maGiamGia)) {
                danhSachMaGiamGia.xoa(maGiamGia);
            }
        }
        danhSachMaGiamGia.getListMaGiamGia().addAll(hangThanhVien.getListMaGiamGiaDQ());
    }
}