package april.day04;

/**
 * ʱ�䣺2024/4/4
 * ����������
 * �����/���˼·��
 * ����һ���ַ��� s �����㷴ת�ַ����� ���� ��˳��
 * ���� ���ɷǿո��ַ���ɵ��ַ�����s ��ʹ������һ���ո��ַ����е� ���� �ָ�����
 * ���� ���� ˳��ߵ��� ���� ֮���õ����ո����ӵĽ���ַ�����
 * ע�⣺�����ַ��� s�п��ܻ����ǰ���ո�β��ո���ߵ��ʼ�Ķ���ո񡣷��صĽ���ַ����У����ʼ�Ӧ�����õ����ո�ָ����Ҳ������κζ���Ŀո�
 * ���룺
 */
public class ReverseWords {
    public String reverseWords(String s) {
        /* ����������� */
        if (s == null || "".equals(s) || "".equals(s.trim())) return "";
        /* ʹ��˫ָ�� */
        StringBuilder sbHead = new StringBuilder();
        StringBuilder sbTail = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            /* �������ҵ��ַ��� */
            int vaildIndex = -1;
            while (left <= right && s.charAt(left) == ' ') left++;
            vaildIndex = left;
            while (left <= right && s.charAt(left) != ' ') left++;
            if (vaildIndex <= right) sbTail.insert(0, " " + s.substring(vaildIndex, left));
            /* ���ҵ������ַ��� */
            vaildIndex = -1;
            while (left <= right && s.charAt(right) == ' ') right--;
            vaildIndex = right;
            while (left <= right && s.charAt(right) != ' ') right--;
            if (vaildIndex >= left) sbHead.append(" ").append(s.substring(right + 1, vaildIndex + 1));
        }
        return (sbHead + sbTail.toString()).trim();
    }
}
