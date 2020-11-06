import java.util.Arrays;

/**
 * Created by mo on 2020/11/6
 * 题目1356:给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * <p>
 * <p>
 * 提示
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 */
public class SortByBits {

    public int[] sortByBits(int[] nums) {
        int len = nums.length;

        //根据 1的个数 和 当前数值，存储 每一个数字,1的个数权值最大，其次是本身的值
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.bitCount(nums[i]) * 100000 + nums[i];
        }

        // 将存储的数字，还原成最初始的数字，并根据 1的个数 和 当前数值 排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            nums[i] %= 100000;
        }
        return nums;
    }
}
