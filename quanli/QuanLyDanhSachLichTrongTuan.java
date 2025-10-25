package quanli;

import danhsach.DanhSachLichTrongTuan;
import database.Database;
import model.LichTrongTuan;
import util.CapMa;
import util.Nhap;
import util.ThoiGian;
import util.XoaManHinh;

public class QuanLyDanhSachLichTrongTuan {
    private Database db;
    DanhSachLichTrongTuan danhSachLichTrongTuan;

    public QuanLyDanhSachLichTrongTuan(Database db) {
        this.db = db;
        danhSachLichTrongTuan = db.getDanhSachLichTrongTuan();
    }

    public LichTrongTuan taoLichTrongTuan(int soTuan) {
        LichTrongTuan lichTrongTuan = new LichTrongTuan();
        lichTrongTuan.setListLichTrongNgay(
                db.getDanhSachLichTrongNgay().taoListLichTrongNgay(db, ThoiGian.layNgayDauTuanStr(soTuan)));
        lichTrongTuan.setMa(CapMa.capMaLichTrongTuan(db));
        lichTrongTuan.setNgayThu2(ThoiGian.layNgayDauTuanStr(soTuan));
        danhSachLichTrongTuan.them(lichTrongTuan);
        return lichTrongTuan;
    }

    public void xepLichLamViecTrongTuanNay() {
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.lichTrongTuanNay();
        if (lichTrongTuan == null) {
            System.out.println("Chua co lich trong tuan nay ban co muon tao moi khong?");
            System.out.println("(1)Co (khac)Khong : ");
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon != 1) {
                return;
            }
            lichTrongTuan = taoLichTrongTuan(ThoiGian.soTuanHienTai());
        }
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
        quanLyLichTrongTuan.xepLichLamViec();
    }

    public void xepLichLamViecTrongTuanSau() {
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.tim(ThoiGian.soTuanHienTai() + 1);
        if (lichTrongTuan == null) {
            System.out.println("Chua co lich trong tuan sau ban co muon tao moi khong?");
            System.out.println("(1)Co (khac)Khong : ");
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon != 1) {
                return;
            }
            lichTrongTuan = taoLichTrongTuan(ThoiGian.soTuanHienTai() + 1);
        }
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
        quanLyLichTrongTuan.xepLichLamViec();
    }

    public void luaChonXepLich() {
        int soTuan = Nhap.nhapInt("Nhap so tuan can xep lich : ");
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.tim(soTuan);
        if (lichTrongTuan == null) {
            System.out.println("Chua co lich trong tuan " + soTuan + " ban co muon tao moi khong?");
            System.out.println("(1)Co (khac)Khong : ");
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon != 1) {
                return;
            }
            lichTrongTuan = taoLichTrongTuan(soTuan);
        }
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
        quanLyLichTrongTuan.xepLichLamViec();
    }

    public void thucHienChucNangXepLich(int luaChon) {
        switch (luaChon) {
            case 1:
                xepLichLamViecTrongTuanNay();
                break;
            case 2:
                xepLichLamViecTrongTuanSau();
                break;
            case 3:
                luaChonXepLich();
            default:
                break;
        }
    }

    public void xuatMenuXepLich() {
        System.out.println("1. Xep lich cho tuan nay");
        System.out.println("2. Xep lich cho tuan sau");
        System.out.println("3. Lua chon tuan de xep");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    public void xepLichLamViec() {
        while (true) {
            XoaManHinh.xoa();
            xuatMenuXepLich();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon == 0) {
                return;
            }
            thucHienChucNangXepLich(luaChon);
            ////////////
            Nhap.pause();
        }
    }

    public void xemLichLamViecTrongTuanNay() {
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.lichTrongTuanNay();
        if (lichTrongTuan == null) {
            System.out.println("Chua tao lich tuan nay");
            return;
        }
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
        quanLyLichTrongTuan.xemLichLamViec();
    }

    public void luaChonXemLich() {
        int soTuan = Nhap.nhapInt("Nhap so tuan trong nam de xem lich");
        LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.tim(soTuan);
        if (lichTrongTuan == null) {
            System.out.println("lich cua tuan " + soTuan + " chua duoc tao");
            return;
        }
        QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
        quanLyLichTrongTuan.xemLichLamViec();
    }

    public void thucHienChucNangXemLich(int luaChon) {
        switch (luaChon) {
            case 1:
                xemLichLamViecTrongTuanNay();
                break;
            case 2:
                luaChonXemLich();
                break;
            default:
                break;
        }
    }

    public void xuatMenuXemLich() {
        System.out.println("1. Xem lich lam viec tuan nay");
        System.out.println("2. Lua chon xem lich");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    public void xuatMenuQlLich() {
        System.out.println("1. Quan li lich tuan nay");
        System.out.println("2. lich can quan li");
        System.out.println("3. Thoat");
    }

    public void thucHienChucNangQuanLi(int luaChon) {
        switch (luaChon) {
            case 1:
                LichTrongTuan lichTrongTuan = danhSachLichTrongTuan.lichTrongTuanNay();
                QuanLyLichTrongTuan quanLyLichTrongTuan = new QuanLyLichTrongTuan(db, lichTrongTuan);
                quanLyLichTrongTuan.menu();
                break;
            case 2:
                for (int i = 0; i < danhSachLichTrongTuan.getListLichTrongTuan().size(); i++) {
                    LichTrongTuan lich = danhSachLichTrongTuan.getListLichTrongTuan().get(i);
                    System.out.println(i + ". " + " so tuan " + ThoiGian.laySoTuanTrongNam(lich.getNgayThu2()) + "  "
                            + lich.getNgayCn() + " " + lich.getNgayThu2());
                }
                int chon = Nhap.nhapInt("Nhap lua chon : ");
                if (chon >= 0 && chon < danhSachLichTrongTuan.getListLichTrongTuan().size()) {
                    QuanLyLichTrongTuan qlLich = new QuanLyLichTrongTuan(db,
                            danhSachLichTrongTuan.getListLichTrongTuan().get(chon));
                    qlLich.menu();
                } else {
                    System.out.println("Lua chon khong hop le");
                }
                break;
            default:
                break;
        }
    }

    public void quanLyLichTrongTuan() {
        while (true) {
            XoaManHinh.xoa();
            xuatMenuQlLich();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon == 0) {
                return;
            }
            thucHienChucNangQuanLi(luaChon);
        }
    }

    public void xemLichLamViec() {
        while (true) {
            XoaManHinh.xoa();
            xuatMenuXemLich();
            int luaChon = Nhap.nhapInt("Nhap lua chon : ");
            if (luaChon == 0) {
                return;
            }
            thucHienChucNangXemLich(luaChon);
            ////////////
        }
    }

    public void thucHienChucNang(int luaChon) {
        switch (luaChon) {
            case 1:
                xemLichLamViec();
                break;
            case 2:
                xepLichLamViec();
                break;
            case 3:
                quanLyLichTrongTuan();
                break;
            default:
                break;
        }
    }

    public void xuatMenu() {
        System.out.println("1. Xem lich lam viec");
        System.out.println("2. Xep lich lam viec");
        System.out.println("3. Quan ly lich lam viec");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
    }

    public void menu() {
        while (true) {
            XoaManHinh.xoa();
            xuatMenu();
            int luaChon = Nhap.nhapInt("Hay nhap lua chon : ");
            if (luaChon == 0) {
                break;
            }
            thucHienChucNang(luaChon);

        }
    }

}
