package danhsach;

import java.util.ArrayList;

import interfaces.QuanLyDanhSach;
import model.TinNhan;

public class DanhSachTinNhan implements QuanLyDanhSach<TinNhan> {
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

    public TinNhan tim(String ma) {
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

    public boolean them(TinNhan tinNhan) {
        if (tinNhan == null) {
            return false;
        }
        return listTinNhan.add(tinNhan);
    }

    public boolean them(String ma) {
        TinNhan tinNhan = tim(ma);
        if (tinNhan == null) {
            return false;
        }
        return listTinNhan.add(tinNhan);
    }

    public boolean xoa(TinNhan tinNhan) {
        if (tinNhan == null) {
            return false;
        }
        return listTinNhan.remove(tinNhan);
    }

    public boolean xoa(String ma) {
        TinNhan tinNhan = tim(ma);
        if (tinNhan == null) {
            return false;
        }
        return listTinNhan.remove(tinNhan);
    }
}
