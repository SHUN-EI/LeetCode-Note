import java.util.concurrent.ForkJoinPool;

/**
 * Created by mo on 2020/11/10
 * 题目31: 实现获取下一个排列的函数，
 * 算法需要将给定数字序列,重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，
 * 排序后，比123大的那个数 也就是132
 * <p>
 * 如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数，
 * 那么就返回1，2，3排序后所有数中最小的那个，
 * 也就是1，2，3 -> [1,2,3]
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int start = len - 2;

        if (nums == null || len < 2) {
            return;
        }

        /**
         * 从 倒数第2个元素 开始，向前遍历,
         * 若 当前元素 < 后面的元素(存在下一个更大的排列),
         * 找到大于当前元素的最后一个元素，记录其下标
         * 交换 选中的两个数组元素
         * 转置后续的元素(保证 后续元素“升序排列”，即 当前排列表示的数“最小”)
         *
         *反之(不存在下一个更大的排列),则继续循环
         * 若全部都未找到，则 当前排列为 最大排列，转置反转后返回即可
         */

        while (start >= 0) {
            if (nums[start] < nums[start + 1]) {
                int next = len - 1;
                //找到大于当前元素的，最后一个元素
                while (next > start && nums[next] <= nums[start]) {
                    next--;
                }
                swap(nums, start, next);
                reverse(nums, start + 1, len - 1);
                return;
            }
            start--;
        }
        reverse(nums, 0, len - 1);
    }

    //数组变量交换使用
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //将数组从指定开始位置 到 指定结束位置，进行原地反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

}
