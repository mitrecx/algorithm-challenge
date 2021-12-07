package cn.mitrecx.practice.check;


//                else {
//                    System.out.println("b 不为 true ....");
//                    int i = 0;
//                    while(i++ < 1_000_000_000L){
//
//                    }
//                        }
public class Test1 {
    private static boolean b = false;

    public static void main(String[] args) throws InterruptedException {
        // 假设这个线程叫 T0
        new Thread(() -> {
            for (; ; ) {
                if (b) {
                    System.out.println(
                            Thread.currentThread().getName() + " " + b);
                    break;
                } else {
                    System.out.println("rosie..");
                }
            }
        }).start();

        Thread.sleep(300);

        System.out.println("b 的值为 : " + b);
        b = true;
        System.out.println("修改 b 的值为 : " + b);
    }
}
