package algorithm.linear.stack;

/**
 * @author HSL
 * @date 2022-02-12 18:35
 * @desc 逆波兰表达式
 */
public class Test1 {

    public static void main(String[] args) {

    }

    /**
     * 逆波兰表达式结果计算
     *
     * @param notaion
     * @return
     */
    public static int caculate(String[] notaion) {
        Stack<Integer> oprands = new Stack<>();
        for (int i = 0; i < notaion.length; i++) {
            String curr = notaion[i];
            Integer o1, o2;
            int result;
            switch (curr) {
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 + o2;
                    oprands.push(result);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 - o2;
                    oprands.push(result);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 * o2;
                    oprands.push(result);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 / o2;
                    oprands.push(result);
                    break;
                default:
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        return oprands.pop();
    }
}
