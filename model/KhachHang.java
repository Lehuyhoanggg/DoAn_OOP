package model;

import java.util.ArrayList;

public class KhachHang {
    private String maKh;
    private String tenKh;
    private String sdt;
    private HangThanhVien hangThanhVien;
    private DanhSachSanPham listSanDaMua;
    private long tienDaChi;
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;
    private ArrayList<BaoHanh> listBaoHanh;
    private ArrayList<MaGiamGia> listMaGiamGia;

    public KhachHang() {

    }

    public KhachHang(String maKh, String tenKh, String sdt, HangThanhVien hangThanhVien, long tienDaChi) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.hangThanhVien = hangThanhVien;
        this.tienDaChi = tienDaChi;
        this.listBaoHanh = new ArrayList<>();
        this.listSanDaMua = new DanhSachSanPham();
        this.listPhieuBaoHanh = new ArrayList<>();
        this.listMaGiamGia = new ArrayList<>();
        this.listMaGiamGia.addAll(hangThanhVien.getListMaGiamGiaDQ());
    }

    public KhachHang(String maKh, String tenKh, String sdt, HangThanhVien hangThanhVien) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.hangThanhVien = hangThanhVien;
        this.listBaoHanh = new ArrayList<>();
        this.listSanDaMua = new DanhSachSanPham();
        this.listPhieuBaoHanh = new ArrayList<>();
        this.listMaGiamGia = new ArrayList<>();
        this.listMaGiamGia.addAll(hangThanhVien.getListMaGiamGiaDQ());
    }

    public KhachHang(String maKh, String tenKh, String sdt) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.listBaoHanh = new ArrayList<>();
        this.listSanDaMua = new DanhSachSanPham();
        this.listPhieuBaoHanh = new ArrayList<>();
        this.listMaGiamGia = new ArrayList<>();
        this.listMaGiamGia.addAll(hangThanhVien.getListMaGiamGiaDQ());
    }

    public void setHangThanhVien(HangThanhVien hangThanhVien) {
        this.hangThanhVien = hangThanhVien;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public void setListPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public void setListSanDaMua(DanhSachSanPham listSanDaMua) {
        this.listSanDaMua = listSanDaMua;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setListMaGiamGia(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public void setTienDaChi(long tienDaChi) {
        this.tienDaChi = tienDaChi;
    }

    public HangThanhVien getHangThanhVien() {
        return hangThanhVien;
    }

    public ArrayList<BaoHanh> getListBaoHanh() {
        return listBaoHanh;
    }

    public ArrayList<PhieuBaoHanh> getListPhieuBaoHanh() {
        return listPhieuBaoHanh;
    }

    public ArrayList<MaGiamGia> getListMaGiamGia() {
        return listMaGiamGia;
    }

    public DanhSachSanPham getListSanDaMua() {
        return listSanDaMua;
    }

    public String getMaKh() {
        return maKh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getTenKh() {
        return tenKh;
    }

    public long getTienDaChi() {
        return tienDaChi;
    }

    public boolean themBaoHanh(BaoHanh baoHanh) {
        if (baoHanh == null) {
            return false;
        }
        return listBaoHanh.add(baoHanh);
    }

    public boolean themPhieuBaoHanh(PhieuBaoHanh phieuBaoHanh) {
        if (phieuBaoHanh == null) {
            return false;
        }
        return listPhieuBaoHanh.add(phieuBaoHanh);
    }

    public boolean themMaGiamGia(MaGiamGia maGiamGia) {
        if (maGiamGia == null) {
            return false;
        }
        return listMaGiamGia.add(maGiamGia);
    }
}
