import java.util.Arrays;

/**
 * Created by mo on 2020/11/8
 * 题目5561: 给你一个整数 n 。
 * 按下述规则生成一个长度为 n + 1 的数组 nums ：
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值
 *
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 *   nums[0] = 0
 *   nums[1] = 1
 *   nums[(1 * 2) = 2] = nums[1] = 1
 *   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 *   nums[(2 * 2) = 4] = nums[2] = 1
 *   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 *   nums[(3 * 2) = 6] = nums[3] = 2
 *   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 *
 */
public class GetMaximumGenerated {

    public static int getMaximumGenerated(int n) {
        int maxValue = 0;
        int[] nums = new int[n + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = 0;
            }

            if (i == 1) {
                nums[i] = 1;
            }

            if (i % 2 == 0 && i * 2 >= 2) {
                nums[i] = nums[i / 2];
            }

            if (i % 2 == 1 && i * 2 + 1 >= 2) {
                nums[i] = nums[i / 2] + nums[i - i / 2];
            }
        }

        if (nums.length > 0) {
            maxValue = Arrays.stream(nums).max().getAsInt();
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int maximumGenerated = getMaximumGenerated(9);
        System.out.println(maximumGenerated);
    }
}
