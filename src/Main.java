import java.util.Random;

/**
 * @ClassName Main
 * @Description
 * @Author zhangzx
 * @Date 2019/3/29 14:21
 * Version 1.0
 **/
public class Main {

    // 测试对比q运行opCount个enqueue和delqueue个方法所需要的时间
    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i < opCount; i ++) {
            // 添加的数值是0——2的32次方的数值
            q.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0; i < opCount; i++) {
            q.deQueue();
        }
        long endTime = System.nanoTime();
        return (startTime - endTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println(time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println(time2);

        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(loopQueue, opCount);
        System.out.println(time3);

    }
}
