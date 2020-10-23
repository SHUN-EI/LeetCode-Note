import java.util.HashMap;
import java.util.Map;

/**
 * Created by mo on 2020/10/22
 * 题目01:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    //哈希表
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                results[0] = i;
                results[1] = hashMap.get(nums[i]);
                return results;
            }
            hashMap.put(target - nums[i], i);
        }

        return results;
    }

    public int[] twoSum3(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{i, hashMap.get(temp)};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    //暴力枚举
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
