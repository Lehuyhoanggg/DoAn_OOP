package util;

import database.Database;

public class CapMa {

    public static String capMaPhieuTraHang(Database db) {
        String soPTH = String.valueOf(db.getListPhieuTraHang());
        while (soPTH.length() < 3) {
            soPTH = "0" + soPTH;
        }
        return "PTH" + soPTH;
    }

    public static String capMaBaoHanh(Database db) {
        String soBH = String.valueOf(db.getListBaoHanh().size());
        while (soBH.length() < 3) {
            soBH = "0" + soBH;
        }
        return "BH" + soBH;
    }

    public static String capMaPhieuBaoHanh(Database db) {
        String soPBH = String.valueOf(db.getListPhieuBaoHanh().size());
        while (soPBH.length() < 3) {
            soPBH = "0" + soPBH;
        }
        return "PBH" + soPBH;
    }

    public static String capMaKhachHang(Database db) {
        String soKh = String.valueOf(db.getListKhachHang().size());
        while (soKh.length() < 3) {
            soKh = "0" + soKh;
        }
        return "KH" + soKh;

    }

    public static String capMaChiTietHoaDon(Database db) {
        String soCTHD = String.valueOf(db.getListChiTietHoaDon().size());
        while (soCTHD.length() < 3) {
            soCTHD = "0" + soCTHD;
        }
        return "CTHD" + soCTHD;
    }

    public static String capMaHoaDon(Database db) {
        String soHD = String.valueOf(db.getListHoaDon().size());
        while (soHD.length() < 3) {
            soHD = "0" + soHD;
        }
        return "HD" + soHD;
    }

    public static String capMaMaGiamGia(Database db) {
        String soMGG = String.valueOf(db.getListMaGiamGia().size());
        while (soMGG.length() < 3) {
            soMGG = "0" + soMGG;
        }
        return "MGG" + soMGG;
    }

    public static String capMaNhanVien(Database db) {
        String soNV = String.valueOf(db.getListNhanVien().size());
        while (soNV.length() < 3) {
            soNV = "0" + soNV;
        }
        return "NV" + soNV;
    }

    public static String capMaQuanly(Database db) {
        String soQL = String.valueOf(db.getListQuanLy().size());
        while (soQL.length() < 3) {
            soQL = "0" + soQL;
        }
        return "QL" + soQL;
    }

    public static String capMaSanPham(Database db) {
        String soSP = String.valueOf(db.getListSanPham().size());
        while (soSP.length() < 3) {
            soSP = "0" + soSP;
        }
        return "SP" + soSP;
    }

    public static String capMaTinNhan(Database db) {
        String soTN = String.valueOf(db.getListTinNhan().size());
        while (soTN.length() < 3) {
            soTN = "0" + soTN;
        }
        return "TN" + soTN;
    }

}