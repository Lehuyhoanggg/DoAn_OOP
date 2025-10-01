package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

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

    public static boolean gioTrongKhoan(String gio, String gioBatDau, String gioKetThuc) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime g = LocalTime.parse(gio, fmt);
        LocalTime batDau = LocalTime.parse(gioBatDau, fmt);
        LocalTime ketThuc = LocalTime.parse(gioKetThuc, fmt);

        if (ketThuc.isBefore(batDau)) {
            return !g.isBefore(batDau) || !g.isAfter(ketThuc);
        }
        return !g.isBefore(batDau) && !g.isAfter(ketThuc);
    }

    public static boolean ngayTrongKhoan(String ngay, String ngayBatDau, String ngayKetThuc) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate g = LocalDate.parse(ngay, fmt);
        LocalDate batDau = LocalDate.parse(ngayBatDau, fmt);
        LocalDate ketThuc = LocalDate.parse(ngayKetThuc, fmt);

        // nằm trong hoặc bằng hai đầu mút
        return (!g.isBefore(batDau)) && (!g.isAfter(ketThuc));
    }

    public static LocalDate chuyenStrThanhDate(String ngay) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(ngay, fmt);
    }

    public static ArrayList<String> layTuanHienTaiStr() {
        ArrayList<String> listNgay = new ArrayList<>();

        LocalDate today = LocalDate.now();
        TemporalField dayOfWeekField = WeekFields.of(Locale.getDefault()).dayOfWeek();
        LocalDate batDau = today.with(dayOfWeekField, 1);
        LocalDate ketThuc = today.with(dayOfWeekField, 7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date = batDau;
        while (!date.isAfter(ketThuc)) {
            listNgay.add(date.format(formatter));
            date = date.plusDays(1);
        }

        return listNgay;

    }

    public static String layThangHienTai() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return today.format(formatter);
    }

    public static String layNgayDauTuanStr() {
        LocalDate today = LocalDate.now();
        TemporalField dayOfWeekField = WeekFields.of(Locale.getDefault()).dayOfWeek();
        LocalDate batDau = today.with(dayOfWeekField, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return batDau.format(formatter);
    }

    public static String layNgayCuoiTuanStr() {
        LocalDate today = LocalDate.now();
        TemporalField dayOfWeekField = WeekFields.of(Locale.getDefault()).dayOfWeek();
        LocalDate batDau = today.with(dayOfWeekField, 7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return batDau.format(formatter);
    }

    public static String layNgayCuoiThangStr() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        YearMonth ym = YearMonth.now(); // lấy năm-tháng hiện tại
        LocalDate lastDay = ym.atEndOfMonth(); // ngày cuối của tháng đó
        return lastDay.format(fmt);
    }

    public static String layNgayDauThangStr() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate firstDay = LocalDate.now().withDayOfMonth(1);
        return firstDay.format(fmt);
    }

    public static LocalDate chuyenNgayStrThanhLocalData(String ngay) {
        return LocalDate.parse(ngay);
    }

    public static long khoangCachNgay(String ngayBd, String ngayKt) {
        LocalDate ngayBdLocal = chuyenNgayStrThanhLocalData(ngayBd);
        LocalDate ngayKtLocal = chuyenNgayStrThanhLocalData(ngayKt);
        return ChronoUnit.DAYS.between(ngayBdLocal, ngayKtLocal);
    }
}