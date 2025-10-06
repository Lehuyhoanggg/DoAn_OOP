package ui;

import database.Database;
import model.CaLam;
import model.LichTrongTuan;
import model.LichTrongNgay;
import model.NhanVien;
import util.XoaManHinh;

import java.util.ArrayList;

import danhsach.DanhSachCaLam;
import danhsach.DanhSachLichTrongNgay;
import danhsach.DanhSachLichTrongTuan;
import danhsach.DanhSachNhanVien;

public class QuanLyLichTrongTuan {
    private Database db;
    private LichTrongTuan lichTrongTuan;

    public QuanLyLichTrongTuan(Database db, LichTrongTuan lichTrongTuan) {
        this.db = db;
        this.lichTrongTuan = lichTrongTuan;
    }

    // diem danh khi da co doi tuong nhan vien
    public boolean diemDanh(NhanVien nhanVien) {
        DanhSachCaLam danhSachCaLam = db.getDanhSachCaLam();
        DanhSachLichTrongTuan danhSachLichTrongTuan = db.getDanhSachLichTrongTuan();
        DanhSachLichTrongNgay danhSachLichTrongNgay = db.getDanhSachLichTrongNgay();
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.lichTrongTuanNay();
        if (lichTrongTuan == null) {
            return false;
        }
        LichTrongNgay lichTrongNgay = danhSachLichTrongNgay.lichTrongNgayHomNay();
        if (lichTrongNgay == null) {
            return false;
        }
        CaLam caLamHienTai = danhSachCaLam.caLamHienTai(lichTrongNgay);
        if (caLamHienTai == null) {
            return false;
        }
        return caLamHienTai.diemDanh(nhanVien);
    }

    // diem danh
    public boolean diemDanh() {
        NhanVien nhanVien = db.getDanhSachNhanVien().timNhanVien(Nhap.nhapStr("Nhap ma nhan vien can diem danh : "));
        return diemDanh(nhanVien);
    }

    private void xoaNhanVienKhoiCa(CaLam caLam) {
        if (caLam.soNguoiTrongCa() == 0) {
            System.out.println("Khong co nhan vien de xoa");
            return;
        }
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
        NhanVien nhanVien = danhSachNhanVien.timNhanVien(Nhap.nhapStr("Nhap ma nhan vien xoa khoi ca lam : "));
        if (nhanVien == null) {
            System.out.println("Khong tim thay nhan vien");
            return;
        }
        caLam.xoaNhanVienKhoiCa(nhanVien);
        System.out.println("Da xoa nhan vien khoi ca lam");
    }

    private void themNhanVienVaoCa(CaLam caLam) {
        if (caLam.caLamDuNguoi()) {
            System.out.println("Ca lam da du nguoi");
            return;
        }
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
        NhanVien nhanVien = danhSachNhanVien.timNhanVien(Nhap.nhapStr("Nhap ma nhan vien de them vao ca lam : "));
        if (nhanVien == null) {
            System.out.println("Khong tim thay nhan vien");
            return;
        }
        caLam.themNhanVienVaoCa(nhanVien);
        System.out.println("Da them nhan vien vao ca");
    }

    private void thucHienChucNangXepLich(int luaChon, CaLam caLam) {
        switch (luaChon) {
            case 1:
                themNhanVienVaoCa(caLam);
                break;
            case 2:
                xoaNhanVienKhoiCa(caLam);
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }

    // xep lich lam viec moi
    public void xepLichLamViec() {
        int xacNhan = 1;
        while (xacNhan == 1) {
            xemLichLamViec();
            int index = Nhap.nhapInt("Chon thu can chinh sua : ") - 2;
            LichTrongNgay lichTrongNgay = lichTrongTuan.getLichTuan().get(index);
            int soCa = Nhap.nhapInt("Nhap so CaLam can chinh sua : ");
            CaLam caLam = db.getDanhSachCaLam().timCaLam(soCa, lichTrongNgay);
            if (caLam == null) {
                System.out.println("Khong tim thay ca lam");
            } else {
                System.out.println("1. Them nhan vien vao ca");
                System.out.println("2. Xoa nhan vien khoi ca");
                System.out.println("0. Thoat");
                int luaChon = Nhap.nhapInt("Nhap lua chon : ");
                if (luaChon == 0) {
                    break;
                }
                thucHienChucNangXepLich(luaChon, caLam);
            }
        }
        xacNhan = Nhap.nhapInt("(1)Tiep tuc xep lich (khac)Thoat");
    }

    // xem tat ca lich lam viec
    public void xemLichLamViec() {
        ArrayList<LichTrongNgay> listLichTrongNgay = lichTrongTuan.getLichTuan();
        if (listLichTrongNgay == null || listLichTrongNgay.size() == 0) {
            System.out.println("Chua xep lich hom nao trong tuan");
            return;
        }
        for (int i = 0; i < listLichTrongNgay.size(); i++) {
            LichTrongNgay lichTrongNgay = listLichTrongNgay.get(i);
            System.out.println("Thu " + lichTrongNgay.getThu() + "      " + lichTrongNgay.getNgay());
            ArrayList<CaLam> listCaLam = lichTrongNgay.getListCaLam();
            for (int j = 0; j < listCaLam.size(); j++) {
                CaLam caLam = listCaLam.get(j);
                System.out
                        .println(
                                "   Ca " + caLam.getSo() + "    " + caLam.getGioBatDau() + " " + caLam.getGioKetThuc() +
                                        "   " + caLam.soNguoiTrongCa() + "/" + caLam.getSoLuongCan());

                if (!caLam.caLamChuaCoNguoi()) {
                    System.out.println("   " + "      gom :");
                    for (NhanVien nhanVien : caLam.getListNhanVien().getMapNhanVien().keySet()) {
                        System.out.println("   " + "        " + nhanVien.getMa() + " " + nhanVien.getTen());
                    }
                } else {
                    System.out.println("   " + "Trong");
                }
            }
        }
    }

    public void xemLichLamViecPro() {
        ArrayList<LichTrongNgay> listLichTrongNgay = lichTrongTuan.getLichTuan();
        if (listLichTrongNgay == null || listLichTrongNgay.size() == 0) {
            System.out.println("Chua xep lich hom nao trong tuan");
            return;
        }
        ArrayList<ArrayList<NhanVien>> ca1 = new ArrayList<>();

        for (int j = 0; j < 7; j++) {
            ca1.add(new ArrayList<>());
        }
        ArrayList<ArrayList<NhanVien>> ca2 = new ArrayList<>();
        for (int j = 0; j < 7; j++) {
            ca2.add(new ArrayList<>());
        }
        ArrayList<ArrayList<NhanVien>> ca3 = new ArrayList<>();
        for (int j = 0; j < 7; j++) {
            ca3.add(new ArrayList<>());
        }
        for (int i = 0; i < listLichTrongNgay.size(); i++) {
            LichTrongNgay lichTrongNgay = listLichTrongNgay.get(i);
            ArrayList<CaLam> listCaLam = lichTrongNgay.getListCaLam();

            for (int j = 0; j < listCaLam.size(); j++) {
                CaLam caLam = listCaLam.get(j);
                ArrayList<NhanVien> listNhanVien = null;
                if (caLam.getSo() == 1) {
                    listNhanVien = ca1.get(i);

                }
                if (caLam.getSo() == 2) {
                    listNhanVien = ca2.get(i);

                }
                if (caLam.getSo() == 3) {
                    listNhanVien = ca3.get(i);
                }
                for (NhanVien nhanVien : caLam.getListNhanVien().getMapNhanVien().keySet()) {
                    listNhanVien.add(nhanVien);
                }
            }

        }
        System.out.println("Lich lam viec cua nhan vien");
        System.out.println(lichTrongTuan.getNgayThu2() + " - " + lichTrongTuan.getNgayCn());
        System.out.println();
        // 5 3 3
        System.out.println("      " + "    Thu 2    " + "    Thu 3    " + "    Thu 4    " + "    Thu 5    "
                + "   Thu 6    " + "    Thu 7    " + "   Chu Nhat   ");
        for (int j = 0; j < 7; j++) {
            if (j == 0) {
                System.out.print("Ca 1  ");
            }
            if (j == 1) {
                System.out.print("06:00 ");
            }
            if (j == 2) {
                System.out.print("12:00 ");
            }
            if (ca1.get(j).size() < 3) {
                ca1.get(j).add(null);
            }
            if (ca1.get(j).get(0) == null) {
                System.out.print("             ");
            } else {
                System.out.printf("%-13s", ca1.get(j).get(0).getMa() + " " + ca1.get(j).get(0).get_ten());
            }
        }
        System.out.println();
        System.out.println();
        for (int j = 0; j < 7; j++) {
            if (j == 0) {
                System.out.print("Ca 2 ");
            }
            if (j == 1) {
                System.out.print("12:00 ");
            }
            if (j == 2) {
                System.out.print("18:00 ");
            }
            if (ca2.get(j).size() < 3) {
                ca2.get(j).add(null);
            }
            if (ca2.get(j).get(1) == null) {
                System.out.println("             ");
            } else {
                System.out.printf("%-13s", ca2.get(j).get(1).getMa() + " " + ca2.get(j).get(1).get_ten());
            }
        }
        System.out.println();
        System.out.println();
        for (int j = 0; j < 7; j++) {
            if (j == 0) {
                System.out.print("Ca 3 ");
            }
            if (j == 1) {
                System.out.print("18:00 ");
            }
            if (j == 2) {
                System.out.print("23:00 ");
            }
            if (ca3.get(j).size() < 3) {
                ca1.get(j).add(null);
            }
            if (ca3.get(j).get(2) == null) {
                System.out.println("             ");
            } else {
                System.out.printf("%-13s", ca3.get(j).get(2).getMa() + " " + ca3.get(j).get(2).get_ten());
            }
        }
    }

    public void thongKeDiemDanhTrongTuan() {
        for (LichTrongNgay lichTrongNgay : lichTrongTuan.getListLichTrongNgay()) {
            System.out.println(lichTrongNgay.getNgay());
            System.out.println("Thu " + lichTrongNgay.getThu());
            for (CaLam caLam : lichTrongNgay.getListCaLam()) {
                System.out.println("ca " + caLam.getSo() + ": ");
                for (NhanVien nhanVien : caLam.getListNhanVien().getMapNhanVien().keySet()) {
                    System.out.println("Nhan Vien : " + nhanVien.getMa() + " " + nhanVien.getTen()
                            + (caLam.getListNhanVien().kiemTraDiemDanh(nhanVien) ? "Da diem danh " : "Chua diem danh"));
                }
            }
        }
    }

    // menu hien thi
    private void xuatMenu() {
        System.out.println("\nQUAN LY LICH LAM VIEC");
        System.out.println("1. Thong ke diem danh trong tuan");
        System.out.println("2. Xep lich lam viec");
        System.out.println("3. Xem lich lam viec");
        System.out.println("0. Thoat");
    }

    private void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 0 -> System.out.println("Thoat menu lich lam viec");
            case 1 -> thongKeDiemDanhTrongTuan();
            case 2 -> xepLichLamViec();
            case 3 -> xemLichLamViec();
            default -> System.out.println("Lua chon khong hop le");
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

    public static void main(String[] args) {
        Database db = new Database();
        DanhSachLichTrongTuan danhSachLichTrongTuan = db.getDanhSachLichTrongTuan();
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, danhSachLichTrongTuan.lichTrongTuanNay());
        quanLyLichTrongTuan.xemLichLamViecPro();
    }
}
