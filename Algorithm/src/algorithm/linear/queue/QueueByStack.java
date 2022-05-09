package algorithm.linear.queue;


import java.util.Stack;

/**
 * 用栈实现队列
 * 解题思路：用两个栈实现队列
 */
public class QueueByStack {
    private static Stack<Integer> ins;
    private static Stack<Integer> outs;

    public QueueByStack() {
        ins = new Stack<>();
        outs = new Stack<>();
    }

    public void push(int x) {
        ins.push(x);
    }

    public int pop() {
        if (outs.isEmpty()) {
            in2Out();
        }
        return outs.pop();
    }

    public int peek() {
        if (outs.isEmpty()) {
            in2Out();
        }
        return outs.peek();
    }

    public boolean isEmpty() {
        return ins.isEmpty() && outs.isEmpty();
    }

    private void in2Out() {
        while (!ins.isEmpty()) {
            outs.push(ins.pop());
        }
    }

}
