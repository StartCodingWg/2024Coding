package april.day28;

import java.util.LinkedList;

/**
 * 时间：2024/4/28
 * 问题描述：
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
 * 切入点/解决思路：使用栈来实现
 * 感想：
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        /* 特殊情况处理 */
        if (asteroids == null || asteroids.length < 2) return asteroids;
        /* 使用栈来处理 */
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < asteroids.length;) {
            if (res.isEmpty() || !(res.getLast() > 0 && asteroids[i] < 0)) res.add(asteroids[i++]);
            else {
                if (Math.abs(res.getLast()) == Math.abs(asteroids[i])) {
                    res.removeLast();
                    i++;
                } else if (Math.abs(res.getLast()) > Math.abs(asteroids[i])) {
                    i++;
                } else {
                    res.removeLast();
                }
            }
        }
        int[] finalRes = new int[res.size()];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i] = res.removeFirst();
        }
        return finalRes;
    }
}
