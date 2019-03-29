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
        data = (E[])new Object[capacity + 1];
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

        if((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public void resize(int newCapacity) {
        E[] newdata = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < size; i ++) {
            //  后面+data.length是为了防止越界，说实话不太懂这个
            //  难道是害怕i+front>data.length ?
            newdata[i] = data[(i + front) % data.length];
        }
        data = newdata;
        front = 0;
        tail = size;
    }

    @Override
    public E deQueue() {

        if(isEmpty()) {
            throw new IllegalArgumentException("cannot delete a empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        // 为什么getCapacity() / 2 != 0？ 空间一定比2大！因为肯定不为空，而且必然比1个多1
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {

        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front;  i != tail ; i = (i + 1) % data.length) {
            res.append(data[i]);
            if((i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return  res.toString();
    }



    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.enQueue(i);
            if (i % 3 == 2) {
                queue.deQueue();
            }
            System.out.println(queue);
        }
    }
}
