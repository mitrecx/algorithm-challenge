package cn.mitrecx.practice.check;

public class TCheck {
    static class Singleton {
        private volatile static Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    private static boolean b = false;
    private boolean b2 = false;

    public static void main(String[] args) throws InterruptedException {



            String s = " 1){";
            s.trim();
        char a = '中';
        System.out.println(a);
//        TCheck o = new TCheck();
//        Thread t2 = new Thread(()->{
//            o.b2 = true;
//
//        });
//        t2.start();
//        while(!o.b2){
//
//        }



    }

    static class Product {
        private String productId;
        private String productName;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }
    }

    static class MyThread extends Thread {
        private boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag = " + flag);
        }
    }

    private static int RESIZE_STAMP_BITS = 16;
    private static final int RESIZE_STAMP_SHIFT = 32 - RESIZE_STAMP_BITS;

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS - 1));
    }

    public static void printBinaryBeauty(int num) {
        System.out.print(num + " 的二进制表示: ");
        for (int i = 0; i < 32; i++) {
            int bit = (num & (0x80000000 >>> i)) >>> (31 - i);
            System.out.print(bit);
            if ((i + 1) % 8 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
