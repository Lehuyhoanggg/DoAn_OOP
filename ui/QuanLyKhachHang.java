package ui;

import java.util.ArrayList;

import danhsach.DanhSachHangThanhVien;
import danhsach.DanhSachKhachHang;
import database.Database;
import model.BaoHanh;
import model.HangThanhVien;
import model.HoaDon;
import model.KhachHang;
import model.MaGiamGia;
import model.PhieuBaoHanh;
import model.PhieuTraHang;
import util.TaoDoiTuong;
import util.XoaManHinh;

public class QuanLyKhachHang {
    private Database db;
    ArrayList<KhachHang> listKhachHang;

    public QuanLyKhachHang(Database db) {
        this.db = db;
        this.listKhachHang = db.getListKhachHang();
    }

    public void taoKhachHang() {
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        KhachHang khachHang = TaoDoiTuong.taoKhachHang(db);
        danhSachKhachHang.themKhachHang(khachHang);
        System.out.println("Da tao khach hang thanh cong");
    }

    private void xuatListTrongKhachHang(KhachHang khachHang) {
        ArrayList<BaoHanh> listBaoHanh = khachHang.getListBaoHanh();
        ArrayList<PhieuBaoHanh> listPhieuBaoHanh = khachHang.getListPhieuBaoHanh();
        ArrayList<MaGiamGia> listMaGiamGia = khachHang.getListMaGiamGia();
        ArrayList<HoaDon> listHoaDon = khachHang.getListHoaDon();
        ArrayList<PhieuTraHang> listPhieuTraHang = khachHang.getListPhieuTraHang();

        if (!listBaoHanh.isEmpty()) {
            System.out.println("Danh sach Bao Hanh:");
            for (BaoHanh bh : listBaoHanh) {
                System.out.println(bh);
            }
        }

        if (!listPhieuBaoHanh.isEmpty()) {
            System.out.println("Danh sach Phieu Bao Hanh:");
            for (PhieuBaoHanh pbh : listPhieuBaoHanh) {
                System.out.println(pbh);
            }
        }

        if (!listMaGiamGia.isEmpty()) {
            System.out.println("Danh sach Ma Giam Gia:");
            for (MaGiamGia mg : listMaGiamGia) {
                System.out.println(mg);
            }
        }

        if (!listHoaDon.isEmpty()) {
            System.out.println("Danh sach Hoa Don:");
            for (HoaDon hd : listHoaDon) {
                System.out.println(hd);
            }
        }

        if (!listPhieuTraHang.isEmpty()) {
            System.out.println("Danh sach Phieu Tra Hang:");
            for (PhieuTraHang pth : listPhieuTraHang) {
                System.out.println(pth);
            }
        }
    }

    public void traCuuThongTinKhachHang() {
        String tuKhoa = Nhap.nhapStr("Nhap tu khoa de tim : ");
        boolean timThay = false;
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();

        if (listKhachHang == null || listKhachHang.size() == 0) {
            System.out.println("khong tim thay khach hang");
            return;
        }

        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getSdt().contains(tuKhoa)) {
                timThay = true;
                System.out.println(i + ". " + listKhachHang.get(i).getMaKh() + " " + listKhachHang.get(i).getTenKh()
                        + " " + listKhachHang.get(i).getSdt());
            }
        }

        if (timThay) {
            int luaChon = Nhap.nhapInt("lua chon khach hang de hien thi : ");
            if (listKhachHang.size() > luaChon || 0 < luaChon) {
                System.out.println("---------------------------");
                System.out.println(listKhachHang.get(luaChon));
                xuatListTrongKhachHang(listKhachHang.get(luaChon));
                System.out.println("---------------------------");
            } else {
                System.out.println("lua chon khong hop le");
            }
        } else {
            // neu tim theo ten khong thay thi tim theo ma
            for (int i = 0; i < listKhachHang.size(); i++) {
                if (listKhachHang.get(i).getMaKh().equals(tuKhoa)) {
                    System.out.println("---------------------------");
                    System.out.println(listKhachHang.get(i));
                    xuatListTrongKhachHang(listKhachHang.get(i));
                    System.out.println("---------------------------");
                    timThay = true;
                    break;
                }
            }
            if (!timThay) {
                for (int i = 0; i < listKhachHang.size(); i++) {
                    if (listKhachHang.get(i).getTenKh().contains(tuKhoa)) {
                        timThay = true;
                        System.out.println(
                                i + ". " + listKhachHang.get(i).getMaKh() + " " + listKhachHang.get(i).getTenKh()
                                        + " " + listKhachHang.get(i).getSdt());
                    }
                }
                if (timThay) {
                    int luaChon = Nhap.nhapInt("lua chon khach hang de hien thi : ");
                    if (listKhachHang.size() > luaChon || 0 < luaChon) {
                        System.out.println("---------------------------");
                        System.out.println(listKhachHang.get(luaChon));
                        xuatListTrongKhachHang(listKhachHang.get(luaChon));
                        System.out.println("---------------------------");
                    } else {
                        System.out.println("lua chon khong hop le");
                    }
                }
            }

        }

        if (!timThay) {
            System.out.println("khong tim thay khach hang");
        }
    }

    public void xoaKhachHang() {
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        String ma = Nhap.nhapStr("Nhap ma khach hang can xoa : ");
        if (listKhachHang == null || listKhachHang.size() == 0) {
            System.out.println("Khong co khach hang de xoa");
            return;
        }
        if (danhSachKhachHang.xoaKhachHang(ma)) {
            System.out.println("Xoa khach hang thanh cong");
        } else {
            System.out.println("Xoa khong thanh cong");
        }
    }

    private void suaThanhPhanKhachHang(KhachHang khachHang, int luaChon) {
        switch (luaChon) {
            case 0:
                System.out.println("Thoat sua khach hang");
                break;
            case 1:
                khachHang.setTenKh(Nhap.nhapStr("Nhap ten khach hang de thay doi : "));
                System.out.println("Da thay doi");
                break;
            case 2:
                khachHang.setSdt(Nhap.nhapStr("Nhap so dien thoai de thay doi : "));
                System.out.println("Da thay doi");
                break;
            case 3:
                DanhSachHangThanhVien danhSachHangThanhVien = db.getDanhSachHangThanhVien();
                HangThanhVien hangThanhVienMoi = danhSachHangThanhVien
                        .timHangThanhVien(Nhap.nhapStr("Nhap hang thanh vien moi : "));
                if (hangThanhVienMoi == null) {
                    System.out.println("Khong tim thay hang thanh vien");
                    return;
                }
                khachHang.setHangThanhVien(hangThanhVienMoi);
                System.out.println("Da thay doi");
                break;
            default:
                break;
        }
    }

    public void xemTatCaKhachHang() {
        for (int i = 0; i < listKhachHang.size(); i++) {
            System.out.println(listKhachHang.get(i));
        }
    }

    private void xuatSuaKhachHang() {
        System.out.println("1. Sua ten khach hang");
        System.out.println("2. Sua so dien thoai");
        System.out.println("3. Sua hang thanh vien");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    public void suaThongTinKhachHang() {
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        KhachHang khachHang = danhSachKhachHang.timKhachHang(Nhap.nhapStr("Nhap ma khach hang can sau : "));
        if (khachHang == null) {
            System.out.println("Khong tim thay khach hang");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            System.out.println();
            System.out.println("------------------------");
            System.out.println(khachHang);
            System.out.println("------------------------");
            xuatSuaKhachHang();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon == 0) {
                return;
            }
            suaThanhPhanKhachHang(khachHang, luaChon);
            Nhap.pause();
        }
    }

    private void xuatMenu() {
        System.out.println("1. Tao khach hang");
        System.out.println("2. Tra cuu thong tin khach hang");
        System.out.println("3. Xoa khach hang");
        System.out.println("4. Sua thong tin khach hang");
        System.out.println("5. Xem tat ca khach hang");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    private void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 0:
                System.out.println("Da thoat");
                break;
            case 1:
                taoKhachHang();
                break;
            case 2:
                traCuuThongTinKhachHang();
                break;
            case 3:
                xoaKhachHang();
                break;
            case 4:
                suaThongTinKhachHang();
                break;
            case 5:
                xemTatCaKhachHang();
                break;
            default:
                break;
        }
    }

    public void menu() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            XoaManHinh.xoa();
            xuatMenu();
            int luaChon = Nhap.nhapInt("Nhap lua Chon : ");
            if (luaChon == 0) {
                return;
            }
            thucHienChucNang(luaChon);
            Nhap.pause();
        }
    }
}
