package model;

import java.time.LocalDate;

import util.ThoiGian;

public class TinNhan {
    private String ma;
    private String tenNgGui;
    private String noiDung;
    private LocalDate ngayGui;

    public TinNhan(String ma, String tenNgGui, String noiDung, String ngayGui) {
        this.ma = ma;
        this.tenNgGui = tenNgGui;
        this.noiDung = noiDung;
        this.ngayGui = ThoiGian.chuyenStrThanhDate(ngayGui);
    }

    public String getMa() {
        return ma;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public String getTenNgGui() {
        return tenNgGui;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setTenNgGui(String tenNgGui) {
        this.tenNgGui = tenNgGui;
    }

    public void setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
    }
}
