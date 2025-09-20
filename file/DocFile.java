package file;

import java.io.BufferedReader;
import java.io.FileReader;
import database.Database;
import interfaces.Xuli_File_Datakhoidau;
import model.KhachHang;
import model.MaGiamGia;
import model.NhanVien;
import model.QuanLy;
import model.SanPham;
import service.HangThanhVienService;
import service.KhacHangService;
import service.MaGiamGiaService;
import service.NhanVienService;
import service.QuanLyService;
import service.SanPhamService;

public class DocFile implements Xuli_File_Datakhoidau {
    Database db;

    public DocFile(Database db) {
        this.db = db;
    }

    //////////////////////////////////  doc file tu datakhoidau
    public void doc_NhanVientxt(String path) {
        NhanVienService nvService = new NhanVienService(db.getListNhanVien());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                String maNV = thanhPhan[0];
                String cmnd = thanhPhan[1];
                String hoTen = thanhPhan[2];
                String ngaySinh = thanhPhan[3];
                String sdt = thanhPhan[4];
                String gioiTinh = thanhPhan[5];
                long luong = Long.parseLong(thanhPhan[6]);
                NhanVien nhanVien = new NhanVien(maNV, cmnd, hoTen, ngaySinh, sdt, gioiTinh, luong);
                nvService.themNhanVien(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_QuanLytxt(String path) {
        QuanLyService qlService = new QuanLyService(db.getListQuanLy());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                String maQL = thanhPhan[0];
                String cmnd = thanhPhan[1];
                String hoTen = thanhPhan[2];
                String ngaySinh = thanhPhan[3];
                String sdt = thanhPhan[4];
                String gioiTinh = thanhPhan[5];
                QuanLy quanLy = new QuanLy(maQL, cmnd, hoTen, ngaySinh, sdt, gioiTinh);
                qlService.themQuanLy(quanLy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_SanPhantxt(String path) {
        SanPhamService spService = new SanPhamService(db.getListSanPham());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                String ten = thanhPhan[1];
                String danhMuc = thanhPhan[2];
                String thuongHieu = thanhPhan[3];
                long gia = Long.parseLong(thanhPhan[4]);
                int tonKho = Integer.parseInt(thanhPhan[5]);
                String moTa = thanhPhan[6];
                int trangThai = Integer.parseInt(thanhPhan[7]);
                SanPham newSp = new SanPham(ma, ten, danhMuc, thuongHieu, gia, tonKho, moTa, trangThai);
                spService.themSanPham(newSp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHangtxt(String path) {
        KhacHangService khService = new KhacHangService(db.getListKhachHang());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                String maKh = thanhPhan[0];
                String tenKh = thanhPhan[1];
                String sdt = thanhPhan[2];
                String hangThanhVien = thanhPhan[3];
                HangThanhVienService htvService = new HangThanhVienService(db.getListHangThanhVien());
                long tienDaChi = Long.parseLong(thanhPhan[4]);
                KhachHang khachHang = new KhachHang(maKh, tenKh, sdt, htvService.timHangThanhVien(hangThanhVien),
                        tienDaChi);
                khService.themKhachHang(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_MaGiamGiatxt(String path) {
        MaGiamGiaService maGgService = new MaGiamGiaService(db.getListMaGiamGia());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                String tenMa = thanhPhan[1];
                String loaiDoanhMuc = thanhPhan[2];
                String loaiThuongHieu = thanhPhan[3];
                long soTienGiam = Long.parseLong(thanhPhan[4]);
                String ngayBatDau = thanhPhan[5];
                String ngayKetThuc = thanhPhan[6];
                MaGiamGia maGiamGia = new MaGiamGia(ma, tenMa, loaiDoanhMuc, loaiThuongHieu, soTienGiam, ngayBatDau,
                        ngayKetThuc);
                maGgService.themMaGiamGia(maGiamGia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_ChiTietHoaDontxt(String path) {

    }

    public void doc_ChiTietHoaDon_BaoHanhtxt(String path) {

    }

    public void doc_ChiTietHoaDon_SanPhamtxt(String path) {

    }

    public void docDataKhoiDauVaoDatabase() {

    }

    ////////////////////////////////
    public static void docDataVaoDatabase() {

    }
}
