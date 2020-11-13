/**
 * Created by mo on 2020/11/12
 * 题目922：按奇偶排序数组II
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int index = 1;

        for (int i = 0; i < len; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[index] % 2 == 1) {
                    index += 2;
                }
                swap(nums, i, index);
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
