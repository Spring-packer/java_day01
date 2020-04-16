package concurrent.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProjectName:    java_day01
 * Package:        concurrent.test
 * ClassName:      ReentrantLockDemo
 * Description:     类作用描述
 * Author:          作者：龙飞
 * CreateDate:     2020/4/15 15:56
 * Version:        1.0
 *
 * 将锁加到class的方法里面是可以 的 只需要锁定一行 就可以实现线程安全
 *
 *
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {

        int count = 10;
        final CountDownLatch l = new CountDownLatch(10);
        SeqWithLock seqWithIndex = new SeqWithLock();
        for(int i = 0; i < 10; i++){
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        seqWithIndex.inc();
                    }
                    System.out.println("finished " + index);
                    l.countDown();
                }
            }).start();
        }

        try {
            l.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all finished");
        System.out.println(seqWithIndex.get() + " end value");


    }


}
class SeqWithLock{

    private  long count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void inc(){
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    public long get(){
        return count;

    }

}



