package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ThoiGian {
    public static String layNgayHienTaiStr() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return today.format(fmt);
    }

    public static LocalDate layNgayHienTai() {
        LocalDate today = LocalDate.now();
        return today;
    }

    public static String layGioHienTai() {
        LocalTime now = LocalTime.now(); // Lấy giờ hiện tại của hệ thống
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        return now.format(fmt); // Trả về chuỗi "HH:mm"
    }

    public static boolean trongKhoan(String gio, String gioBatDau, String gioKetThuc) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime g = LocalTime.parse(gio, fmt);
        LocalTime batDau = LocalTime.parse(gioBatDau, fmt);
        LocalTime ketThuc = LocalTime.parse(gioKetThuc, fmt);

        if (ketThuc.isBefore(batDau)) {
            return !g.isBefore(batDau) || !g.isAfter(ketThuc);
        }
        return !g.isBefore(batDau) && !g.isAfter(ketThuc);
    }

    public static LocalDate chuyenStrThanhDate(String ngay) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(ngay, fmt);
    }
}
