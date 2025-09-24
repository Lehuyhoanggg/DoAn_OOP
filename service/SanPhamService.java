package service;
import java.util.ArrayList;
import model.SanPham;

public class SanPhamService {
    private ArrayList<SanPham> listSanPham;

    public SanPhamService() {
        listSanPham = new ArrayList<>();
    }

    public SanPhamService(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public void themSanPham(SanPham sanPham) {
        listSanPham.add(sanPham);
    }

    public void xoaSanPham(String ma) {
        if (listSanPham == null) return;
        listSanPham.removeIf(sp -> sp.getMa().equals(ma));
    }

    public void suaSanPham(SanPham sanPham) {
        if (listSanPham == null) return;
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getMa().equals(sanPham.getMa())) {
                listSanPham.set(i, sanPham);
                break;
            }
        }
    }
    public void searchSanPham(String ten) {
        if (listSanPham == null) return;
        listSanPham.removeIf(sp -> !sp.getTen().toLowerCase().contains(ten.toLowerCase()));
    }
}
