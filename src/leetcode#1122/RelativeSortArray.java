import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mo on 2020/11/14
 * 题目1122:给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 提示:
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] temps = new int[1001];

        //遍历arr1，统计每个元素的数量。存放在数组nums中
        Arrays.stream(arr1).forEach(n -> temps[n]++);
        //将arr2中出现的数，放入result中
        int index = 0;
        for (int i : arr2) {
            while (temps[i] > 0) {
                result[index++] = i;
                temps[i]--;
            }
        }

        //将arr2中没有出现的数放入res中
        for (int i = 0; i < temps.length; i++) {
            while (temps[i] > 0) {
                result[index++] = i;
                temps[i]--;
            }
        }

        return result;
    }
}
