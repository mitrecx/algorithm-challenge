package cn.mitrecx.thread;

import java.lang.reflect.Field;

public class WeakReferenceDemo2 {
    static final ThreadLocal<User> threadLocalStatic = new ThreadLocal<>();

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        System.out.println("case 1: ");
        Thread t1 = new Thread(() -> test(new User("111", "mitre", 11), false));
        t1.start();
        t1.join();

        System.out.println("\ncase 2: ");
        Thread t2 = new Thread(() -> test(new User("222", "rosie", 22), true));
        t2.start();
        t2.join();

        System.out.println("\ncase 3: ");
        User user = new User("333", "abby", 33);
        Thread t3 = new Thread(() -> test(user, true));
        t3.start();
        t3.join();

        System.out.println(user);
        threadLocalStatic.set(new User("444", "Sia", 44));
        System.gc();

        System.out.println(threadLocalStatic.get());
        Thread t = Thread.currentThread();
        Class<? extends Thread> clz = t.getClass();
        Field field = clz.getDeclaredField("threadLocals");
        field.setAccessible(true);
        Object threadLocalMap = field.get(t);
        Class<?> tlmClass = threadLocalMap.getClass();
        Field tableField = tlmClass.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] arr = (Object[]) tableField.get(threadLocalMap);
        for (Object o : arr) {
            if (o != null) {
                Class<?> entryClass = o.getClass();
                Field valueField = entryClass.getDeclaredField("value");
                Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                valueField.setAccessible(true);
                referenceField.setAccessible(true);
                System.out.printf("弱引用key: %s, 值: %s %n", referenceField.get(o), valueField.get(o));
            }
        }
    }

    private static void test(User user, boolean isGC) {
        try {
            new ThreadLocal<User>().set(user);
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            Class<?> tlmClass = threadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(threadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.printf("弱引用key: %s, 值: %s %n", referenceField.get(o), valueField.get(o));
                }
            }
            if (isGC) {
                System.out.println("---GC---");
                System.gc();
                arr = (Object[]) tableField.get(threadLocalMap);
                for (Object o : arr) {
                    if (o != null) {
                        Class<?> entryClass = o.getClass();
                        Field valueField = entryClass.getDeclaredField("value");
                        Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                        valueField.setAccessible(true);
                        referenceField.setAccessible(true);
                        System.out.printf("弱引用key: %s, 值: %s %n", referenceField.get(o), valueField.get(o));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
