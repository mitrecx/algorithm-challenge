package cn.mitrecx.thread;

public class ThreadLocalTest {
    static final ThreadLocal<User> LOCAL_USER = new ThreadLocal<>();
    static final ThreadLocal<Integer> TEST = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("123","Mitre",13);
        LOCAL_USER.set(user1);
        System.out.println("main: " + LOCAL_USER.get());

        TEST.set(123);
        System.out.println("main: " + TEST.get());

        System.out.println("---t1 线程---");
        Thread t1 = new Thread(() -> {
            //
            System.out.println("t1, before set: " + LOCAL_USER.get());
            // new User
            User user = new User("666","Rosie",647);
            LOCAL_USER.set(user);
            System.out.println("t1, after set: " + LOCAL_USER.get());
            LOCAL_USER.remove();
            System.out.println("t1, after remove: " + LOCAL_USER.get());
        });
        t1.start();
        t1.join();

        System.out.println("\nmain: " + LOCAL_USER.get());
        System.out.println("---t2 线程---");
        // 不良示范, ThreadLocal 用于线程隔离, 不应该把共享变量传给ThreadLocal
        Thread t2 = new Thread(() -> {
            System.out.println("t2, before set: " + LOCAL_USER.get());
            // 把共享变量传给ThreadLocal, ThreadLocal set 时, 会修改共享变量的值
            LOCAL_USER.set(user1);
            // user1.name 会由 "Mitre" -> "A BAD TRYING"
            LOCAL_USER.get().setName("A BAD TRYING.");
            System.out.println("t2, after set: " + LOCAL_USER.get());
            LOCAL_USER.remove();
            System.out.println("t2, after remove: " + LOCAL_USER.get());
        });
        t2.start();
        t2.join();

        System.out.println("\nmain: " + LOCAL_USER.get());
    }
}
