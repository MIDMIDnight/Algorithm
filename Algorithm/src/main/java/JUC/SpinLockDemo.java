package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public class SpinLockDemo {
    AtomicReference<Thread> threadAtomicReference=new AtomicReference<Thread>();

    public void lock(){
        while (!threadAtomicReference.compareAndSet(null,Thread.currentThread())){
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"RETRYING");
    }}
    public void unLock(){
        threadAtomicReference.compareAndSet(Thread.currentThread(),null);
        System.out.println(Thread.currentThread().getName()+"UNLOCK");
    }

    public static void main(String[] args) {
         SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.lock();
            System.out.println(Thread.currentThread().getName()+"抢到锁，正在处理业务");
        },"thread 1 :").start();
        new Thread(()->{
            spinLockDemo.lock();
            System.out.println(Thread.currentThread().getName()+"抢到锁，正在处理业务");
            spinLockDemo.unLock();
        },"thread 2 :").start();
    }


}
