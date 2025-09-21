import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import model.NhanVien;

public class NhanVienService{
    private List<NhanVien> dsnv;
    //contructor
    public NhanVienService(){
        
    }
    public NhanVienService(List<NhanVien> dsnv){
        this.dsnv = dsnv;
    }
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
    public void xoanhanvien(String ma){
        NhanVien nv =  timnhanvien(ma);

        dsnv.remove(nv);

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
=======
import model.NhanVien;

public class NhanVienService {
    private ArrayList<NhanVien> dsnv;

    // contructor
    public NhanVienService() {

    }

    public NhanVienService(ArrayList<NhanVien> dsnv) {
        this.dsnv = dsnv;
    }

    // them nhan vien
    public void themNhanVien(NhanVien nv) {

        dsnv.add(nv);
    }

    // tim nhan vien theo ma tra ve NhanVien
    public NhanVien timnhanvien(String ma) {
        for (int i = 0; i < dsnv.size(); i++) {
            NhanVien nv = dsnv.get(i);
            if (nv.getMa().equals(ma))
                return nv;
        }
        return null;
    }

    // xoa nhan vien
    public void xoanhanvien(String ma) {
        NhanVien nv = timnhanvien(ma);

        dsnv.remove(nv);

    }

    // sua thong tin nhan vien
    public void suathongtin(String ma, NhanVien nvMoi) {
        NhanVien nv = timnhanvien(ma);
        if (nv != null) {
            nv.setCccd(nvMoi.getCccd());
            nv.setTen(nvMoi.getTen());
            nv.setngaySinh(nvMoi.getngaySinh());
            nv.setSdt(nvMoi.getSdt());
            nv.setGioiTinh(nvMoi.getGioiTinh());
        }
    }
>>>>>>> 165be0d789370205e6e2a9332c0cdcd22e97234a
}