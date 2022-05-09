package algorithm.linear.queue;

import java.util.Iterator;

/**
 * @author HSL
 * @date 2022-02-12 15:59
 * @desc 队列
 */
public class Queue<T> implements Iterable<T> {
    private Node head;

    private Node last;

    private int N;

    // 队列遍历
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    /**
     * @author HSL
     * @date 2022-02-12
     * @desc 迭代器
     **/
    private class QueueIterator implements Iterator {

        /**
         * 表示遍历的对象
         */
        private Node n;

        public QueueIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 添加元素
    public void add(T t) {
        if (last == null) {
            last = new Node(t, null);
            head.next = last;
        } else {
            Node temp = last;
            last = new Node(t, null);
            temp.next = last;
        }
        N++;
    }

    // 获取元素
    public T get() {
        if (isEmpty()) {
            return null;
        }
        Node target = head.next;
        head.next = target.next;
        N--;
        // 因为出队列是在删除元素，如果元素删除完了，需要重置last = null;
        if (isEmpty()) {
            last = null;
        }
        return target.item;
    }
}
