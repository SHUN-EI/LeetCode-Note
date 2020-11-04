import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2020/11/4
 * 题目57:给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠
 * （如果有必要的话，可以合并区间）
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 */
public class Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        int i = 0;
        //先把前面不重合的添加到list中
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            resultList.add(intervals[i++]);
        }

        int mergeStart = newInterval[0];
        int mergeEnd = newInterval[1];
        //前面不重合的都添加到集合list中，从这里开始就出现重合了，我们要找到重合的开始和结束值
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            mergeStart = Math.min(mergeStart, intervals[i][0]);
            mergeEnd = Math.max(mergeEnd, intervals[i][1]);
            i++;
        }
        //把重合的添加到list中
        resultList.add(new int[]{mergeStart, mergeEnd});
        //把剩下的在添加到集合list中
        while (i < intervals.length) {
            resultList.add(intervals[i++]);

        }
        //转换魏二维数组
        int[][] resultArray = new int[resultList.size()][2];
        for (int j = 0; j < resultList.size(); j++) {
            resultArray[j] = resultList.get(j);
        }
        return resultArray;
    }
}
