package april.day24;

/**
 * Author:   wang
 * Date:     2024/4/24 23:02
 * function:
 * ����һ���������� arr�������æͳ��������ÿ�����ĳ��ִ�����
 * ���ÿ�����ĳ��ִ������Ƕ�һ�޶��ģ��ͷ��� true�����򷵻� false��
 * idea: hash
 */
public class UniqueOccurrences {
    /**
     * ʱ�临�ӵģ�O��n��
     * �ռ临�ӵģ�O��1��
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        /* ����������� */
        if (arr == null || arr.length <= 1) return true;
        /* ����ÿ�������ֵĴ�����ʹ�� hash ���� */
        short[] hash = new short[2001];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i] + 1000]++;
        }
        /* �ж��Ƿ�����ظ������֣�ʹ�� hash�� */
        boolean[] isRepeat = new boolean[1001];
        for (int i = 0; i < hash.length; i++) {
            // �����ظ�������
            if (hash[i] > 0 && isRepeat[hash[i]]) return false;
            isRepeat[hash[i]] = true;
        }
        return true;
    }

}
