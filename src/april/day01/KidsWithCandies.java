package april.day01;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:   wang
 * Date:     2024/4/1 21:05
 * function: 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 *
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 */
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new LinkedList<>();
        /* 特殊处理 */
        if (candies == null) return res;
        /* 获取最大糖果数 */
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        /* 判断每个孩子是否能够称为拥有糖果数最多的孩子 */
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max ? true : false);
        }
        return res;
    }
}
