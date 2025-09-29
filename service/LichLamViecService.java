package service;

import java.util.ArrayList;

import model.CaLam;
import model.LichLamViec;
import model.LichTrongNgay;
import model.NhanVien;
import util.ThoiGian;

public class LichLamViecService {
    private LichLamViec lichLamViec;

    public LichLamViecService(LichLamViec lichLamViec) {
        this.lichLamViec = lichLamViec;
    }

    public LichTrongNgay lichTrongNgayHomNay() {
        String ngayHomNay = ThoiGian.layNgayHienTaiStr();
        ArrayList<LichTrongNgay> lichTuan = lichLamViec.getLichTuan();
        if (lichTuan == null) {
            return null;
        }
        for (int i = 0; i < lichTuan.size(); i++) {
            if (lichTuan.get(i).getNgay().equals(ngayHomNay)) {
                return lichTuan.get(i);
            }
        }
        return null;
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

    public boolean diemDanh(NhanVien nhanVien) {
        LichTrongNgay lichTrongNgay = lichTrongNgayHomNay();
        String gioHienTai = ThoiGian.layGioHienTai();
        CaLam caLam = caLamHienTai(gioHienTai, lichTrongNgay);
        if (lichTrongNgay == null || caLam == null) {
            return false;
        }
        if (tonTaiNhanVienTrongCa(nhanVien, caLam)) {
            return caLam.diemDanh(nhanVien);
        }
        return false;
    }

    public boolean tonTaiNhanVienTrongCa(NhanVien nhanVien, CaLam caLam) {
        return caLam.tonTaiNhanVien(nhanVien);
    }

    public CaLam timCaLam(int soCa, LichTrongNgay lichTrongNgay) {
        if (lichTrongNgay == null) {
            return null;
        }
        ArrayList<CaLam> listCaLam = lichTrongNgay.getListCaLam();
        for (CaLam caLam : listCaLam) {
            if (caLam.getSo() == soCa) {
                return caLam;
            }
        }
        return null;
    }
}
