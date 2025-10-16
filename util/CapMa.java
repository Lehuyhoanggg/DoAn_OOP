package util;

import database.Database;

public class CapMa {

    public static String capMaPhieuTraHang(Database db) {
        String soPTH = String.valueOf(db.getListPhieuTraHang().size() + 1);
        while (soPTH.length() < 3) {
            soPTH = "0" + soPTH;
        }
        return "PTH" + soPTH;
    }

    public static String capMaBaoHanh(Database db) {
        String soBH = String.valueOf(db.getListBaoHanh().size() + 1);
        while (soBH.length() < 3) {
            soBH = "0" + soBH;
        }
        return "BH" + soBH;
    }

    public static String capMaPhieuBaoHanh(Database db) {
        String soPBH = String.valueOf(db.getListPhieuBaoHanh().size() + 1);
        while (soPBH.length() < 3) {
            soPBH = "0" + soPBH;
        }
        return "PBH" + soPBH;
    }

    public static String capMaKhachHang(Database db) {
        String soKh = String.valueOf(db.getListKhachHang().size() + 1);
        while (soKh.length() < 3) {
            soKh = "0" + soKh;
        }
        return "KH" + soKh;

    }

    public static String capMaChiTietHoaDon(Database db) {
        String soCTHD = String.valueOf(db.getListChiTietHoaDon().size() + 1);
        while (soCTHD.length() < 3) {
            soCTHD = "0" + soCTHD;
        }
        return "CTHD" + soCTHD;
    }

    public static String capMaHoaDon(Database db) {
        String soHD = String.valueOf(db.getListHoaDon().size() + 1);
        while (soHD.length() < 3) {
            soHD = "0" + soHD;
        }
        return "HD" + soHD;
    }

    public static String capMaMaGiamGia(Database db) {
        String soMGG = String.valueOf(db.getListMaGiamGia().size() + 1);
        while (soMGG.length() < 3) {
            soMGG = "0" + soMGG;
        }
        return "MGG" + soMGG;
    }

    public static String capMaNhanVien(Database db) {
        String soNV = String.valueOf(db.getListNhanVien().size() + 1);
        while (soNV.length() < 3) {
            soNV = "0" + soNV;
        }
        return "NV" + soNV;
    }

    public static String capMaQuanly(Database db) {
        String soQL = String.valueOf(db.getListQuanLy().size() + 1);
        while (soQL.length() < 3) {
            soQL = "0" + soQL;
        }
        return "QL" + soQL;
    }

    public static String capMaSanPham(Database db) {
        String soSP = String.valueOf(db.getListSanPham().size() + 1);
        while (soSP.length() < 3) {
            soSP = "0" + soSP;
        }
        return "SP" + soSP;
    }

    public static String capMaTinNhan(Database db) {
        String soTN = String.valueOf(db.getListTinNhan().size() + 1);
        while (soTN.length() < 3) {
            soTN = "0" + soTN;
        }
        return "TN" + soTN;
    }

    public static String capMaCaLam(Database db) {
        String soCL = String.valueOf(db.getListCaLam().size() + 1);
        while (soCL.length() < 3) {
            soCL = "0" + soCL;
        }
        return "CA" + soCL;
    }

    public static String capMaLichTrongNgay(Database db) {
        String soLTN = String.valueOf(db.getListLichTrongNgay().size() + 1);
        while (soLTN.length() < 3) {
            soLTN = "0" + soLTN;
        }
        return "LTN" + soLTN;
    }

    public static String capMaLichTrongTuan(Database db) {
        String soLTT = String.valueOf(db.getListLichTrongTuan().size() + 1);
        while (soLTT.length() < 3) {
            soLTT = "0" + soLTT;
        }
        return "LTT" + soLTT;
    }

    public static String capMaSanPhamDaban(Database db) {
        String soSPDB = String.valueOf(db.getDanhSachSanPhamDaBan().getListSanPhamDaBan().size() + 1);
        while (soSPDB.length() < 3) {
            soSPDB = "0" + soSPDB;
        }
        return "SPDB" + soSPDB;
    }
}