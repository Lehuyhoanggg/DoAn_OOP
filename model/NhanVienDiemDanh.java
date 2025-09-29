package model;

import java.util.HashMap;
import java.util.Map;

public class NhanVienDiemDanh {
    private Map<NhanVien, Boolean> mapNhanVien;

    public NhanVienDiemDanh() {
        mapNhanVien = new HashMap<>();
    }

    public Map<NhanVien, Boolean> getMapNhanVien() {
        return mapNhanVien;
    }

    public Boolean kiemTraDiemDanh(NhanVien nhanVien) {
        if (nhanVien == null) {
            return false;
        }
        return mapNhanVien.get(nhanVien);
    }

    public boolean themNhanVien(NhanVien nhanVien) {
        if (nhanVien == null) {
            return false;
        }
        return mapNhanVien.put(nhanVien, false);
    }

    public boolean xoaNhanVien(NhanVien nhanVien) {
        if (nhanVien == null) {
            return false;
        }
        return mapNhanVien.remove(nhanVien);
    }

    public boolean diemDanhNhanVien(NhanVien nhanVien) {
        if (nhanVien == null) {
            return false;
        }
        if (mapNhanVien.containsKey(nhanVien)) {
            mapNhanVien.put(nhanVien, true);
            return true;
        }
        return false;
    }

    public int soNhanVienDaXep() {
        return mapNhanVien.size();
    }

    public boolean tonTaiNhanVien(NhanVien nhanVien) {
        return mapNhanVien.containsKey(nhanVien);
    }
}
