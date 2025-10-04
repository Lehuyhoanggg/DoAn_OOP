package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

import database.Database;
import interfaces.GhiFile_Datas;
import model.*;
import util.XulyString;

public class GhiFile implements GhiFile_Datas {
    private Database db;

    public GhiFile(Database db) {
        this.db = db;
    }

    // nhan vien
    public void ghi_NhanVientxt(String path) {
        ArrayList<NhanVien> listNhanVien = db.getListNhanVien();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listNhanVien.size(); i++) {
                line = listNhanVien.get(i).getMa() + " " +
                        listNhanVien.get(i).getCccd() + " " +
                        XulyString.dongGoiStr(listNhanVien.get(i).getTen()) + " " +
                        listNhanVien.get(i).getNgaySinh() + " " +
                        listNhanVien.get(i).getSdt() + " " +
                        listNhanVien.get(i).getGioiTinh() + " " +
                        listNhanVien.get(i).getLuong();

                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // quan ly
    public void ghi_QuanLytxt(String path) {
        ArrayList<QuanLy> listQuanly = db.getListQuanLy();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listQuanly.size(); i++) {
                line = listQuanly.get(i).getMa() + " " +
                        listQuanly.get(i).getCccd() + " " +
                        XulyString.dongGoiStr(listQuanly.get(i).getTen()) + " " +
                        listQuanly.get(i).getNgaySinh() + " " +
                        listQuanly.get(i).getSdt() + " " +
                        listQuanly.get(i).getGioiTinh();
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // san pham
    public void ghi_SanPhamtxt(String path) {
        ArrayList<SanPham> listSanPham = db.getListSanPham();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listSanPham.size(); i++) {
                line = listSanPham.get(i).getMa() + " " +
                        listSanPham.get(i).getTen() + " " +
                        listSanPham.get(i).getDanhMuc() + " " +
                        listSanPham.get(i).getThuongHieu() + " " +
                        listSanPham.get(i).getGia() + " " +
                        listSanPham.get(i).getTonKho() + " " +
                        listSanPham.get(i).getMoTa() + " " +
                        XulyString.dongGoiStr(listSanPham.get(i).getTrangThai());
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ma giam gia
    public void ghi_MaGiamGiatxt(String path) {
        ArrayList<MaGiamGia> listMaGiamGia = db.getListMaGiamGia();
        ArrayList<MaGiamGia> listMaGiamGiaDq = db.getListMaGiamGiaDq();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            // Ghi ma giam gia thuong
            for (int i = 0; i < listMaGiamGia.size(); i++) {
                line = listMaGiamGia.get(i).getMa() + " " +
                        listMaGiamGia.get(i).getTenMa() + " " +
                        listMaGiamGia.get(i).getLoaiDoanhMuc() + " " +
                        listMaGiamGia.get(i).getLoaiThuongHieu() + " " +
                        listMaGiamGia.get(i).getTienGiam() + " " +
                        listMaGiamGia.get(i).getNgayBatDau() + " " +
                        listMaGiamGia.get(i).getNgayKetThuc();
                bw.write(line);
                bw.newLine();
            }
            // Ghi ma giam gia doc quyen
            for (int i = 0; i < listMaGiamGiaDq.size(); i++) {
                line = listMaGiamGiaDq.get(i).getMa() + " " +
                        listMaGiamGiaDq.get(i).getTenMa() + " " +
                        listMaGiamGiaDq.get(i).getLoaiDoanhMuc() + " " +
                        listMaGiamGiaDq.get(i).getLoaiThuongHieu() + " " +
                        listMaGiamGiaDq.get(i).getTienGiam() + " " +
                        listMaGiamGiaDq.get(i).getNgayBatDau() + " " +
                        listMaGiamGiaDq.get(i).getNgayKetThuc();
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // hang thanh vien
    public void ghi_HangThanhVientxt(String path) {
        ArrayList<HangThanhVien> listHangThanhVien = db.getListHangThanhVien();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listHangThanhVien.size(); i++) {
                line = listHangThanhVien.get(i).getTenHang() + " " +
                        listHangThanhVien.get(i).getMoTa();
                for (int j = 0; j < listHangThanhVien.get(i).getListMaGiamGiaDQ().size(); j++) {
                    line = line + " " + listHangThanhVien.get(i).getListMaGiamGiaDQ().get(j).getMa();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // khach hang
    public void ghi_KhachHangtxt(String path) {
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listKhachHang.size(); i++) {
                line = listKhachHang.get(i).getMaKh() + " " +
                        XulyString.dongGoiStr(listKhachHang.get(i).getTenKh()) + " " +
                        listKhachHang.get(i).getSdt() + " " +
                        ((listKhachHang.get(i).getHangThanhVien() == null) ? "Null"
                                : listKhachHang.get(i).getHangThanhVien().getTenHang());
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // bao hanh
    public void ghi_BaoHanhtxt(String path) {
        ArrayList<BaoHanh> listBaoHanh = db.getListBaoHanh();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listBaoHanh.size(); i++) {
                line = listBaoHanh.get(i).getMaBh() + " " +
                        listBaoHanh.get(i).getLoaiBaoHanh() + " " +
                        listBaoHanh.get(i).getSanPham().getMa() + " " +
                        listBaoHanh.get(i).getGia();
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // phieu bao hanh
    public void ghi_PhieuBaoHanhtxt(String path) {
        ArrayList<PhieuBaoHanh> listPhieuBaoHanh = db.getListPhieuBaoHanh();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listPhieuBaoHanh.size(); i++) {
                line = listPhieuBaoHanh.get(i).getMaBaoHanh() + " " +
                        listPhieuBaoHanh.get(i).getKhachHang().getMaKh() + " " +
                        listPhieuBaoHanh.get(i).getSanPham().getMa() + " " +
                        listPhieuBaoHanh.get(i).getNgayBaoHanh() + " " +
                        listPhieuBaoHanh.get(i).getChiTietLoi();
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // phieu tra hang
    public void ghi_PhieuTraHangtxt(String path) {
        ArrayList<PhieuTraHang> listPhieuTraHang = db.getListPhieuTraHang();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listPhieuTraHang.size(); i++) {
                line = listPhieuTraHang.get(i).getMaTraHang() + " " +
                        listPhieuTraHang.get(i).getKhachHang().getMaKh() + " " +
                        listPhieuTraHang.get(i).getSanPham().getMa() + " " +
                        listPhieuTraHang.get(i).getNgayTra() + " " +
                        XulyString.dongGoiStr(listPhieuTraHang.get(i).getLyDoTra());
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // chi tiet hoa don
    public void ghi_ChiTietHoaDontxt(String path) {
        ArrayList<ChiTietHoaDon> listChiTietHoaDon = db.getListChiTietHoaDon();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listChiTietHoaDon.size(); i++) {
                line = listChiTietHoaDon.get(i).getMa() + " " +
                        listChiTietHoaDon.get(i).getThanhTien();
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // chi tiet hoa don san pham
    public void ghi_ChiTietHoaDon_SanPhamtxt(String path) {
        ArrayList<ChiTietHoaDon> listChiTietHoaDon = db.getListChiTietHoaDon();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listChiTietHoaDon.size(); i++) {
                line = listChiTietHoaDon.get(i).getMa();
                Map<SanPham, Integer> mapSanPham = listChiTietHoaDon.get(i).getDanhSachSanPham().getMapSanPham();
                for (SanPham sanPham : mapSanPham.keySet()) {
                    for (int j = 0; j < mapSanPham.get(sanPham); j++) {
                        line += " " + sanPham.getMa();
                    }
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // chi tiet hoa don bao hanh
    public void ghi_ChiTietHoaDon_BaoHanhtxt(String path) {
        ArrayList<ChiTietHoaDon> listChiTietHoaDon = db.getListChiTietHoaDon();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listChiTietHoaDon.size(); i++) {
                line = listChiTietHoaDon.get(i).getMa();
                for (int j = 0; j < listChiTietHoaDon.get(i).getListBaoHanh().size(); j++) {
                    line = line + " " + listChiTietHoaDon.get(i).getListBaoHanh().get(j).getMaBh();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // chi tiet hoa don ma giam gia
    public void ghi_ChiTietHoaDon_MaGiamGiatxt(String path) {
        ArrayList<ChiTietHoaDon> listChiTietHoaDon = db.getListChiTietHoaDon();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listChiTietHoaDon.size(); i++) {
                line = listChiTietHoaDon.get(i).getMa();
                for (int j = 0; j < listChiTietHoaDon.get(i).getListMaGiamGiaDaDung().size(); j++) {
                    line = line + " " + listChiTietHoaDon.get(i).getListMaGiamGiaDaDung().get(j).getMa();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // chi tiet hoa don_ma giam gia_san pham
    public void ghi_ChiTietHoaDon_MaGiamGia_SanPhamtxt(String path) {
        ArrayList<ChiTietHoaDon> listChiTietHoaDon = db.getListChiTietHoaDon();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listChiTietHoaDon.size(); i++) {
                for (int j = 0; j < listChiTietHoaDon.get(i).getListMaGiamGiaDaDung().size(); j++) {
                    MaGiamGia mgg = listChiTietHoaDon.get(i).getListMaGiamGiaDaDung().get(j);
                    if (mgg.getSanPhamDaDung() != null) {
                        line = listChiTietHoaDon.get(i).getMa() + " " +
                                mgg.getMa() + " " +
                                mgg.getSanPhamDaDung().getMa();
                        bw.write(line);
                        bw.newLine();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // hoa don
    public void ghi_HoaDontxt(String path) {
        ArrayList<HoaDon> listHoaDon = db.getListHoaDon();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listHoaDon.size(); i++) {
                line = listHoaDon.get(i).getMa() + " " +
                        listHoaDon.get(i).getKhachHang().getMaKh() + " " +
                        listHoaDon.get(i).getChiTietHoaDon().getMa() + " " +
                        listHoaDon.get(i).getNgayTaoHoaDon() + " " +
                        XulyString.dongGoiStr(listHoaDon.get(i).getGhiChu());
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // khach hang _ phieu bao hanh
    public void ghi_KhachHang_PhieuBaoHanhtxt(String path) {
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listKhachHang.size(); i++) {
                line = listKhachHang.get(i).getMaKh();
                for (int j = 0; j < listKhachHang.get(i).getListPhieuBaoHanh().size(); j++) {
                    line = line + " " + listKhachHang.get(i).getListPhieuBaoHanh().get(j).getMaBaoHanh();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // khach hang bao hanh
    public void ghi_KhachHang_BaoHanhtxt(String path) {
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listKhachHang.size(); i++) {
                for (int j = 0; j < listKhachHang.get(i).getListBaoHanh().size(); j++) {
                    BaoHanh bh = listKhachHang.get(i).getListBaoHanh().get(j);
                    line = listKhachHang.get(i).getMaKh() + " " +
                            bh.getMaBh() + " " +
                            bh.getNgayBatDau();
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // khach hang_ma giam gia
    public void ghi_KhachHang_MaGiamGiatxt(String path) {
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listKhachHang.size(); i++) {
                line = listKhachHang.get(i).getMaKh();
                for (int j = 0; j < listKhachHang.get(i).getListMaGiamGia().size(); j++) {
                    line = line + " " + listKhachHang.get(i).getListMaGiamGia().get(j).getMa();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // khach hang_hoa don
    public void ghi_KhachHang_HoaDontxt(String path) {
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listKhachHang.size(); i++) {
                line = listKhachHang.get(i).getMaKh();
                for (int j = 0; j < listKhachHang.get(i).getListHoaDon().size(); j++) {
                    line = line + " " + listKhachHang.get(i).getListHoaDon().get(j).getMa();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // khach hang_phieu tra hang
    public void ghi_KhachHang_PhieuTraHangtxt(String path) {
        ArrayList<KhachHang> listKhachHang = db.getListKhachHang();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listKhachHang.size(); i++) {
                line = listKhachHang.get(i).getMaKh();
                for (int j = 0; j < listKhachHang.get(i).getListPhieuTraHang().size(); j++) {
                    line = line + " " + listKhachHang.get(i).getListPhieuTraHang().get(j).getMaTraHang();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ghi ca lam
    public void ghi_CaLamtxt(String path) {
        ArrayList<CaLam> listCaLam = db.getListCaLam();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listCaLam.size(); i++) {
                line = listCaLam.get(i).getMa() + " " +
                        listCaLam.get(i).getSo() + " " +
                        listCaLam.get(i).getGioBatDau() + " " +
                        listCaLam.get(i).getGioKetThuc() + " " +
                        listCaLam.get(i).getSoLuongCan();
                for (NhanVien nhanVien : listCaLam.get(i).getListNhanVien().getMapNhanVien().keySet()) {
                    line = line + " " + nhanVien.getMa();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ghi lich trong ngay
    public void ghi_LichTrongNgaytxt(String path) {
        ArrayList<LichTrongNgay> listLichTrongNgay = db.getListLichTrongNgay();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listLichTrongNgay.size(); i++) {
                line = listLichTrongNgay.get(i).getMa() + " " +
                        listLichTrongNgay.get(i).getThu() + " " +
                        listLichTrongNgay.get(i).getNgay();
                for (int j = 0; j < listLichTrongNgay.get(i).getListCaLam().size(); j++) {
                    line = line + " " + listLichTrongNgay.get(i).getListCaLam().get(j).getMa();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ghi lich lam viec
    public void ghi_LichLamViectxt(String path) {
        LichLamViec lichLamViec = db.getLichTuan();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line = "";
            for (int i = 0; i < lichLamViec.getLichTuan().size(); i++) {
                if (i > 0) {
                    line = line + " ";
                }
                line = line + lichLamViec.getLichTuan().get(i).getMa();
            }
            bw.write(line);
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ghi tai khoan
    public void ghi_TaiKhoantxt(String path) {
        ArrayList<TaiKhoan> listTaiKhoan = db.getListTaiKhoan();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listTaiKhoan.size(); i++) {
                line = listTaiKhoan.get(i).getTenDangNhap() + " " +
                        listTaiKhoan.get(i).getMatKhau();
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ghi tin nhan
    public void ghi_TinNhantxt(String path) {
        ArrayList<TinNhan> listTinNhan = db.getListTinNhan();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listTinNhan.size(); i++) {
                line = listTinNhan.get(i).getMa() + " " +
                        XulyString.dongGoiStr(listTinNhan.get(i).getTenNgGui()) + " " +
                        XulyString.dongGoiStr(listTinNhan.get(i).getNoiDung()) + " " +
                        listTinNhan.get(i).getNgayGui();
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ghi user_TinNhan
    public void ghi_User_TinNhantxt(String path) {
        ArrayList<User> listUser = db.getListUser();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String line;
            for (int i = 0; i < listUser.size(); i++) {
                line = listUser.get(i).getMa();
                for (int j = 0; j < listUser.get(i).getListTinNhan().size(); j++) {
                    line = line + " " + listUser.get(i).getListTinNhan().get(j).getMa();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ghi database vao data
    public void ghi_DatasVaoDatabase() {
        ghi_NhanVientxt("datas/NhanVien.txt");
        ghi_QuanLytxt("datas/QuanLy.txt");
        ghi_SanPhamtxt("datas/SanPham.txt");
        ghi_MaGiamGiatxt("datas/MaGiamGia.txt");
        ghi_HangThanhVientxt("datas/HangThanhVien.txt");
        ghi_KhachHangtxt("datas/KhachHang.txt");
        ghi_BaoHanhtxt("datas/BaoHanh.txt");
        ghi_PhieuBaoHanhtxt("datas/PhieuBaoHanh.txt");
        ghi_PhieuTraHangtxt("datas/PhieuTraHang.txt");
        ghi_ChiTietHoaDontxt("datas/ChiTietHoaDon.txt");
        ghi_ChiTietHoaDon_SanPhamtxt("datas/ChiTietHoaDon_SanPham.txt");
        ghi_ChiTietHoaDon_BaoHanhtxt("datas/ChiTietHoaDon_BaoHanh.txt");
        ghi_ChiTietHoaDon_MaGiamGiatxt("datas/ChiTietHoaDon_MaGiamGia.txt");
        ghi_ChiTietHoaDon_MaGiamGia_SanPhamtxt("datas/ChiTietHoaDon_MaGiamGia_SanPham.txt");
        ghi_HoaDontxt("datas/HoaDon.txt");
        ghi_KhachHang_PhieuBaoHanhtxt("datas/KhachHang_PhieuBaoHanh.txt");
        ghi_KhachHang_BaoHanhtxt("datas/KhachHang_BaoHanh.txt");
        ghi_KhachHang_MaGiamGiatxt("datas/KhachHang_MaGiamGia.txt");
        ghi_KhachHang_HoaDontxt("datas/KhachHang_HoaDon.txt");
        ghi_KhachHang_PhieuTraHangtxt("datas/KhachHang_PhieuTraHang.txt");
        ghi_CaLamtxt("datas/CaLam.txt");
        ghi_LichTrongNgaytxt("datas/LichTrongNgay.txt");
        ghi_LichLamViectxt("datas/LichLamViec.txt");
        ghi_TaiKhoantxt("datas/TaiKhoan.txt");
        ghi_TinNhantxt("datas/TinNhan.txt");
        ghi_User_TinNhantxt("datas/User_TinNhan.txt");
    }
}