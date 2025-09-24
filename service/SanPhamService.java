package service;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").toLowerCase();
    }

    public List<SanPham> searchSanPham(String ten) {
        if (listSanPham == null) return null;
        String keyword = removeAccent(ten);
        return listSanPham.stream()
                          .filter(sp -> removeAccent(sp.getTen()).contains(keyword))
                          .collect(Collectors.toList());
    }
}
