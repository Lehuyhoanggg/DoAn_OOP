package ui;

import database.Database;
import model.HangThanhVien;
import model.KhachHang;
import service.KhacHangService;
import service.SanPhamService;
import service.HangThanhVienService;
import util.TaoDoiTuong;

public class MenuHangThanhVien {
    private Database db;

    public MenuHangThanhVien(Database db) {
        this.db = db;
    }

    public void hienThiTatCaHangThanhVien() {
        System.out.println("DANH SACH HANG THANH VIEN");
        HangThanhVienService service = new HangThanhVienService(db.getListHangThanhVien());
        if (db.getListHangThanhVien().size() == 0) {
            System.out.println("Khong tim thay hang thanh vien nao");
            return;
        }
        for (int i = 0; i < db.getListHangThanhVien().size(); i++) {
            System.out.println(db.getListHangThanhVien().get(i));
        }
    }

    public void taoHangThanhVien() {
        HangThanhVienService service = new HangThanhVienService(db.getListHangThanhVien());
        HangThanhVien htv = TaoDoiTuong.taoHangThanhVien(db);
        if (service.themHangThanhVien(htv)) {
            System.out.println("Tao hang thanh vien thanh cong!");
        } else {
            System.out.println("Tao hang thanh vien that bai!");
        }
    }

    public void xoaHangThanhVien() {
        HangThanhVienService service = new HangThanhVienService(db.getListHangThanhVien());
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien can xoa: ");
        if (service.xoaHangThanhVien(ten)) {
            System.out.println("Xoa hang thanh vien thanh cong!");
        } else {
            System.out.println("Khong tim thay hang thanh vien hoac xoa that bai!");
        }
    }

    public void suaChiTietHangThanhVien(HangThanhVien htv) {
        System.out.println("Nhap thong tin moi (de trong neu khong muon sua)");
        String tenMoi = Nhap.nhapStr("Nhap ten hang thanh vien: ");
        if (!tenMoi.isEmpty()) {
            htv.setTenHang(tenMoi);
        }
        String moTaMoi = Nhap.nhapStr("Nhap mo ta: ");
        if (!moTaMoi.isEmpty()) {
            htv.setMoTa(moTaMoi);
        }
        String hangMoi = Nhap.nhapStr("Nhap hang moi (de trong neu khong muon sua): ");
        if (!hangMoi.isEmpty()) {
            // Them ma giam gia cho hang thanh vien
            // Tim ma giam gia trong database
        }
        System.out.println("Sua hang thanh vien thanh cong!");
    }

    public void suaThanhPhanHangThanhVien(int luachon) {
        switch (luachon) {
            case 1:
                HangThanhVienService service = new HangThanhVienService(db.getListHangThanhVien());
                String ten = Nhap.nhapStr("Nhap ten hang thanh vien: ");
                HangThanhVien htv = service.timHangThanhVien(ten);
                if (htv == null) {
                    System.out.println("Khong tim thay hang thanh vien!");
                } else {
                    System.out.println("Thong tin hang thanh vien: ");
                    System.out.println(htv);
                }
                break;
            case 2:
                themMaGiamGiaChoHangThanhVien();
                break;
            case 0:
                System.out.println("Thoat sua hang thanh vien");
        }

    }

    public void themMaGiamGiaChoHangThanhVien() {
        System.out.println("THEM MA GIAM GIA CHO HANG THANH VIEN");
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien can them ma giam gia: ");
        HangThanhVienService service = new HangThanhVienService(db.getListHangThanhVien());
        HangThanhVien htv = service.timHangThanhVien(ten);
        if (htv == null) {
            System.out.println("Khong tim thay hang thanh vien!");
            return;
        }
        String maGiamGia = Nhap.nhapStr("Nhap ma giam gia can them: ");
        // Tim ma giam gia trong database
        // Neu tim thay thi them vao hang thanh vien
        System.out.println("Them ma giam gia cho hang thanh vien thanh cong!");
    }

    public void suaHangThanhVien() {
        System.out.println("===== SUA HANG THANH VIEN =====");
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien can sua: ");
        HangThanhVienService service = new HangThanhVienService(db.getListHangThanhVien());
        HangThanhVien htv = service.timHangThanhVien(ten);
        if (htv == null) {
            System.out.println("Khong tim thay hang thanh vien!");
            return;
        }
        suaChiTietHangThanhVien(htv);

    }

    public void traCuuHangThanhVien() {
        System.out.println("TRA CUU HANG THANH VIEN");
        String ten = Nhap.nhapStr("Nhap ten hang thanh vien can tra cuu: ");
        HangThanhVienService service = new HangThanhVienService(db.getListHangThanhVien());
        HangThanhVien htv = service.timHangThanhVien(ten);
        if (htv == null) {
            System.out.println("Khong tim thay hang thanh vien!");
            return;
        }
        System.out.println("Thong tin hang thanh vien: ");
        System.out.println(htv);
    }

    public void xemTatCaHangThanhVien() {
        System.out.println("DANH SACH HANG THANH VIEN");
        HangThanhVienService service = new HangThanhVienService(db.getListHangThanhVien());
        if (db.getListHangThanhVien().size() == 0) {
            System.out.println("Khong tim thay hang thanh vien nao");
            return;
        }
        for (int i = 0; i < db.getListHangThanhVien().size(); i++) {
            System.out.println(db.getListHangThanhVien().get(i));
        }
    }

    public void menu() {
        int tiep = 1;
        while (tiep == 1) {
            xuatMenu();
            int chon = Nhap.nhapInt("Nhap lua chon: ");
            switch (chon) {
                case 1:
                    taoHangThanhVien();
                    break;
                case 2:
                    xoaHangThanhVien();
                    break;
                case 3:
                    traCuuHangThanhVien();
                    break;
                case 4:
                    suaHangThanhVien();
                    break;
                case 5:
                    xemTatCaHangThanhVien();
                    break;
                case 6:
                    themMaGiamGiaChoHangThanhVien();
                    break;
                case 0:
                    System.out.println("Thoat menu hang thanh vien");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
            if (tiep == 1) {
                tiep = Nhap.nhapInt("(1) Tiep tuc (khac) Thoat: ");
            }
        }
    }

    public void xuatMenu() {
        System.out.println("1. Tao hang thanh vien moi");
        System.out.println("2. Xoa hang thanh vien");
        System.out.println("3. Tra cuu hang thanh vien");
        System.out.println("4. Sua hang thanh vien");
        System.out.println("5. hien thi thong tin tat ca hang thanh vien");
        System.out.println("6. Them ma giam gia cho hang thanh vien");
        System.out.println("0. Thoat");
    }
}
// xoa
// sua
// tra cuu
// hien thi tat ca