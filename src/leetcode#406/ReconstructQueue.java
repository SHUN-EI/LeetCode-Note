import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by mo on 2020/11/16
 * 题目406：假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {

        //核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求

        //排序规则：按照先H高度降序，K个数升序排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        //插入规则:遍历排序后的数组，根据K插入到K的位置上
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.stream(people).forEach(p -> list.add(p[1], p));

        return list.toArray(people);
    }


}
