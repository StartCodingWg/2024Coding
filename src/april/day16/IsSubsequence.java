package april.day16;

/**
 * Author:   wang
 * Date:     2024/4/16 23:39
 * function: �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 *
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ�����
 * �����磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        /* ����������� */
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() < s.length()) return false;
        /* ��ʼ�ж� */
        char[] cArrS = s.toCharArray();
        char[] cArrT = t.toCharArray();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < cArrS.length && idx2 < cArrT.length) {
            while (idx2 < cArrT.length && cArrS[idx1] != cArrT[idx2]) idx2++;
            if (idx2 < cArrT.length && cArrS[idx1] == cArrT[idx2]) idx1++;
            idx2++;
        }
        return idx1 == cArrS.length;
    }
}
