import database.Database;
import file.GhiFile;
import model.NhanVien;
import model.QuanLy;
import model.User;
import service.TaiKhoanService;
import ui.MenuNhanVien;
import ui.MenuQuanLy;
import ui.Nhap;

public class Main {
    private User user;
    private Database db = new Database();

    public Main() {
        user = null;
    }

    public void dieuHuongMenu() {
        if (user.getQuyenHang() == "NhanVien") {
            MenuNhanVien menuNhanVien = new MenuNhanVien(db, (NhanVien) user);
            menuNhanVien.menu();
        } else if (user.getQuyenHang() == "QuanLy") {
            MenuQuanLy menuQuanLy = new MenuQuanLy(db, (QuanLy) user);
            menuQuanLy.menu();
        } else {
            System.out.println("Tai Khoan chua duoc cap quyen");
        }
    }

    public void dangNhap() {
        int xacNhan = 1;
        do {
            int dem = 0;
            TaiKhoanService taiKhoanService = new TaiKhoanService(db.getListTaiKhoan());
            String tenTaiKhoan;
            String matKhau;
            do {
                if (dem == 3) {
                    break;
                }
                dem++;
                tenTaiKhoan = Nhap.nhapStr("Tai khoan : ");
                matKhau = Nhap.nhapStr("Mat khau : ");
                user = taiKhoanService.layUserBangTk(tenTaiKhoan, matKhau);
                if (user == null) {
                    System.out.println("Tai khoan hoac mat khau khong khong dung vui long nhap lai");
                }

            } while (user == null);
            dieuHuongMenu();
            dem = 0;
            xacNhan = Nhap.nhapInt("(1)Tiep tuc dang nhap (khac)Thoat");
        } while (xacNhan == 1);
        System.out.println("Da thoat khoi chuong trinh");
    }

    public static void main(String[] args) {
        Main cellPhoneX = new Main();
        cellPhoneX.dangNhap();
        GhiFile.GhiDatabaseVaoData();

    }
}
