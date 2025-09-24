package model;

import java.util.HashMap;
import java.util.Map;

public class NhanVienDiemDanh {
    private Map<NhanVien, Boolean> mapNhanVien;

    public NhanVienDiemDanh() {
        mapNhanVien = new HashMap<>();
    }

    public Boolean kiemTraDiemDanh(NhanVien nhanVien) {
        if (mapNhanVien.get(nhanVien)) {
            return true;
        }
        return false;
    }

    public void themNhanVien(NhanVien nhanVien) {
        mapNhanVien.put(nhanVien, false);
    }

    public void diemDanhNhanVien(NhanVien nhanVien) {
        if (mapNhanVien.containsKey(nhanVien)) {
            mapNhanVien.put(nhanVien, true);
        }

    }

    public boolean tonTaiNhanVien(NhanVien nhanVien) {
        return mapNhanVien.containsKey(nhanVien);
    }
}
