package march.day31;

/**
 * Author:   wang
 * Date:     2024/3/31 21:02
 * function: �����ַ��� s �� t��ֻ���� s = t + t + t + ... + t + t��t �������� 1 �λ��Σ�ʱ�����ǲ��϶� ��t �ܳ��� s����
 */
public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        /* ���⴦�� */
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return "";
        if (str1.length() == str2.length()) return str1.equals(str2) ? str1 : "";
        // ��ȡ���Լ��
        int len = getMax(Math.max(str1.length(), str2.length()), Math.min(str1.length(), str2.length()));
        /* ��ȡ����������Ȼ������������ʼ�Ƿ���Ի�ȡ��Ҫ�Ľ�� */
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
