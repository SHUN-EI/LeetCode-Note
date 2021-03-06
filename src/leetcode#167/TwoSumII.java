import java.util.HashMap;
import java.util.Map;

/**
 * Created by mo on 2020/10/22
 * 题目167:给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * * 返回的下标值（index1 和 index2）不是从零开始的。
 * * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
 */
public class TwoSumII {

    //双指针
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    //二分查找
    public int[] twoSum4(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            int temp = target - nums[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == temp) {
                    return new int[]{i + 1, mid + 1};
                } else if (nums[mid] < temp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    //HashMap
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp) + 1, i + 1};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};

    }

    //暴力枚举
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

}
