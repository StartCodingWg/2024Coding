package april.day08;

/**
 * Author:   wang
 * Date:     2024/4/8 22:27
 * function:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length <= 1) return;
        /* 使用双指针开始移动 */
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                if (left != right) nums[right] = 0;
                left++;
            }
            right++;
        }
    }
}
