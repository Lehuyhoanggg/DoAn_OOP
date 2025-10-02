package database;

import java.util.ArrayList;
import java.util.List;

import file.DocFile;
import model.BaoHanh;
import model.CaLam;
import model.ChiTietHoaDon;
import model.HangThanhVien;
import model.HoaDon;
import model.KhachHang;
import model.LichLamViec;
import model.LichTrongNgay;
import model.MaGiamGia;
import model.NhanVien;
import model.PhieuBaoHanh;
import model.PhieuTraHang;
import model.QuanLy;
import model.SanPham;
import model.TaiKhoan;
import model.TinNhan;
import model.User;

public class Database {
    private ArrayList<NhanVien> listNhanVien;
    private ArrayList<QuanLy> listQuanLy;
    private ArrayList<HoaDon> listHoaDon;
    private ArrayList<TaiKhoan> listTaiKhoan;
    private ArrayList<SanPham> listSanPham;
    private ArrayList<ChiTietHoaDon> listChiTietHoaDon;
    private ArrayList<BaoHanh> listBaoHanh;
    private ArrayList<PhieuBaoHanh> listPhieuBaoHanh;
    private ArrayList<PhieuTraHang> listPhieuTraHang;
    private ArrayList<KhachHang> listKhachHang;
    private ArrayList<MaGiamGia> listMaGiamGia;
    private ArrayList<MaGiamGia> listMaGiamGiaDq;
    private ArrayList<HangThanhVien> listHangThanhVien;
    private ArrayList<TinNhan> listTinNhan;
    private ArrayList<CaLam> listCaLam;
    private ArrayList<LichTrongNgay> listLichTrongNgay;
    private LichLamViec lichTuan;

    public Database() {
        listNhanVien = new ArrayList<>();
        listQuanLy = new ArrayList<>();
        listHoaDon = new ArrayList<>();
        listTaiKhoan = new ArrayList<>();
        listSanPham = new ArrayList<>();
        listChiTietHoaDon = new ArrayList<>();
        listBaoHanh = new ArrayList<>();
        listPhieuBaoHanh = new ArrayList<>();
        listPhieuTraHang = new ArrayList<>();
        listKhachHang = new ArrayList<>();
        listMaGiamGia = new ArrayList<>();
        listMaGiamGiaDq = new ArrayList<>();
        listHangThanhVien = new ArrayList<>();
        listTinNhan = new ArrayList<>();
        listCaLam = new ArrayList<>();
        listLichTrongNgay = new ArrayList<>();
        lichTuan = new LichLamViec();
        DocFile docFile = new DocFile(this);
        docFile.doc_DatasVaoDatabase();
    }

    public ArrayList<CaLam> getListCaLam() {
        return listCaLam;
    }

    public ArrayList<LichTrongNgay> getListLichTrongNgay() {
        return listLichTrongNgay;
    }

    public ArrayList<MaGiamGia> getListMaGiamGiaDq() {
        return listMaGiamGiaDq;
    }

    public ArrayList<HangThanhVien> getListHangThanhVien() {
        return listHangThanhVien;
    }

    public LichLamViec getLichTuan() {
        return lichTuan;
    }

    public ArrayList<TinNhan> getListTinNhan() {
        return listTinNhan;
    }

    public ArrayList<BaoHanh> getListBaoHanh() {
        return listBaoHanh;
    }

    public ArrayList<PhieuTraHang> getListPhieuTraHang() {
        return listPhieuTraHang;
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public ArrayList<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public ArrayList<KhachHang> getListKhachHang() {
        return listKhachHang;
    }

    public ArrayList<MaGiamGia> getListMaGiamGia() {
        return listMaGiamGia;
    }

    public ArrayList<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public ArrayList<PhieuBaoHanh> getListPhieuBaoHanh() {
        return listPhieuBaoHanh;
    }

    public ArrayList<QuanLy> getListQuanLy() {
        return listQuanLy;
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public ArrayList<TaiKhoan> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public void setLichTuan(LichLamViec lichTuan) {
        this.lichTuan = lichTuan;
    }

    public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public void setListBaoHanh(ArrayList<BaoHanh> listBaoHanh) {
        this.listBaoHanh = listBaoHanh;
    }

    public void setListCaLam(ArrayList<CaLam> listCaLam) {
        this.listCaLam = listCaLam;
    }

    public void setListMaGiamGiaDq(ArrayList<MaGiamGia> listMaGiamGiaDq) {
        this.listMaGiamGiaDq = listMaGiamGiaDq;
    }

    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public void setListTinNhan(ArrayList<TinNhan> listTinNhan) {
        this.listTinNhan = listTinNhan;
    }

    public void setListKhachHang(ArrayList<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }

    public void setListMaGiamGia(ArrayList<MaGiamGia> listMaGiamGia) {
        this.listMaGiamGia = listMaGiamGia;
    }

    public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public void setListPhieuBaoHanh(ArrayList<PhieuBaoHanh> listPhieuBaoHanh) {
        this.listPhieuBaoHanh = listPhieuBaoHanh;
    }

    public void setListHangThanhVien(ArrayList<HangThanhVien> listHangThanhVien) {
        this.listHangThanhVien = listHangThanhVien;
    }

    public void setListQuanLy(ArrayList<QuanLy> listQuanLy) {
        this.listQuanLy = listQuanLy;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public void setListTaiKhoan(ArrayList<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    public void setListPhieuTraHang(ArrayList<PhieuTraHang> listPhieuTraHang) {
        this.listPhieuTraHang = listPhieuTraHang;
    }

    public void setListLichTrongNgay(ArrayList<LichTrongNgay> listLichTrongNgay) {
        this.listLichTrongNgay = listLichTrongNgay;
    }

    public ArrayList<User> getListUser() {
        ArrayList<User> listUser = new ArrayList<>();
        listUser.addAll(listNhanVien);
        listUser.addAll(listQuanLy);
        return listUser;
    }

    public void xuatListNhanVien() {
        if (listNhanVien != null) {
            for (NhanVien nv : listNhanVien) {
                System.out.print(nv); // toString() của NhanVien đã in \n cuối
            }
        }
    }

    public void xuatListQuanLy() {
        if (listQuanLy != null) {
            for (QuanLy ql : listQuanLy) {
                System.out.print(ql);
            }
        }
    }

    public void xuatListHoaDon() {
        if (listHoaDon != null) {
            for (HoaDon hd : listHoaDon) {
                System.out.print(hd);
            }
        }
    }

    public void xuatListTaiKhoan() {
        if (listTaiKhoan != null) {
            for (TaiKhoan tk : listTaiKhoan) {
                System.out.print(tk);
            }
        }
    }

    public void xuatListSanPham() {
        if (listSanPham != null) {
            for (SanPham sp : listSanPham) {
                System.out.print(sp);
            }
        }
    }

    public void xuatListChiTietHoaDon() {
        if (listChiTietHoaDon != null) {
            for (ChiTietHoaDon cthd : listChiTietHoaDon) {
                System.out.print(cthd);
                xuatList(cthd.getListMaGiamGiaDaDung());
            }
            System.out.println("---------------------------------------------------");
        }
    }

    public void xuatListBaoHanh() {
        if (listBaoHanh != null) {
            for (BaoHanh bh : listBaoHanh) {
                System.out.print(bh);
            }
        }
    }

    public void xuatListPhieuBaoHanh() {
        if (listPhieuBaoHanh != null) {
            for (PhieuBaoHanh pbh : listPhieuBaoHanh) {
                System.out.print(pbh);
            }
        }
    }

    public void xuatListPhieuTraHang() {
        if (listPhieuTraHang != null) {
            for (PhieuTraHang pth : listPhieuTraHang) {
                System.out.print(pth);
            }
        }
    }

    public void xuatListKhachHang() {
        if (listKhachHang != null) {
            for (KhachHang kh : listKhachHang) {
                System.out.print(kh);
            }
        }
    }

    public void xuatListMaGiamGia() {
        if (listMaGiamGia != null) {
            for (MaGiamGia mg : listMaGiamGia) {
                System.out.print(mg);
            }
        }
    }

    public void xuatListMaGiamGiaDq() {
        if (listMaGiamGiaDq != null) {
            for (MaGiamGia mg : listMaGiamGiaDq) {
                System.out.print(mg);
            }
        }
    }

    public void xuatListHangThanhVien() {
        if (listHangThanhVien != null) {
            for (HangThanhVien htv : listHangThanhVien) {
                System.out.print(htv);
            }
        }
    }

    public void xuatListTinNhan() {
        if (listTinNhan != null) {
            for (TinNhan tn : listTinNhan) {
                System.out.print(tn);
            }
        }
    }

    public void xuatListCaLam() {
        if (listCaLam != null) {
            for (CaLam cl : listCaLam) {
                System.out.print(cl);
            }
        }
    }

    public void xuatListLichTrongNgay() {
        if (listLichTrongNgay != null) {
            for (LichTrongNgay ltn : listLichTrongNgay) {
                System.out.print(ltn);
            }
        }
    }

    public void xuatLichTuan() {
        if (lichTuan != null) {
            System.out.print(lichTuan);
        }
    }

    public static void xuatList(List<?> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách rỗng\n");
            return;
        }
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println(); // thêm \n ở cuối
    }

    public static void main(String[] args) {
        Database db = new Database();
        DocFile docFile = new DocFile(db);
        db.xuatListNhanVien();
    }

}
