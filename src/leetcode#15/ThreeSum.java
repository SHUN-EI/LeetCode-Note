import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mo on 2020/10/25
 * 题目15：给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();

        for (int first = 0; first < len; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = len - 1;
            int target = -nums[first];

            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
