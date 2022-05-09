package algorithm.linear.queue;

import algorithm.linear.queue.Queue;

/**
 * @author HSL
 * @date 2022-02-12 17:11
 * @desc
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");

        for (String s : queue) {
            System.out.println(s);
        }
    }
}
