package algorithm.linear.string;

import algorithm.linear.stack.Stack;

/**
 * 字符串解码：
 * 元组：数字[字符串]
 * 借助栈来进行处理
 */
public class LC_394 {

    public static String decodeStr(String s) {
        String res = "";
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();

        int idx = 0;
        while (idx < s.length()) {
            char curr = s.charAt(idx);
            /**处理多位数字**/
            if (Character.isDigit(curr)) {
                StringBuffer buf = new StringBuffer();
                while (Character.isDigit(s.charAt(idx))) {
                    buf.append(s.charAt(idx++));
                }
                // 得到复制的‘倍数’
                count.push(Integer.parseInt(buf.toString()));
            } else if (curr == '[') {
                /**处理[**/
                result.push(res);
                res = "";
                idx++;
            } else if (curr == ']') {
                /**处理],处理与其匹配的[中间的字符**/
                StringBuffer temp = new StringBuffer(result.pop());
                int repeatTimes = count.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                // 3[2[a]]
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
