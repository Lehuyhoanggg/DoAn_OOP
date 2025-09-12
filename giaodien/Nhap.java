package giaodien;

import java.util.Scanner;

public class Nhap {
    static Scanner sc = new Scanner(System.in);

    static int nhapInt(String tuKhoa) {
        System.out.print(tuKhoa);
        int luaChon = sc.nextInt();
        sc.nextLine();
        return luaChon;
    }

    static String nhapStr(String tuKhoa) {
        System.out.print(tuKhoa);
        return sc.nextLine();
    }

    static char nhapChar(String tuKhoa) {
        System.out.print(tuKhoa);
        return sc.next().charAt(0);
    }
}
