package ui;

import java.util.Scanner;

public class Nhap {
    static Scanner sc = new Scanner(System.in);

    private static boolean laSo(String so) {
        for (int i = 0; i < so.length(); i++) {
            if (i == 0 && so.length() > 1 && so.charAt(i) == '-')
                continue;
            if (!Character.isDigit(so.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean laSoThuc(String so) {
        try {
            Double.parseDouble(so);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean laSoLong(String so) {
        try {
            Long.parseLong(so);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int nhapInt(String tuKhoa) {
        String luaChon;
        do {
            System.out.print(tuKhoa);
            luaChon = sc.nextLine();
            if (!laSo(luaChon)) {
                System.out.println("Chi duoc nhap so nguyen");
            }
        } while (!laSo(luaChon));

        return Integer.parseInt(luaChon);
    }

    public static double nhapDouble(String tuKhoa) {
        String luaChon;
        do {
            System.out.print(tuKhoa);
            luaChon = sc.nextLine();
            if (!laSoThuc(luaChon)) {
                System.out.println("Chi duoc nhap so thuc");
            }
        } while (!laSoThuc(luaChon));

        return Double.parseDouble(luaChon);
    }

    public static long nhapLong(String tuKhoa) {
        String luaChon;
        do {
            System.out.print(tuKhoa);
            luaChon = sc.nextLine();
            if (!laSoLong(luaChon)) {
                System.out.println("Chi duoc nhap so nguyen");
            }
        } while (!laSoLong(luaChon));

        return Long.parseLong(luaChon);
    }

    public static String nhapStr(String tuKhoa) {
        System.out.print(tuKhoa);
        return sc.nextLine();
    }

    public static char nhapChar(String tuKhoa) {
        String luaChon;
        do {
            System.out.print(tuKhoa);
            luaChon = sc.nextLine();
            if (luaChon.length() != 1) {
                System.out.println("Chi duoc nhap 1 ky tu");
            }
        } while (luaChon.length() != 1);

        return luaChon.charAt(0);
    }
}