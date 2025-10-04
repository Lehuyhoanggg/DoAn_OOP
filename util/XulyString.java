package util;

public class XulyString {
    public static String dongGoiStr(String s) {
        return s.trim().replaceAll("\\s+", "_");
    }

    public static String chuyenLaiDangStrMacDinh(String s) {
        return s.replaceAll("_", " ");
    }
}
