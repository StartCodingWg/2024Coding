package april.day27;

/**
 * Author:   wang
 * Date:     2024/4/27 23:11
 * function:
 * ����һ�����������Ǻ� * ���ַ��� s ��
 *
 * ��һ�������У�����ԣ�
 *
 * ѡ�� s �е�һ���Ǻš�
 * �Ƴ��Ǻ� ��� ������Ǹ� ���Ǻ� �ַ������Ƴ����Ǻ�����
 * �����Ƴ� ���� �Ǻ�֮����ַ�����
 * ֱ��ʹ�����鼴�ɣ���
 */
public class RemoveStars {
    public String removeStars(String s) {
        /* ����������� */
        if (s == null || s.length() < 2) return s;
        /* ֱ�Ӵ��� */
        char[] res = s.toCharArray();
        // ˫ָ��
        int vaildIdx = 0;
        for (int i = 1; i < res.length; i++) {
            if (res[i] == '*') {
                vaildIdx--;
            } else {
                res[++vaildIdx] = res[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= vaildIdx; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

}
