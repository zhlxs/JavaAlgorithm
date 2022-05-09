package algorithm.linear.stack;

/**
 * @author HSL
 * @date 2022-02-12 17:57
 * @desc 括号匹配问题
 */
public class BraceMatchDemo {
    public static void main(String[] args) {

    }

    public static boolean isMatch(String str) {
        // 创建栈对象，存储左括号
        // 从左到右遍历字符串
        Stack<String> chars = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String s = str.charAt(i) + "";
            if (s.equals("(")) {
                chars.push(s);
            } else if (s.equals(")")) {
                String pop = chars.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        return chars.size() == 0;
    }
}
