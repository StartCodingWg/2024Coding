package april.day08;

/**
 * Author:   wang
 * Date:     2024/4/8 22:04
 * function:
 * ����һ���ַ����� chars ����ʹ�������㷨ѹ����
 * ��һ�����ַ��� s ��ʼ������ chars �е�ÿ�� �����ظ��ַ� ��
 * �����һ�鳤��Ϊ 1 �����ַ�׷�ӵ� s �С�
 * ������Ҫ�� s ׷���ַ��������һ��ĳ��ȡ�
 * ѹ����õ����ַ��� s ��Ӧ��ֱ�ӷ��� ����Ҫת�����ַ����� chars �С���Ҫע����ǣ�����鳤��Ϊ 10 �� 10 ���ϣ����� chars �����лᱻ���Ϊ����ַ���
 * ���� �޸������������ �����ظ�������³��ȡ�
 * �������Ʋ�ʵ��һ��ֻʹ�ó�������ռ���㷨����������⡣
 */
public class Compress {
    public int compress(char[] chars) {
        /* ����������� */
        if (chars == null || chars.length <= 0) return 0;
        /* ��ʼͳ�ƣ�ʹ��˫ָ�� */
        int first = 0;
        int second = 0;
        int res = 0;
        while (second <= chars.length) {
            if (second == chars.length || chars[second] != chars[first]) {
                /* ����д�� char */
                // д���ַ�
                chars[res++] = chars[first];
                // д����ַ����ֵĴ���
                int num = second - first;
                if (num > 1) {
                    String strNum = String.valueOf(num);
                    for (int i = 0; i < strNum.length(); i++) {
                        chars[res++] = strNum.charAt(i);
                    }
                }
                // ���¶�λ��ָ��
                first = second;
            }
            second++;
        }
        return res;
    }
}
