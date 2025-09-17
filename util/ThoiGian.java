package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ThoiGian {
    public static String layNgayHienTai() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return today.format(fmt);
    }

    public static LocalDate chuyenStrThanhDate(String ngay) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(ngay, fmt);
    }
}
