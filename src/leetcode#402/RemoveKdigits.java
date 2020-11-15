import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mo on 2020/11/15
 * 题目402:给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小
 * <p>
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        String result = "";
        int len = num.length();
        if (len <= k)
            return "0";

        char[] stringChars = num.toCharArray();

        int count = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < stringChars.length; i++) {
            int index = stringChars[i] - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() > index) {
                stack.pop();
                k--;
            }
            if (index != 0 || !stack.isEmpty()) {
                stack.push(index);
            }
        }

        while (k > 0) {
            if (stack.isEmpty())
                return "0";
            stack.pop();
            k--;
        }

        if (stack.isEmpty())
            return "0";

        while (!stack.isEmpty()) {
            result += stack.pollLast();
        }
        return result;
    }
}
