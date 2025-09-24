package ui;

import model.User;
import model.NhanVien;
import java.util.ArrayList;
import service.TaiKhoanService;
import database.Database;
import file.DocFile;
import file.GhiFile;
import interfaces.GiaoTiep;
import interfaces.LamViec;
import service.MaGiamGiaService;
import service.NhanVienService;
import model.MaGiamGia;

public class MenuNhanVien implements LamViec{
    //
    private Database db;
    private NhanVien nv;
    public MenuNhanVien(Database db, NhanVien nv){
        this.db = db;
        this.nv = nv;
    }
 
    public void diemDanhCaLam(){

    }

    public void xemLichLamViec(){

    }

    public void traCuuThongTinKhachHang(){

    }

    public void taoHoaDon(){

    }

    public void taoPhieuTraHang(){

    }

    public void timKiemSanPham(){

    }

    public void TimKiemBaoHanh(){

    }

    public void taoBaoHanh(){

    }

    public void xemTatCaMaGiamGia(){
        ArrayList<MaGiamGia> listmGiamGia = db.getListMaGiamGia();
        System.out.println("list ma giam gia:");
        for(int i = 0; i < listmGiamGia.size(); i++){
            System.out.println(listmGiamGia.get(i));
        }
    }
    //
    public void doiMatKhau(){ // tai khoan service
        TaiKhoanService tKhoanService = new TaiKhoanService();
        System.out.println("doi mat khau:");
        String matKhauMoi = Nhap.nhapStr("mat khau moi");
        tKhoanService.doiMatKhau(matKhauMoi,nv.getTaiKhoan());
    }

    public void docDuLieuKhoiDau(){

    }
    public void doiTraHang(){

    }
    public void hienThiThongTin(){
        System.out.println(nv);
    }

    public void xuatMenu(){
        System.out.println("1. Hien thi thong tin");
        System.out.println("2. Diem danh ca lam");
        System.out.println("3. Tra cuu thong tin khanh hang");
        System.out.println("4. Tao hoa don");
        System.out.println("5. Doi/Tra hang");
        System.out.println("6. Tim kiem san pham");
        System.out.println("7. xem tat ca ma giam gia");
        System.out.println("8. Doc du lieu khoi dau");
        System.out.println("9. Xem lich lam trong tuan");
        System.out.println("10. Doi mat khau");
        System.out.println("11. tra cuu thong tin bao hanh");
        System.out.println("12. Tao phieu bao hanh");
        System.out.println("0. Thoat Menu");
    }
    //thuc hien chuc nang
    public void thucHienChucNang(int choice){
        switch (choice) {
            case 1 -> hienThiThongTin();
            case 2 -> diemDanhCaLam();
            case 3 -> traCuuThongTinKhachHang();
            case 4 -> taoHoaDon();
            case 5 -> doiTraHang();
            case 6 -> timKiemSanPham();
            case 7 -> xemTatCaMaGiamGia();
            case 8 -> docDuLieuKhoiDau();
            case 9 -> xemLichLamViec();
            case 10 -> doiMatKhau();
            case 11 -> TimKiemBaoHanh();
            case 12 -> taoBaoHanh();
            default -> System.out.println("Da thoat Menu!");
        }
    }
    //nhap lua chon thuc hien chuc nang  
    public void menu(){
        int thoat = 1;
        while(thoat == 1) {
            xuatMenu();
            int choice = Nhap.nhapInt("Nhap lua chon");
            thucHienChucNang(choice);
            thoat = Nhap.nhapXacNhanThoat();
        }
    }
}

/*1. Hien thi thong tin
2. Điểm danh ca lam
3. Tra cuu thong tin khach hang
4. Tao hoa don mua hang cho khach(Lấy sdt , check mã giảm giá , nếu chưa có thì tạo mới)
5. Doi / Tra Hàng 
6. Tim Kiem San Pham
7. Tra cuu khuyen mai giam gia kha dung
8. Doc du lieu khởi đầu
9. Xem lich Lam trong tuan
10. Đổi mật khẩu
11. Tra cuu thong tin bảo hành
12. Bảo hành sản phẩm (xem các đơn bảo hành đang nhận , tạo và lưu phiếu bảo hành)
0. Thoat */
