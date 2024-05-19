package May.day19;

import java.util.PriorityQueue;

/**
 * 时间：2024/5/19
 * 问题描述：
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好 k 位工人的总代价。
 * 切入点/解决思路：使用小根堆
 * 感想：
 */
public class TotalCost {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        /* 特殊情况处理 */
        if (k == 0 || candidates == 0 || costs == null || costs.length == 0 || k > costs.length) return res;
        /* 开始处理 */
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
