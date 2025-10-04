package database;

import java.util.ArrayList;

import danhsach.DanhSachBaoHanh;
import danhsach.DanhSachCaLam;
import danhsach.DanhSachChiTietHoaDon;
import danhsach.DanhSachHangThanhVien;
import danhsach.DanhSachHoaDon;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachLichLamViec;
import danhsach.DanhSachLichTrongNgay;
import danhsach.DanhSachMaGiamGia;
import danhsach.DanhSachNhanVien;
import danhsach.DanhSachPhieuBaoHanh;
import danhsach.DanhSachPhieuTraHang;
import danhsach.DanhSachQuanLy;
import danhsach.DanhSachSanPham;
import danhsach.DanhSachTaiKhoan;
import danhsach.DanhSachTinNhan;
import danhsach.DanhSachUser;
import file.DocFile;
import model.BaoHanh;
import model.CaLam;
import model.ChiTietHoaDon;
import model.HangThanhVien;
import model.HoaDon;
import model.KhachHang;
import model.LichLamViec;
import model.LichTrongNgay;
import model.MaGiamGia;
import model.NhanVien;
import model.PhieuBaoHanh;
import model.PhieuTraHang;
import model.QuanLy;
import model.SanPham;
import model.TaiKhoan;
import model.TinNhan;
import model.User;

public class Database {
    // danh sach
    private DanhSachNhanVien danhSachNhanVien;
    private LichLamViec lichTuan;
    private DanhSachQuanLy danhSachQuanLy;
    private DanhSachHoaDon danhSachHoaDon;
    private DanhSachTaiKhoan danhSachTaiKhoan;
    private DanhSachSanPham danhSachSanPham;
    private DanhSachChiTietHoaDon danhSachChiTietHoaDon;
    private DanhSachBaoHanh danhSachBaoHanh;
    private DanhSachPhieuBaoHanh danhSachPhieuBaoHanh;
    private DanhSachPhieuTraHang danhSachPhieuTraHang;
    private DanhSachKhachHang danhSachKhachHang;
    private DanhSachMaGiamGia danhSachMaGiamGia;
    private DanhSachMaGiamGia danhSachMaGiamGiaDq;
    private DanhSachHangThanhVien danhSachHangThanhVien;
    private DanhSachTinNhan danhSachTinNhan;
    private DanhSachCaLam danhSachCaLam;
    private DanhSachLichTrongNgay danhSachLichTrongNgay;
    private DanhSachLichLamViec danhSachLichLamViec;
    private DanhSachUser danhSachUser;

    public Database() {
        DocFile docFile = new DocFile(this);
        danhSachNhanVien = new DanhSachNhanVien(new ArrayList<NhanVien>());
        danhSachQuanLy = new DanhSachQuanLy(new ArrayList<QuanLy>());
        danhSachHoaDon = new DanhSachHoaDon(new ArrayList<HoaDon>());
        danhSachTaiKhoan = new DanhSachTaiKhoan(new ArrayList<TaiKhoan>());
        danhSachSanPham = new DanhSachSanPham(new ArrayList<SanPham>());
        danhSachChiTietHoaDon = new DanhSachChiTietHoaDon(new ArrayList<ChiTietHoaDon>());
        danhSachBaoHanh = new DanhSachBaoHanh(new ArrayList<BaoHanh>());
        danhSachPhieuBaoHanh = new DanhSachPhieuBaoHanh(new ArrayList<PhieuBaoHanh>());
        danhSachPhieuTraHang = new DanhSachPhieuTraHang(new ArrayList<PhieuTraHang>());
        danhSachKhachHang = new DanhSachKhachHang(new ArrayList<KhachHang>());
        danhSachMaGiamGia = new DanhSachMaGiamGia(new ArrayList<MaGiamGia>());
        danhSachMaGiamGiaDq = new DanhSachMaGiamGia(new ArrayList<MaGiamGia>());
        danhSachHangThanhVien = new DanhSachHangThanhVien(new ArrayList<HangThanhVien>());
        danhSachTinNhan = new DanhSachTinNhan(new ArrayList<TinNhan>());
        danhSachCaLam = new DanhSachCaLam(new ArrayList<CaLam>());
        danhSachLichTrongNgay = new DanhSachLichTrongNgay(new ArrayList<LichTrongNgay>());
        danhSachLichLamViec = new DanhSachLichLamViec(lichTuan);
        docFile.doc_DatasVaoDatabase();
        lichTuan = new LichLamViec();
    }

    public void taoDanhSachUser() {
        danhSachUser = new DanhSachUser(getListUser());
    }

    // ===== GET =====
    public ArrayList<NhanVien> getListNhanVien() {
        return danhSachNhanVien.getListNhanVien();
    }

    public ArrayList<QuanLy> getListQuanLy() {
        return danhSachQuanLy.getListQuanLy();
    }

    public ArrayList<HoaDon> getListHoaDon() {
        return danhSachHoaDon.getListHoaDon();
    }

    public ArrayList<TaiKhoan> getListTaiKhoan() {
        return danhSachTaiKhoan.getListTaiKhoan();
    }

    public ArrayList<SanPham> getListSanPham() {
        return danhSachSanPham.getListSanPham();
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
        return danhSachChiTietHoaDon.getListChiTietHoaDon();
    }

    public ArrayList<BaoHanh> getListBaoHanh() {
        return danhSachBaoHanh.getListBaoHanh();
    }

    public ArrayList<PhieuBaoHanh> getListPhieuBaoHanh() {
        return danhSachPhieuBaoHanh.getListPhieuBaoHanh();
    }

    public ArrayList<PhieuTraHang> getListPhieuTraHang() {
        return danhSachPhieuTraHang.getListPhieuTraHang();
    }

    public ArrayList<KhachHang> getListKhachHang() {
        return danhSachKhachHang.getListKhachHang();
    }

    public ArrayList<MaGiamGia> getListMaGiamGia() {
        return danhSachMaGiamGia.getListMaGiamGia();
    }

    public ArrayList<MaGiamGia> getListMaGiamGiaDq() {
        return danhSachMaGiamGiaDq.getListMaGiamGia();
    }

    public ArrayList<HangThanhVien> getListHangThanhVien() {
        return danhSachHangThanhVien.getListHangThanhVien();
    }

    public ArrayList<TinNhan> getListTinNhan() {
        return danhSachTinNhan.getListTinNhan();
    }

    public ArrayList<CaLam> getListCaLam() {
        return danhSachCaLam.getListCaLam();
    }

    public ArrayList<LichTrongNgay> getListLichTrongNgay() {
        return danhSachLichTrongNgay.getListLichTrongNgay();
    }

    public LichLamViec getLichTuan() {
        return lichTuan;
    }

    // ===== SET =====
    public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
        danhSachNhanVien.setListNhanVien(listNhanVien);
    }

    public void setListQuanLy(ArrayList<QuanLy> listQuanLy) {
        danhSachQuanLy.setListQuanLy(listQuanLy);
    }

    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
        danhSachHoaDon.setListHoaDon(listHoaDon);
    }

    public void setListTaiKhoan(ArrayList<TaiKhoan> listTaiKhoan) {
        danhSachTaiKhoan.setListTaiKhoan(listTaiKhoan);
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        danhSachSanPham.setListSanPham(listSanPham);
    }

    public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        danhSachChiTietHoaDon.setListChiTietHoaDon(listChiTietHoaDon);
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        danhSachBaoHanh.setListBaoHanh(listBaoHanh);
    }

    public void setListPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        danhSachPhieuBaoHanh.setListPhieuBaoHanh(listPhieuBaoHanh);
    }

    public void setListPhieuTraHang(ArrayList<PhieuTraHang> listPhieuTraHang) {
        danhSachPhieuTraHang.setListPhieuTraHang(listPhieuTraHang);
    }

    public void setListKhachHang(ArrayList<KhachHang> listKhachHang) {
        danhSachKhachHang.setListKhachHang(listKhachHang);
    }

    public void setListMaGiamGia(ArrayList<MaGiamGia> listMaGiamGia) {
        danhSachMaGiamGia.setListMaGiamGia(listMaGiamGia);
    }

    public void setListMaGiamGiaDq(ArrayList<MaGiamGia> listMaGiamGiaDq) {
        danhSachMaGiamGiaDq.setListMaGiamGia(listMaGiamGiaDq);
    }

    public void setListHangThanhVien(ArrayList<HangThanhVien> listHangThanhVien) {
        danhSachHangThanhVien.setListHangThanhVien(listHangThanhVien);
    }

    public void setListTinNhan(ArrayList<TinNhan> listTinNhan) {
        danhSachTinNhan.setListTinNhan(listTinNhan);
    }

    public void setListCaLam(ArrayList<CaLam> listCaLam) {
        danhSachCaLam.setListCaLam(listCaLam);
    }

    public void setListLichTrongNgay(ArrayList<LichTrongNgay> listLichTrongNgay) {
        danhSachLichTrongNgay.setListLichTrongNgay(listLichTrongNgay);
    }

    public void setLichTuan(LichLamViec lichTuan) {
        this.lichTuan = lichTuan;
    }

    /// get set danh sach

    // ===== GET: các đối tượng DanhSach =====
    public DanhSachNhanVien getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public DanhSachUser getDanhSachUser() {
        return danhSachUser;
    }

    public DanhSachQuanLy getDanhSachQuanLy() {
        return danhSachQuanLy;
    }

    public DanhSachHoaDon getDanhSachHoaDon() {
        return danhSachHoaDon;
    }

    public DanhSachTaiKhoan getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    public DanhSachSanPham getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public DanhSachChiTietHoaDon getDanhSachChiTietHoaDon() {
        return danhSachChiTietHoaDon;
    }

    public DanhSachBaoHanh getDanhSachBaoHanh() {
        return danhSachBaoHanh;
    }

    public DanhSachPhieuBaoHanh getDanhSachPhieuBaoHanh() {
        return danhSachPhieuBaoHanh;
    }

    public DanhSachPhieuTraHang getDanhSachPhieuTraHang() {
        return danhSachPhieuTraHang;
    }

    public DanhSachKhachHang getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    public DanhSachMaGiamGia getDanhSachMaGiamGia() {
        return danhSachMaGiamGia;
    }

    public DanhSachMaGiamGia getDanhSachMaGiamGiaDq() {
        return danhSachMaGiamGiaDq;
    }

    public DanhSachHangThanhVien getDanhSachHangThanhVien() {
        return danhSachHangThanhVien;
    }

    public DanhSachTinNhan getDanhSachTinNhan() {
        return danhSachTinNhan;
    }

    public DanhSachLichLamViec getDanhSachLichLamViec() {
        return danhSachLichLamViec;
    }

    public DanhSachCaLam getDanhSachCaLam() {
        return danhSachCaLam;
    }

    public DanhSachLichTrongNgay getDanhSachLichTrongNgay() {
        return danhSachLichTrongNgay;
    }

    public void setDanhSachNhanVien(DanhSachNhanVien danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public void setDanhSachQuanLy(DanhSachQuanLy danhSachQuanLy) {
        this.danhSachQuanLy = danhSachQuanLy;
    }

    public void setDanhSachHoaDon(DanhSachHoaDon danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }

    public void setDanhSachTaiKhoan(DanhSachTaiKhoan danhSachTaiKhoan) {
        this.danhSachTaiKhoan = danhSachTaiKhoan;
    }

    public void setDanhSachSanPham(DanhSachSanPham danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public void setDanhSachChiTietHoaDon(DanhSachChiTietHoaDon danhSachChiTietHoaDon) {
        this.danhSachChiTietHoaDon = danhSachChiTietHoaDon;
    }

    public void setDanhSachBaoHanh(DanhSachBaoHanh danhSachBaoHanh) {
        this.danhSachBaoHanh = danhSachBaoHanh;
    }

    public void setDanhSachPhieuBaoHanh(DanhSachPhieuBaoHanh danhSachPhieuBaoHanh) {
        this.danhSachPhieuBaoHanh = danhSachPhieuBaoHanh;
    }

    public void setDanhSachPhieuTraHang(DanhSachPhieuTraHang danhSachPhieuTraHang) {
        this.danhSachPhieuTraHang = danhSachPhieuTraHang;
    }

    public void setDanhSachKhachHang(DanhSachKhachHang danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }

    public void setDanhSachMaGiamGia(DanhSachMaGiamGia danhSachMaGiamGia) {
        this.danhSachMaGiamGia = danhSachMaGiamGia;
    }

    public void setDanhSachMaGiamGiaDq(DanhSachMaGiamGia danhSachMaGiamGiaDq) {
        this.danhSachMaGiamGiaDq = danhSachMaGiamGiaDq;
    }

    public void setDanhSachHangThanhVien(DanhSachHangThanhVien danhSachHangThanhVien) {
        this.danhSachHangThanhVien = danhSachHangThanhVien;
    }

    public void setDanhSachTinNhan(DanhSachTinNhan danhSachTinNhan) {
        this.danhSachTinNhan = danhSachTinNhan;
    }

    public void setDanhSachCaLam(DanhSachCaLam danhSachCaLam) {
        this.danhSachCaLam = danhSachCaLam;
    }

    public void setDanhSachLichTrongNgay(DanhSachLichTrongNgay danhSachLichTrongNgay) {
        this.danhSachLichTrongNgay = danhSachLichTrongNgay;
    }

    public void setDanhSachLichLamViec(DanhSachLichLamViec danhSachLichLamViec) {
        this.danhSachLichLamViec = danhSachLichLamViec;
    }

    public ArrayList<User> getListUser() {
        ArrayList<User> listUser = new ArrayList<>();
        listUser.addAll(getListNhanVien());
        listUser.addAll(getListQuanLy());
        return listUser;
    }
}
