package algorithm.linear.stack;

import java.util.Iterator;

/**
 * @author HSL
 * @date 2022-02-12 17:24
 * @desc 栈，数据的出口入口为同一个 FILO，先进后出，压栈->弹栈
 */
public class Stack<T> implements Iterable<T> {

    // 首个元素
    private Node head;
    // 元素个数
    private int N;

    /**
     * 迭代器
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator {

        private Node node;

        public StackIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node;
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

    /**
     * 物理存储结构：实现栈的方式
     * 顺序存储结构：数组
     * 链式存储结构：链表（单链表）
     */
    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 压栈
     *
     * @param t
     */
    public void push(T t) {
        // 创建新节点
        Node old = head.next;
        Node node = new Node(t, null);
        head.next = node;
        node.next = old;
        N++;
    }

    /**
     * 弹栈
     *
     * @return
     */
    public T pop() {
        Node old = head.next;
        if (old == null) {
            return null;
        }
        head.next = old.next;
        N--;
        return old.item;
    }
}
