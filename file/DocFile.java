package file;

import java.io.BufferedReader;
import java.io.FileReader;
import database.Database;
import interfaces.Xuli_File_Datakhoidau;
import model.*;
import service.*;

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
        ChiTietHoaDonService service = new ChiTietHoaDonService(db.getListChiTietHoaDon());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                service.themChiTietHoaDon(new ChiTietHoaDon(thanhPhan[0], Long.parseLong(thanhPhan[1])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_BaoHanhtxt(String path) {
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                baoHanhService
                        .themBaoHanh(new BaoHanh(thanhPhan[0], thanhPhan[1], khacHangService.timKhachHang(thanhPhan[2]),
                                sanPhamService.timSanPham(thanhPhan[3]), thanhPhan[4], thanhPhan[5]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_ChiTietHoaDon_BaoHanhtxt(String path) {
        ChiTietHoaDonService hdService = new ChiTietHoaDonService(db.getListChiTietHoaDon());
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                ChiTietHoaDon chiTietHoaDon = hdService.timChiTietHoaDon(thanhPhan[0]);
                for (int i = 1; i < thanhPhan.length; i++) {
                    BaoHanh baoHanh = baoHanhService.timBaoHanh(thanhPhan[i]);
                    chiTietHoaDon.themBaoHanh(baoHanh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_ChiTietHoaDon_SanPhamtxt(String path) {
        ChiTietHoaDonService chiTietHoaDonService = new ChiTietHoaDonService(db.getListChiTietHoaDon());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                ChiTietHoaDon chiTietHoaDon = chiTietHoaDonService.timChiTietHoaDon(thanhPhan[0]);
                for (int i = 0; i < thanhPhan.length; i++) {
                    chiTietHoaDon.themSanPham(sanPhamService.timSanPham(thanhPhan[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_HangThanhVientxt(String path) {
        HangThanhVienService hangThanhVienService = new HangThanhVienService(db.getListHangThanhVien());
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(db.getListMaGiamGia());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                HangThanhVien hangThanhVien = new HangThanhVien(thanhPhan[0]);
                for (int i = 1; i < thanhPhan.length; i++) {
                    hangThanhVien.themMaGiamGia(maGiamGiaService.timMaGiamGia(thanhPhan[i]));
                }
                hangThanhVienService.themHangThanhVien(hangThanhVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_LichTrongNgaytxt(String path){
        LichLamViecService lichLamViecService = new LichLamViecService(db.getLichTuan());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                LichTrongNgay lichTrongNgay = new LichTrongNgay(Integer.parseInt( thanhPhan[0]),thanhPhan[1]);
                lichLamViecService.getLichLamViec().
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

    public void doc_LichLamViectxt(String path) {///////////////

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_PhieuBaoHanhtxt(String path) {
        PhieuBaoHanhService phieuBaoHanhservice = new PhieuBaoHanhService(db.getListPhieuBaoHanh());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                phieuBaoHanhservice
                        .themPhieuBaoHanh(new PhieuBaoHanh(thanhPhan[0], khacHangService.timKhachHang(thanhPhan[1]),
                                sanPhamService.timSanPham(thanhPhan[2]), thanhPhan[3], thanhPhan[4]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_TaiKhoantxt(String path) {
        TaiKhoanService taiKhoanService = new TaiKhoanService(db.getListTaiKhoan());
        UserService userService = new UserService(db.getListNhanVien(), db.getListQuanLy());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thanhPhan = line.split("\\s+");
                TaiKhoan taiKhoan = new TaiKhoan(thanhPhan[0], thanhPhan[1], thanhPhan[2]);
                userService.ganTaiKhoanChoUser(taiKhoan);
                taiKhoanService.themTaiKhoan(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void docDataKhoiDauVaoDatabase() {
        // TODO: Đọc tất cả các file cần thiết và nạp vào Database
    }

    ////////////////////////////////
    public static void docDataVaoDatabase() {

    }
}
