package database;;

import java.util.ArrayList;

import model.BaoHanh;
import model.ChiTietHoaDon;
import model.HangThanhVien;
import model.HoaDon;
import model.KhachHang;
import model.LichLamViec;
import model.MaGiamGia;
import model.NhanVien;
import model.PhieuBaoHanh;
import model.QuanLy;
import model.SanPham;
import model.TaiKhoan;

public class Database {
    private ArrayList<NhanVien> listNhanVien;
    private ArrayList<QuanLy> listQuanLy;
    private ArrayList<HoaDon> listHoaDon;
    private ArrayList<TaiKhoan> listTaiKhoan;
    private ArrayList<SanPham> listSanPham;
    private ArrayList<ChiTietHoaDon> listChiTietHoaDon;
    private ArrayList<BaoHanh> listBaoHanh;
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;
    private ArrayList<KhachHang> listKhachHang;
    private ArrayList<MaGiamGia> listMaGiamGia;
    private ArrayList<HangThanhVien> listHangThanhVien;
    private LichLamViec lichTuan;

    public Database() {
        listNhanVien = new ArrayList<>();
        listQuanLy = new ArrayList<>();
        listHoaDon = new ArrayList<>();
        listTaiKhoan = new ArrayList<>();
        listSanPham = new ArrayList<>();
        listChiTietHoaDon = new ArrayList<>();
        listPhieuBaoHanh = new ArrayList<>();
        listKhachHang = new ArrayList<>();
        listMaGiamGia = new ArrayList<>();
        lichTuan = new LichLamViec();
        listHangThanhVien = new ArrayList<>();
        listBaoHanh = new ArrayList<>();
    }

    public ArrayList<HangThanhVien> getListHangThanhVien() {
        return listHangThanhVien;
    }

    public LichLamViec getLichTuan() {
        return lichTuan;
    }

    public ArrayList<BaoHanh> getListBaoHanh() {
        return listBaoHanh;
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public ArrayList<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public ArrayList<KhachHang> getListKhachHang() {
        return listKhachHang;
    }

    public ArrayList<MaGiamGia> getListMaGiamGia() {
        return listMaGiamGia;
    }

    public ArrayList<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public ArrayList<PhieuBaoHanh> getListPhieuBaoHanh() {
        return listPhieuBaoHanh;
    }

    public ArrayList<QuanLy> getListQuanLy() {
        return listQuanLy;
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public ArrayList<TaiKhoan> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public void setLichTuan(LichLamViec lichTuan) {
        this.lichTuan = lichTuan;
    }

    public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public void setListKhachHang(ArrayList<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }

    public void setListMaGiamGia(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public void setListPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public void setListHangThanhVien(ArrayList<HangThanhVien> listHangThanhVien) {
        this.listHangThanhVien = listHangThanhVien;
    }

    public void setListQuanLy(ArrayList<QuanLy> listQuanLy) {
        this.listQuanLy = listQuanLy;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public void setListTaiKhoan(ArrayList<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }
}
