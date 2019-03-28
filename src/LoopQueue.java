/**
 * @ClassName LoopQueue
 * @Description
 * @Author zhangzx
 * @Date 2019/3/28 17:59
 * Version 1.0
 **/
public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity - 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enQueue(E e) {

    }

    @Override
    public E deQueue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
