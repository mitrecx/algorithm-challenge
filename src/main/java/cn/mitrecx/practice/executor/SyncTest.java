package cn.mitrecx.practice.executor;

public class SyncTest {
    static class SyncIncrDemo implements Runnable {
        //共享资源(临界资源)
        static int i = 0;

        //synchronized关键字修饰代码块
        public void methodA() {
            /**
             * 假设我们此时只有这里存在对共享资源操作，我们如果对整个方法进行同步
             * 那么是不应该的，而我们可以使用同步这段代码的形式使用`synchronized`
             * 关键字对它进行同步修饰
             */
            synchronized (SyncIncrDemo.class) {
                i++;
            }
            // 省略八百行代码....
        }

        @Override
        public void run() {
            methodA();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncIncrDemo syncIncrDemo = new SyncIncrDemo();
        for (int j = 0; j < 1000; j++) {
            new Thread(syncIncrDemo).start();
        }
        Thread.sleep(10000);
        System.out.println(SyncIncrDemo.i);
    }
    /**
     * 输出结果:
     * 1000
     */
}
