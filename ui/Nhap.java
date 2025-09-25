package ui;

import java.util.Scanner;

public class Nhap {
    static Scanner sc = new Scanner(System.in);

    public static int nhapInt(String tuKhoa) {
        System.out.print(tuKhoa);
        int luaChon = sc.nextInt();
        sc.nextLine();
        return luaChon;
    }

    public static double nhapDouble(String tuKhoa) {
        System.out.print(tuKhoa);
        double luaChon = sc.nextDouble();
        sc.nextLine();
        return luaChon;
    }

    public static long nhapLong(String tuKhoa) {
        System.out.print(tuKhoa);
        long luaChon = sc.nextLong();
        sc.nextLine();
        return luaChon;
    }

    public static String nhapStr(String tuKhoa) {
        System.out.print(tuKhoa);
        return sc.nextLine();
    }

    public static char nhapChar(String tuKhoa) {
        System.out.print(tuKhoa);
        return sc.next().charAt(0);
    }

    public static int nhapXacNhanThoat() {
        System.out.print("(1)Tiep tuc (khac)thoat : ");
        int luaChon = sc.nextInt();
        sc.nextLine();
        return luaChon;
    }
}
