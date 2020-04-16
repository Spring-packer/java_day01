package concurrent.test;

import java.util.concurrent.CountDownLatch;

/**
 * ProjectName:    java_day01
 * Package:        concurrent.test
 * ClassName:      CountDown
 * Description:     类作用描述
 * Author:          作者：龙飞
 * CreateDate:     2020/4/15 15:23
 * Version:        1.0
 *
 * 等待多个线程执行完之后执行想让执行的代码
 *
 *
 */
public class CountDown {

    public static void main(String[] args) {
        int count = 10;
        CountDownLatch L = new CountDownLatch(count);
        for(int i = 0; i < count; i++){
            final int index = i;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(10 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread " + index + " has finished");
                    L.countDown();
                }
            }).start();
        }

        try {
            L.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all thread finished ....");
    }

}
