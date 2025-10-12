package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;

public class ThoiGian {
    public static String layNgayHienTaiStr() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return today.format(fmt);
    }

    public static String layGioHienTai() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        return now.format(fmt);
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

        return (!g.isBefore(batDau)) && (!g.isAfter(ketThuc));
    }

    public static LocalDate chuyenStrThanhDate(String ngay) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(ngay, fmt);
    }

    public static String chuyenDateThanhStr(LocalDate ngay) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ngay.format(fmt);
    }

    public static ArrayList<String> layTuanHienTaiStr() {
        ArrayList<String> listNgay = new ArrayList<>();

        LocalDate today = LocalDate.now();
        TemporalField dayOfWeekField = WeekFields.ISO.dayOfWeek();
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
        TemporalField dayOfWeekField = WeekFields.ISO.dayOfWeek();
        LocalDate batDau = today.with(dayOfWeekField, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return batDau.format(formatter);
    }

    public static String layNgayDauTuanStr(int soTuan) {
        LocalDate today = LocalDate.now();
        int nam = today.getYear();

        WeekFields wf = WeekFields.ISO;

        LocalDate ngayDauTuan = LocalDate
                .ofYearDay(nam, 1)
                .with(wf.weekOfYear(), soTuan)
                .with(wf.dayOfWeek(), 1);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ngayDauTuan.format(fmt);
    }

    public static String layNgayCuoiTuanStr() {
        LocalDate today = LocalDate.now();
        TemporalField dayOfWeekField = WeekFields.ISO.dayOfWeek();
        LocalDate batDau = today.with(dayOfWeekField, 7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return batDau.format(formatter);
    }

    public static String layNgayCuoiThangStr() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        YearMonth ym = YearMonth.now();
        LocalDate lastDay = ym.atEndOfMonth();
        return lastDay.format(fmt);
    }

    public static String layNgayDauThangStr() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate firstDay = LocalDate.now().withDayOfMonth(1);
        return firstDay.format(fmt);
    }

    public static long khoangCachNgay(String ngayBd, String ngayKt) {
        LocalDate ngayBdLocal = chuyenStrThanhDate(ngayBd);
        LocalDate ngayKtLocal = chuyenStrThanhDate(ngayKt);
        return ChronoUnit.DAYS.between(ngayBdLocal, ngayKtLocal);
    }

    public static String ngaySauNThang(String ngay, int n) {
        LocalDate localDate = chuyenStrThanhDate(ngay);
        localDate = localDate.plusMonths(n);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(fmt);
    }

    public static String ngayTiepTheo(String ngay) {
        LocalDate ngayLCD = chuyenStrThanhDate(ngay);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ngayLCD.plusDays(1).format(fmt);
    }

    public static String nNgayTiepTheo(String ngay, int n) {
        LocalDate ngayLCD = chuyenStrThanhDate(ngay);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ngayLCD.plusDays(n).format(fmt);
    }

    public static int soTuanHienTai() {
        LocalDate today = LocalDate.now();
        WeekFields weekFields = WeekFields.ISO;
        return today.get(weekFields.weekOfYear());
    }

    public static int laySoTuanTrongNam(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        WeekFields weekFields = WeekFields.ISO;
        int weekOfYear = date.get(weekFields.weekOfWeekBasedYear());
        
        return weekOfYear;
    }
}