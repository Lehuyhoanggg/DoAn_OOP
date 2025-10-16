package file;

import java.io.BufferedReader;
import java.io.FileReader;

import danhsach.*;
import database.Database;
import model.*;
import util.XulyString;

public class DocFile {
    Database db;

    public DocFile(Database db) {
        this.db = db;
    }

    ////////////////////////////////// doc file tu datas
    public void doc_NhanVientxt(String path) {
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
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
                hoTen = XulyString.chuyenLaiDangStrMacDinh(hoTen);
                String ngaySinh = thanhPhan[3];
                String sdt = thanhPhan[4];
                String gioiTinh = thanhPhan[5];
                long luong = Long.parseLong(thanhPhan[6]);
                NhanVien nhanVien = new NhanVien(maNV, cmnd, hoTen, ngaySinh, sdt, gioiTinh, luong);
                danhSachNhanVien.them(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_QuanLytxt(String path) {
        DanhSachQuanLy danhSachQuanLy = db.getDanhSachQuanLy();
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
                hoTen = XulyString.chuyenLaiDangStrMacDinh(hoTen);
                String ngaySinh = thanhPhan[3];
                String sdt = thanhPhan[4];
                String gioiTinh = thanhPhan[5];
                QuanLy quanLy = new QuanLy(maQL, cmnd, hoTen, ngaySinh, sdt, gioiTinh);
                danhSachQuanLy.them(quanLy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_SanPhamtxt(String path) {
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
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
                trangThai = XulyString.chuyenLaiDangStrMacDinh(trangThai);
                SanPham newSp = new SanPham(ma, ten, danhMuc, thuongHieu, gia, tonKho, moTa, trangThai);
                danhSachSanPham.them(newSp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_MaGiamGiatxt(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
            DanhSachMaGiamGia danhSachMaGiamGiaDq = db.getDanhSachMaGiamGiaDq();
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

                if (danhSachMaGiamGiaDq.laMaGiamGiaDocQuyen(maGiamGia)) {
                    danhSachMaGiamGiaDq.them(maGiamGia);
                    continue;
                }
                danhSachMaGiamGia.them(maGiamGia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_HangThanhVientxt(String path) {
        DanhSachHangThanhVien danhSachHangThanhVien = db.getDanhSachHangThanhVien();
        DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                HangThanhVien hangThanhVien = new HangThanhVien(thanhPhan[0], thanhPhan[1]);
                for (int i = 2; i < thanhPhan.length; i++) {
                    hangThanhVien.themMaGiamGia(danhSachMaGiamGia.tim(thanhPhan[i]));
                }
                danhSachHangThanhVien.them(hangThanhVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHangtxt(String path) {
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        DanhSachHangThanhVien danhSachHangThanhVien = db.getDanhSachHangThanhVien();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String maKh = thanhPhan[0];
                String tenKh = thanhPhan[1];
                tenKh = XulyString.chuyenLaiDangStrMacDinh(tenKh);
                String sdt = thanhPhan[2];
                String hangThanhVien = thanhPhan[3];
                KhachHang khachHang = new KhachHang(maKh, tenKh, sdt,
                        danhSachHangThanhVien.tim(hangThanhVien));
                danhSachKhachHang.them(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_BaoHanhtxt(String path) {
        DanhSachBaoHanh danhSachBaoHanh = db.getDanhSachBaoHanh();
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                danhSachBaoHanh.them(new BaoHanh(thanhPhan[0], thanhPhan[1],
                        danhSachSanPham.tim(thanhPhan[2]), Long.parseLong(thanhPhan[3])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_PhieuBaoHanhtxt(String path) {
        DanhSachPhieuBaoHanh danhSachPhieuBaoHanh = db.getDanhSachPhieuBaoHanh();
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                danhSachPhieuBaoHanh.them(new PhieuBaoHanh(thanhPhan[0],
                        danhSachKhachHang.tim(thanhPhan[1]),
                        danhSachSanPham.tim(thanhPhan[2]), thanhPhan[3],
                        XulyString.chuyenLaiDangStrMacDinh(thanhPhan[4])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_PhieuTraHangtxt(String path) { ///////
        DanhSachPhieuTraHang danhSachPhieuTraHang = db.getDanhSachPhieuTraHang();
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                danhSachPhieuTraHang.them(new PhieuTraHang(thanhPhan[0],
                        danhSachKhachHang.tim(thanhPhan[1]),
                        danhSachSanPham.tim(thanhPhan[2]), thanhPhan[3], thanhPhan[4],
                        XulyString.chuyenLaiDangStrMacDinh(thanhPhan[5])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_ChiTietHoaDontxt(String path) {
        DanhSachChiTietHoaDon danhSachChiTietHoaDon = db.getDanhSachChiTietHoaDon();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                danhSachChiTietHoaDon.them(
                        new ChiTietHoaDon(thanhPhan[0], Integer.parseInt(thanhPhan[1]), Integer.parseInt(thanhPhan[2]),
                                Long.parseLong(thanhPhan[3])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_SanPhamDaBan(String path) {
        DanhSachBaoHanh danhSachBaoHanh = db.getDanhSachBaoHanh();
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        DanhSachSanPhamDaBan danhSachSanPhamDaBan = db.getDanhSachSanPhamDaBan();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                String serial = thanhPhan[1];
                SanPham sanPham = danhSachSanPham.tim(thanhPhan[2]);
                BaoHanh baoHanh = danhSachBaoHanh.tim(thanhPhan[3]);
                danhSachSanPhamDaBan.them(new SanPhamDaBan(ma, sanPham, serial, baoHanh));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_ChiTietHoaDon_SanPhamDaBantxt(String path) { //////////////
        DanhSachChiTietHoaDon danhSachChiTietHoaDon = db.getDanhSachChiTietHoaDon();
        DanhSachSanPhamDaBan danhSachSanPhamDaBan = db.getDanhSachSanPhamDaBan();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                ChiTietHoaDon chiTietHoaDon = danhSachChiTietHoaDon.tim(thanhPhan[0]);
                if (chiTietHoaDon == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    chiTietHoaDon.themSanPhamDaBan(danhSachSanPhamDaBan.tim(thanhPhan[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_SanPhamDaBan_MaGiamGiatxt(String path) {
        DanhSachSanPhamDaBan danhSachSanPhamDaBan = db.getDanhSachSanPhamDaBan();
        DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");

                SanPhamDaBan sanPhamDaBan = danhSachSanPhamDaBan.tim(thanhPhan[0]);
                if (sanPhamDaBan == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    MaGiamGia maGiamGia = danhSachMaGiamGia.tim(thanhPhan[i]);
                    sanPhamDaBan.themMaGiamGiaDaDung(maGiamGia);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_SanPhamDaBan_MaGiamGia_SanPhamtxt(String path) {
        DanhSachSanPhamDaBan danhSachSanPhamDaBan = db.getDanhSachSanPhamDaBan();
        DanhSachSanPham danhSachSanPham = db.getDanhSachSanPham();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                SanPhamDaBan sanPhamDaBan = danhSachSanPhamDaBan.tim(thanhPhan[0]);
                if (sanPhamDaBan == null) {
                    continue;
                }
                DanhSachMaGiamGia danhSachMaGiamGiaKH = new DanhSachMaGiamGia(sanPhamDaBan.getListMaGiamGiaDaDung());
                MaGiamGia maGiamGia = danhSachMaGiamGiaKH.tim(thanhPhan[1]);
                if (maGiamGia == null) {
                    continue;
                }
                SanPham sanPham = danhSachSanPham.tim(thanhPhan[2]);
                maGiamGia.setSanPhamDaDung(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_HoaDontxt(String path) {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                KhachHang khachHang = danhSachKhachHang.tim(thanhPhan[1]);
                String ngayTaoHoaDon = thanhPhan[2];
                String ghiChu = thanhPhan[3];
                long ThanhTien = Long.parseLong(thanhPhan[4]);
                ghiChu = XulyString.chuyenLaiDangStrMacDinh(ghiChu);
                danhSachHoaDon.them(new HoaDon(ma, khachHang, ngayTaoHoaDon, ghiChu, ThanhTien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_HoaDon_ChiTietHoaDontxt(String path) {
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        DanhSachChiTietHoaDon danhSachChiTietHoaDon = db.getDanhSachChiTietHoaDon();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                HoaDon hoaDon = danhSachHoaDon.tim(thanhPhan[0]);
                if (hoaDon == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    ChiTietHoaDon chiTietHoaDon = danhSachChiTietHoaDon.tim(thanhPhan[i]);
                    hoaDon.themChiTietHoaDon(chiTietHoaDon);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////////////////////////
    public void doc_KhachHang_PhieuBaoHanhtxt(String path) {
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        DanhSachPhieuBaoHanh danhSachPhieuBaoHanh = db.getDanhSachPhieuBaoHanh();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = danhSachKhachHang.tim(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    khachHang.themPhieuBaoHanh(danhSachPhieuBaoHanh.tim(thanhPhan[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_BaoHanhtxt(String path) {
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        DanhSachBaoHanh danhSachBaoHanh = db.getDanhSachBaoHanh();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = danhSachKhachHang.tim(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                BaoHanh baoHanh = danhSachBaoHanh.tim(thanhPhan[1]);
                if (baoHanh != null) {
                    baoHanh.setNgayBatDau(thanhPhan[2]);
                    baoHanh.setNgayKetThuc();
                }
                khachHang.themBaoHanh(baoHanh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_MaGiamGiatxt(String path) {
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        DanhSachMaGiamGia danhSachMaGiamGia = db.getDanhSachMaGiamGia();
        DanhSachMaGiamGia danhSachMaGiamGiaDq = db.getDanhSachMaGiamGia();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = danhSachKhachHang.tim(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    MaGiamGia maGiamGia = danhSachMaGiamGia.tim(thanhPhan[i]);
                    DanhSachMaGiamGia danhSachMggKhachHang = new DanhSachMaGiamGia(khachHang.getListMaGiamGia());
                    if (maGiamGia != null) {
                        danhSachMggKhachHang.them(new MaGiamGia(maGiamGia));
                    }
                    MaGiamGia maGiamGiaDq = danhSachMaGiamGiaDq.tim(thanhPhan[i]);
                    if (maGiamGiaDq != null) {
                        danhSachMggKhachHang.them(new MaGiamGia(maGiamGiaDq));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_HoaDontxt(String path) {
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        DanhSachHoaDon danhSachHoaDon = db.getDanhSachHoaDon();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = danhSachKhachHang.tim(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    khachHang.themHoaDon(danhSachHoaDon.tim(thanhPhan[i]));
                }
            }
            danhSachKhachHang.setTienDaChi();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_KhachHang_PhieuTraHangtxt(String path) {
        DanhSachKhachHang danhSachKhachHang = db.getDanhSachKhachHang();
        DanhSachPhieuTraHang danhSachPhieuTraHang = db.getDanhSachPhieuTraHang();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                KhachHang khachHang = danhSachKhachHang.tim(thanhPhan[0]);
                if (khachHang == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    khachHang.themPhieuTraHang(danhSachPhieuTraHang.tim(thanhPhan[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_CaLamtxt(String path) {
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
        DanhSachCaLam danhSachCaLam = db.getDanhSachCaLam();
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
                for (int i = 5; i < thanhPhan.length; i++) {
                    caLam.themNhanVienVaoCa(danhSachNhanVien.tim(thanhPhan[i]));
                }
                danhSachCaLam.them(caLam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_CaLam_NhanVienDiemDanh(String path) {
        DanhSachNhanVien danhSachNhanVien = db.getDanhSachNhanVien();
        DanhSachCaLam danhSachCaLam = db.getDanhSachCaLam();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                CaLam caLam = danhSachCaLam.tim(ma);
                if (caLam == null) {
                    continue;
                }
                for (int i = 1; i < thanhPhan.length; i++) {
                    caLam.getListNhanVien().diemDanhNhanVien((danhSachNhanVien.tim(thanhPhan[i])));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_LichTrongNgaytxt(String path) {
        DanhSachCaLam danhSachCaLam = db.getDanhSachCaLam();
        DanhSachLichTrongNgay danhSachLichTrongNgay = db.getDanhSachLichTrongNgay();
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
                    lichTrongNgay.themCaLam(danhSachCaLam.tim(thanhPhan[i]));
                }
                danhSachLichTrongNgay.them(lichTrongNgay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_LichTrongTuantxt(String path) {
        DanhSachLichTrongTuan danhSachLichTrongTuan = db.getDanhSachLichTrongTuan();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                String ngayThu2 = thanhPhan[1];
                String ngayCn = thanhPhan[2];
                LichTrongTuan lichTrongTuan = new LichTrongTuan(ma, ngayThu2, ngayCn);
                DanhSachLichTrongNgay danhSachLichTrongNgay = db.getDanhSachLichTrongNgay();
                for (int i = 3; i < thanhPhan.length; i++) {
                    lichTrongTuan.themLichTrongNgay(danhSachLichTrongNgay.tim(thanhPhan[i]));
                }
                danhSachLichTrongTuan.them(lichTrongTuan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_TaiKhoantxt(String path) {
        DanhSachTaiKhoan danhSachTaiKhoan = db.getDanhSachTaiKhoan();
        DanhSachUser danhSachUser = db.getDanhSachUser();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                TaiKhoan taiKhoan = new TaiKhoan(thanhPhan[0], thanhPhan[1]);
                danhSachUser.ganTaiKhoanChoUser(taiKhoan);
                danhSachTaiKhoan.them(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_TinNhantxt(String path) {
        DanhSachTinNhan danhSachTinNhan = db.getDanhSachTinNhan();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                String ma = thanhPhan[0];
                String tenNgGui = thanhPhan[1];
                tenNgGui = XulyString.chuyenLaiDangStrMacDinh(tenNgGui);
                String noiDung = thanhPhan[2];
                noiDung = XulyString.chuyenLaiDangStrMacDinh(noiDung);
                String ngayGui = thanhPhan[3];
                danhSachTinNhan.them(new TinNhan(ma, tenNgGui, noiDung, ngayGui));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doc_User_TinNhantxt(String path) {
        DanhSachTinNhan danhSachTinNhan = db.getDanhSachTinNhan();
        DanhSachUser danhSachUser = db.getDanhSachUser();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.replaceAll("\\s+", "").length() == 0) {
                    continue;
                }
                String[] thanhPhan = line.split("\\s+");
                User user = danhSachUser.timUser(thanhPhan[0]);
                for (int i = 1; i < thanhPhan.length; i++) {
                    user.nhanTinNhan(danhSachTinNhan.tim(thanhPhan[i]));
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

        doc_SanPhamDaBan("datas/SanPhamDaBan.txt");
        doc_ChiTietHoaDontxt("datas/ChiTietHoaDon.txt");

        doc_ChiTietHoaDon_SanPhamDaBantxt("datas/ChiTietHoaDon_SanPhamDaBan.txt");
        doc_SanPhamDaBan_MaGiamGia_SanPhamtxt("datas/SanPhamDaBan_MaGiamGia_SanPham.txt");
        doc_SanPhamDaBan_MaGiamGiatxt("datas/SanPhamDaBan_MaGiamGia.txt");
        doc_HoaDontxt("datas/HoaDon.txt");
        doc_HoaDon_ChiTietHoaDontxt("datas/HoaDon_ChiTietHoaDon.txt");

        doc_KhachHang_PhieuBaoHanhtxt("datas/KhachHang_PhieuBaoHanh.txt");
        doc_KhachHang_BaoHanhtxt("datas/KhachHang_BaoHanh.txt");
        doc_KhachHang_MaGiamGiatxt("datas/KhachHang_MaGiamGia.txt");
        doc_KhachHang_HoaDontxt("datas/KhachHang_HoaDon.txt");
        doc_KhachHang_PhieuTraHangtxt("datas/KhachHang_PhieuTraHang.txt");
        doc_CaLamtxt("datas/CaLam.txt");
        doc_LichTrongNgaytxt("datas/LichTrongNgay.txt");
        doc_LichTrongTuantxt("datas/LichTrongTuan.txt");
        db.taoDanhSachUser();
        doc_TaiKhoantxt("datas/TaiKhoan.txt");
        doc_TinNhantxt("datas/TinNhan.txt");
        doc_User_TinNhantxt("datas/User_TinNhan.txt");
    }

}