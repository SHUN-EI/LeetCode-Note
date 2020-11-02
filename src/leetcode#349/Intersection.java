import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mo on 2020/11/2
 * 题目349:给定两个数组，编写一个函数来计算它们的交集
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 说明:输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> numSet1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        int[] result = Arrays.stream(nums2).distinct().filter(numSet1::contains).toArray();
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //去重数组1
        for (int item : nums1) {
            set1.add(item);
        }

        for (int item : nums2) {
            if (set1.contains(item)) {
                set2.add(item);
            }
        }

        int[] result = new int[set2.size()];
        int start = 0;
        for (int item : set2) {
            result[start] = item;
            start++;
        }
        return result;
    }

}
