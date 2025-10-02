package file;

import java.io.BufferedReader;
import java.io.FileReader;
import database.Database;
import interfaces.DocFile_Datas;
import model.*;
import service.*;

public class DocFile implements DocFile_Datas {
    Database db;

    public DocFile(Database db) {
        this.db = db;
    }

    //////////////////////////////////  doc file tu datas
    public void doc_NhanVientxt(String path) {
        NhanVienService nvService = new NhanVienService(db.getListNhanVien());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
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
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
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

    public void doc_SanPhamtxt(String path) {
        SanPhamService spService = new SanPhamService(db.getListSanPham());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                String ten = thanhPhan[1];
                String danhMuc = thanhPhan[2];
                String thuongHieu = thanhPhan[3];
                long gia = Long.parseLong(thanhPhan[4]);
                int tonKho = Integer.parseInt(thanhPhan[5]);
                String moTa = thanhPhan[6];
                String trangThai = thanhPhan[7];
                SanPham newSp = new SanPham(ma, ten, danhMuc, thuongHieu, gia, tonKho, moTa, trangThai);
                spService.themSanPham(newSp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_MaGiamGiatxt(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            MaGiamGiaService maGgService = new MaGiamGiaService(db.getListMaGiamGia());
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                String tenMa = thanhPhan[1];
                String loaiDoanhMuc = thanhPhan[2];
                String loaiThuongHieu = thanhPhan[3];
                String tienGiam = thanhPhan[4];
                String ngayBatDau = thanhPhan[5];
                String ngayKetThuc = thanhPhan[6];
                MaGiamGia maGiamGia = new MaGiamGia(ma, tenMa, loaiDoanhMuc, loaiThuongHieu, tienGiam, ngayBatDau,
                        ngayKetThuc);
                if (maGgService.laMaGiamGiaDocQuyen(maGiamGia)) {
                    MaGiamGiaService maGiamGiaServiceDq = new MaGiamGiaService(db.getListMaGiamGiaDq());
                    maGiamGiaServiceDq.themMaGiamGia(maGiamGia);
                    continue;
                }
                maGgService.themMaGiamGia(maGiamGia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_HangThanhVientxt(String path) {
        HangThanhVienService hangThanhVienService = new HangThanhVienService(db.getListHangThanhVien());
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(db.getListMaGiamGiaDq());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                HangThanhVien hangThanhVien = new HangThanhVien(thanhPhan[0], thanhPhan[1]);
                for (int i = 2; i < thanhPhan.length; i++) {
                    hangThanhVien.themMaGiamGia(maGiamGiaService.timMaGiamGia(thanhPhan[i]));
                }
                hangThanhVienService.themHangThanhVien(hangThanhVien);
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
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String maKh = thanhPhan[0];
                String tenKh = thanhPhan[1];
                String sdt = thanhPhan[2];
                String hangThanhVien = thanhPhan[3];
                HangThanhVienService htvService = new HangThanhVienService(db.getListHangThanhVien());
                KhachHang khachHang = new KhachHang(maKh, tenKh, sdt, htvService.timHangThanhVien(hangThanhVien));
                khService.themKhachHang(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_BaoHanhtxt(String path) {
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                baoHanhService
                        .themBaoHanh(new BaoHanh(thanhPhan[0], thanhPhan[1], sanPhamService.timSanPham(thanhPhan[2]),
                                Long.parseLong(thanhPhan[3])));
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
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                phieuBaoHanhservice
                        .themPhieuBaoHanh(new PhieuBaoHanh(thanhPhan[0], khacHangService.timKhachHang(thanhPhan[1]),
                                sanPhamService.timSanPham(thanhPhan[2]), thanhPhan[3], thanhPhan[4]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_PhieuTraHangtxt(String path) {
        PhieuTraHangService phieuTraHangService = new PhieuTraHangService(db.getListPhieuTraHang());
        SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                phieuTraHangService
                        .themPhieuTraHang(new PhieuTraHang(thanhPhan[0], khacHangService.timKhachHang(thanhPhan[1]),
                                sanPhamService.timSanPham(thanhPhan[2]), thanhPhan[3], thanhPhan[4]));
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
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                service.themChiTietHoaDon(new ChiTietHoaDon(thanhPhan[0], Long.parseLong(thanhPhan[1])));
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
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                ChiTietHoaDon chiTietHoaDon = chiTietHoaDonService.timChiTietHoaDon(thanhPhan[0]);
                if (chiTietHoaDon == null) {
                    continue;
                }
                for (int i = 0; i < thanhPhan.length; i++) {
                    chiTietHoaDon.themSanPham(sanPhamService.timSanPham(thanhPhan[i]));
                }
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
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                ChiTietHoaDon chiTietHoaDon = hdService.timChiTietHoaDon(thanhPhan[0]);
                if (chiTietHoaDon == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    BaoHanh baoHanh = baoHanhService.timBaoHanh(thanhPhan[i]);
                    chiTietHoaDon.themBaoHanh(baoHanh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_ChiTietHoaDon_MaGiamGiatxt(String path) {
        ChiTietHoaDonService hdService = new ChiTietHoaDonService(db.getListChiTietHoaDon());
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(db.getListMaGiamGia());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                ChiTietHoaDon chiTietHoaDon = hdService.timChiTietHoaDon(thanhPhan[0]);
                if (chiTietHoaDon == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    MaGiamGia maGiamGia = maGiamGiaService.timMaGiamGia(thanhPhan[i]);
                    chiTietHoaDon.themMaGiamGiaDaDung(maGiamGia);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_HoaDontxt(String path) {
        HoaDonService hoaDonService = new HoaDonService(db.getListHoaDon());
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        ChiTietHoaDonService chiTietHoaDonService = new ChiTietHoaDonService(db.getListChiTietHoaDon());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                KhachHang khachHang = khacHangService.timKhachHang(thanhPhan[1]);
                ChiTietHoaDon chiTietHoaDon = chiTietHoaDonService.timChiTietHoaDon(thanhPhan[2]);
                String ngayTaoHoaDon = thanhPhan[3];
                String ghiChu = thanhPhan[4];
                hoaDonService
                        .themHoaDon(new HoaDon(ma, khachHang, chiTietHoaDon, ngayTaoHoaDon, ghiChu));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_PhieuBaoHanhtxt(String path) {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        PhieuBaoHanhService phieuBaoHanhService = new PhieuBaoHanhService(db.getListPhieuBaoHanh());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = khacHangService.timKhachHang(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    khachHang.themPhieuBaoHanh(phieuBaoHanhService.timPhieuBaoHanh(thanhPhan[i]));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_BaoHanhtxt(String path) {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        BaoHanhService baoHanhService = new BaoHanhService(db.getListBaoHanh());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = khacHangService.timKhachHang(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                BaoHanh baoHanh = baoHanhService.timBaoHanh(thanhPhan[1]);
                if (baoHanh != null) {
                    baoHanh.setNgayBatDau(thanhPhan[2]);
                }
                baoHanh.setNgayKetThuc();
                khachHang.themBaoHanh(baoHanh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_MaGiamGiatxt(String path) {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        MaGiamGiaService maGiamGiaService = new MaGiamGiaService(db.getListMaGiamGia());
        MaGiamGiaService maGiamGiaServiceDq = new MaGiamGiaService(db.getListMaGiamGiaDq());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = khacHangService.timKhachHang(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    khachHang.themMaGiamGia(new MaGiamGia(maGiamGiaService.timMaGiamGia(thanhPhan[i])));
                    khachHang.themMaGiamGia(new MaGiamGia(maGiamGiaServiceDq.timMaGiamGia(thanhPhan[i])));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_MaGiamGia_SanPhamtxt(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
                KhachHang khachHang = khacHangService.timKhachHang(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                MaGiamGiaService maGiamGiaService = new MaGiamGiaService(khachHang.getListMaGiamGia());
                MaGiamGia maGiamGia = maGiamGiaService.timMaGiamGia(thanhPhan[1]);
                if (maGiamGia == null) {
                    continue;
                }
                SanPhamService sanPhamService = new SanPhamService(db.getListSanPham());
                SanPham sanPham = sanPhamService.timSanPham(thanhPhan[2]);
                maGiamGia.setSanPhamDaDung(sanPham);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_HoaDontxt(String path) {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        HoaDonService hoaDonService = new HoaDonService(db.getListHoaDon());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = khacHangService.timKhachHang(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    khachHang.themHoaDon(hoaDonService.timHoaDon(thanhPhan[i]));
                }
            }
            khacHangService.setTienDaChi();// khi da co tat ca hoa don thi tien hanh tinh tong so tien
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_PhieuTraHangtxt(String path) {
        KhacHangService khacHangService = new KhacHangService(db.getListKhachHang());
        PhieuTraHangService phieuTraHangService = new PhieuTraHangService(db.getListPhieuTraHang());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = khacHangService.timKhachHang(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    khachHang.themPhieuTraHang(phieuTraHangService.timPhieuTraHang(thanhPhan[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_CaLamtxt(String path) {
        NhanVienService nhanVienService = new NhanVienService(db.getListNhanVien());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                int so = Integer.parseInt(thanhPhan[1]);
                String gioBd = thanhPhan[2];
                String gioKt = thanhPhan[3];
                int soLuongCan = Integer.parseInt(thanhPhan[4]);
                CaLam caLam = new CaLam(ma, so, gioBd, gioKt, soLuongCan);
                for (int i = 4; i < thanhPhan.length; i++) {
                    caLam.themNhanVienVaoCa(nhanVienService.timNhanVien(thanhPhan[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_LichTrongNgaytxt(String path) {
        CaLamService caLamService = new CaLamService(db.getListCaLam());
        LichTrongNgayService lichTrongNgayService = new LichTrongNgayService(db.getListLichTrongNgay());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                int thu = Integer.parseInt(thanhPhan[1]);
                String ngay = thanhPhan[2];
                LichTrongNgay lichTrongNgay = new LichTrongNgay(ma, thu, ngay);
                for (int i = 3; i < thanhPhan.length; i++) {
                    lichTrongNgay.themCaLam(caLamService.timCaLam(thanhPhan[i]));
                }
                lichTrongNgayService.themLichTrongNgay(lichTrongNgay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_LichLamViectxt(String path) {
        LichTrongNgayService lichTrongNgayService = new LichTrongNgayService(db.getListLichTrongNgay());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                LichLamViec lichLamViec = db.getLichTuan();
                for (int i = 0; i < thanhPhan.length; i++) {
                    lichLamViec.themLichTrongNgay(lichTrongNgayService.timLichTrongNgay(thanhPhan[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_TaiKhoantxt(String path) {
        TaiKhoanService taiKhoanService = new TaiKhoanService(db.getListTaiKhoan());
        UserService userService = new UserService(db.getListUser());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                TaiKhoan taiKhoan = new TaiKhoan(thanhPhan[0], thanhPhan[1]);
                userService.ganTaiKhoanChoUser(taiKhoan);
                taiKhoanService.themTaiKhoan(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_TinNhantxt(String path) {
        TinNhanService tinNhanService = new TinNhanService(db.getListTinNhan());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                String tenNgGui = thanhPhan[1];
                String noiDung = thanhPhan[2];
                String ngayGui = thanhPhan[3];
                tinNhanService.themTinNhan(new TinNhan(ma, tenNgGui, noiDung, ngayGui));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_User_TinNhantxt(String path) {
        TinNhanService tinNhanService = new TinNhanService(db.getListTinNhan());
        UserService userService = new UserService(db.getListUser());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                User user = userService.timUser(thanhPhan[0]);
                for (int i = 1; i < thanhPhan.length; i++) {
                    user.nhanTinNhan(tinNhanService.timTinNhan(thanhPhan[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////
    public void doc_DatasVaoDatabase() {
        doc_NhanVientxt("datas/NhanVien.txt");
        doc_QuanLytxt("datas/QuanLy.txt");
        doc_SanPhamtxt("datas/SanPham.txt");
        doc_MaGiamGiatxt("datas/MaGiamGia.txt");
        doc_HangThanhVientxt("datas/HangThanhVien.txt");
        doc_KhachHangtxt("datas/KhachHang.txt");
        doc_BaoHanhtxt("datas/BaoHanh.txt");
        doc_PhieuBaoHanhtxt("datas/PhieuBaoHanh.txt");
        doc_PhieuTraHangtxt("datas/PhieuTraHang.txt");
        doc_ChiTietHoaDontxt("datas/ChiTietHoaDon.txt");
        doc_ChiTietHoaDon_SanPhamtxt("datas/ChiTietHoaDon_SanPham.txt");
        doc_ChiTietHoaDon_BaoHanhtxt("datas/ChiTietHoaDon_BaoHanh.txt");
        doc_ChiTietHoaDon_MaGiamGiatxt("datas/ChiTietHoaDon_MaGiamGia.txt");
        doc_HoaDontxt("datas/HoaDon.txt");
        doc_KhachHang_PhieuBaoHanhtxt("datas/KhachHang_PhieuBaoHanh.txt");
        doc_KhachHang_BaoHanhtxt("datas/KhachHang_BaoHanh.txt");
        doc_KhachHang_MaGiamGiatxt("datas/KhachHang_MaGiamGia.txt");
        doc_KhachHang_MaGiamGia_SanPhamtxt("datas/KhachHang_MaGiamGia_SanPham.txt");
        doc_KhachHang_HoaDontxt("datas/KhachHang_HoaDon.txt");
        doc_KhachHang_PhieuTraHangtxt("datas/KhachHang_PhieuTraHang.txt");
        doc_CaLamtxt("datas/CaLam.txt");
        doc_LichTrongNgaytxt("datas/LichTrongNgay.txt");
        doc_LichLamViectxt("datas/LichLamViec.txt");
        doc_TaiKhoantxt("datas/TaiKhoan.txt");
        doc_TinNhantxt("datas/TinNhan.txt");
        doc_User_TinNhantxt("datas/User_TinNhan.txt");
    }
}