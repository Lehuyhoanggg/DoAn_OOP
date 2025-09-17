package model;

import java.util.ArrayList;

public class ChiTietHoaDon {
    private String ma;
    private ArrayList<SanPham> listSanPham;
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;

    public ArrayList<PhieuBaoHanh> getListPhieuBaoHanh() {
        return listPhieuBaoHanh;
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public String getMa() {
        return ma;
    }

    public void setListPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

}
