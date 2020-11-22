import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * Created by mo on 2020/11/22
 * 题目5605：检查两个字符串数组是否相等
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 *
 *
 */
public class ArrayStringsAreEqual {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder resultWord1 = new StringBuilder();
        StringBuilder resultWord2 = new StringBuilder();

        for (int i = 0; i < word1.length; i++) {
            resultWord1.append(word1[i]);
        }


        for (int i = 0; i < word2.length; i++) {
            resultWord2.append(word2[i]);
        }

        if (resultWord1.toString().equalsIgnoreCase(resultWord2.toString())) {
            return true;
        }

        return false;
    }

}
