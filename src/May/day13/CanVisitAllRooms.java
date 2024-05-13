package May.day13;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 时间：2024/5/13
 * 问题描述：
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 * 切入点/解决思路：图的深度优先搜索
 * 感想：
 */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        /* 特殊情况处理 */
        if (rooms == null || rooms.size() < 2) return true;
        /* 开始进行深度优先搜索 */
        Set<Integer> indexSet = new HashSet<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        indexSet.add(0);
        while (!queue.isEmpty()) {
            int index = queue.pollFirst();
            rooms.get(index).forEach(ele -> {
                if (indexSet.add(ele)) {
                    queue.addLast(ele);
                }
            });
        }
        return indexSet.size() == rooms.size();
    }

}
