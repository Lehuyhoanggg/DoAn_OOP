package interfaces;

import model.TinNhan;
import model.User;

public interface GiaoTiep {
    public void guiTinNhan(String maNguoiNhan, TinNhan tinNhan);

    public void xemTatCaTinNhan(User user);

    public void xemTinNhanTrongNgay();
}
