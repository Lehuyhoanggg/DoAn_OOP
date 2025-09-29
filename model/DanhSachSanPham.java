package model;

import java.util.HashMap;
import java.util.Map;

public class DanhSachSanPham {
    private Map<SanPham, Integer> mapSanPham;

    public DanhSachSanPham() {
        mapSanPham = new HashMap<>();
    }

    public Map<SanPham, Integer> getMapSanPham() {
        return mapSanPham;
    }

    public void setMapSanPham(Map<SanPham, Integer> mapSanPham) {
        this.mapSanPham = mapSanPham;
    }

    public boolean themSanPham(SanPham sanPham) {
        if (sanPham == null) {
            return false;
        }
        mapSanPham.put(sanPham, mapSanPham.containsKey(sanPham) ? mapSanPham.get(sanPham) + 1 : 1);
        return true;
    }

    public boolean xoa1SanPham(SanPham sanPham) {
        if (mapSanPham.containsKey(sanPham)) {
            if (mapSanPham.get(sanPham) > 1) {
                mapSanPham.put(sanPham, mapSanPham.get(sanPham) - 1);
            } else {
                mapSanPham.remove(sanPham);
            }
            return true;
        }
        return false;
    }

    public int getSoLuong(SanPham sanPham) {
        return mapSanPham.getOrDefault(sanPham, 0);
    }

    public boolean tonTaiSanPham(SanPham sanPham) {
        return mapSanPham.containsKey(sanPham);
    }
}
