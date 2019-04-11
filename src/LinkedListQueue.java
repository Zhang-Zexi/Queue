/**
 * @ClassName LinkedListQueue
 * @Description
 * @Author zhangzx
 * @Date 2019/4/11 20:12
 * Version 1.0
 **/
public class LinkedListQueue<E> implements Queue<E> {

    private  class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head, tail ;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return  size == 0;
    }

    @Override
    public void enQueue(E e) {
        if(tail == null) {
            tail = new Node(e);
            head = tail;
        }
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E deQueue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Can not Null!")
        }
        Node retNode = head;
        head = head.next;
        retNode = null;
        if(head == null) {
            tail = null;
        }
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return null;
    }
}
