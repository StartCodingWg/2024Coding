package march.day31;

/**
 * Author:   wang
 * Date:     2024/3/31 21:02
 * function: 对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 */
public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        /* 特殊处理 */
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return "";
        if (str1.length() == str2.length()) return str1.equals(str2) ? str1 : "";
        // 获取最大公约数
        int len = getMax(Math.max(str1.length(), str2.length()), Math.min(str1.length(), str2.length()));
        /* 获取所有因数，然后从最大因数开始是否可以获取想要的结果 */
        String ext = str1.substring(0, len);
        StringBuilder sb1 = new StringBuilder();
        for (int i = str1.length() / len; i > 0; i--) {
            sb1.append(ext);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = str2.length() / len; i > 0; i--) {
            sb2.append(ext);
        }
        if (str1.equals(sb1.toString()) && str2.equals(sb2.toString())) return ext;
        return "";
    }

    private int getMax(int len1, int len2) {
        while (len1 % len2 != 0) {
            int tem = len2;
            len2 = len1 % len2;
            len1 =tem;
        }
        return len2;
    }
}
