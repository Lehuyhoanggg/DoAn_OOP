import model.User;
import repository.Datadabase;
import repository.DocFile;
import repository.GhiFile;
import service.TaiKhoanService;
import ui.MenuNhanVien;
import ui.MenuQuanLy;
import ui.Nhap;

public class Main {
    private User user;
    private Datadabase datadabase = new Datadabase();

    public Main() {
        user = null;
        DocFile.docDataVaoDatabase(datadabase);
    }

    public void dieuHuongMenu() {
        if (user.getQuyenHang() == "NhanVien") {
            MenuNhanVien menuNv = new MenuNhanVien();

        } else if (user.getQuyenHang() == "QuanLy") {
            MenuQuanLy menuQl = new MenuQuanLy();

        } else {
            System.out.println("Tai Khoan chua duoc cap quyen");
        }
    }

    public void dangNhap() {
        int dem = 0;
        TaiKhoanService taiKhoanService = new TaiKhoanService(datadabase.getListTaiKhoan());
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
        } while (user == null);
        dieuHuongMenu();
        System.out.println("Da thoat khoi chuong trinh");
    }

    public static void main(String[] args) {
        Main cellPhoneX = new Main();
        cellPhoneX.dangNhap();
        GhiFile.GhiDatabaseVaoData(cellPhoneX.datadabase);
    }
}
