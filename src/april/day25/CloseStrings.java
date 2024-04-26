package april.day25;

/**
 * Author:   wang
 * Date:     2024/4/25 22:19
 * function:
 * �������ʹ�����²�����һ���ַ����õ���һ���ַ���������Ϊ�����ַ��� �ӽ� ��
 *
 * ���� 1�������������� ���� �ַ���
 * ���磬abcde -> aecdb
 * ���� 2����һ�� ���� �ַ���ÿ�γ���ת��Ϊ��һ�� ���� �ַ���������һ���ַ�ִ����ͬ�Ĳ�����
 * ���磬aacabb -> bbcbaa������ a ת��Ϊ b �������е� b ת��Ϊ a ��
 * ����Ը�����Ҫ������һ���ַ������ʹ�������ֲ�����
 *
 * ���������ַ�����word1 �� word2 ����� word1 �� word2 �ӽ� ���ͷ��� true �����򣬷��� false ��
 * ʵ�֣�ʹ�� hash�����ʾ����ж������ַ������ַ��������Ƿ�һ�£��Լ��ַ����ֵĴ����Ƿ�һ�£��������ַ����ֵ����ࣩ
 *
 */
public class CloseStrings {
    /***
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�ӵģ�O��n��
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {
        /* ������� */
        if (word1 == word2) return true;
        if (word1 == null || word2 == null) return false;
        if (word1.length() != word2.length()) return false;
        /* ���������ַ�����ÿ���ַ������ֵĴ��� */
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            word1Count[charArray1[i] - 'a']++;
            word2Count[charArray2[i] - 'a']++;
        }
        /* �ж������ַ������ַ������Ƿ�һ�� */
        int[] time = new int[100001];
        for (int i = 0; i < word1Count.length; i++) {
            if ((word1Count[i] == 0 && word2Count[i] != 0) ||
                    (word1Count[i] != 0 && word2Count[i] == 0))
                return false;
            else time[word1Count[i]]++;
        }
        /* �жϳ��ֵĴ����Ƿ�һ�� */
        for (int i = 0; i < word2Count.length; i++) {
            time[word2Count[i]]--;
            if (time[word2Count[i]] < 0) return false;

        }
        return true;
    }
}
