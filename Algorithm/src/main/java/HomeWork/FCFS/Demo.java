package HomeWork.FCFS;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Demo {
    //考虑线程安全
    //static ConcurrentLinkedDeque quene=new ConcurrentLinkedDeque<Work>();

    /**
     * @description:
        就当前代码进行volatile可见性问题分析:
     如果当前容器为LinkedList,睡眠时间过长就会出现线程安全问题，就比如模拟cpu线程出现卡死现象，但是作业添加线程会一直运行

     原因：
        JIT编译器会对一些热点代码进行一些优化，什么是热点代码？假如有一段代码1s内循环上k次，那么该代码就是热点代码
        例如：
        while (true){
        System.out.println(quene.size());
        if (quene.size() > 0){
            Work jcb = (Work) quene.removeFirst();
            try {
                Long processWorkTime = jcb.processWork();
                long zhouzhuanTime= jcb.endTime- jcb.createTime;
                double daiquanzhouzhuanTime=zhouzhuanTime/processWorkTime;
                System.out.println("任务"+jcb.JCBName+"完成作业调度，其中加入时间"+jcb.createTime+"  完成的时间"+jcb.endTime+"  服务时间 "+processWorkTime+"周转时间是"+zhouzhuanTime+",带权周转时间是"+daiquanzhouzhuanTime);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
     上段代码中的quene.size()

        static void foo() {
            int i = 0;
            while (!stop) {
                i++;
        }
            System.out.println(i);
             }
        stop每次的值都需要去内存种读取最新的值，但是循环很多次后读到的都是同一个值，那么JIT编译器
        就做了一个大胆的决定，将stop替换为常量false 那么foo()方法就永远得不到结束，一直处于死循环。


     通过上面的说明，我们将作业控制块中的睡眠时间减少1ms之后，整个实验正常进行，可以得知1ms内还没到JIT编译器优化的次数，所以每次都是从内存中获取到新的值！

     解决办法：
     1：加volatile 关键字
     2：加锁
     3：关闭虚拟机JIT编译器的优化
     */





    static volatile LinkedList quene=new LinkedList<Work>();
    /**
     * @description:  FCFS先来先到调度算法：
     * 非抢占式调度，选择就绪队列中等待时间最长的进程
     * 评价：简单 系统开销小 利于长时间作业
     * 周转时间=完成时间-进入就绪队列时间
     * 带权周转时=周转时间/服务时间

     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("作业    提交时间  运行时间  开始     完成    周转时间  带权周转时间  ");
        //当前线程模拟作业添加到就绪队列里面
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i <= 20; i++) {
                    quene.add(new Work("任务"+String.valueOf(i),System.currentTimeMillis()));
                    try {
                        Thread.sleep((long) (Math.random()*1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    quene.add(new Work("任务"+String.valueOf(i),System.currentTimeMillis()));
                    try {
                        Thread.sleep((long) (Math.random()*1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }).start();
        //当前线程模拟cpu调度任务
        System.out.println("排序JCB");
        Thread.sleep(3000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                quene.sort(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return (int) (((Work)o1).createTime-((Work)o2).createTime);
                    }
                });


                while (true){
                    //System.out.println(quene.size());
                    if (quene.size() > 0){
                        Work jcb = (Work) quene.removeFirst();
                        try {
                            Long processWorkTime = jcb.processWork();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

                            long zhouzhuanTime= jcb.endTime- jcb.createTime;
                            double daiquanzhouzhuanTime=(double) zhouzhuanTime/(double)processWorkTime;
                            //System.out.println("任务"+jcb.JCBName+"完成作业调度，其中加入时间"+jcb.createTime+"  完成的时间"+jcb.endTime+"  服务时间 "+processWorkTime+"周转时间是"+zhouzhuanTime+",带权周转时间是"+daiquanzhouzhuanTime);
                            System.out.println(jcb.JCBName+"   "+jcb.createTime+"   "+(processWorkTime)+"   "+(jcb.endTime-processWorkTime)+"   "+jcb.endTime+"   "+(zhouzhuanTime)+"   "+daiquanzhouzhuanTime);
                            //System.out.println(jcb.JCBName+"   "+ simpleDateFormat.format(new Date(jcb.createTime))+"   "+(processWorkTime/1000)+"/s      "+ simpleDateFormat.format(new Date(jcb.endTime-processWorkTime))+"   "+simpleDateFormat.format(new Date(jcb.endTime))+"   "+(zhouzhuanTime/1000)+"/m     "+daiquanzhouzhuanTime);

                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }
            }
        }).start();

    }
}
class Work implements Comparable{

    String JCBName;
    long createTime;
    long endTime;

    public Work(String flag,Long createTime) {
        this.JCBName = flag;
        this.createTime=createTime;
        //System.out.println("作业"+this.JCBName+"加入就绪队列。时间为"+this.createTime);
    }

    public Long processWork() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep((long) (Math.random()*2000));
        endTime = System.currentTimeMillis();
        return endTime-startTime;
    }


    @Override
    public int compareTo(Object o) {
        return (int) (this.createTime-((Work)o).createTime);
    }
}
