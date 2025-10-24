package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.BaoHanh;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.MaGiamGia;
import model.SanPham;
import util.ThoiGian;

public class DanhSachMaGiamGia implements QuanLyDanhSach<MaGiamGia> {
    ArrayList<MaGiamGia> listMaGiamGia;
    private int soLuong = 0;

    public DanhSachMaGiamGia(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public DanhSachMaGiamGia() {

    }

    public ArrayList<MaGiamGia> getListMaGiamGia() {
        return listMaGiamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListMaGiamGia(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean them(MaGiamGia maGiamGia) {
        if (maGiamGia == null) {
            return false;
        }
        if (tim(maGiamGia.getMa()) != null) {
            return false;
        }
        soLuong++;
        return listMaGiamGia.add(maGiamGia);
    }

    public boolean xoa(MaGiamGia ma) {
        if (ma == null) {
            return false;
        }
        soLuong--;
        return listMaGiamGia.remove(ma);
    }

    public MaGiamGia tim(String ma) {
        if (listMaGiamGia == null) {
            return null;
        }
        for (int i = 0; i < listMaGiamGia.size(); i++) {
            if (listMaGiamGia.get(i).getMa().equals(ma)) {
                return listMaGiamGia.get(i);
            }
        }
        return null;
    }

    private boolean trungDanhMuc(MaGiamGia maGiamGia, SanPham sanPham) {
        return maGiamGia.getLoaiDoanhMuc().equals(sanPham.getDanhMuc());
    }

    private boolean trungThuongHieu(MaGiamGia maGiamGia, SanPham sanPham) {
        return maGiamGia.getLoaiThuongHieu().equals(sanPham.getThuongHieu());
    }

    public boolean maGiamGiaThoaMan(SanPham sanPham, MaGiamGia maGiamGia) {
        if ((trungDanhMuc(maGiamGia, sanPham) || maGiamGia.getLoaiDoanhMuc().equals("Tat_Ca"))
                && (trungThuongHieu(maGiamGia, sanPham)
                        || maGiamGia.getLoaiThuongHieu().equals("Tat_Ca"))
                && ((maGiamGia.getNgayBatDau().equals("Vinh_Vien") || maGiamGia.getNgayKetThuc().equals("Vinh_Vien") ||
                        ThoiGian.ngayTrongKhoan(ThoiGian.layNgayHienTaiStr(), maGiamGia.getNgayBatDau(),
                                maGiamGia.getNgayKetThuc())))) {
            return true;
        }
        return false;
    }

    private long appDungMaGiamGia(SanPham sanPham, MaGiamGia maGiamGia) {
        if (maGiamGiaThoaMan(sanPham, maGiamGia)) {
            String tienGiam = maGiamGia.getTienGiam();
            if (tienGiam != null && tienGiam.length() >= 2 && tienGiam.charAt(tienGiam.length() - 1) == '%') {
                Long phanTram = Long.parseLong(tienGiam.substring(0, tienGiam.length() - 1));
                maGiamGia.setSanPhamDaDung(sanPham);
                return (sanPham.getGia() * phanTram) / 100;
            } else {
                maGiamGia.setSanPhamDaDung(sanPham);
                return Long.parseLong(tienGiam);
            }

        }
        return 0;
    }

    public MaGiamGia tim(String ma, KhachHang khachHang) {
        for (MaGiamGia maGiamGia : listMaGiamGia) {
            if (maGiamGia.getKhachHangDaDung().equals(khachHang) && maGiamGia.getMa().equals(ma)) {
                return maGiamGia;
            }
        }
        return null;
    }

    public void setThanhTienDaApMaGG(HoaDon hoaDon, ArrayList<MaGiamGia> danhGiamGiaDaDung) {
        for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {
            long thanhTien = 0;
            for (int i = 0; i < chiTietHoaDon.getListSanPham().size(); i++) { // duyệt qua từng sản phẩm trong hóa đơn
                SanPham sanPham = chiTietHoaDon.getListSanPham().get(i);

                ArrayList<MaGiamGia> listRemove = new ArrayList<>(); // lưu các mã giảm giá đã áp dụng => để xóa khỏi
                                                                     // kho mã gg của khangHang
                long giaSanPham = sanPham.getGia();
                ArrayList<MaGiamGia> maGiamGiaSp = listMaGiamGiaChoSp(sanPham); // list mã khả dụng của sản phẩm
                for (int k = 0; k < maGiamGiaSp.size(); k++) {
                    long giaGiam = appDungMaGiamGia(sanPham, maGiamGiaSp.get(k));
                    // nếu giá giảm là dương thì xử lí ,lưu vào chi tiết hóa đơn và xóa ở kho mgg
                    // khangHang
                    if (giaGiam > 0) {
                        chiTietHoaDon.themMaGiamGia(maGiamGiaSp.get(k));
                        giaSanPham -= giaGiam;
                        listRemove.add(maGiamGiaSp.get(k));
                        maGiamGiaSp.get(k).setKhachHangDaDung(hoaDon.getKhachHang());
                        maGiamGiaSp.get(k).setSanPhamDaDung(sanPham);
                        danhGiamGiaDaDung.add(maGiamGiaSp.get(k));
                    }
                    if (giaSanPham <= 0) { // giá sản phẩm đã âm
                        giaSanPham = 0;
                        break;
                    }
                }
                thanhTien += giaSanPham;
                /// nếu sản phẩm có bảo hành thì + vào thành tiền
                BaoHanh baoHanh = sanPham.getBaoHanh();
                if (baoHanh != null) {
                    thanhTien += baoHanh.getGia();
                }

                /// xóa mã giảm giá cho khachHang
                for (int j = listRemove.size() - 1; j >= 0; j--) { // duyệt ngược để tránh xung đột
                    listMaGiamGia.remove(listRemove.get(j));
                }
            }

            chiTietHoaDon.setThanhTien(thanhTien); // lưu thành tiền đã tính vào chiTietHoaDon
        }
        hoaDon.tinhThanhTien();
    }

    public ArrayList<MaGiamGia> listMaGiamGiaChoSp(SanPham sanPham) {
        ArrayList<MaGiamGia> listMaGiamGiaTM = new ArrayList<>();
        for (int i = 0; i < listMaGiamGia.size(); i++) {
            if (maGiamGiaThoaMan(sanPham, listMaGiamGia.get(i))) {
                listMaGiamGiaTM.add(listMaGiamGia.get(i));
            }
        }
        return listMaGiamGiaTM;
    }

    private boolean maDocQuyen(String ma) {
        String maDong = "MGGDONG";
        String maBac = "MGGBAC";
        String maVang = "MGGVANG";
        return ma.startsWith(maDong) || ma.startsWith(maBac) || ma.startsWith(maVang);
    }

    public boolean laMaGiamGiaDocQuyen(MaGiamGia maGiamGia) {
        if (maDocQuyen(maGiamGia.getMa())) {
            return true;
        }
        return false;
    }

    public long giaSanPhamSauKhiApDungTatCa(SanPham sanPham) {
        long gia = sanPham.getGia();
        for (MaGiamGia maGiamGia : listMaGiamGia) {
            if (gia > appDungMaGiamGia(sanPham, maGiamGia)) {
                gia = appDungMaGiamGia(sanPham, maGiamGia);
            }

        }
        return gia;
    }

    public ArrayList<MaGiamGia> xoaSanPhamThuHoiMa(SanPham sanPham, HoaDon hoaDon) {
        KhachHang khachHang = hoaDon.getKhachHang();
        if (sanPham == null) {
            return null;
        }
        DanhSachChiTietHoaDon danhSachChiTietHoaDon = new DanhSachChiTietHoaDon(hoaDon.getListChiTietHoaDon());
        ChiTietHoaDon chiTietHoaDon = danhSachChiTietHoaDon.tim(sanPham);
        ArrayList<MaGiamGia> listMaThuHoi = new ArrayList<>();
        ArrayList<MaGiamGia> listMaGiamGiaSp = null;
        listMaGiamGiaSp = chiTietHoaDon.getListMaGiamGia();
        DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia(listMaGiamGiaSp);
        long tienGiam = danhSachMaGiamGia.giaSanPhamSauKhiApDungTatCa(sanPham);
        if (sanPham.getBaoHanh() != null) {
            tienGiam += sanPham.getBaoHanh().getGia();
        }
        chiTietHoaDon.setThanhTien(chiTietHoaDon.getThanhTien() - tienGiam);
        hoaDon.tinhThanhTien();////

        chiTietHoaDon.xoaSanPham(sanPham);

        if (listMaGiamGia == null) {
            return null;
        }
        for (int i = listMaGiamGiaSp.size() - 1; i >= 0; i--) {
            if (listMaGiamGiaSp.get(i).getSanPhamDaDung().equals(sanPham)
                    && (listMaGiamGiaSp.get(i).getNgayKetThuc().equals("Vinh_Vien")
                            || listMaGiamGiaSp.get(i).getNgayBatDau().equals("Vinh_Vien")
                            || ThoiGian.ngayTrongKhoan(ThoiGian.layNgayHienTaiStr(),
                                    listMaGiamGiaSp.get(i).getNgayBatDau(),
                                    listMaGiamGiaSp.get(i).getNgayKetThuc()))) {
                khachHang.themMaGiamGia(listMaGiamGiaSp.get(i));
                listMaThuHoi.add(listMaGiamGiaSp.get(i));
                listMaGiamGiaSp.remove(i);
            }
        }
        return listMaThuHoi;
    }
}