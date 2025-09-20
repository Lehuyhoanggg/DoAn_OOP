package interfaces;

import database.Database;

public interface Xuli_File_Datakhoidau {
    public void doc_NhanVientxt(String path);

    public void doc_QuanLytxt(String path);

    public void doc_SanPhantxt(String path);

    public void doc_KhachHangtxt(String path);

    public void doc_MaGiamGiatxt(String path);

    public void doc_ChiTietHoaDontxt(String path);

    public void doc_ChiTietHoaDon_BaoHanhtxt(String path);

    public void doc_ChiTietHoaDon_SanPhamtxt(String path);

    public void docDataKhoiDauVaoDatabase();
}
