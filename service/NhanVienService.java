import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

public class NhanVienService{
    private List<NhanVien> dsnv = new ArrayList<>();
    //them nhan vien 
    public void themNhanVien(NhanVien nv){

        dsnv.add(nv);
    }
    //tim nhan vien theo ma tra ve NhanVien
    public NhanVien timnhanvien(String ma){
        for(int i = 0; i < dsnv.size(); i++){
            NhanVien nv = dsnv.get(i);
            if(nv.getMa().equals(ma))
            return nv;
        }
        return null;
    }
    //xoa nhan vien 
    public boolean xoanhanvien(String ma){
        NhanVien nv =  timnhanvien(ma);
        if(nv != null){
            dsnv.remove(nv);
            return true;
        }
        return false;
    }
    //sua thong tin nhan vien 
    public void suathongtin(String ma, NhanVien nvMoi){
        NhanVien nv = timnhanvien(ma);
        if(nv != null){
            nv.setCccd(nvMoi.getCccd());
            nv.setTen(nvMoi.getTen());
            nv.setngaySinh(nvMoi.getngaySinh());
            nv.setSdt(nvMoi.getSdt());
            nv.setGioiTinh(nvMoi.getGioiTinh());
        }
    }
}