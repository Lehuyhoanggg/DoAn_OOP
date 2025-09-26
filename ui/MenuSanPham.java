package ui;

import java.util.ArrayList;

import database.Database;
import model.SanPham;
import service.SanPhamService;
import util.TaoDoiTuong;

public class MenuSanPham {
    private Database db;

    public MenuSanPham(Database db) {
        this.db = db;
    }

    public void hienThiTatCaSanPham() {
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        System.out.println("Danh sach san pham:");
        for (SanPham sp : sanPhamService.getListSanPham()) {
            System.out.println(sp);
        }
    }

    public void themSanPham() {
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        SanPham sp = TaoDoiTuong.taoSanPham();
        if (sanPhamService.themSanPham(sp)) {
            System.out.println("Them san pham thanh cong!");
        } else {
            System.out.println("Them san pham khong thanh cong!");
        }

    }

    public void xoaSanPham() {
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        String ma = Nhap.nhapStr("Nhap ma san pham can xoa: ");
        if (sanPhamService.xoaSanPham(ma)) {
            System.out.println("Xoa san pham thanh cong!");
        } else {
            System.out.println("Xoa san pham khong thanh cong!");
        }

    }

    ///// sua san pham
    public void xuatSuaSanPham() {
        System.out.println("===== Menu Sua San Pham =====");
        System.out.println("1. Sua ten san pham");
        System.out.println("2. Sua danh muc");
        System.out.println("3. Sua thuong hieu");
        System.out.println("4. Sua gia");
        System.out.println("5. Sua so luong ton kho");
        System.out.println("6. Sua mo ta");
        System.out.println("7. Sua trang thai");
        System.out.println("0. Thoat");
    }

    private void suaThanhPhanSanPham(SanPham sp, int chon) {
        switch (chon) {
            case 1:
                sp.setTen(Nhap.nhapStr("Nhap ten san pham moi: "));
                System.out.println("Da thay doi");
                break;
            case 2:
                sp.setDanhMuc(Nhap.nhapStr("Nhap danh muc moi: "));
                System.out.println("Da thay doi");
                break;
            case 3:
                sp.setThuongHieu(Nhap.nhapStr("Nhap thuong hieu moi: "));
                System.out.println("Da thay doi");
                break;
            case 4:
                sp.setGia(Nhap.nhapLong("Nhap gia moi: "));
                System.out.println("Da thay doi");
                break;
            case 5:
                sp.setTonKho(Nhap.nhapInt("Nhap so luong ton kho moi: "));
                System.out.println("Da thay doi");
                break;
            case 6:
                sp.setMoTa(Nhap.nhapStr("Nhap mo ta moi: "));
                System.out.println("Da thay doi");
                break;
            case 7:
                sp.setTrangThai(Nhap.nhapStr("Nhap trang thai moi: "));
                System.out.println("Da thay doi");
                break;
            case 0:
                System.out.println("Thoat sua san pham");
                break;
            default:
                System.out.println("Lua chon khong hop le");
        }
    }

    public void suaSanPham() {
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        SanPham sp = sanPhamService.timSanPham(Nhap.nhapStr("Nhap ma san pham can sua"));
        if (sp == null) {
            System.out.println("khong tim thay ma san pham");
            return;
        }
        int xacNhan = 1;
        while (xacNhan == 1) {
            xuatSuaSanPham();
            int chon = Nhap.nhapInt("Chon muc can sua: ");
            suaThanhPhanSanPham(sp, chon);
            xacNhan = Nhap.nhapInt("(1)Tiep tuc sua (Khac)Thoat");
        }
    }

    //////////
    public void traCuuSanPham() {
        String tuKhoa = Nhap.nhapStr("Nhap tu khoa de tim : ");
        boolean timThay = false;
        ArrayList<SanPham> listSanPham = db.getListSanPham();
        if (listSanPham == null || listSanPham.size() == 0) {
            System.out.println("khong tim thay san pham");
            return;
        }
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getTen().contains(tuKhoa)) {
                timThay = true;
                System.out.println(i + ". " + listSanPham.get(i).getMa() + " " + listSanPham.get(i).getTen() + " "
                        + listSanPham.get(i).getGia() + " " + listSanPham.get(i).getThuongHieu());
            }
        }

        if (timThay) {
            int luaChon = Nhap.nhapInt("lua chon san pham de hien thi : ");
            if (listSanPham.size() > luaChon && 0 <= luaChon) {
                System.out.println(listSanPham.get(luaChon));
            } else {
                System.out.println("lua chon khong hop le");
            }
        } else {
            // neu tim theo ten khong thay thi tim theo ma
            for (int i = 0; i < listSanPham.size(); i++) {
                if (listSanPham.get(i).getMa().equals(tuKhoa)) {
                    System.out.println(i + ". " + listSanPham.get(i).getMa() + " " + listSanPham.get(i).getTen()
                            + " " + listSanPham.get(i).getGia() + " " + listSanPham.get(i).getThuongHieu());

                    timThay = true;
                    break;
                }
            }

        }

        if (!timThay) {
            System.out.println("khong tim thay san pham");
        }

    }

    private void xuatMenu() {
        System.out.println("===== MENU SAN PHAM =====");
        System.out.println("1. Hien thi tat ca san pham");
        System.out.println("2. Them san pham");
        System.out.println("3. Xoa san pham");
        System.out.println("4. Sua san pham");
        System.out.println("5. Tra cuu san pham");
        System.out.println("0. Thoat Menu");
    }

    private void thucHienChucNang(int choice) {
        switch (choice) {
            case 0 -> System.out.println("Da thoat Menu!");
            case 1 -> hienThiTatCaSanPham();
            case 2 -> themSanPham();
            case 3 -> xoaSanPham();
            case 4 -> suaSanPham();
            case 5 -> traCuuSanPham();
            default -> System.out.println("Lua chon khong hop le");
        }
    }

    public void menu() {
        int thoat = 1;
        while (thoat == 1) {
            xuatMenu();
            int choice = Nhap.nhapInt("Nhap lua chon: ");
            thucHienChucNang(choice);
            thoat = Nhap.nhapXacNhanThoat();
        }
    }
}
