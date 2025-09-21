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

    public void luuSanPham(SanPham sanPham) {
        mapSanPham.put(sanPham, mapSanPham.containsKey(sanPham) ? mapSanPham.get(sanPham) + 1 : 0);
    }

}
