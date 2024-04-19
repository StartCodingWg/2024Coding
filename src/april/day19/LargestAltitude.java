package april.day19;

/**
 * 时间：2024/4/19
 * 问题描述：
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 *
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 * 切入点/解决思路：额，没啥可想的
 * 感想：
 */
public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        /* 特殊情况处理 */
        if (gain == null) return 0;
        /* 开始计算 */
        int res = 0;
        int maxHigh = 0;
        for (int i = 0; i < gain.length; i++) {
            res += gain[i];
            maxHigh = Math.max(maxHigh, res);
        }
        return maxHigh;
    }
}
