/**
 * Created by mo on 2020/11/3
 * 题目941:给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false
 * <p>
 * 如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] nums) {
        if (nums.length < 3)
            return false;

        int left = 0, right = nums.length - 1;
        while (right > 1 && nums[right] < nums[right - 1]) {
            right--;
        }
        //left指针只能到数组的倒数第二个位置
        while (left < nums.length - 2 && nums[left] < nums[left + 1]) {
            left++;
        }

        return left == right;
    }
}
