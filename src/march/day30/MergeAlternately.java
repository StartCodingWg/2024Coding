package march.day30;

/**
 * Author:   wang
 * Date:     2024/3/30 22:10
 * function: ���������ַ��� word1 �� word2 ��
 *      ����� word1 ��ʼ��ͨ�����������ĸ���ϲ��ַ�����
 *      ���һ���ַ�������һ���ַ��������ͽ����������ĸ׷�ӵ��ϲ����ַ�����ĩβ��
 */
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null) return word2;
        if (word2 == null) return word1;
        StringBuilder sb = new StringBuilder();
        char[] idx1 = word1.toCharArray();
        char[] idx2 = word2.toCharArray();
        int i1 = 0, i2 = 0;
        for (; i1 < idx1.length && i2 < idx2.length; i1++, i2++) {
            sb.append(idx1[i1]).append(idx2[i2]);
        }
        for (; i1 < idx1.length; i1++) {
            sb.append(idx1[i1]);;
        }
        for (; i2 < idx2.length; i2++) {
            sb.append(idx2[i2]);;
        }
        return sb.toString();
    }

}
