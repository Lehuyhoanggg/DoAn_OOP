package danhsach;

import java.util.ArrayList;

import model.TinNhan;

public class DanhSachTinNhan {
    private ArrayList<TinNhan> listTinNhan;
    private int soLuong = 0;

    public DanhSachTinNhan(ArrayList<TinNhan> listTinNhan) {
        this.listTinNhan = listTinNhan;
    }

    public DanhSachTinNhan() {
    }

    public ArrayList<TinNhan> getListTinNhan() {
        return listTinNhan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setListTinNhan(ArrayList<TinNhan> listTinNhan) {
        this.listTinNhan = listTinNhan;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public TinNhan timTinNhan(String ma) {
        if (listTinNhan == null) {
            return null;
        }
        for (int i = 0; i < listTinNhan.size(); i++) {
            if (listTinNhan.get(i).getMa().equals(ma)) {
                return listTinNhan.get(i);
            }
        }
        return null;
    }

    public boolean themTinNhan(TinNhan tinNhan) {
        if (tinNhan == null) {
            return false;
        }
        return listTinNhan.add(tinNhan);
    }

    public boolean themTinNhan(String ma) {
        TinNhan tinNhan = timTinNhan(ma);
        if (tinNhan == null) {
            return false;
        }
        return listTinNhan.add(tinNhan);
    }

    public boolean xoaTinNhan(TinNhan tinNhan) {
        if (tinNhan == null) {
            return false;
        }
        return listTinNhan.remove(tinNhan);
    }

    public boolean xoaTinNhan(String ma) {
        TinNhan tinNhan = timTinNhan(ma);
        if (tinNhan == null) {
            return false;
        }
        return listTinNhan.remove(tinNhan);
    }
}
