package May.day19;

import java.util.PriorityQueue;

/**
 * ʱ�䣺2024/5/19
 * ����������
 * ����һ���±�� 0 ��ʼ���������� costs ������ costs[i] �ǹ�Ӷ�� i λ���˵Ĵ��ۡ�
 * ͬʱ������������ k �� candidates ��������������¹���ǡ�ù�Ӷ k λ���ˣ�
 * �ܹ����� k �ֹ�Ӷ����ÿһ��ǡ�ù�Ӷһλ���ˡ�
 * ��ÿһ�ֹ�Ӷ�У�����ǰ�� candidates ������� candidates ����ѡ��������С��һλ���ˣ�����ж�λ������ͬ����С�Ĺ��ˣ�ѡ���±��С��һλ���ˡ�
 * �ȷ�˵��costs = [3,2,7,7,1,2] �� candidates = 2 ����һ�ֹ�Ӷ�У�����ѡ��� 4 λ���ˣ���Ϊ���Ĵ�����С [3,2,7,7,1,2] ��
 * �ڶ��ֹ�Ӷ������ѡ��� 1 λ���ˣ���Ϊ���ǵĴ������ 4 λ����һ��������С���ۣ������±��С��[3,2,7,7,2] ��ע��ÿһ�ֹ�Ӷ��ʣ�๤�˵��±���ܻᷢ���仯��
 * ���ʣ��Ա����Ŀ���� candidates �ˣ���ô��һ�ֹ�Ӷ�����д�����С��һ�ˣ�����ж�λ������ͬ����С�Ĺ��ˣ�ѡ���±��С��һλ���ˡ�
 * һλ����ֻ�ܱ�ѡ��һ�Ρ�
 * ���ع�Ӷǡ�� k λ���˵��ܴ��ۡ�
 * �����/���˼·��ʹ��С����
 * ���룺
 */
public class TotalCost {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        /* ����������� */
        if (k == 0 || candidates == 0 || costs == null || costs.length == 0 || k > costs.length) return res;
        /* ��ʼ���� */
        PriorityQueue<int[]> preCandidates = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> postCandidates = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int pre = 0;
        int post = costs.length - 1;
        while (pre <= post && pre < candidates) {
            if (pre < post) {
                preCandidates.offer(new int[]{costs[pre], pre});
                postCandidates.offer(new int[]{costs[post], post});
                pre++;
                post--;
            } else {
                preCandidates.offer(new int[]{costs[pre], pre});
                pre++;
            }
        }
        for (int i = 0; i < k; i++) {
            if (preCandidates.isEmpty()) {
                res += postCandidates.poll()[0];
            } else if (postCandidates.isEmpty()) {
                res += preCandidates.poll()[0];
            } else if (preCandidates.peek()[0] <= postCandidates.peek()[0]) {
                res += preCandidates.poll()[0];
                if (pre <= post) preCandidates.offer(new int[]{costs[pre], pre});
                pre++;
            } else {
                res += postCandidates.poll()[0];
                if (post >= pre) postCandidates.offer(new int[]{costs[post], post});
                post--;
            }
        }
        return res;
    }

}
