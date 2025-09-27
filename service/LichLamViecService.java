package service;

import java.util.ArrayList;

import model.CaLam;
import model.LichLamViec;
import model.LichTrongNgay;
import model.NhanVien;
import model.NhanVienDiemDanh;
import util.ThoiGian;

public class LichLamViecService {
    private LichLamViec lichLamViec;

    public LichLamViecService(LichLamViec lichLamViec) {
        this.lichLamViec = lichLamViec;
    }

    public LichLamViec getLichLamViec() {
        return lichLamViec;
    }

    public void diemDanh(NhanVien nhanVien) {
        LichTrongNgay lichTrongNgay = lichTrongNgayHomNay();
        String gioHienTai = ThoiGian.layGioHienTai();
        CaLam caLam = caLamHienTai(gioHienTai, lichTrongNgay);
        if (lichTrongNgay == null || caLam == null) {
            return;
        }
        if (tonTaiNhanVienTrongCa(nhanVien, caLam)) {
            caLam.diemDanh(nhanVien);
        }
    }

    public boolean tonTaiNhanVienTrongCa(NhanVien nhanVien, CaLam caLam) {
        NhanVienDiemDanh mapNhanVien = caLam.getListNhanVien();
        if (mapNhanVien == null) {
            return false;
        }

        return mapNhanVien.tonTaiNhanVien(nhanVien);
    }

    public CaLam caLamHienTai(String gio, LichTrongNgay lichTrongNgay) {
        if (lichTrongNgay == null) {
            return null;
        }
        ArrayList<CaLam> listCaLam = lichTrongNgay.getListCaLam();
        if (listCaLam == null) {
            return null;
        }
        for (int i = 0; i < listCaLam.size(); i++) {
            if (ThoiGian.gioTrongKhoan(gio, listCaLam.get(i).getGioBatDau(), listCaLam.get(i).getGioKetThuc())) {
                return listCaLam.get(i);
            }
        }
        return null;
    }

    public LichTrongNgay lichTrongNgayHomNay() {
        String ngayHomNay = ThoiGian.layNgayHienTaiStr();
        ArrayList<LichTrongNgay> lichTuan = lichLamViec.getLichTuan();
        if (lichTuan == null) {
            return null;
        }
        for (int i = 0; i < lichTuan.size(); i++) {
            if (lichTuan.get(i).getNgay() == ngayHomNay) {
                return lichTuan.get(i);
            }
        }
        return null;
    }

}
